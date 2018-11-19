package cn.qyd.springcloud.springcloudrest.cxf;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

public class CxfClient {
    public static void main(String[] args) throws IOException {
        WebClient client = WebClient.create("http://localhost:8080/hello");

        Response response = client.get();

        InputStream ent = (InputStream)response.getEntity();
        String comtent = IOUtils.readStringFromStream(ent);
        System.out.println(comtent);
    }
}
