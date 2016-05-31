package com.mini.framework.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


/**
 * 属性文件操作工具类
 *
 * Created by bruce on 16/5/30.
 */
public class PropsUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loadProps(String propsPath){
        Properties props = new Properties();
        InputStream is = null;
        try {
            if (StringUtils.isEmpty(propsPath)){
                throw new IllegalArgumentException();
            }
            String suffix = ".properties";
            if (propsPath.lastIndexOf(suffix) == -1){
                propsPath += suffix;
            }
            is = ClassUtil.getClassLoader().getResourceAsStream(propsPath);
            if (is != null){
                props.load(is);
            }
        } catch (Exception e){
            logger.error("load properties err", e);
            throw new RuntimeException(e);
        } finally {
            try {
                if (is != null){
                    is.close();
                }
            } catch (IOException e){
                logger.error("资源释放出错", e);
            }
        }
        return props;
    }

    public static String getString(Properties configProps, String key) {
        String value = "";
        if (configProps.containsKey(key)){
            value = configProps.getProperty(key);
        }
        return value;
    }

    public static String getString(Properties configProps, String key, String defaultValue){
        String value = defaultValue;
        if (configProps.containsKey(key)){
            value = configProps.getProperty(key);
        }
        return value;
    }

    public static int getInt(Properties configProps, String key){
        int value = 0;
        if (configProps.containsKey(key)){
            value = Integer.parseInt(configProps.getProperty(key));
        }
        return value;
    }

    public static int getInt(Properties configProps, String key, int defaultValue){
        int value = defaultValue;
        if (configProps.containsKey(key)){
            value = Integer.parseInt(configProps.getProperty(key));
        }
        return value;
    }

    public static Map<String,Object> getMap(Properties configProps, String prefix) {
        Map<String ,Object> kvMap = new LinkedHashMap<String, Object>();
        Set<String> keySet = configProps.stringPropertyNames();
        if (CollectionUtils.isNotEmpty(keySet)){
            for (String key : keySet){
                if (key.startsWith(prefix)){
                    String value = configProps.getProperty(key);
                    kvMap.put(key, value);
                }
            }
        }
        return kvMap;
    }
}
