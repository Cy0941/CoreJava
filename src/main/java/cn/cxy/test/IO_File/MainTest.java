package cn.cxy.test.IO_File;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/4/6 18:05 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class MainTest {

    public static void main(String[] args){
        //确定当前当前平台哪些字符集可用
        //SortedMap<String, Charset> cset = Charset.availableCharsets();
        //for (String name : cset.keySet()){
        //    System.out.println(cset.get(name));
        //}

        //编码
        Charset cs = Charset.forName("UTF-16");
        //此编码的别名
        /*Set<String> aliases = cs.aliases();
        for (String alias : aliases) {
            System.out.println(alias);
        }*/
        String str = "这是测试内容";
        ByteBuffer buf = cs.encode(str);
        byte[] array = buf.array();
        System.out.println(Arrays.toString(array));
        //解码
        ByteBuffer wrap = ByteBuffer.wrap(array);
        CharBuffer decode = cs.decode(wrap);//使用相同charset进行解码
        String s = decode.toString();
        System.err.println(s);
    }

}
