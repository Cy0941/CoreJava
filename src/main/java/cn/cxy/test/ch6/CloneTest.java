package cn.cxy.test.ch6;

import java.util.Date;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/27 22:52 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class CloneTest {

    public static void main(String[] args){
        try {
            Employee original = new Employee("John",5000.0,new Date());
            original.setHireDay(2000,1,1);
            //TODO 深克隆 对克隆对象的改变不影像原对象
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2012,1,20);
            System.out.println("original:"+original);
            System.err.println("copy:"+copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
