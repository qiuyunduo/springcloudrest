package cn.qyd.springcloud.springcloudrest.restlet;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestletClient {

    public static void main(String[] args) throws IOException {
        ClientResource client = new ClientResource("http://localhost:8080/hello");
        //调用get方法,服务端发布的是get方法
        Representation response = client.get();
        System.out.println(response.getText());
        //创建JacksonRepresentation实例，将其转换为Map
        JacksonRepresentation jr = new JacksonRepresentation(response, String.class);
        //获取转换后的Map对象
        String result = (String)jr.getObject();
        System.out.println(result);

    }
}
