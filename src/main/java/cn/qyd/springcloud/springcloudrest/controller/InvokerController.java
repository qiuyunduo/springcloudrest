package cn.qyd.springcloud.springcloudrest.controller;

import cn.qyd.springcloud.springcloudrest.annotion.MyLoadBalanced;
import cn.qyd.springcloud.springcloudrest.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class InvokerController {

    @Bean
    @MyLoadBalanced
    public RestTemplate getMyRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/router")
    public String router(){
        RestTemplate restTpl = getMyRestTemplate();
        String json = restTpl.getForObject("http://my-server/hello",String.class);

        return json;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!!!";
    }

    @GetMapping("/person/{personid}")
    public Person getPerson(@PathVariable("personid") Integer personid){
        Person person = new Person();
        person.setId(personid);
        person.setAge(18);
        person.setName("qiuyunduo");
        person.setMessage("asdsda");
        return person;
    }

    @PostMapping(value = "/person/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createperson(@RequestBody Person person){
        System.out.println(person.getName() + "-" + person.getAge());
        return "success, Person : " + person.toString();
    }
}
