package cn.cxy.test.ch5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/18 14:40 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class ReflectTest2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter class name(e.g. java.util.Date)");
        String name = sc.next();

        try {
            Class<?> aClass = Class.forName(name);
            Class<?> superclass = aClass.getSuperclass();
            //Modifier 获取修饰符
            String modifiers = Modifier.toString(aClass.getModifiers());
            if (modifiers.length() > 0){
                System.out.print(modifiers+" ");
            }
            System.out.print("class "+name);
            if (superclass != null && superclass != Object.class){
                System.out.print(" extends "+superclass.getName());
            }
            System.out.println("{\n");
            //构造方法
            printConstructors(aClass);
            System.out.println();
            //该类中定义的方法
            printMethods(aClass);
            System.out.println();
            //该类中定义的变量
            printFields(aClass);
            System.out.println("\r}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * 获取所有字段及名称
     * @param aClass
     */
    private static void printFields(Class<?> aClass) {
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f : declaredFields){
            Class<?> type = f.getType();//类型
            String name = f.getName();//名称
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());//范围修饰符
            if (modifiers.length()>0){
                System.out.print(modifiers+" ");
            }
            System.out.println(type.getName()+" "+name+" ;");
        }
    }

    /**
     * 获取所有方法的完整名称
     * @param aClass
     */
    private static void printMethods(Class<?> aClass) {
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method m : declaredMethods){
            String s = Modifier.toString(m.getModifiers());//修饰符
            Class<?> returnType = m.getReturnType();//返回类型
            String name = m.getName();//方法名称
            Class<?>[] parameterTypes = m.getParameterTypes();//参数类型列表
            Class<?>[] exceptionTypes = m.getExceptionTypes();//可能抛出的异常
            StringBuilder sb = new StringBuilder();
            if (s.length()>0){
                sb.append(s+" ");
            }
            sb.append(returnType.getName()+" ");
            sb.append(name+" ( ");
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i != parameterTypes.length -1){
                    sb.append(parameterTypes[i].getName());
                    sb.append(",");
                }
            }
            sb.append(")");
            if (exceptionTypes.length>0){
                sb.append(" throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    sb.append(exceptionTypes[i].getName());
                    if (i != exceptionTypes.length-1){
                        sb.append(",");
                    }
                }
            }
            sb.append(";");
            System.out.println(sb.toString());
        }
    }

    /**
     * 获取完整的构造方法
     * @param aClass
     */
    private static void printConstructors(Class<?> aClass) {
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor c : declaredConstructors){
            String s = Modifier.toString(c.getModifiers());//修饰符
            //返回类型
            Class[] parameterTypes = c.getParameterTypes();//参数类型
            StringBuilder sb = new StringBuilder();
            if (s.length()>0){
                sb.append(s+" ");
            }
            sb.append(aClass.getName()+" ");
            sb.append("(");
            for (int i = 0; i < parameterTypes.length; i++) {
                sb.append(parameterTypes[i]);
                if (i != parameterTypes.length-1){
                    sb.append(",");
                }
            }
            sb.append(");");
            System.out.println(sb.toString());
        }
    }


}
