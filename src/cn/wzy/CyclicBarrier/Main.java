package cn.wzy.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/8/19 20:52
 */
public class Main {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(9, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("人到齐了,开始干活..");
            }
        });
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("waiting...");
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("一起来干活.");
                }
            }).start();
        }
    }
}
