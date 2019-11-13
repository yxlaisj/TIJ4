package io;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author YuanXiaolong
 * @date 2019/11/9 7:41 下午
 */
public class IntBufferDemo {
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        ib.put(new int[]{1,2,3,4,5,6,7});
        System.out.println(ib.get(3));
        ib.put(3, 100);
        ib.flip();
        while (ib.hasRemaining()) {
            System.out.println(ib.get());
        }

    }
}
