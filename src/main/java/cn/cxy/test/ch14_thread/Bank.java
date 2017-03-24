package cn.cxy.test.ch14_thread;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/3/24 0:06 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class Bank {

    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < n; i++) {
            accounts[i] = initialBalance;
        }
    }

    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d , and totalBalance is : %s", amount, from, to,getTotalBalance());
        System.out.println();
        accounts[to] += amount;
    }

    public double getTotalBalance() {
        double sum = 0;
        for (double account : accounts) {
            sum += account;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }

}
