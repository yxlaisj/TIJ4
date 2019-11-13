package net.mindview.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author YuanXiaolong
 * @date 2019/11/9 6:41 下午
 */
public class OSExecute {
    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null) {
                System.out.println(s);
            }
            BufferedReader errs = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String e;
            while ((e = errs.readLine()) != null) {
                System.err.println(e);
                err = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (err) {
            throw new OSExecuteException("Error executing " + command);
        }
    }
}
