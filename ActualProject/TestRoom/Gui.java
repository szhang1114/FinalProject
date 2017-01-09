
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Gui extends JFrame{

    private JButton bWeather, bClock, bExit, getWeather;
    private JLabel labelWeather, labelClock;
    private String time;
    private double weather;
    
    public Gui(){
	setUp();
	//gui defaults
	setSize(new Dimension(300, 400));
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Widgets");
        setVisible(true);

    }
    
    private void setUp(){
	//panels
	JPanel buttonPanel = new JPanel();
	buttonPanel.setPreferredSize(new Dimension (400, 80));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	this.add(buttonPanel, BorderLayout.PAGE_END);
	
	//widget buttons
	//weather button
	bWeather = new JButton("Weather");
	bWeather.setIcon(new ImageIcon("weather.png"));
	bWeather.addActionListener(
				   new ActionListener(){
				       public void actionPerformed(ActionEvent e){
					   weatherSetup();
					   pack();
				       }
				   }
				   );
			       
	buttonPanel.add(bWeather);

	//clock button
	bClock = new JButton("Clock");
	bClock.setIcon(new ImageIcon("clock.png"));
	validate();
	bClock.addActionListener (
				 new ActionListener(){
				     public void actionPerformed(ActionEvent e){
					 clockSetup();
					 pack();
				     }
				 }
				 );
	buttonPanel.add(bClock);

	//exit button
	bExit = new JButton("exit");
	buttonPanel.add(bExit);
    }

    private void weatherSetup(){
	JPanel weatherPanel = new JPanel();
	weatherPanel.setPreferredSize(new Dimension(100, 200));
	this.add(weatherPanel);

	//select city
	/*String[] cities = {"New York", "Tokyo", "London"};
	JComboBox city = new JComboBox(cities);
	city.setSelectedIndex(0);
	weatherPanel.add(city);*/
	JTextField city = new JTextField();
	city.setPreferredSize(new Dimension(250, 30));
	weatherPanel.add(city);

	//get weather
	getWeather = new JButton("Search");
	weatherPanel.add(getWeather);

	
	

	//weather
	labelWeather = new JLabel();
	labelWeather.setPreferredSize(new Dimension(100, 100));
	weatherPanel.add(labelWeather);
	updateWeather();
    }

    private void clockSetup(){
	JPanel clockPanel = new JPanel();
	clockPanel.setPreferredSize(new Dimension(100, 200));
	this.add(clockPanel);

	labelClock = new JLabel();
	updateTime();
	clockPanel.add(labelClock);
    }
	

    private void updateWeather(){
	if(weather != 0){
	   labelWeather.setText(weather + "°");
	}
	else labelWeather.setText("");
    }

    private void updateTime(){
	time = SimpleDateFormat.getInstance().format(Calendar.getInstance().getTime());
	labelClock.setText(time);

    }
    



    
    public static void main(String[] args){
	Gui test = new Gui();
    }
		

}
