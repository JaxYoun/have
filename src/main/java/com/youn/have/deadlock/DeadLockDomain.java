package com.youn.have.deadlock;

/**
 * @Author：YangJx
 * @Description：死锁测试
 * @DateTime：2018/1/21 23:04
 */
public class DeadLockDomain {

    private static final String left = "1";

    private static final String right = "2";

    /**
     * 先右后左
     */
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

    /**
     * 先左后右
     */
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
        private DeadLockDomain deadLockTest;
        public DeadThread1(DeadLockDomain deadLockTest) {
            this.deadLockTest = deadLockTest;
        }
        @Override
        public void run() {
            deadLockTest.leftRight();
        }
    }

    static class DeadThread2 implements Runnable {
        private DeadLockDomain deadLockTest;
        public DeadThread2(DeadLockDomain deadLockTest) {
            this.deadLockTest = deadLockTest;
        }
        @Override
        public void run() {
            deadLockTest.rightLeft();
        }
    }

    public static void main(String[] args) {
        DeadLockDomain deadLockDomain = new DeadLockDomain();
        new Thread(new DeadThread1(deadLockDomain)).start();
        new Thread(new DeadThread2(deadLockDomain)).start();
    }

}


