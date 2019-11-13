package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author YuanXiaolong
 * @date 2019/11/9 7:11 下午
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("/Users/yuanxiaolong/Downloads/test.out").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        fc = new RandomAccessFile("/Users/yuanxiaolong/Downloads/test.out","rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        fc = new FileInputStream("/Users/yuanxiaolong/Downloads/test.out").getChannel();
        ByteBuffer bff = ByteBuffer.allocate(BSIZE);
        fc.read(bff);
        bff.flip();
        while (bff.hasRemaining()) {
            System.out.print((char)bff.get());
        }
    }
}
