package cn.cxy.test.Internationalization;

import java.text.Collator;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/4/26 9:26 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class MainTest {

    public static void main(String[] args) {
        /*Locale[] availableLocales = Locale.getAvailableLocales();
        for (Locale availableLocale : availableLocales) {
            System.out.println(availableLocale.getCountry());
        }*/

        Locale locale = new Locale("de", "DE");
        System.err.println(locale.getDisplayName(Locale.GERMAN));

        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        double amt = 123456.78;
        String format = fmt.format(amt);
        System.out.println(format);

        Locale aDefaultLocale = Locale.getDefault();
        Collator instance = Collator.getInstance(aDefaultLocale);
        String s1 = "aZ";
        String s2 = "Az";
        int compare = instance.compare(s1, s2);
        System.out.println(compare);

        char ca = 'a';
        char cz = 'z';
        char cA = 'A';
        char cZ = 'Z';
        System.err.println((int) ca + " : " + (int) cz + " : " + (int) cA + " : " + (int) cZ + " : "+ (int)' ');
    }

}
