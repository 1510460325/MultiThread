package cn.wzy.Executor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/9/12 18:55
 */
public class ThreadPool {

	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(
			3
			,3
			,100l
			, TimeUnit.SECONDS
			, new LinkedBlockingQueue<Runnable>(50)
			, new ThreadPoolExecutor.AbortPolicy()
		);
		Runnable run = new Runnable() {
			@Override
			public void run() {
				System.out.println("===" + Thread.currentThread().getId() + "===");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		for (int i = 0; i < 10; i++) {
			try {
				pool.execute(run);
			} catch (RejectedExecutionException e) {
				e.printStackTrace();
				System.out.println("任务被拒.");
			}
		}
		pool.shutdown();
	}
}
