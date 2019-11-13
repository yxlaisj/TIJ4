package io;

import net.mindview.util.OSExecute;

/**
 * @author YuanXiaolong
 * @date 2019/11/9 6:48 下午
 */
public class OSExecuteDemo {
    public static void main(String[] args) {
        OSExecute.command("javap java.lang.String");
    }
}
