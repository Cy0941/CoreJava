package cn.cxy.test.ch6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/27 23:26 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class InnerClassTest {
    public static void main(String[] args){
        TalkingClock clock = new TalkingClock(3000,true);
        //TODO 创建内部类的方式
        TalkingClock.TimePrinter printer = clock.new TimePrinter();
        clock.start();
        JOptionPane.showMessageDialog(null,"Quit Program?");
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

    public void start(){
        //TODO
        this.new TimePrinter();

        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval,listener);
        t.start();
    }

    /**
     * 此类随所在类方法创建（不是所有的所在类都含有此内部类对象）
     * TODO 只有内部类可以是 私有private 的
     */
    public class TimePrinter implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            Date now = new Date();
            System.out.println("At the tone,the time is "+now);
            if (TalkingClock.this.beep){
            //if (beep){
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
