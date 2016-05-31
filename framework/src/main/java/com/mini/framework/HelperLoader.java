package com.mini.framework;

import com.mini.framework.ioc.BeanHelper;
import com.mini.framework.ioc.IocHelper;
import com.mini.framework.mvc.ActionHelper;
import com.mini.framework.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 *
 * @author huangyong
 * @since 2.0
 */
public final class HelperLoader {

    public static void init() {
        // 定义需要加载的 Helper 类
        Class<?>[] classList = {
            //DatabaseHelper.class,
            //EntityHelper.class,
            ActionHelper.class,
            BeanHelper.class,
            //AopHelper.class,
            IocHelper.class,
            //PluginHelper.class,
        };
        // 按照顺序加载类
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
