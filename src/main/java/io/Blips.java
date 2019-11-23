package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author YuanXiaolong
 * @date 2019/11/23 3:14 下午
 */
public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(Files.newOutputStream(Paths.get(Constants.FILE_DIR,"Blips.out")));
        System.out.println("Saving Objects");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();

        // Now get them back
        ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(Constants.FILE_DIR,"Blips.out")));
        System.out.println("Recovering b1:");
        in.readObject();
        System.out.println("Recovering b2:");
        in.readObject();
    }
}

class Blip1 implements Externalizable {

    public Blip1() {
        System.out.println("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {

    public Blip2() {
        System.out.println("Blip2 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}
