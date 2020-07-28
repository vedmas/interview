package lesson3;

import java.util.concurrent.locks.ReentrantLock;

public class MyLock {
    ReentrantLock lock = new ReentrantLock();
    int counter = 0;

    public void add(int count) {
        lock.lock();
        try {
            counter += count;
        } finally {
            lock.unlock();
        }
    }

    public void subtract(int count) {
        lock.lock();
        try {
            counter -= count;
        } finally {
            lock.unlock();
        }
    }

    public int getCounter() {
        return counter;
    }
}
