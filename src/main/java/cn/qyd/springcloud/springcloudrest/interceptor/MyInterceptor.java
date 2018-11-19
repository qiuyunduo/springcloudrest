package cn.qyd.springcloud.springcloudrest.interceptor;

import cn.qyd.springcloud.springcloudrest.util.MyHttpRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class MyInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        System.out.println("=========     这是自定义拦截器实现");
        System.out.println("         原来的URI:  "+httpRequest.getURI());
        //换成新的请求对象（更换URL）
        MyHttpRequest newRequest = new MyHttpRequest(httpRequest);
        System.out.println("         拦截后新的URI: "+newRequest.getURI());
        return clientHttpRequestExecution.execute(newRequest,bytes);
    }
}
