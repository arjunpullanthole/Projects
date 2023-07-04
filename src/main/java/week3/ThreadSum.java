package week3;

public class ThreadSum implements Runnable{
    public int start;
    public int end;
    public int[] arr;
    public int sum;
    public ThreadSum(int start, int end, int[] arr) {
        this.start = start;
        this.end = end;
        this.arr = arr;
    }
    public int getSum()
    {
        return this.sum;
    }
    @Override
    public void run() {
        this.sum = 0;
        for (int i=start ; i<end ; i++)
        {
            this.sum += this.arr[i];
        }
    }
}
