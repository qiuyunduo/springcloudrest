package cn.qyd.springcloud.springcloudrest.test;

import cn.qyd.springcloud.springcloudrest.service.HelloService;
import cn.qyd.springcloud.springcloudrest.util.MyContract;
import feign.Feign;

public class ContractTest {
    public static void main(String[] args) {
        HelloService helloService = Feign.builder()
                .contract(new MyContract())
                .target(HelloService.class,"http://localhost:8080/");

        String result = helloService.sayHello();

        System.out.println("  接口相应内容： " + result);
    }
}
