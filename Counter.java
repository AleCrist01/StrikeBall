package client.server;
/**
 *
 * @author Alessandro Cristofani
 */
public class Counter extends Thread
{
    private int n;
    public boolean connected;
    public Counter()
    {
        n=5000;
        connected=false;
    }
    @Override
    public void run()
    {
        while(n>0)
        {
            if(connected==true)
            {
                break;
            }
            else
            {
                System.out.println("COUNTDOWN: "+n/1000+" secondi");
                n-=1000;
                try
                {
                    sleep(1000);
                }
                catch (InterruptedException ex)
                {
                    System.err.println("ERRORE!");
                }
            }
        }
        if(n<0)
        {
            System.out.println("TEMPO SCADUTO!");
        }
    }
    public void cambiaStato()
    {
        connected=true;
    }
}