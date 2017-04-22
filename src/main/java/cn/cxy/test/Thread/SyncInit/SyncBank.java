package cn.cxy.test.Thread.SyncInit;

/**
 * Function: 使用 synchronized 关键字实现锁与条件对象
 * Reason: TODO synchronized - 内部锁与内部条件对象
 * Date: 2017/3/25 11:10 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class SyncBank {

    private final double[] accounts;

    public SyncBank(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < n; i++) {
            accounts[i] = initialBalance;
        }
    }

    public synchronized void transfer(int from, int to, double amount) {
        try {
            //TODO 循环判定是否进入阻塞
            while (accounts[from] < amount) {
                wait();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d ", amount, from, to);
            System.out.println();
            accounts[to] += amount;
            //TODO 锁是可重入的 -- 被一个锁保护的代码可以调用另一个使用相同的锁的方法 -- getTotalBalance()
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            //解除对应阻塞
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized double getTotalBalance() {
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
