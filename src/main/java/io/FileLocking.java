package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @author YuanXiaolong
 * @date 2019/11/17 7:50 下午
 */
public class FileLocking {
    private static final String file = "/Users/yuanxiaolong/Downloads/file.txt";
    public static void main(String[] args) {
        try (FileChannel fc = new FileOutputStream(file).getChannel()) {
            FileLock lock = fc.tryLock();
            if (lock != null) {
                System.out.println("Locked File");
                TimeUnit.MILLISECONDS.sleep(100);
                lock.release();
                System.out.println("Released Lock");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
