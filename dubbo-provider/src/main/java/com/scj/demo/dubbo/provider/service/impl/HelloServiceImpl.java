package com.scj.demo.dubbo.provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.scj.demo.dubbo.api.HelloService;
import com.scj.demo.dubbo.api.Result;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HelloServiceImpl implements HelloService,ByeService {

    Executor executor = Executors.newCachedThreadPool();

    @Override
    public Result<String> hello(String name) {
        return Result.ofSuccess("hello"+name);
    }

    public Result<String> exception(String name)  {
        throw new RuntimeException("1234");
        //return Result.ofSuccess("hello"+name);
    }

    @Override
    public Result<String> timeout(String name) {
        try {
            Thread.sleep(1000* 20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("timeout invoked");
        return Result.ofSuccess("hello"+name);
    }

    @Override
    public Result<List<String>> testPage1(Integer page, Integer pageSize) {
        try {
            Thread.sleep(1000* 4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Result.ofSuccess(Lists.newArrayList("scj","123","356"));
    }

    @Override
    public CompletableFuture<Result<List<String>>> testPage2(Integer page, Integer pageSize) {

        //注意这边不过不配置executor 连续的testPage2调用 会在默认线程池里面串行
        return CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000* 4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Result.ofSuccess(Lists.newArrayList("scj","123","356"));
        },executor);
    }

    @Override
    public String helloWorld(String name) {
        return "hello,world" + name;
    }

    @Override
    public String bye(Map object) {
        return "hello" + JSON.toJSONString(object);
    }

    @Override
    public String byePersons(List<Person> persons) {
        return "hello" + Joiner.on(",").join(persons);
    }

    @Override
    public String byePersons(Person[] persons) {
        return "hello" + Arrays.toString(persons);
    }
}
