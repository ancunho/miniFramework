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
     * ������ Ĭ���Զ���ʼ��
     * @param className
     * @return
     */
    public static Class<?> loadClass(String className){
        return loadClass(className, true);
    }

    /**
     * ������
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

    /**
     * �Ƿ�Ϊ int ���ͣ����� Integer ���ͣ�
     */
    public static boolean isInt(Class<?> type) {
        return type.equals(int.class) || type.equals(Integer.class);
    }

    /**
     * �Ƿ�Ϊ long ���ͣ����� Long ���ͣ�
     */
    public static boolean isLong(Class<?> type) {
        return type.equals(long.class) || type.equals(Long.class);
    }

    /**
     * �Ƿ�Ϊ double ���ͣ����� Double ���ͣ�
     */
    public static boolean isDouble(Class<?> type) {
        return type.equals(double.class) || type.equals(Double.class);
    }

    /**
     * �Ƿ�Ϊ String ����
     */
    public static boolean isString(Class<?> type) {
        return type.equals(String.class);
    }
}
