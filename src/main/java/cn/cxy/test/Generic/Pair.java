package cn.cxy.test.Generic;

/**
 * Function: 泛型类定义
 * Reason: 泛型标志 T(表示任意类型) 紧跟类名.</br>
 * Date: 2017/3/17 9:54 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class Pair<T> {

    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public Pair() {
        first = null;
        second = null;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
