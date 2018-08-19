package cn.wzy.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/8/19 18:22
 */
public class Worker {

    private Semaphore tools = new Semaphore(10);


    /**
     * 信号量，控制访问线程的个数
     */
    public void work() {
        try {
            tools.acquire(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("working for " + Thread.currentThread().getName()+ " ...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tools.release(2);
    }
}
