package cn.wzy.FieldAndMethod;

import java.lang.reflect.Field;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/9/14 10:09
 */
public class GetSuperField {

	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
		Class<User> clazz = User.class;
		User user = new User();
		Field field = clazz.getSuperclass().getDeclaredField("name");
		field.setAccessible(true);
		field.set(user, "wzy");
		System.out.println(user.getName());
	}
}
