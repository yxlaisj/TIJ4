package io;

import java.io.*;

/**
 * @author YuanXiaolong
 * @date 2019/11/9 6:09 下午
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;

        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("/Users/yuanxiaolong/Downloads/test"));
        PrintStream out = new PrintStream(new BufferedOutputStream(
                new FileOutputStream("/Users/yuanxiaolong/Downloads/test.out")
        ));

        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        out.close();
        System.setOut(console);
    }
}
