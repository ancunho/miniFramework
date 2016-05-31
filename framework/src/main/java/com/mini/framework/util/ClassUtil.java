package com.mini.framework.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

/**
 * Created by bruce on 16/5/30.
 */
public class ClassUtil {
    private static final Logger logger = LoggerFactory.getLogger(org.codehaus.jackson.map.util.ClassUtil.class);

    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static String getClassPath(){
        String classpath = "";
        URL res = getClassLoader().getResource("");
        if (res != null){
            classpath = res.getPath();
        }
        return classpath;
    }

    /**
     * 加载类 默认自动初始化
     * @param className
     * @return
     */
    public static Class<?> loadClass(String className){
        return loadClass(className, true);
    }

    /**
     * 加载类
     * @param className
     * @param isInitialized
     * @return
     */
    public static Class<?> loadClass(String className, boolean isInitialized){
        Class<?> cls;
        try {
            cls = Class.forName(className, isInitialized, getClassLoader());
        } catch (ClassNotFoundException e) {
            logger.error("loadClass error", e);
            throw new RuntimeException(e);
        }
        return cls;
    }

}
