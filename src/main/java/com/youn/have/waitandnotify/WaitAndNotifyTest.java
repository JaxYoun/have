package com.youn.have.waitandnotify;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author：YangJx
 * @Description：等待唤醒机制测试
 * @DateTime：2018/1/24 9:41
 */
@Slf4j
public class WaitAndNotifyTest {

    @Data
    @Slf4j
    private static class User {

        private String name;
        private String sex;
        private boolean flag;

        private void sing() {
            System.out.printf("%s=====%s\n", this.getName(), this.getSex());
        }


        public void man() {
            synchronized (this) {
                while (true) {
                    if (this.isFlag()) {
                        this.sing();
                        this.setName("Tom");
                        this.setSex("M");
                        this.setFlag(false);
                        this.notify();
                    } else {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            log.error(e.getMessage(), e);
                        }
                    }
                }
            }
        }

        public void women() {
            synchronized (this) {
                while (true) {
                    if (!this.isFlag()) {
                        this.sing();
                        this.setName("Lily");
                        this.setSex("W");
                        this.setFlag(true);
                        this.notify();
                    } else {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            log.error(e.getMessage(), e);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        User user = new User();
        new Thread(() -> user.man()).start();
        new Thread(() -> user.women()).start();
    }
}
