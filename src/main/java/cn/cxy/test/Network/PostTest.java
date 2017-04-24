package cn.cxy.test.Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

/**
 * Function: POST请求实现
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/4/24 15:16 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class PostTest {

    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        try {
            InputStream in = Files.newInputStream(Paths.get(args[0]));
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //移除目标key及对应的value值 - 返回对应的value值
        String url = props.remove("url").toString();
        String result = doPost(url, props);
        System.out.println(result);
    }

    private static String doPost(String urlString, Map<Object, Object> nameValuePairs) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        //开启输出流 - 向服务器传递数据
        connection.setDoOutput(true);
        try {
            PrintWriter writer = new PrintWriter(connection.getOutputStream());
            boolean first = true;
            Set<Map.Entry<Object, Object>> entries = nameValuePairs.entrySet();
            for (Map.Entry<Object, Object> pair : entries) {
                if (first){
                    //排除第一个字符为 &
                    first = false;
                }else {
                    writer.print('&');
                }
                String name = pair.getKey().toString();
                String value = pair.getValue().toString();
                writer.print(name);
                writer.print('=');
                writer.print(URLEncoder.encode(value,"UTF-8"));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        StringBuilder response = new StringBuilder();
        try {
            Scanner in = new Scanner(connection.getInputStream());
            while (in.hasNextLine()){
                response.append(in.nextLine());
                response.append('\n');
            }
        }catch (IOException e){
            if (!(connection instanceof HttpURLConnection)){
                throw e;
            }
            InputStream err = ((HttpURLConnection)connection).getErrorStream();
            if (null == err){
                throw e;
            }
            Scanner in = new Scanner(err);
            response.append(in.nextLine());
            response.append('\n');
        }
        return response.toString();
    }

}
