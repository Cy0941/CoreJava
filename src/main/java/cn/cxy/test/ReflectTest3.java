package cn.cxy.test;

import java.lang.reflect.Field;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/18 15:26 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class ReflectTest3 {
    public static void main(String[] args){
        Employee employee = new Employee("Harry",5000);
        Class<? extends Employee> aClass = employee.getClass();
        try {
            Field name = aClass.getDeclaredField("name");
            name.setAccessible(true);
            //TODO name.get(employee) 获取 employee 对象的 name 属性
            Object o = name.get(employee);
            name = aClass.getDeclaredField("salary");
            //解除 private 属性无法访问的问题
            name.setAccessible(true);
            double aDouble = name.getDouble(employee);
            //通过反射设置字段值
            name.setDouble(employee,5000);
            System.err.println("aDouble: "+aDouble);
            System.out.println(name + " " + o);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
