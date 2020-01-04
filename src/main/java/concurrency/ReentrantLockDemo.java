package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YuanXiaolong
 * @date 2019/12/20 11:25 上午
 */
public class ReentrantLockDemo {
    // 转出账户
    private Account from;
    // 转入账户
    private Account to;
    // 持有重入锁
    private Lock lock = new ReentrantLock();

    public ReentrantLockDemo(Account from, Account to) {
        this.from = from;
        this.to = to;
    }

    /**
     * 转账操作，从from账户转money额度到to账户
     */
    public void transform(int money) {
        lock.lock();
        try {
            from.minus(money);
            Thread.yield();     // 为了更大几率让其它线程进入
            to.add(money);
            System.out.println(Thread.currentThread() + " from.money = " + from.money + "; to.money = " + to.money);
        } finally {
          lock.unlock();
        }
    }

    public static void multiThreadTransform(ReentrantLockDemo demo) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(() -> {
                demo.transform(10);
            });
        }
        exec.shutdown();
    }

    public static void main(String[] args) {
        Account from = new Account(),
                to = new Account();
        ReentrantLockDemo demo = new ReentrantLockDemo(from, to);
        multiThreadTransform(demo);

    }
}

class Account {
    // 账号初始额度为100元
    int money = 100;

    void add(int m) {
        money += m;
    }

    void minus(int m) {
        money -= m;
    }
}
