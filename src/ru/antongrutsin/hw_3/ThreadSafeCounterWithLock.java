package ru.antongrutsin.hw_3;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCounterWithLock implements Runnable{
    private int counter = 1;

    private final ReentrantLock counterLock = new ReentrantLock(true);

    private void incrementCounter(){
        counterLock.lock();
        try{
            counter++;
        }finally{
            counterLock.unlock();
        }
    }

    @Override
    public void run() {
        while(counter<1000){
            incrementCounter();
        }
    }

    public static void main(String[] args) {
        ThreadSafeCounterWithLock safeCounter = new ThreadSafeCounterWithLock();
        Thread thread1 = new Thread(safeCounter);
        Thread thread2 = new Thread(safeCounter);
        thread1.start();
        thread2.start();
    }
}
