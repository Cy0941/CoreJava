package cn.cxy.test.Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Function: 单线程服务器
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/4/22 15:01 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class EchoServer {

    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(8189);
            //会一直阻塞
            System.out.println("Echo is running with port 8089 ...");
            Socket incoming = s.accept();
            InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();
            Scanner scanner = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream, true);
            out.println("Hello,Enter BYE to exit");
            boolean done = false;
            while (!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Msg from client: " + line);
                out.println("Echo: " + line);
                if (line.trim().equals("BYE")) {
                    done = true;
                    //关闭套接字
                    incoming.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
