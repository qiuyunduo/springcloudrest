package cn.qyd.springcloud.springcloudrest.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import java.net.URI;
import java.net.URL;

public class MyHttpRequest implements HttpRequest {
    private HttpRequest sourceRequest;

    public MyHttpRequest(HttpRequest sourceRequest) {
        this.sourceRequest = sourceRequest;
    }

    @Override
    public HttpMethod getMethod() {
        return sourceRequest.getMethod();
    }

    @Override
    public URI getURI() {
        try {
            String oldUri = sourceRequest.getURI().toString();
            System.out.println("旧的URI:"+oldUri);
            URI newUri = new URI("http://localhost:8080/hello");
            return newUri;
        }catch (Exception e){
            e.printStackTrace();
        }
        return sourceRequest.getURI();
    }

    @Override
    public HttpHeaders getHeaders() {
        return sourceRequest.getHeaders();
    }
}
