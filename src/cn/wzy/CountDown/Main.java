package cn.wzy.CountDown;

import java.util.concurrent.CountDownLatch;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/8/19 16:03
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch start = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程：" + Thread.currentThread().getId() + " ready..");
                        start.await();
                        System.out.println("线程：" + Thread.currentThread().getId() + " complete..");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        System.out.println("我说开始才开始..  start");
        Thread.sleep(5000);
        System.out.println("start!");
        start.countDown();
        //countDown() 减少一个限制，当限制为0的时候，所有等待的线程就会继续执行下去
    }
}
