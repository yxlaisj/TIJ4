package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author YuanXiaolong
 * @date 2019/12/12 6:27 下午
 */
public class ExceptionThread implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            new Thread(new ExceptionThread()).start();
        } catch (Exception e) {
            // 抓不到其它线程的异常
            System.out.println("抓不到其它线程异常");
        }
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (Exception e) {
            System.out.println("同样抓不到异常");
        }

    }
}
