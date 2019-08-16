package com.digital.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorizationInterceptor extends AbstractInterceptor {
    @Override	//拦截器的拦截方法
    public String intercept(ActionInvocation invocation) throws Exception {
        //获取用户会话信息
        Map session=invocation.getInvocationContext().getSession();
        String usr=(String)session.get("CURRENT_USER"); //取得登录用户
        if (usr==null) {
            //返回’input’字符串，终止执行，返回登录页面,
            return Action.INPUT; //Action接口中的INPUT常量,即’input’
        }else{
            //继续执行剩余的拦截器和Action
            return invocation.invoke();
        }
    }
}

