package com.zhao.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/*
 * @Description:  过滤器示例代码
 *
 * @Author: xyzhao
 * @Date 2018-11-23 21:09
 */
public class LoginFilter extends ZuulFilter {

    /**
     * 返回过滤类型，有：pre，route，post，error
     */
    @Override
    public String filterType() {
        return null;
    }

    /**
     * 返回过滤的优先级，数字越大，优先级越高，越早执行
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 设置过滤条件
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * 具体的操作
     */
    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
