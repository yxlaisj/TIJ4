package io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author YuanXiaolong
 * @date 2019/11/9 5:21 下午
 */
public class ChangeSystemOut {
    public static void main(String[] args) throws IOException {
//        BufferedWriter stdout = new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"));
//        stdout.write("Hello world");
//        stdout.close();

        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello world!");
    }
}
