package concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.*;

/**
 * @author YuanXiaolong
 * @date 2020/1/19 7:04 下午
 */
class LiftOffRunning implements Runnable {
    BlockingQueue<LiftOff> rockets;

    public LiftOffRunning(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            System.out.println("Interrupt during put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupt during take()");
        }
        System.out.println("Exiting LiftOfRunner");
    }
}

public class TestBlockingQueues {

    public static void main(String[] args) throws InterruptedException {
        test("LinkedBlockingQueue",new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlokingQueue",new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue",new SynchronousQueue<>());
    }

    private static void test(String msg, BlockingQueue<LiftOff> es) throws InterruptedException {
        Thread  t = new Thread(new LiftOffRunning(es));
        t.start();
        for (int i = 0; i < 5; i++) {
            es.put(new LiftOff(5));
        }
        getKey("Press 'Enter' (" + msg + ")");
        t.interrupt();
        System.out.println("Finished " + msg + " test");

    }

    private static void getKey(String s) {
        System.out.println(s);
        getKey();
    }

    private static void getKey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
