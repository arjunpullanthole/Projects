package week3;

public class ThreadPrint extends Thread{
    @Override
    public void run()
    {
        for(int i =1; i<11; i++)
        {
            System.out.printf( " Thread Id: %d %d\n",this.threadId(),i);
            try {
                Thread.sleep(100);
            }
            catch(Exception e)
            {
            }
        }

    }
}
