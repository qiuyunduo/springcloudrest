package cn.qyd.springcloud.springcloudrest.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class MyReuqestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Content-Type","application/json");
    }
}
