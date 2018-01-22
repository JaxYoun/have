package com.youn.have.deadlock;

/**
 * @Author：YangJx
 * @Description：死锁测试
 * @DateTime：2018/1/21 23:04
 */
public class DeadLockTest {

    private static final String left = "1";

    private static final String right = "2";

    public void rightLeft() {

        synchronized (right) {
            System.err.println("rightLeft 拿到了右锁");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (left) {
                System.err.println("rightLeft 拿到了左锁");
            }
        }

    }

    public void leftRight() {

        synchronized (left) {
            System.out.println("leftRight 拿到了左锁");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (right) {
                System.out.println("leftRight 拿到了右锁");
            }
        }

    }

    static class DeadThread1 implements Runnable {

        private DeadLockTest deadLockTest;

        public DeadThread1(DeadLockTest deadLockTest) {
            this.deadLockTest = deadLockTest;
        }

        @Override
        public void run() {
            deadLockTest.leftRight();
        }
    }

    static class DeadThread2 implements Runnable {

        private DeadLockTest deadLockTest;

        public DeadThread2(DeadLockTest deadLockTest) {
            this.deadLockTest = deadLockTest;
        }

        @Override
        public void run() {
            deadLockTest.rightLeft();
        }
    }

    public static void main(String[] args) {
        DeadLockTest deadLockTest = new DeadLockTest();

        DeadThread1 deadThread1 = new DeadThread1(deadLockTest);
        Thread thread1 = new Thread(deadThread1);
        DeadThread2 deadThread2 = new DeadThread2(deadLockTest);
        Thread thread2 = new Thread(deadThread2);

        thread1.start();
        thread2.start();
    }

}


