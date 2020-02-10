package client.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
public class ServerClass
{
	public ServerSocket ss;
	public Counter ct;
	public Socket socket;
	public BufferedReader in;
        public PrintWriter out;
	public ServerClass()
	{
		try
		{
			ss=new ServerSocket(2000);
		}
		catch (IOException ex)
		{
			System.err.println("PORT ERROR!");
		}
		try
		{
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		}
		catch (IOException ex)
		{
			System.err.println("STREAM ERROR!");
		}
		ct=new Counter();
	}
	public void openConnection()
	{
		System.out.println("ATTENDO CONNESSIONI...");
		try
		{
			ss.setSoTimeout(5000);
		}
		catch (SocketException ex)
		{
			System.err.println("SOCKET ERROR!");
		}
        ct.start();
	}
	public void acceptConnection()
	{
		try
		{
			socket = ss.accept();
			System.out.println("CONNESSIONE STABILITA!");
			System.out.println("Socket del server: "+socket.getLocalSocketAddress());
			System.out.println("Socket del client: "+socket.getRemoteSocketAddress());
		}
		catch (IOException ex)
		{
			System.err.println("SOCKET ERROR!");
		}
        ct.cambiaStato();
	}
	public void initializeCommunication()
	{
		String messaggio;
		try
		{
			messaggio = in.readLine();
			System.out.println("Messaggio dal client: "+messaggio);
		}
		catch (IOException ex)
		{
			System.err.println("STREAM ERROR!");
		}
        out.println("OK");
	}
	public void closeConnection()
	{
		try
		{
			ss.close();
		}
		catch (IOException ex)
		{
			System.err.println("SOCKET ERROR!");
		}
		System.out.println("CONNESSIONE CHIUSA");
	}
}