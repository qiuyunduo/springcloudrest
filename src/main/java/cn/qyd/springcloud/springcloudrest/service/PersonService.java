package cn.qyd.springcloud.springcloudrest.service;

import cn.qyd.springcloud.springcloudrest.entity.Person;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface PersonService {
    @RequestLine("GET /person/{personid}")
    Person findById(@Param("personid")Integer personid);

    @RequestLine("POST /person/create")
    @Headers("Content-Type: application/json")
    String createPerson(Person person);

}
