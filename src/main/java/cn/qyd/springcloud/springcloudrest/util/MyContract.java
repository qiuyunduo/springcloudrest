package cn.qyd.springcloud.springcloudrest.util;

import cn.qyd.springcloud.springcloudrest.annotion.MyUrl;
import feign.Contract;
import feign.MethodMetadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyContract extends Contract.BaseContract {
    @Override
    protected void processAnnotationOnClass(MethodMetadata methodMetadata, Class<?> aClass) {

    }

    /**
     * 用于处理方法级的注解
     * @param methodMetadata
     * @param annotation
     * @param method
     */

    @Override
    protected void processAnnotationOnMethod(MethodMetadata methodMetadata, Annotation annotation, Method method) {
        //是MyUrl注解才进行处理
        if(MyUrl.class.isInstance(annotation)){
            //获取注解实例
            MyUrl myUrlAnn = method.getAnnotation(MyUrl.class);
            //获取配置的Http方法
            String httpMehtod = myUrlAnn.method();
            //获取服务的url
            String url = myUrlAnn.url();
            //将值设置到模板中
            methodMetadata.template().method(httpMehtod);
            methodMetadata.template().append(url);
        }
    }

    @Override
    protected boolean processAnnotationsOnParameter(MethodMetadata methodMetadata, Annotation[] annotations, int i) {
        return false;
    }
}
