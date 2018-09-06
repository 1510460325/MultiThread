package cn.wzy.interactive;

import java.util.concurrent.*;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/9/6 8:44
 */
public class FutureCancel {

	public static void main(String[] args) {
		FutureTask<Integer> future = new FutureTask<>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				System.out.println("=======start run==========");
				return 15;
			}
		});
		new Thread(future).start();
		System.out.println("===begin====");
		future.cancel(true);
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (CancellationException e) {
			System.out.println("=====任务被取消=====");
		}
	}
}
