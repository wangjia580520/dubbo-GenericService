package com.scj.demo.dubbo.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangjia580520
 * @date 2020-06-05
 **/
public class XmlGenericInvokeTest {
    public static void main(String[] args) {
        // 外部服务的接口信息在xml文件中保存
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer-generic.xml");
        // 相当于一个代理服务类
        PersonService personService = applicationContext.getBean(PersonService.class);
        // 提供者的接口
        personService.sayBye();
        // api里面的接口
        personService.hello();
    }
}
