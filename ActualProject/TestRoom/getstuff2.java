import java.io.*;
import java.net.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
public class getstuff2{
	public static getstuff2(){
	}
	public static void main(String[] args){
		try{
			getstuff2 Bob = new getstuff2();
			Bob.start();
			System.out.println("Done");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public String[] getweather(int placeindex){
		/*
		Beijing
		Berlin
		Hong Kong
		Istanbul
		London
		Los Angeles
		Madrid
		New York = 40.731 -74.010 
		Paris
		Rio
		Rome
		Seoul
		Shanghai
		Taipei
		Tokyo
		Toronto
		Washington DC
		*/
		String[] places = {
				"China/Beijing",
				"Germany/Berlin",
				"UK/London.xml","canada/Toronto.xml","France/Paris.xml",
		}
		try{
			URL url = new URL("http://api.wunderground.com/api/2a8f76b8f5d220cf/conditions/q/"+places[placeindex]+".xml");
		}catch(Exception e){}}
		
	private void start() throws Exception
    {
        URL url = new URL("http://api.wunderground.com/api/2a8f76b8f5d220cf/conditions/q/NY/New_York.xml");
        URLConnection connection = url.openConnection();

        Document doc = parseXML(connection.getInputStream());
        NodeList descNodes = doc.getElementsByTagName("temp_f");
		NodeList descWeat = doc.getElementsByTagName("weather");
        for(int i=0; i<descNodes.getLength();i++)
        {
            System.out.println(descNodes.item(i).getTextContent());
			System.out.println("Done: "+i);
        }
		for(int i=0; i<descWeat.getLength();i++)
        {
            System.out.println(descWeat.item(i).getTextContent());
			System.out.println("Done: "+i);
        }
    }
	private Document parseXML(InputStream stream) throws Exception
    {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        }
        catch(Exception ex)
        {
            throw ex;
        }       

        return doc;
    }

		
}