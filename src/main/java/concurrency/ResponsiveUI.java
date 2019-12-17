package concurrency;

import java.io.IOException;

/**
 * @author YuanXiaolong
 * @date 2019/12/12 6:16 下午
 */
public class ResponsiveUI extends Thread{
    private static volatile double d = 1;
    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws IOException {
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
