package cn.wzy.string;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/9/1 9:47
 */
public class StringTest {
	public static void main(String[] args) {

		String s = "asdf";
		String s1 = s + "a";
		String str = s + "a";
		System.out.println(s1.hashCode() == str.hashCode());
		System.out.println(s1 == str);

		String s2 = "asdf" + "a";
		String s3 = "asdf" + "a";
		System.out.println(s2.hashCode() == s3.hashCode());
		System.out.println(s2 == s3);
	}
}
