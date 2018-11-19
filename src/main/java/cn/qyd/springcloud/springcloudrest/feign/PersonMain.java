package cn.qyd.springcloud.springcloudrest.feign;

import cn.qyd.springcloud.springcloudrest.entity.Person;
import cn.qyd.springcloud.springcloudrest.service.PersonService;
import feign.Feign;
import feign.gson.GsonDecoder;

public class PersonMain {
    public static void main(String[] args) {
        PersonService personService = Feign.builder().decoder(new GsonDecoder()).target(PersonService.class,"http://localhost:8080/");

            Person byId = personService.findById(88);
        System.out.println(byId);
    }
}
