
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
//import javax.swing.ImageIcon;
 
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class GUItest extends JFrame {
    private JButton bWeather, bClock, b;
    private Container pane;
    public GUItest() {
        this.setTitle("First GUI test");
	this.setSize(100,100);
	this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	
	bWeather = new JButton("Weather");
	
	bClock = new JButton("Clock");

	b = new JButton("asdf");

	pane.add(bWeather);
	pane.add(bClock);
	//pane.add(b);
    }

    public static void main(String[] args) {
        GUItest g = new GUItest();
        g.setVisible(true);
    }
}
