package com.mini.framework.annotation;

import java.lang.annotation.*;

/**
 * 定义切面类
 *
 * @since 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * 包名
     */
    String pkg() default "";

    /**
     * 类名
     */
    String cls() default "";

    /**
     * 注解
     *
     * @since 2.2
     */
    Class<? extends Annotation> annotation() default Aspect.class;
}
