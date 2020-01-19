package concurrency;

import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YuanXiaolong
 * @date 2020/1/15 10:19 上午
 */
public class Interrupting {
    private final static ExecutorService exec = Executors.newCachedThreadPool();
    private static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
//        exec.execute(r);
        TimeUnit.MICROSECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupt send to " + r.getClass().getName());

    }

    public static void main(String[] args) throws Exception {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        test(new LockedBlocked());

//        exec.shutdownNow();

        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }
}

class SleepBlocked implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable {
    private InputStream in;
    public IOBlocked(InputStream is) {
        in = is;
    }
    @Override
    public void run() {
        try {
            System.out.println("Waiting for read():");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from block I/O");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked run()");
    }
}

class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread(() -> f()).start();
    }

    @Override
    public void run() {
        System.out.println("trying to call f():");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}

class LockedBlocked implements Runnable {
    private final Lock lock = new ReentrantLock();
    public void f() {
        try{
            lock.lockInterruptibly();
            while (true) {
                Thread.yield();
            }
        } catch (InterruptedException e) {
            System.out.println("Lock InterruptedException");
        } finally {
            lock.unlock();
        }

    }

    public LockedBlocked() {
        new Thread(() -> f()).start();
    }

    @Override
    public void run() {
        System.out.println("trying to call f():");
        f();
        System.out.println("Exiting LockedBlocked.run()");
    }
}


