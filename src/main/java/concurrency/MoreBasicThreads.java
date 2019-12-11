package concurrency;

/**
 * @author YuanXiaolong
 * @date 2019/12/8 7:16 下午
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
