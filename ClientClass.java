package client.server;
import java.io.*;
import java.net.*;
/**
 * @author Alessandro Cristofani
 */
public class ClientClass
{
    public Socket socket;
    public BufferedReader in;
    public PrintWriter out;
    public ClientClass()
    {
        try
        {
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException ex)
        {
            System.err.println("ERRORE BUFFERED READER!");
        }
        try
        {
            out=new PrintWriter(socket.getOutputStream(),true);
        }
        catch (IOException ex)
        {
            System.err.println("ERRORE PRINT WRITER!");
        }
    }
    public void findServer()
    {
        System.out.println("RICERCA SERVER IN CORSO...");
        try
        {
            socket=new Socket("localhost",2000);
        }
        catch (IOException ex)
        {
            System.err.println("ERRORE CREAZIONE SOCKET!");
        }
        System.out.println("CONNESSIONE STABILITA!");
    }
    public void receiveMessage() throws IOException
    {
        String messaggio=in.readLine();
        System.out.println("Messaggio dal server: "+messaggio);
    }
    public void closeConnection() throws IOException
    {
        socket.close();
        System.out.println("CONNESSIONE CHIUSA.");
    }
}