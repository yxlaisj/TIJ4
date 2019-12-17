package concurrency;

/**
 * @author YuanXiaolong
 * @date 2019/12/16 10:29 上午
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    // Allow  this to be canceled:
    public void cancel() {
        canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
}
