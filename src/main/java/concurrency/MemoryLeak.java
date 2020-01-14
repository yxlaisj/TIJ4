package concurrency;

import java.util.Vector;

/**
 * @author YuanXiaolong
 * @date 2020/1/4 6:47 下午
 */
public class MemoryLeak {
    public static void main(String[] args) {
        Vector v = new Vector(10);
        for (int i = 0; i < 10; i++) {
            Object obj = new Object();
            v.add(obj);
            obj = null;
        }
    }
}
