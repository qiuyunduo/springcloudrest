package cn.qyd.springcloud.springcloudrest.test;

import cn.qyd.springcloud.springcloudrest.interceptor.MyReuqestInterceptor;
import cn.qyd.springcloud.springcloudrest.service.HelloService;
import feign.Feign;

public class InterceptorTest {

    public static void main(String[] args) {
        HelloService helloService = Feign.builder()
                .requestInterceptor(new MyReuqestInterceptor())
                .target(HelloService.class,"http://localhost:8080/");
    }
}
