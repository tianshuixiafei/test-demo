package com.robin.test;

/**
 * @author  10258035
 * @version v1.0
 */
public class YieldTest implements Runnable {

    public YieldTest() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            if(i%5==0){
                System.out.println(Thread.currentThread() + "yield cpu...");

                //出让cpu执行权
                Thread.yield();
            }
        }

    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }

}
