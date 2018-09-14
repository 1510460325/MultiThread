package cn.wzy.FieldAndMethod;

import java.lang.reflect.Field;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/9/14 9:38
 */
public class Main {

	public static void main(String[] args) {
		Class<User> clazz = User.class;
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		System.out.println("========*****========");
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field.getName());
		}
	}
}
