package io;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author YuanXiaolong
 * @date 2019/11/8 6:20 下午
 */
public class BufferedInputFile {
    public static String read(String file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("//Users//yuanxiaolong//Desktop//workspace//gossip//users//yuanxl//1572513400657.txt"));
    }
}
