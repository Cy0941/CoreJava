package cn.cxy.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/2/18 13:40 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public enum Size {

    SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");

    Size(String abbreviation){
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation(){
        return abbreviation;
    }

    private String abbreviation;

    public static void main(String[] args){
        String s = Size.SMALL.toString();
        System.out.println(s);

        Size[] values = Size.values();
        System.err.println("Enum Values: "+ Arrays.toString(values));


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size:(SMALL,MEDIUM,LARGE,EXTRA_LARGE");
        String input = scanner.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size = "+size);
        System.out.println("abbreviation="+size.getAbbreviation());
        if (size == Size.EXTRA_LARGE){
            System.out.println("Good job -- you paid attention to the _.");
        }
    }

}
