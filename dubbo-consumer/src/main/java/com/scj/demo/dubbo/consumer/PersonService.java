package com.scj.demo.dubbo.consumer;

import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjia580520
 * @date 2022/9/11
 **/
@Service
public class PersonService {

    @Resource(name = "byeServiceComsumer")
    private GenericService genericService;

    @Resource(name = "helloServiceComsumer")
    private GenericService helloGenericService;


    public void sayBye() {
        Map personMap = new HashMap();
        personMap.put("name", "scj");
        personMap.put("age", "12");
        personMap.put("birth", new Date());
        Object result = genericService.$invoke(
                "bye",
                new String[]{"java.util.Map"},
                new Object[]{personMap});

        System.out.println(result);
    }

    public void hello() {
        Object result = helloGenericService.$invoke(
                "hello",
                new String[]{"java.lang.String"},
                new Object[]{"wangjia"});
        System.out.println(result);
    }
}
