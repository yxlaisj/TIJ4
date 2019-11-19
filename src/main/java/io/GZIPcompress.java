package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.zip.GZIPOutputStream;

/**
 * @author YuanXiaolong
 * @date 2019/11/19 5:41 下午
 */
public class GZIPcompress {
    private static final String FILE = "/Users/yuanxiaolong/Downloads/request.2019-11-18.log";
    private static final String OUTPUT_FILE = "/Users/yuanxiaolong/Downloads/request.2019-11-18.zip";

    public static void main(String[] args) throws Exception {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(FILE)));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(OUTPUT_FILE)));
        int c;
        byte[] buffer = new byte[2048];
        while ((c = in.read(buffer)) != -1) {
            out.write(buffer, 0, c);
        }
        in.close();
        out.close();

        BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
