package io;

import jdk.management.resource.internal.inst.FileChannelImplRMHooks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author YuanXiaolong
 * @date 2019/11/9 7:20 下午
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel
                in = new FileInputStream("/Users/yuanxiaolong/Downloads/test.out").getChannel(),
                out = new FileOutputStream("/Users/yuanxiaolong/Downloads/test2.out").getChannel();
        ByteBuffer bff = ByteBuffer.allocate(BSIZE);
        while (in.read(bff) != -1) {
            bff.flip();
            out.write(bff);
            bff.clear();
        }

    }
}
