package concurrency;

/**
 * @author YuanXiaolong
 * @date 2019/12/8 7:14 下午
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
