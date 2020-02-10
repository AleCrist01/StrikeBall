package client.server;

import java.io.IOException;

/**
 * @author Alessandro Cristofani
 **/
public class Client
{
    public static void main(String[] args) throws IOException
    {
        ClientClass cc=new ClientClass();
        cc.findServer();
        cc.receiveMessage();
        cc.closeConnection();
    }
}