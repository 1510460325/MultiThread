package cn.wzy.Executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/8/28 15:31
 */
public class FixThreadPoll {

		/**
		 * 保证足够的线程处于运行状态。
		 */
		private static final Executor exe = Executors.newFixedThreadPool(2);

		public static void main(String[] args) {
				Runnable one = new Runnable() {
						@Override
						public void run() {
								System.out.println("i'm thread-.");
								try {
										Thread.sleep(5000);
								} catch (InterruptedException e) {
										e.printStackTrace();
								}
						}
				};
				exe.execute(one);
				System.out.println("end");
		}
}
