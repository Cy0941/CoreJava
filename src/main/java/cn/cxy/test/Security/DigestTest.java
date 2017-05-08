package cn.cxy.test.Security;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Function: 加密测试 -- 消息摘要计算
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/5/8 10:53 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class DigestTest {

    public static void main(String[] args) {
        try {
            MessageDigest alg = MessageDigest.getInstance("SHA-1");
            byte[] input = Files.readAllBytes(Paths.get(args[0]));
            byte[] hash = alg.digest(input);
            String d = "";
            for (int i = 0; i < hash.length; i++) {
                int v = hash[i] & 0xFF;
                if (v < 16){
                    d += "0";
                }
                d += Integer.toString(v,16).toUpperCase()+" ";
                System.out.println(d);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
