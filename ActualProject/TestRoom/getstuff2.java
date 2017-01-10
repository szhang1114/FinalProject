import java.io.*;
import java.net.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
public class getstuff2{
	public getstuff2(){
	}
	/*public static void main(String[] args){
			getstuff2 Bob = new getstuff2();
			System.out.println(Bob.getweather(7));
			System.out.println("Done");
	}*/
	public static String getweather(int placeindex){
		/*
	0	Beijing
	1	Berlin
	2	Hong Kong = 22.396,114.109
	3	Istanbul
	4	London
	5	Los Angeles
	6	Madrid
	7	8New York = 40.731 -74.010 
	8	Paris
	9	Rio = -22.902 -43.2075
	10	Rome
	11	Seoul
	12	Shanghai
		Taipei
		Tokyo
		Toronto
		Washington DC
		*/
		String[] places = {
				"China/Beijing",
				"Germany/Berlin",
				"22.396,114.109",
				"Turkey/Istanbul",
				"UK/London",
				"CA/Los_Angeles",
				"Spain/Madrid",
				"NY/New_York",
				"France/Paris",
				"-22.902,-43.2075",
				"Italy/Rome",
				"SouthKorea/Seoul",
				"canada/Toronto"
		};
		try{
			URL url = new URL("http://api.wunderground.com/api/2a8f76b8f5d220cf/conditions/q/"+places[placeindex]+".xml");
			URLConnection connection = url.openConnection();
			String retstring = "";
        	Document doc = parseXML(connection.getInputStream());
        	NodeList descNodes = doc.getElementsByTagName("temp_f");
			NodeList descWeat = doc.getElementsByTagName("weather");
        	for(int i=0; i<descNodes.getLength();i++)
        	{
            	retstring += descNodes.item(i).getTextContent();
        	}
			retstring+="|";
			for(int i=0; i<descWeat.getLength();i++)
        	{
            	retstring += descWeat.item(i).getTextContent();
        	}
			return retstring;
			}catch(Exception e){
			//e.printStackTrace();
		return "Error|Invalid City!";	}}
	/*private void start() throws Exception
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
    }*/
	private static Document parseXML(InputStream stream) throws Exception
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