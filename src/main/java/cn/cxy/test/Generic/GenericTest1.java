package cn.cxy.test.Generic;

import java.io.Serializable;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/17 10:04 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class GenericTest1 {

    public static void main(String[] args){
        String[] words = {"Mary","had","little","lamb"};
        Pair<String> mm = ArrayAlg.minMax(words);
        System.out.println("min = "+mm.getFirst());
        System.out.println("max = "+mm.getSecond());

        String[] names = {"John","Q","Public"};
        String middle = ArrayAlg.getMiddle(names);
        System.out.println(middle);




    }

}

class ArrayAlg{

    /**
     * 通过 extends 关键字限制类型变量的上限范围
     * @param ts
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T> & Serializable> T min(T[] ts){
        if (null == ts || ts.length == 0){
            return null;
        }
        T smallest = ts[0];
        for (int i = 1; i < ts.length; i++) {
            if (smallest.compareTo(ts[i])>0){
                smallest = ts[i];
            }
        }
        return smallest;
    }

    /**
     * 类型变量放在修饰符后面，返回类型的前面
     * @param t
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T getMiddle(T[] t){
        return t[t.length / 2];
    }

    public static Pair<String> minMax(String[] a){
        if (null == a || a.length == 0){
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i])>0){
                min = a[i];
            }
            if (max.compareTo(a[i])<0){
                max = a[i];
            }
        }
        return new Pair<String>(min,max);
    }
}


