package io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author YuanXiaolong
 * @date 2019/11/28 5:31 下午
 */
public class RecoverCADState {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(Constants.FILE_DIR, "CADState.out")));
        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
        Line.deserializeStaticState(in);
        List<Shape> shaped = (List<Shape>) in.readObject();
        System.out.println(shaped);
    }
}
