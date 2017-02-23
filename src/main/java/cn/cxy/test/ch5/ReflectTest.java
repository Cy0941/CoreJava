package cn.cxy.test.ch5;

import java.lang.reflect.Constructor;
import java.util.Date;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/18 14:02 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Employee em = new Employee("Harry",5000);
        String name = em.getClass().getName();
        System.out.println(em.getName()+" : "+name);


        Date date = new Date();
        Class<? extends Date> aClass = date.getClass();
        System.err.println("aClass Name:"+aClass.getName());

        String className = "java.util.Date";
        Class<?> forName = Class.forName(className);
        System.out.println(" : "+forName);

        Class<String> stringClass = String.class;
        System.err.println("stringClass:"+stringClass);


        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);

        System.err.println(Double[].class.getName());
        System.err.println(double[].class.getName());

        Object o = forName.newInstance();
        System.out.println(o);

        Constructor<?>[] constructors = forName.getConstructors();
        for (Constructor c : constructors){
            //c.newInstance()
        }

    }

}
