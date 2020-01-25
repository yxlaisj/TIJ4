package concurrency;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author YuanXiaolong
 * @date 2020/1/21 3:27 下午
 */
public class DeadlockingDiningPhilosophers {
    public static void main(String[] args) throws IOException {
        int ponder = 5;
        if (args.length > 0) {
            ponder = Integer.parseInt(args[0]);
        }
        Chopstick[] sticks = new Chopstick[5];
        for (int i = 0; i < 5; i++) {
            sticks[i] = new Chopstick();
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Philosopher(sticks[i],sticks[(i + 1) % 5],i,ponder));
        }
        System.out.println("Press 'Enter' to quit");
        System.in.read();
        exec.shutdownNow();
    }
}
