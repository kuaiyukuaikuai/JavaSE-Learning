package com.kuaiyukuaikuai.demo4proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StarProxy {
    public static StarService createProxy(Star s) {
        //参数1:类加载器, 参数2:代理类需要实现的接口, 参数3:代理类对象
        StarService proxy = (StarService)Proxy.newProxyInstance(StarProxy.class.getClassLoader(), s.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //声明代理对象要干的事情
                //参数1:代理对象, 参数2:要调用的方法, 参数3:调用方法时传递的参数
                String methodName = method.getName();
                if (methodName.equals("sing")) {
                    System.out.println("准备话筒,收钱10万");
                }else if (methodName.equals("dance")) {
                    System.out.println("准备场地,收钱200万");
                }
                //真正干活(调用方法)
                Object result = method.invoke(s, args);
                return result;
            }
        });
        return proxy;
    }
}
