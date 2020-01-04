package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author YuanXiaolong
 * @date 2019/12/17 8:24 下午
 */
public class InterruptedTest implements Runnable{

    @Override
    public void run() {
        while (true) {
            if (Thread.interrupted()) {
                break;
            }
        }
        System.out.println("over");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new InterruptedTest());
        t.start();
        TimeUnit.MILLISECONDS.sleep(1);
        t.interrupt();
    }
}
