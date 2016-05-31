package com.mini.sample.action;


import com.mini.framework.annotation.Action;
import com.mini.framework.annotation.Request;
import com.mini.framework.mvc.bean.Params;
import com.mini.framework.mvc.bean.Result;
import com.mini.framework.mvc.bean.View;

@Action
public class SystemAction {

    @Request.Get("/captcha")
    public void captcha() {
        //String captcha = WebUtil.createCaptcha(DataContext.getResponse());
        //DataContext.Session.put(Constant.CAPTCHA, captcha);
    }

    @Request.Get("/login")
    public View login() {
        return new View("login.jsp");
    }

    @Request.Post("/login")
    public Result login(Params params) {
        /*String username = params.getString("username");
        String password = params.getString("password");
        String captcha = params.getString("captcha");

        String sessionCaptcha = DataContext.Session.get(Constant.CAPTCHA);
        if (StringUtil.isNotEmpty(sessionCaptcha) && !sessionCaptcha.equals(captcha)) {
            return new Result(false).data("captcha_error");
        }

        try {
            SecurityHelper.login(username, password, false);
        } catch (LoginException e) {
            return new Result(false);
        }
        */

        return new Result(true);
    }

    @Request.Get("/logout")
    public Result logout() {
        //SecurityHelper.logout();
        return new Result(true);
    }
}
