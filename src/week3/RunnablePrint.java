package week3;

public class RunnablePrint implements Runnable{
    String run;

    public RunnablePrint(String run) {
        this.run = run;
    }

    @Override
    public void run() {
        for(int i =1; i<11; i++)
        {
            System.out.printf("%s : %d\n",this.run,i);
            try {
                Thread.sleep(100);
            }
            catch(Exception e)
            {
            }
        }
    }
}
