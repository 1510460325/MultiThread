package cn.wzy.FutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/8/19 16:28
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> future = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 15-15*89;
            }
        });
        Thread thread = new Thread(future);
        thread.start();
        System.out.println(future.get());

        /**
         * future.get() 在执行完毕之后返回一个对象，如果代码在执行中，则一直阻塞。
         * 执行场景：等待执行完毕之后会自动调用执行下去，异步任务
         */
    }

}
