package cn.cxy.test.RMI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

/**
 * Function: RMI 注册表 - 获取本地存根方法：调用另一个服务对象上的另一个远程方法，已返回值的方式获得存根
 * Reason:  1、JDK 提供自举注册服务（bootstrap register service) - 需要一个RMI URL 和一个对实现对象的引用
 *          2、RMI 的 URL 以 rmi: 开头，后接服务器以及一个可选的端口号，接着是远程对象的（希望是）唯一的名字
 * Date: 2017/5/8 16:22 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class WarehouseServer_3 {

    public static void main(String[] args) throws RemoteException,NamingException{
        System.out.println("Constructing server implementation...");
        WarehouseImpl_2 centralWarehouse = new WarehouseImpl_2();
        System.out.println("Binding server implementation to registry...");
        Context namingContext = new InitialContext();
        //cxy 默认情况下，主机名是 localhost，端口号是 1099
        namingContext.bind("rmi:central_warehouse",centralWarehouse);
        System.out.println("Waiting fro invocations from clients...");
    }

}
