/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.*;
import java.net.*;

/**
 *
 * @author Learn new here
 */
class ChatServer
{  
    public static void main(String args[])throws Exception
    {  
        ServerSocket ss = null;
        Socket s = null;
        DataInputStream din = null;
        DataOutputStream dout = null;
        BufferedReader br = null;
        try
        {
            ss = new ServerSocket(3333);  
            s = ss.accept();  
            din = new DataInputStream(s.getInputStream());  
            dout=new DataOutputStream(s.getOutputStream());  
            br=new BufferedReader(new InputStreamReader(System.in));  

            String str="",str2="";  
            while(!str.equals("stop"))
            {  
                str=din.readUTF();  
                System.out.println("client says: "+str);  
                str2=br.readLine();  
                dout.writeUTF(str2);  
                dout.flush();  
            }  
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
            if(ss != null)
            {
                ss.close();  
            }
        }
    }
}
