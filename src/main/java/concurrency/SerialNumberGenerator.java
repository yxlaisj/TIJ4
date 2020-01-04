package concurrency;

/**
 * @author YuanXiaolong
 * @date 2020/1/2 7:48 下午
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public synchronized static int nextSerialNumber() {
        return serialNumber++;
    }
}
