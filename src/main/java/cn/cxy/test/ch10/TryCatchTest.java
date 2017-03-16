package cn.cxy.test.ch10;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/16 18:16 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class TryCatchTest {

    public static void main(String[] args){
        int i = tryCatch(2);
        System.out.println(i);
    }

    private static int tryCatch(int n){
        try {
            int r = n * n;
            return r;
        }finally {
            //TODO 如果 finally 块中包含 return ；则该 return 会先于 try 中的 return 执行并会覆盖 try 中原本的返回值
            if (n == 2){
                return 0;
            }
        }
    }

}
