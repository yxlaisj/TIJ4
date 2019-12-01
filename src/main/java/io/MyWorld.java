package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YuanXiaolong
 * @date 2019/11/26 5:19 下午
 */
public class MyWorld {
    public static void main(String[] args) throws Exception {
        House house = new House();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("cat", house));
        animals.add(new Animal("dog", house));
        System.out.println("animals:" + animals);
        ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
        ObjectOutputStream out1 = new ObjectOutputStream(bos1);
        out1.writeObject(animals);
        out1.writeObject(animals);
        out1.close();

        ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bos2);
        out2.writeObject(animals);
        out2.close();

        ByteArrayInputStream bis1 = new ByteArrayInputStream(bos1.toByteArray());
        ObjectInputStream in1 = new ObjectInputStream(bis1);
        ByteArrayInputStream bis2 = new ByteArrayInputStream(bos2.toByteArray());
        ObjectInputStream in2 = new ObjectInputStream(bis2);

        List<Animal>
                animals1 = (List<Animal>) in1.readObject(),
                animals2 = (List<Animal>) in1.readObject(),
                animals3 = (List<Animal>) in2.readObject();
        in1.close();
        in2.close();
        System.out.println("animals1: " + animals1);
        System.out.println("animals2: " + animals2);
        System.out.println("animals3: " + animals3);
        System.out.println(animals1 == animals2);

    }
}

class House implements Serializable {

}

class Animal implements Serializable {
    private String name;
    private House house;

    public Animal(String name, House house) {
        this.name = name;
        this.house = house;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", house=" + house +
                '}';
    }
}
