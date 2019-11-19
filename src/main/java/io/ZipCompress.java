package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * @author YuanXiaolong
 * @date 2019/11/19 6:08 下午
 */
public class ZipCompress {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("/Users/yuanxiaolong/Downloads/log2019_11.zip");
        CheckedOutputStream cos = new CheckedOutputStream(fos, new CRC32());
        ZipOutputStream zos = new ZipOutputStream(cos,StandardCharsets.UTF_8);
        BufferedOutputStream bos = new BufferedOutputStream(zos);
        zos.setComment("test for compress multiple files");
        for (String arg : args) {
            zos.putNextEntry(new ZipEntry(arg));
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(arg));
            int i;
            while ((i = in.read()) != -1) {
                bos.write(i);
            }
            in.close();
            bos.flush();
        }
        bos.close();
        System.out.println("Checked sum: " + cos.getChecksum().getValue());

        System.out.println("Reading file....");
        FileInputStream fis = new FileInputStream("/Users/yuanxiaolong/Downloads/log2019_11.zip");
        CheckedInputStream cis = new CheckedInputStream(fis, new CRC32());
        ZipInputStream zis = new ZipInputStream(cis, StandardCharsets.UTF_8);

        BufferedInputStream bis = new BufferedInputStream(zis);
        ZipEntry ze;
        while ((ze = zis.getNextEntry()) != null) {
            System.out.println("Reading file : " + ze);
            int c;
            while ((c = bis.read()) != -1) {
                System.out.write(c);
            }
        }
        System.out.println("Checked sum: " + cis.getChecksum().getValue());
        bis.close();

        ZipFile zf = new ZipFile("/Users/yuanxiaolong/Downloads/log2019_11.zip");
        Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zf.entries();
        while (entries.hasMoreElements()) {
            ZipEntry ze1 = entries.nextElement();
            System.out.println(ze1);
        }
    }
}
