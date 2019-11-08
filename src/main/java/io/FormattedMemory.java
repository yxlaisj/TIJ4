package io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author YuanXiaolong
 * @date 2019/11/8 9:18 下午
 */
public class FormattedMemory {
    public static void main(String[] args)  {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(BufferedInputFile.read(
                            "//Users//yuanxiaolong//Desktop//workspace//gossip//users//yuanxl//1572513400657.txt").getBytes()));
            while (true) {
                System.out.println((char)in.readByte());
            }
        } catch (IOException e) {
            System.out.println("end of reading");
        }
    }
}

