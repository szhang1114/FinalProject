
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Demo extends JFrame {

    private JButton bWeather, bClock, bExit, getWeather;
    private JLabel labelWeather, labelClock, spacer;
    private String time, selectedCity, weather;
    private JComboBox<String> city;
    private JPanel weatherPanel, clockPanel;
    private boolean w, c;
    
    public Demo(){
	setUp();
	w = false;
	c = false;
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
					   if(c == true){
					       clockPanel.setVisible(false);
					       c = false;
					       w = true;
					       weatherSetup();
					       pack();
					   }
					   else if(w == true){
					   }
					   else{weatherSetup();
					   pack();
					   w = true;
					   }
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
					 if (w == true){
					     weatherPanel.setVisible(false);
					     w = false;
					     c = true;
					     clockSetup();
					     pack();
					 }
					 else if(c == true){
					 }
					 else{clockSetup();
					     pack();
					     c = true;
					 }
				     }
				 }
				 );
	buttonPanel.add(bClock);

	//exit button
	bExit = new JButton("exit");
	//buttonPanel.add(bExit);
    }

    private void weatherSetup(){
        weatherPanel = new JPanel();
	weatherPanel.setPreferredSize(new Dimension(100, 200));
	this.add(weatherPanel);

	//select city
        String[] cities = {"Beijing", "Berlin", "Hong Kong", "Istanbul", "London", "Los Angeles", "Madrid", "New York", "Paris", "Rio", "Rome", "Seoul"};
	city = new JComboBox<String>(cities);
	city.setSelectedIndex(7);
	weatherPanel.add(city);
	
	/*JTextField city = new JTextField();
	city.setPreferredSize(new Dimension(250, 30));
	weatherPanel.add(city);*/

	//get weather
	getWeather = new JButton("");
	getWeather.setIcon(new ImageIcon("search.png"));
	validate();
	getWeather.addActionListener(
				     new ActionListener(){
					 getstuff2 method = new getstuff2();
					 public void actionPerformed(ActionEvent e){
					     selectedCity = (String)city.getSelectedItem();
					     weather = method.getWeather(method.getIndex(cities, selectedCity));
					     updateWeather();
					 }
				     }
				     );
					     
	weatherPanel.add(getWeather);
	weatherPanel.add(spacer = new JLabel(" "), "span, grow");
	
	

	//weather
	labelWeather = new JLabel();
	labelWeather.setPreferredSize(new Dimension(500, 50));
	weatherPanel.add(labelWeather);
    }

    private void clockSetup(){
	clockPanel = new JPanel();
	clockPanel.setPreferredSize(new Dimension(100, 200));
	this.add(clockPanel);

	labelClock = new JLabel();
	updateTime();
	clockPanel.add(labelClock);
    }
	

    private void updateWeather(){
	if(weather.compareTo("") != 0){
	    int split = weather.indexOf('|');
	    String temp = weather.substring(0, split);
	    String type = weather.substring(split + 1); 
	    weather = "                       It is currently " + temp + " degrees in " + selectedCity + " and the weather is " + type;
	    labelWeather.setText(weather);
	}
	else labelWeather.setText("");
	}



    private void updateTime(){
	    time = SimpleDateFormat.getInstance().format(Calendar.getInstance().getTime());
	    labelClock.setText(time);

    }
    

	

    
    public static void main(String[] args){
	Demo test = new Demo();
    }
		

}
