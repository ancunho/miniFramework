package com.mini.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by bruce on 16/5/30.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Request {
    /**
     * 定义 GET 请求
     *
     * @author huangyong
     * @since 2.1
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Get {

        String value();
    }

    /**
     * 定义 POST 请求
     *
     * @author huangyong
     * @since 2.1
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Post {

        String value();
    }

    /**
     * 定义 PUT 请求
     *
     * @author huangyong
     * @since 2.1
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Put {

        String value();
    }

    /**
     * 定义 DELETE 请求
     *
     * @author huangyong
     * @since 2.1
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Delete {

        String value();
    }
}
