package cn.qyd.springcloud.springcloudrest.service;

import cn.qyd.springcloud.springcloudrest.annotion.MyUrl;
import feign.RequestLine;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface HelloService {

//    @RequestLine("GET /hello")
//    @GET @Path("/hello")
    @MyUrl(method = "GET",url = "/hello")
    String sayHello();

}
