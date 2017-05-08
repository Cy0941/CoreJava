package cn.cxy.test.RMI;

import javax.naming.*;
import java.rmi.RemoteException;

/**
 * Function: TODO
 * Reason: TODO 在一个全局注册表中，想保持一个名字的唯一是非常困难的 -- 自举服务只应该用该用来注册非常少的远程对象.</br>
 * Date: 2017/5/8 16:50 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class WarehouseClient {

    public static void main(String[] args){
        try {
            Context namingContext = new InitialContext();
            System.out.println("RMI registry bindings: ");
            //cxy NameClassPair 是一个助手类，包含绑定对象的名字和该对象所属类的名字
            NamingEnumeration<NameClassPair> e = namingContext.list("rmi://localhost:1099/");
            while (e.hasMoreElements()){
                System.out.println(e.nextElement().getName());
            }

            String url = "rmi://localhost:1099/central_warehouse";
            Warehouse_1 centralWarehouse = (Warehouse_1)namingContext.lookup(url);

            String desc = "Blackwell Toaster";
            double price = centralWarehouse.getPrice(desc);
            System.out.println(desc+" : "+price);
        } catch (NamingException e1) {
            e1.printStackTrace();
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }

}
