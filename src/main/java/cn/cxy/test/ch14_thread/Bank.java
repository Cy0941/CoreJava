package cn.cxy.test.ch14_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
    /**
     * 锁 - 同步访问机制实现
     */
    private Lock bankLock;

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < n; i++) {
            accounts[i] = initialBalance;
        }
        //TODO 锁
        bankLock = new ReentrantLock();
    }

    public void transfer(int from, int to, double amount) {
        bankLock.lock();
        try {
            if (accounts[from] < amount) {
                return;
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d ", amount, from, to);
            System.out.println();
            accounts[to] += amount;
            //TODO 锁是可重入的 -- 被一个锁保护的代码可以调用另一个使用相同的锁的方法 -- getTotalBalance()
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        }finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;
            for (double account : accounts) {
                sum += account;
            }
            return sum;
        }finally {
            bankLock.unlock();
        }
    }

    public int size() {
        return accounts.length;
    }

}
