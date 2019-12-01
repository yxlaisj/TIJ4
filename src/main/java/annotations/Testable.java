package annotations;

import net.mindview.atunit.Test;

/**
 * @author YuanXiaolong
 * @date 2019/12/1 2:48 下午
 */
public class Testable {
    public void execute() {
        System.out.println("Executing...");
    }

    @Test
    void testExecute(){execute();}
}
