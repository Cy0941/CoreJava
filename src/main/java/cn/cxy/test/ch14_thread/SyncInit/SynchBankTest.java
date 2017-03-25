package cn.cxy.test.ch14_thread.SyncInit;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/24 0:17 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class SynchBankTest {

    public static final int NACCOUNTS = 100;
public static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(bank, i, INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }

}
