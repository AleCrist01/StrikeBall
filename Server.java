package client.server;
/**
 * @author Alessandro Cristofani
 **/
public class Server
{
    public static void main(String[] args)
    {
			ServerClass server=new ServerClass();
			server.openConnection();
			server.acceptConnection();
			server.initializeCommunication();
			server.closeConnection();
    }
}