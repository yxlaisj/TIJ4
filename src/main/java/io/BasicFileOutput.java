package io;

import java.io.*;

/**
 * @author YuanXiaolong
 * @date 2019/11/8 9:33 下午
 */
public class BasicFileOutput {
    static String file = "/Users/yuanxiaolong/Downloads/BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("/Users/yuanxiaolong/Downloads/test"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
