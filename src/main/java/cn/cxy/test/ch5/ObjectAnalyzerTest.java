package cn.cxy.test.ch5;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Function: 通用 toString 方法实现
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/21 14:56 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class ObjectAnalyzerTest {

    public static void main(String[] args){
        ArrayList<Integer> squares = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }

}

class ObjectAnalyzer{
    private ArrayList<Object> visited = new ArrayList<Object>();

    public String toString(Object object){
        if (object == null){
            return "null";
        }
        if (visited.contains(object)){
            return "...";
        }
        visited.add(object);
        Class<?> aClass = object.getClass();
        //字符串
        if (aClass == String.class){
            return (String)object;
        }
        //数组
        if (aClass.isArray()){
            String r = aClass.getComponentType()+"[]{";
            for (int i = 0; i < Array.getLength(object); i++) {
                if (i>0){
                    r += ",";
                }
                Object val = Array.get(object,i);
                //TODO isPrimitive() 确认是否为基本类型
                if (aClass.getComponentType().isPrimitive()){
                    r += val;
                }else {
                    r += toString(val);
                }
            }
            return r +"}";
        }

        String r = aClass.getName();
        do {
            r += "[";
            Field[] fields = aClass.getDeclaredFields();
            AccessibleObject.setAccessible(fields,true);
            for (Field f : fields){
                if (!Modifier.isStatic(f.getModifiers())){
                    if (!r.endsWith("[")){
                        r += ",";
                    }
                    try {
                        Class<?> t = f.getType();
                        Object val = f.get(object);
                        if (t.isPrimitive()){
                            r += val;
                        }else {
                            r += toString(val);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            aClass = aClass.getSuperclass();
        }while (aClass != null);
        return r;
    }
}
