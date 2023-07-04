package week3;

public class Consumer implements Runnable{
    final private SharedResource sr;
    final private int choice;

    public Consumer(SharedResource sr,int ch) {
        this.sr = sr;
        this.choice = ch;
    }

    @Override
    public void run() {
        if (choice == 1) {
            sr.getShared1();
        } else {
            sr.getShared2();
        }
    }
}
