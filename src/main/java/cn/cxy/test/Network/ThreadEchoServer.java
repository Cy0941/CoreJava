package cn.cxy.test.Network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/4/22 15:20 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class ThreadEchoServer {

    public static void main(String[] args) {
        try {
            int i = 1;
            ServerSocket s = new ServerSocket(8189);
            while (true) {
                //TODO 一直阻塞
                Socket incoming = s.accept();

                //可中断套接字及获取对应读取、输出流
                //SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8189));
                //Scanner scanner = new Scanner(channel);
                //OutputStream outputStream = Channels.newOutputStream(channel);

                System.out.println("Spawning " + i);
                Runnable runnable = new ThreadedEchoHandler(incoming);
                Thread thread = new Thread(runnable);
                thread.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
