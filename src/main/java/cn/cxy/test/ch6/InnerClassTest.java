package cn.cxy.test.ch6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/4 12:19 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class InnerClassTest {

    public static void main(String[] args){
        TalkingClock clock = new TalkingClock(1000,true);
        //TalkingClock.TimePrinter printer = clock.new TimePrinter();
        //clock.start();
        clock.start(1000,true);
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

}

class TalkingClock{
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start(int interval,final boolean beep){
        //TODO 内部类的创建必须依赖外部类（显示或隐式的标志）
        //ActionListener listener1 = this.new TimePrinter();
        //ActionListener listener0 = TalkingClock.this.new TimePrinter();
        TalkingClock.TimePrinter listener = new TimePrinter();
        Timer t = new Timer(interval,listener);
        t.start();

        //TODO 局部内部类 局部类不能使用 public 或 private 访问说明符进行说明
        class TimePrinter2 implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("At the tone,the time is "+now);
                //TODO 引用外部类的参数
                //if (beep){
                //if (TalkingClock.this.beep){
                //TODO final
                if (beep){
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }

        ActionListener listener2 = new TimePrinter2();
        Timer t2 = new Timer(1000,listener2);
        t2.start();
    }

    /**
     * 内部类
     */
    public class TimePrinter implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            Date now = new Date();
            System.out.println("At the tone,the time is "+now);
            //if (beep){
            if (TalkingClock.this.beep){
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
