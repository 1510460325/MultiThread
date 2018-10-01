package cn.wzy.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/10/1 9:02
 */
public class Main {
	public static void main(String[] args) throws IOException {
		String command = "java -classpath C:\\Users\\wang\\Desktop AdressQuery 222.196.35.228";
		Process p = Runtime.getRuntime().exec(command);
		InputStream is = p.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is,"gbk"));
		String str;
		while ((str = reader.readLine()) != null) {
			System.out.println(str);
		}
	}
}
