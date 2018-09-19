package cn.wzy.ThreadScope.escape;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/9/19 9:16
 */
public class Escape {
	static Escape escape = null;

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("====gc====");
		escape = this;
	}

	public static void main(String[] args) throws InterruptedException {
		escape = new Escape();
		escape = null;
		System.gc();//执行上一个对象的finalize方法
		Thread.sleep(5000);
		if (escape != null) {
			System.out.println("====alive=====");
		} else {
			System.out.println("=====dead=====");
		}
		escape = null;
		System.gc();
		Thread.sleep(5000);
		if (escape != null) {
			System.out.println("====alive=====");
		} else {
			System.out.println("=====dead=====");
		}
	}
}
