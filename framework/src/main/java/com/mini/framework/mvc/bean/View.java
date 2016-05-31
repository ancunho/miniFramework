package com.mini.framework.mvc.bean;

import com.mini.framework.core.bean.BaseBean;

import java.util.HashMap;
import java.util.Map;

/**
 * ��װ��ͼ����
 *
 * @author huangyong
 * @since 1.0
 */
public class View extends BaseBean {

    private String path;              // ��ͼ·��
    private Map<String, Object> data; // �������

    public View(String path) {
        this.path = path;
        data = new HashMap<String, Object>();
    }

    public View data(String key, Object value) {
        data.put(key, value);
        return this;
    }

    public boolean isRedirect() {
        return path.startsWith("/");
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
