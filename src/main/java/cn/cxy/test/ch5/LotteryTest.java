package cn.cxy.test.ch5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/10 15:36 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class LotteryTest {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.println("How many numbers do you need to draw ?");
        int k = in.nextInt(); // 5

        System.out.println("What is the highest number you can draw ?");
        int n = in.nextInt(); // 20

        //待抽取号码集合
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        System.out.println();
        //号码抽取结果集合
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int r;
            if (i ==0){
                r = 5;
            }else
            //抽取下标
            r = (int) (Math.random() * n); // 0-19
            System.err.println(r);
            result[i] = numbers[r];
            numbers[r] = numbers[n - 1];
            System.out.println(Arrays.toString(numbers));
            n--;
        }
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
    }


}
