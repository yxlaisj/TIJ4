package io;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author YuanXiaolong
 * @date 2019/11/8 6:33 下午
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("//Users//yuanxiaolong//Desktop//workspace//gossip//users//yuanxl//1572513400657.txt"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.println((char)c);
        }

    }
}
