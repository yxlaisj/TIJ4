package io;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.time.Instant;

/**
 * @author YuanXiaolong
 * @date 2019/11/13 7:42 下午
 */
public class MappedIO {
    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 200000;

    private static final String file = "/Users/yuanxiaolong/Downloads/temp.tmp";

    public static void main(String[] args) {
        for (Tester test : getTesters()) {
            Tester tester = (Tester) Proxy.newProxyInstance(MappedIO.class.getClassLoader(),
                    new Class[]{Tester.class},
                    new TestInvocationHandler(test));
            tester.test();
        }

    }

    public static Tester[] getTesters() {
        return new Tester[] {
            new StreamWriteTester("Stream Write"),
            new MappedWriter("Mapped Write"),
            new StreamRead("Stream Read"),
            new MappedRead("Mapped Read"),
            new StreamReadWrite("String Read Write"),
            new MappedReadWrite("Mapped Read Writer")
        };
    }


    interface Tester {
        void test();
        String getName();
    }

    static class StreamWriteTester implements Tester {
        String name;
        public StreamWriteTester(String name) {
            this.name = name;
        }

        @Override
        public void test() {
            try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
                    new FileOutputStream(file)))) {
                for (int i = 0; i < numOfInts; i++) {
                    out.writeInt(i);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    static class MappedWriter implements Tester {
        String name;
        public MappedWriter(String name) {
            this.name = name;
        }

        @Override
        public void test() {
            try (FileChannel fc = new RandomAccessFile(file, "rw").getChannel()) {
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                for (int i = 0; i < numOfInts; i++) {
                    ib.put(i);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    static class StreamRead implements Tester {
        String name;
        public StreamRead(String name) {
            this.name = name;
        }

        @Override
        public void test() {
            try (DataInputStream in = new DataInputStream(new BufferedInputStream(
                    new FileInputStream(file)))) {
                for (int i = 0; i < numOfInts; i++) {
                    in.readInt();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    static class MappedRead implements Tester {
        String name;
        public MappedRead(String name) {
            this.name = name;
        }

        @Override
        public void test() {
            try (FileChannel fc = new FileInputStream(file).getChannel()) {
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
                while (ib.hasRemaining()) {
                    ib.get();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    static class StreamReadWrite implements Tester{
        String name;
        public StreamReadWrite(String name) {
            this.name = name;
        }

        @Override
        public void test() {
            try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
                raf.writeInt(1);
                for (int i = 0; i < numOfUbuffInts; i++) {
                    raf.seek(raf.length() - 4);
                    raf.writeInt(raf.readInt());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    static class MappedReadWrite implements Tester {
        private String name;
        public MappedReadWrite(String name) {
            this.name = name;
        }

        @Override
        public void test() {
            try (FileChannel fc = new RandomAccessFile(file, "rw").getChannel()) {
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                ib.put(0);
                for (int i =0 ; i < numOfUbuffInts; i++) {
                    ib.put(ib.get(i - 1));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String getName() {
            return this.name;
        }
    }


}

class TestInvocationHandler implements InvocationHandler {
    private Object proxied;

    public TestInvocationHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            Instant start = Instant.now();
            method.invoke(proxied, args);
            Instant end = Instant.now();
            System.out.println(String.format("[%s] finnish testing, cost[%s]", ((MappedIO.Tester)proxied).getName(),
                    end.minusMillis(start.toEpochMilli()).toEpochMilli()));
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}



