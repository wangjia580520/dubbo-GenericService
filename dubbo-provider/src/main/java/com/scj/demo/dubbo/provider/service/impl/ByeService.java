package com.scj.demo.dubbo.provider.service.impl;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wangjia580520
 * @date 2022/9/11
 **/
public interface ByeService {

    String bye(Map obj);

    String byePersons(List<Person> persons);

    String byePersons(Person[] persons);

    @Data
    public static class Person {
        private String name;

        private Long age;

        private Date birth;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getAge() {
            return age;
        }

        public void setAge(Long age) {
            this.age = age;
        }

        public Date getBirth() {
            return birth;
        }

        public void setBirth(Date birth) {
            this.birth = birth;
        }
    }

    public static void main(String[] args) {
        System.out.println(Person.class.getName());
    }

}
