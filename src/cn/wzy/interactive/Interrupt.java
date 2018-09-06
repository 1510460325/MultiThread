package cn.wzy.interactive;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/9/1 9:21
 */
public class Interrupt {

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("start");
				System.out.println(Thread.currentThread().isInterrupted());
				try {
					Thread.sleep(0);
				} catch (InterruptedException e) {
					System.out.println("阻断");
					System.out.println(Thread.interrupted());
					System.out.println("继续");
				}
				System.out.println("end");
			}
		});
		thread.start();
		thread.interrupt();
		System.out.println("All end.");
	}
}
