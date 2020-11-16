package com.shenge.study.concurrent.thread;

/**
 * @author : Shi Yue Sheng
 * @date : 2020/11/13
 * @time : 11:35 AM
 * @desc : 描述
 *
 * wait，notify，notifyAll 是对象示例方法
 * 使用时必须在synchronized同步块内，而且同步块锁定的对象必须是同一个，不然会抛出 IllegalMonitorStateException
 * 这个异常代表管程的状态不正确，前置状态是当前线程已经在该对象的管程上面拿到了锁。
 *
 *
 *
 */
public class WaitTest {
    private static Object lockA = new Object();
    private static Object lockB = new Object();

    public void waitMethod() {
        synchronized(lockA) {
            try {
                System.out.println("线程等待：" + Thread.currentThread().getName());
                lockB.wait();
                System.out.println("线程唤醒1：" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程唤醒2：" + Thread.currentThread().getName());
        }
    }

    public void notifyMethod() {
        synchronized(lockA) {
            try {
                System.out.println("唤醒");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockB.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitTest test = new WaitTest();
        Thread waitThread = new Thread(() -> {
            test.waitMethod();
        });
        WaitTest test1 = new WaitTest();
        Thread notifyThread = new Thread(() -> {
            test1.notifyMethod();
        });

        waitThread.start();
        notifyThread.start();
    }
}