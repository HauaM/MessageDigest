package potals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Total {
	public static void main(String[] args) {
        // TODO Auto-generated method stub
 
        String urlPath = "http://localhost:8000/blog/";
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

    		//MD 생성과 관련된 부
    		try {
    			MessageDigest md = MessageDigest.getInstance("MD5");
    			//update the md object
    			md.update(contents.toString().getBytes(),0,contents.toString().length());
    			//output the MD5 equivalent
    			System.out.println(new BigInteger(1,md.digest()).toString(16));
    		}catch(NoSuchAlgorithmException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

        }catch(Exception e){
            e.printStackTrace();
        }
 
    }

}
