package com.mini.framework.mvc;

import com.mini.framework.annotation.Action;
import com.mini.framework.annotation.Request;
import com.mini.framework.core.ClassHelper;
import com.mini.framework.util.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bruce on 16/5/30.
 */
public class ActionHelper {

    /**
     * Action Map��HTTP ������ Action ������ӳ�䣩
     */
    private static final Map<Requester, Handler> actionMap = new LinkedHashMap<Requester, Handler>();

    static {
        // ��ȡ���� Action ��
        List<Class<?>> actionClassList = ClassHelper.getClassListByAnnotation(Action.class);
        if (CollectionUtils.isNotEmpty(actionClassList)) {
            // �������� Action Map
            Map<Requester, Handler> commonActionMap = new HashMap<Requester, Handler>(); // �����ͨ Action Map
            Map<Requester, Handler> regexpActionMap = new HashMap<Requester, Handler>(); // ��Ŵ���������ʽ�� Action Map
            // ���� Action ��
            for (Class<?> actionClass : actionClassList) {
                // ��ȡ�������� Action �������еķ���
                Method[] actionMethods = actionClass.getDeclaredMethods();
                if (!ArrayUtils.isEmpty(actionMethods)) {
                    for (Method actionMethod : actionMethods) {
                        // ���� Action ����
                        handleActionMethod(actionClass, actionMethod, commonActionMap, regexpActionMap);
                    }
                }
            }
            // ��ʼ�����յ� Action Map���� Common ���� Regexp ǰ�棩
            actionMap.putAll(commonActionMap);
            actionMap.putAll(regexpActionMap);
        }
    }

    private static void handleActionMethod(Class<?> actionClass, Method actionMethod, Map<Requester, Handler> commonActionMap, Map<Requester, Handler> regexpActionMap) {
        // �жϵ�ǰ Action �����Ƿ���� Request ע��
        if (actionMethod.isAnnotationPresent(Request.Get.class)) {
            String requestPath = actionMethod.getAnnotation(Request.Get.class).value();
            putActionMap("GET", requestPath, actionClass, actionMethod, commonActionMap, regexpActionMap);
        } else if (actionMethod.isAnnotationPresent(Request.Post.class)) {
            String requestPath = actionMethod.getAnnotation(Request.Post.class).value();
            putActionMap("POST", requestPath, actionClass, actionMethod, commonActionMap, regexpActionMap);
        } else if (actionMethod.isAnnotationPresent(Request.Put.class)) {
            String requestPath = actionMethod.getAnnotation(Request.Put.class).value();
            putActionMap("PUT", requestPath, actionClass, actionMethod, commonActionMap, regexpActionMap);
        } else if (actionMethod.isAnnotationPresent(Request.Delete.class)) {
            String requestPath = actionMethod.getAnnotation(Request.Delete.class).value();
            putActionMap("DELETE", requestPath, actionClass, actionMethod, commonActionMap, regexpActionMap);
        }
    }

    private static void putActionMap(String requestMethod, String requestPath, Class<?> actionClass, Method actionMethod, Map<Requester, Handler> commonActionMap, Map<Requester, Handler> regexpActionMap) {
        // �ж� Request Path ���Ƿ����ռλ��
        if (requestPath.matches(".+\\{\\w+\\}.*")) {
            // ������·���е�ռλ�� {\w+} ת��Ϊ������ʽ (\\w+)
            requestPath = StringUtil.replaceAll(requestPath, "\\{\\w+\\}", "(\\\\w+)");
            // �� Requester �� Handler ���� Regexp Action Map ��
            regexpActionMap.put(new Requester(requestMethod, requestPath), new Handler(actionClass, actionMethod));
        } else {
            // �� Requester �� Handler ���� Common Action Map ��
            commonActionMap.put(new Requester(requestMethod, requestPath), new Handler(actionClass, actionMethod));
        }
    }

    /**
     * ��ȡ Action Map
     */
    public static Map<Requester, Handler> getActionMap() {
        return actionMap;
    }
}
