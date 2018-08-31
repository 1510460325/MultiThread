package cn.wzy.Executor;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/8/31 15:23
 */
public class ScheduleThreadPool {

		public static void main(String[] args) {
				ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
				executor.scheduleWithFixedDelay(new Runnable() {
						@Override
						public void run() {
								System.out.println("start.");
						}
				},0, 5000,TimeUnit.MILLISECONDS);

		}


}
