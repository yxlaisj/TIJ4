package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author YuanXiaolong
 * @date 2019/12/12 3:50 下午
 */
public class InnerRunnable2 {
    private int countDown = 5;
    private Runnable inner;

    public InnerRunnable2(String name) {
        inner = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public String toString() {
                return Thread.currentThread().getName() + ": " + countDown;
            }
        };
        new Thread(inner,name).start();
    }

    public static void main(String[] args) {
        new InnerRunnable2("asd");
    }
}
