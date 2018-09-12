package cn.wzy.Executor;

import java.util.concurrent.*;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/9/12 18:55
 */
public class ThreadPool {

	public static void main(String[] args) {

		//自定义线程工厂实现类
		ThreadFactory myFactory = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r,"wzy线程");
			}
		};


		ThreadPoolExecutor pool = new ThreadPoolExecutor(
			3
			, 10
			, 2
			, TimeUnit.SECONDS
			, new LinkedBlockingQueue<Runnable>(3) //工作队列
			, myFactory                                 //自定义线程工厂
			, new ThreadPoolExecutor.AbortPolicy()//默认拒绝方式，舍弃策略
		);
		Runnable run = new Runnable() {
			@Override
			public void run() {
				System.out.println("===" + Thread.currentThread().getId() + "===");
				try {
					Thread.sleep(5000);
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
		pool.shutdown();//等待线程池已经提交的任务执行完毕之后关闭线程池
	}
}
