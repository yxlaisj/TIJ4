package io.xfiles;

import io.Constants;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author YuanXiaolong
 * @date 2019/11/23 3:01 下午
 */
public class ThawAlien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(Constants.FILE_DIR, "X.file")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());

    }
}
