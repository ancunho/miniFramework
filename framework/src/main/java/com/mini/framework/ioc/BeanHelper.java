package com.mini.framework.ioc;

import com.mini.framework.annotation.Action;
import com.mini.framework.annotation.Aspect;
import com.mini.framework.annotation.Bean;
import com.mini.framework.annotation.Service;
import com.mini.framework.core.ClassHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bruce on 16/5/30.
 */
public class BeanHelper {

    /**
     * Bean Map��Bean �� => Bean ʵ����
     */
    private static final Map<Class<?>, Object> beanMap = new HashMap<Class<?>, Object>();

    static {
        try {
            // ��ȡӦ�ð�·�������е���
            List<Class<?>> classList = ClassHelper.getClassList();
            for (Class<?> cls : classList) {
                // ������� Bean/Service/Action/Aspect ע�����
                if (cls.isAnnotationPresent(Bean.class) ||
                        cls.isAnnotationPresent(Service.class) ||
                        cls.isAnnotationPresent(Action.class) ||
                        cls.isAnnotationPresent(Aspect.class)) {
                    // ���� Bean ʵ��
                    Object beanInstance = cls.newInstance();
                    // �� Bean ʵ������ Bean Map �У���Ϊ Bean �ֵ࣬Ϊ Bean ʵ����
                    beanMap.put(cls, beanInstance);
                }
            }
        } catch (Exception e) {
            throw new Error("��ʼ�� BeanHelper ����", e);
        }
    }

    /**
     * ��ȡ Bean Map
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return beanMap;
    }

    /**
     * ��ȡ Bean ʵ��
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls) {
        if (!beanMap.containsKey(cls)) {
            throw new RuntimeException("�޷�����������ȡʵ����" + cls);
        }
        return (T) beanMap.get(cls);
    }

    /**
     * ���� Bean ʵ��
     */
    public static void setBean(Class<?> cls, Object obj) {
        beanMap.put(cls, obj);
    }
}
