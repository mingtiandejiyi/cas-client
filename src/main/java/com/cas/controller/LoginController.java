package com.cas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    /**
     * @param session
     * @return
     * @author bjf
     * @created 2018-05-06
     * 单点登出
     */
    @RequestMapping("/loginOut1")
    public String loginOut(HttpSession session) {
        //退出cas
        session.invalidate();
        //退出当前系统

        //这个是直接退出，走的是默认退出方式
        return "redirect:https://www.cas.com:8443/logout";
    }

    @RequestMapping("/loginOut2")
    public String loginOut2(HttpSession session) {
        //退出cas
        session.invalidate();
        //退出当前系统

        //退出登录后，跳转到退成成功的页面，不走默认页面
        return "redirect:https://www.cas.com:8443/logout?service=http://app1.ngrok.xiaomiqiu.cn/loginOut/success";
    }

    /**
     * @return
     * @author bjf
     * @created 2018-05-06
     * 退出成功的界面
     */
    @RequestMapping("/loginOut/success")
    public String loginOutPage() {
        return "user/loginOut";
    }
}
