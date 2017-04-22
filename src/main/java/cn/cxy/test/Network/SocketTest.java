package cn.cxy.test.Network;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/4/22 11:52 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class SocketTest {

    public static void main(String[] args){
        try {
            Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13);
            InputStream inputStream = s.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
