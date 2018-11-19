package cn.qyd.springcloud.springcloudrest.test;

import cn.qyd.springcloud.springcloudrest.entity.Person;
import cn.qyd.springcloud.springcloudrest.service.PersonService;
import feign.Feign;
import feign.gson.GsonEncoder;

public class EncodeTest {
    public static void main(String[] args) {
        PersonService personService = Feign.builder()
                .encoder(new GsonEncoder())
                .target(PersonService.class,"http://localhost:8080/");

        Person person = new Person();
        person.setId(1);
        person.setMessage("聪昂前后就自动机");
        person.setName("Tom");
        person.setAge(20);

        String result = personService.createPerson(person);

        System.out.println(result);
    }
}
