package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

/**
 * @author YuanXiaolong
 * @date 2019/11/23 3:55 下午
 */
public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;
    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }

    @Override
    public String toString() {
        return "Logon{" +
                "date=" + date +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Logon a = new Logon("Hulk", "myLittlePony");
        System.out.println("logon a = " + a);
        ObjectOutputStream o = new ObjectOutputStream(Files.newOutputStream(Paths.get(Constants.FILE_DIR,"Logon.out")));
        o.writeObject(a);
        o.close();

        ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(Constants.FILE_DIR, "Logon.out")));
        System.out.println("Recovering object at " + new Date());
        a = (Logon) in.readObject();
        System.out.println("logon a = " + a);
    }
}
