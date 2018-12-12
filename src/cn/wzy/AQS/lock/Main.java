package cn.wzy.AQS.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	private static Lock lock = new ReentrantLock();

	private static Condition condition = lock.newCondition();

	private static int id;
	public static void work() throws InterruptedException {
		while (!lock.tryLock()) {
			Thread.sleep(200);
		}
		condition.await();
		System.out.println(id++);
		condition.signal();
		lock.unlock();
	}

	public static void Fistnotify() {
		lock.lock();
		condition.signal();
		lock.unlock();
	}
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 500;i++) {
			new Thread(()-> {
				try {
					work();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}
		while (Thread.activeCount() < 501) {
			Thread.sleep(500);
			System.out.println(Thread.activeCount());
		}
		boolean flag = false;
		while (Thread.activeCount() > 2) {
			if (!flag) {
				flag = !flag;
			}
			Fistnotify();
			Thread.sleep(500);
			System.out.println(Thread.activeCount());
		}
		System.out.println(id);
	}
}
