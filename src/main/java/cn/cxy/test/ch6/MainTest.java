package cn.cxy.test.ch6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/23 10:58 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class MainTest {

    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        for (String s : list){
            System.out.println(s);
        }

        //TODO 看不懂啊
        //int count = 0;
        final int[] counter = new int[1];
        Date[] dates = new Date[100];
        for (int i = 0; i < dates.length; i++)
            dates[i] = new Date(){
                public int compareTo(Date other){
                    //count ++;
                    counter[0]++;
                    return super.compareTo(other);
                }
            };
        Arrays.sort(dates);
        //System.out.println(count + " comparisons.");
        System.out.println(counter[0]+" comparisons.");
    }
}
