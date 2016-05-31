package com.mini.framework.mvc.bean;


import com.mini.framework.core.bean.BaseBean;

import java.util.Map;

/**
 * 封装请求参数
 *
 * @author huangyong
 * @since 2.2
 */
public class Params extends BaseBean {

    private final Map<String, Object> fieldMap;

    public Params(Map<String, Object> fieldMap) {
        this.fieldMap = fieldMap;
    }

    public Map<String, Object> getFieldMap() {
        return fieldMap;
    }

    public String getString(String name) {
        return String.valueOf(get(name));
    }

    public double getDouble(String name) {
        return Double.parseDouble(String.valueOf(get(name)));
    }

    public long getLong(String name) {
        return Long.parseLong(String.valueOf(get(name)));
    }

    public int getInt(String name) {
        return Integer.parseInt(String.valueOf(get(name)));
    }

    private Object get(String name) {
        return fieldMap.get(name);
    }
}
