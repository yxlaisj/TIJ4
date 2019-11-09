package io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author YuanXiaolong
 * @date 2019/11/9 4:54 下午
 */
public class BinaryFile {
    public static byte[] read(File file) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        } finally {
            bf.close();
        }
    }

    public static byte[] read(String filename) throws IOException {
        return read(new File(filename));
    }

    public static void main(String[] args) throws IOException {
        byte[] data = read("/Users/yuanxiaolong/Downloads/BasicFileOutput.out");
        System.out.println(new String(data));
    }
}
