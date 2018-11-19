package cn.qyd.springcloud.springcloudrest.test;

import cn.qyd.springcloud.springcloudrest.feign.MyFeignClient;
import cn.qyd.springcloud.springcloudrest.service.HelloService;
import cn.qyd.springcloud.springcloudrest.service.PersonService;
import feign.Feign;
import feign.gson.GsonEncoder;

public class MyFeignClientTest {
    public static void main(String[] args) {
        //获取服务接口
        HelloService helloService = Feign.builder()
                .encoder(new GsonEncoder())
                .client(new MyFeignClient())
                .target(HelloService.class,"http://localhost:8080/");

        //请求Hello World!!!接口
        String result = helloService.sayHello();

        System.out.println("  借口响应的内容： " + result);
    }
}
