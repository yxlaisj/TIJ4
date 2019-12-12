package net.mindview.util;

import java.util.concurrent.ThreadFactory;

/**
 * @author YuanXiaolong
 * @date 2019/12/11 6:10 下午
 */
public class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
