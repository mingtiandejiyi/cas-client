package com.cas.auth;

import org.jasig.cas.client.authentication.UrlPatternMatcherStrategy;

/**
 * @author bjf
 * @created 2018-05-06
 * 过滤掉一些不需要授权，登录的界面
 * @return
 */
public class SimpleUrlPatternMatcherStrategy implements UrlPatternMatcherStrategy {


    /**
     * @param url 用户请求的连接
     * @return true : 我就不拦截你了
     * false :必须得登录了
     * @author bjf
     * @created 2018-05-06
     * 过滤掉一些不需要授权，登录的界面
     * 判断是否匹配这个字符串
     */
    @Override
    public boolean matches(String url) {
        //当含有loginout的字段，就可以不用登录了
        return url.contains("/loginOut/success");
    }

    /**
     * 正则表达式的规则，这个地方可以是web传递过来的
     */
    @Override
    public void setPattern(String pattern) {

    }

}
