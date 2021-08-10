/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.net.*;
import java.io.*;
/**
 *
 * @author Learn new here
 */
public class ChatClient
{
    public static void main(String args[])throws Exception
    {  
        Socket s = null;
        DataInputStream din = null;
        DataOutputStream dout = null;
        BufferedReader br = null;
        try
        {
            s = new Socket("localhost",3333);  
            din = new DataInputStream(s.getInputStream());  
            dout = new DataOutputStream(s.getOutputStream());  
            br = new BufferedReader(new InputStreamReader(System.in));  

            String str="",str2="";  
            while(!str.equals("stop"))
            {  
                str=br.readLine();  
                dout.writeUTF(str);  
                dout.flush();  
                str2=din.readUTF();  
                System.out.println("Server says: "+str2);  
            }  
            dout.close();  
            s.close();  
        }
        catch(Exception ex)
        {
            System.out.print(ex);
        }
        finally
        {
            //make sure the connections are closed in the reversed order.
            if(br != null)
            {
                br.close();
            }
            if(dout != null)
            {
                dout.close();
            }
            if(din != null)
            {
                din.close();  
            }
            if(s != null)
            {
                s.close();  
            }
        }
    }
}

