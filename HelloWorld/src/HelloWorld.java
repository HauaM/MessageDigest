import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HelloWorld {
	public static void main(String[] args) {
        // TODO Auto-generated method stub
 
        String urlPath = "http://www.example.com";
        String pageContents = "";
        StringBuilder contents = new StringBuilder();
 
        try{
 
            URL url = new URL(urlPath);
            URLConnection con = (URLConnection)url.openConnection();
            InputStreamReader reader = new InputStreamReader (con.getInputStream(), "utf-8");
 
            BufferedReader buff = new BufferedReader(reader);
 
            while((pageContents = buff.readLine())!=null){
                //System.out.println(pageContents);             
                contents.append(pageContents);
                contents.append("\r\n");
            }
 
            buff.close();
 
            System.out.println(contents.toString());

        }catch(Exception e){
            e.printStackTrace();
        }
 
    }
 
}
