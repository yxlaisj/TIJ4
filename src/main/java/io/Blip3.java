package io;

import sun.net.util.IPAddressUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author YuanXiaolong
 * @date 2019/11/23 3:36 下午
 */
public class Blip3 implements Externalizable {
    private int i;
    private String s;   // No initialization
    public Blip3() {
        System.out.println("Blip3 Constructor");
        // s和i在默认构造器中不初始化
    }
    public Blip3(String x, int a) {
        System.out.println("Blip3(String x, int a)");
        s = x;
        i = a;
        // s和i仅在非默认构造器中才初始化
    }
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Blip3 b3 = new Blip3("A String ", 47);
        System.out.println(b3);
        ObjectOutputStream o = new ObjectOutputStream(Files.newOutputStream(Paths.get(Constants.FILE_DIR, "Blip3.out")));
        System.out.println("Saving object:");
        o.writeObject(b3);
        o.close();
        // Now get it back;
        ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(Constants.FILE_DIR, "Blip3.out")));
        System.out.println("Recovering b3:");
        b3 = (Blip3) in.readObject();
        System.out.println(b3);
    }
}
