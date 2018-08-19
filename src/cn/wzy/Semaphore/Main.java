package cn.wzy.Semaphore;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/8/19 18:20
 */
public class Main {

    public static void main(String[] args) {
        Worker worker = new Worker();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    worker.work();
                }
            },"Thread" + i).start();
        }
    }
}
