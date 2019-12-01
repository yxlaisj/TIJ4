package annotations.database;

import java.lang.annotation.Target;

/**
 * @author YuanXiaolong
 * @date 2019/12/1 6:59 下午
 */
public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
