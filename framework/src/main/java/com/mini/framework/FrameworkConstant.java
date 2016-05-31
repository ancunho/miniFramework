package com.mini.framework;

import com.mini.framework.core.ConfigHelper;

public interface FrameworkConstant {

    String UTF_8 = "UTF-8";

    String CONFIG_PROPS = "mini.properties";
    String SQL_PROPS = "mini-sql.properties";

    String PLUGIN_PACKAGE = "com.mini.plugin";

    String JSP_PATH = ConfigHelper.getString("mini.framework.app.jsp_path", "/WEB-INF/jsp/");
    String WWW_PATH = ConfigHelper.getString("mini.framework.app.www_path", "/www/");
    String HOME_PAGE = ConfigHelper.getString("mini.framework.app.home_page", "/products");
    int UPLOAD_LIMIT = ConfigHelper.getInt("mini.framework.app.upload_limit", 10);

    String PK_NAME = "id";
}
