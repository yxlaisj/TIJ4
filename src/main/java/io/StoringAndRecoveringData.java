package io;

import java.io.*;

/**
 * @author YuanXiaolong
 * @date 2019/11/8 10:05 下午
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("/Users/yuanxiaolong/Downloads/DataOut.out")));
        out.writeDouble(3.141592);
        out.writeUTF("Tha was pi");
        out.writeBoolean(Boolean.TRUE);
        out.writeInt(3);
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(
                new FileInputStream("/Users/yuanxiaolong/Downloads/DataOut.out")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readBoolean());
        System.out.println(in.readInt());
        
    }
}
