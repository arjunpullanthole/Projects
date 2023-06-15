package week3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    final private int shared1 =1;
    final private int shared2 = 2;
    private final Lock lk1;
    private final Lock lk2;

    public SharedResource() {
        this.lk1 = new ReentrantLock();
        this.lk2 = new ReentrantLock();

    }

    public int getShared1() {
        System.out.printf("Thread %d going to acquired Shared Resource 1\n",Thread.currentThread().threadId());
        lk1.lock();         //Acquire Lock1;
        int val1 = shared1;
        System.out.printf("Thread %d acquired Shared Resource 1\n",Thread.currentThread().threadId());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lk2.lock();         //Acquire Lock2;
        int val2 = shared1;
        System.out.printf("Thread %d acquired Shared Resource 2\n",Thread.currentThread().threadId());
        lk2.unlock();
        lk1.unlock();
        return val1;
    }

    public int getShared2() {
        System.out.printf("Thread %d going to acquired Shared Resource 2\n",Thread.currentThread().threadId());
        lk2.lock();
        int val2 = shared2;
        System.out.printf("Thread %d acquired Shared Resource 2\n",Thread.currentThread().threadId());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lk1.lock();
        int val1 = shared1;
        System.out.printf("Thread %d acquired Shared Resource 1\n",Thread.currentThread().threadId());
        lk1.unlock();
        lk2.unlock();
        return val2;
    }
}
