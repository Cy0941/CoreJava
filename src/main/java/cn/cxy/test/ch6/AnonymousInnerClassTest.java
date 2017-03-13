package cn.cxy.test.ch6;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Function: 匿名内部类
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/13 22:46 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args){
        TalkingClock_2 clock_2 = new TalkingClock_2();
        clock_2.start(1000,true);
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);

        //TODO “双括号初始化”
        /**
         * 外层括号：建立了一个 匿名子类
         * 内层括号：对象构造块
         */
        java.util.List<String> nameList = new ArrayList<String>(){{
            add("harry");
            add("porter");
        }};
    }
}

class TalkingClock_2{
    public void start(int interval,final boolean beep){
        //匿名内部类
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("At the tone,the time is "+now);
                if (beep){
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        Timer t = new Timer(interval,listener);
        t.start();
    }
}
