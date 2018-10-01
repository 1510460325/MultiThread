package cn.wzy.string;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author wzy 不短不长八字刚好.
 * @since 2018/9/30 17:15
 */
public class AdressQuery {
	public static void main(String[] args) throws Exception {
		System.out.println(getData("http://www.ip138.com/ips138.asp?ip=" + "222.196.35.228" + "&action=2"));
	}

	public static String getData(String add) throws Exception {
		URL url = new URL(add);
		URLConnection connection = url.openConnection();
		connection.connect();
		InputStream inputStream = connection.getInputStream();
		BufferedReader reader = null;
		String start = "class=\"ul1\"><li>本站数据：";
		String end = "</li><li>参考数据1：";
		try {
			reader = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
			String ans;
			while ((ans = reader.readLine()) != null) {
				int index = ans.indexOf(start);
				if (index != -1) {
					int e = ans.indexOf(end, index);
					return ans.substring(index + 21, e);
				}
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}

		return "未查到该用户地址";
	}
}
