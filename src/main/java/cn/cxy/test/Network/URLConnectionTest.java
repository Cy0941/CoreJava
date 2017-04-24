package cn.cxy.test.Network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Function: URLConnection 功能步骤及编码
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/4/24 11:02 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class URLConnectionTest {

    public static void main(String[] args) throws IOException {
        String urlName;
        if (args.length > 0) {
            urlName = args[0];
        } else {
            urlName = "https://www.baidu.com";
        }
        URL url = new URL(urlName);
        //1、获取URLConnection对象
        URLConnection conn = url.openConnection();
        if (args.length > 2) {
            String username = args[1];
            String password = args[2];
            String input = username + ":" + password;
            String encoding = base64Encode(input);
            //2、设置任意请求属性
            conn.setDoOutput(true);//获得输出流 - 向一个服务器提交数据
            conn.setDoInput(true);//获得输入流 - 可以接收来自该 URLConnection 的输入
            conn.setRequestProperty("Authorization", "Basic " + encoding);
        }
        //3、调用 connect 方法连接远程资源
        conn.connect();

        //4、访问数据资源
        //print header fields
        Map<String, List<String>> headers = conn.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            String key = entry.getKey();
            for (String value : entry.getValue()) {
                System.out.println(key + " : " + value);
            }
        }

        //print convenience functions
        System.out.println("--------------");
        System.out.println("getContentType: " + conn.getContentType());
        System.out.println("getContentLength: " + conn.getContentLength());
        System.out.println("getContentEncoding: " + conn.getContentEncoding());
        System.out.println("getDate: " + conn.getDate());
        System.out.println("getExpiration: " + conn.getExpiration());
        System.out.println("getLastModified: " + conn.getLastModified());
        System.out.println("---------------");

        Scanner scanner = new Scanner(conn.getInputStream());//读取服务器返回的信息
        //print first ten lines of contents
        for (int n = 1; scanner.hasNextLine() && n <= 10; n++) {
            System.out.println(scanner.nextLine());
            if (scanner.hasNextLine()) {
                System.out.println("...");
            }
        }
    }

    /**
     * Base64编码
     *
     * @param s
     * @return
     */
    private static String base64Encode(String s) {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        Base64OutputStream out = new Base64OutputStream(bOut);
        try {
            out.write(s.getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bOut.toString();
    }

}
