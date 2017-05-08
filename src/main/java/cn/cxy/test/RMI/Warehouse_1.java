package cn.cxy.test.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Function: 远程方法调用 - 远程对象的能力是由客户端和服务器之间共享的接口表示的
 * Reason: 1、远程对象接口必须扩展 java.rmi.Remote 接口；</br>
 *         2、接口中的方法必须抛出 java.rmi.RemoteException 异常 </br>
 *         3、要求每一次调用该方法的类必须捕获 java.rmi.RemoteException 异常，且指明当调用失败时的操作
 * Date: 2017/5/8 15:57 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public interface Warehouse_1 extends Remote {

    double getPrice(String description) throws RemoteException;

}
