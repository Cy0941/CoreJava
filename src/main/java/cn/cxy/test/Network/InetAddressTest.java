package cn.cxy.test.Network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/4/22 14:45 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        String host = "www.baidu.com";
        //InetAddress - 如果需要在主机名和因特网地址之间切换使用
        InetAddress byName = InetAddress.getByName(host);
        byte[] addressByte = byName.getAddress();
        System.err.println(Arrays.toString(addressByte));
        //返回所有主机名对应的网址
        InetAddress[] allByName = InetAddress.getAllByName(host);
        for (InetAddress address : allByName) {
            System.out.println(address.getHostAddress());
        }
        System.out.println();
        //TODO 获取本地主机地址 - 可供外部访问
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
    }

}
