package concurrency;

/**
 * @author YuanXiaolong
 * @date 2019/12/12 3:37 下午
 */
public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread t = new Thread(this);
    public SelfManaged() {
        t.start();
    }
    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + ")";
    }
    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
