package cn.cxy.test.ch13_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/22 23:10 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class MainTest {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
        strList.add("g");
        strList.add("c");
        strList.add("e");
        strList.add("q");
        //默认字典升序排列
        Collections.sort(strList);
        System.out.println("default dict asc sort:"+ strList);
        //Collections.sort(strList, Collections.<String>reverseOrder());
        //System.err.println("change to desc sort:" + strList);
        //二分法查找
        int a = Collections.binarySearch(strList, "a");
        System.out.println("---------+++   " + a);

        /*List<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < 49; i++) {
            numList.add(i);
        }
        Collections.shuffle(numList);
        List<Integer> subList = numList.subList(0, 6);
        Collections.sort(subList,Collections.<Integer>reverseOrder());
        System.out.println(subList);*/
    }

}
