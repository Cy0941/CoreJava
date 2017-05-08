package cn.cxy.test.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Function: 1、扩展自 java.rmi.server.UnicastRemoteObject ，其构造器使得它的对象可提供远程访问</br>
 *           2、如果因为扩展了其他类等不希望扩展 UnicastRemoteObject ，则需手动实例化远程对象，并将它们传递给静态的 exportObject() 方法
 *              UnicastRemoteObject.exportObject(this,0); - 0 表示任何合适的端口都可用来监听客户连接
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/5/8 16:02 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class WarehouseImpl_2 extends UnicastRemoteObject implements Warehouse_1 {

    private Map<String, Double> prices;

    //构造器抛出异常
    public WarehouseImpl_2() throws RemoteException {
        prices = new HashMap<String, Double>();
        prices.put("Blackwell Toaster", 24.95);
        prices.put("ZapXpress Microwave Oven", 49.95);
    }

    public double getPrice(String description) throws RemoteException {
        Double price = prices.get(description);
        return price == null ? 0 : price;
    }

}
