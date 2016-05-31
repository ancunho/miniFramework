package com.mini.framework.core;

import com.mini.framework.InstanceFactory;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * ����������ȡ�����
 *
 * Created by bruce on 16/5/30.
 */
public class ClassHelper {

    /**
     * ��ȡ��������
     */
    private static final String basePackage = ConfigHelper.getString("smart.framework.app.base_package");

    /**
     * ��ȡ ClassScanner
     */
    private static final ClassScanner classScanner = InstanceFactory.getClassScanner();

    /**
     * ��ȡ���������е�������
     */
    public static List<Class<?>> getClassList() {
        return classScanner.getClassList(basePackage);
    }

    /**
     * ��ȡ����������ָ�������ӿڵ������
     */
    public static List<Class<?>> getClassListBySuper(Class<?> superClass) {
        return classScanner.getClassListBySuper(basePackage, superClass);
    }

    /**
     * ��ȡ����������ָ��ע��������
     */
    public static List<Class<?>> getClassListByAnnotation(Class<? extends Annotation> annotationClass) {
        return classScanner.getClassListByAnnotation(basePackage, annotationClass);
    }
}
