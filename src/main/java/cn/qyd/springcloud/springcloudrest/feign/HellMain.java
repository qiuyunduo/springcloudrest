package cn.qyd.springcloud.springcloudrest.feign;

import cn.qyd.springcloud.springcloudrest.service.HelloService;
import feign.Feign;
import feign.jaxrs.JAXRSContract;

public class HellMain {
    public static void main(String[] args) {
        HelloService helloService = Feign.builder()
                .contract(new JAXRSContract())
                .target(HelloService.class,"http://localhost:8080/");

        System.out.println(helloService.sayHello());
    }
}
