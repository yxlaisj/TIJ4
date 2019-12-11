package concurrency;

/**
 * @author YuanXiaolong
 * @date 2019/12/8 7:13 下午
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}
