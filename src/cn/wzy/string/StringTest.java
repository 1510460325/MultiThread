package cn.wzy.string;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/9/1 9:47
 */
public class StringTest {
	public static void main(String[] args) {
		String s0 = "world";
		String s1 = "hello";
		String s2 = "hello" + "world";
		String s3 = "hello" + "world";
		System.out.println(s2 == s3);//true 编译期间明确知道是常量，所有取值唯一。
		String s4 = s1 + s0;
		String s5 = s1 + s0;
		System.out.println(s4 == s5);//false 编译期间取得是栈引用，所以不知道情况，所以新建到堆中，取值不一致

		System.out.println("========================");

		String s6 = new String("asdf");
		System.out.println(s6 = s6.intern());//运行期间扩充字符串常量池
		System.out.println(s6 == "asdf");
	}
}
