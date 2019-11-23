package io;

import com.sun.tools.internal.jxc.ap.Const;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author YuanXiaolong
 * @date 2019/11/23 2:55 下午
 */
public class FreezeAlien {

    public static void main(String[] args) throws IOException {
        ObjectOutput out = new ObjectOutputStream(Files.newOutputStream(Paths.get(Constants.FILE_DIR,"X.file")));
        Alien quillek = new Alien();
        out.writeObject(quillek);
    }
}
