package com.shenge.study.generic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.*;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author : Shi Yue Sheng
 * @Date : 2020/6/8
 * @Time : 下午1:14
 * @Desc : 范型类
 */
public class GenericReflectDemo7<T> {
    /**
     * 通用的返回值类型
     *
     * @param <T>
     */
    @Getter
    @Setter
    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Result<T> implements Serializable { //@1
        private String code;
        private String subCode;
        private String msg;
        private T data;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserModel {
        private Integer id;
        private String name;
    }

    public static Result<UserModel> getUser() {
        UserModel userModel = UserModel.builder().id(1).name("shenge").build();
        Result<UserModel> result = Result.<UserModel>builder().code("1").subCode(null).msg("操作成功").data(userModel).build();
        return result;
    }

    public static String getUserString() { //@4
        return JSON.toJSONString(getUser());
    }

    public static void main(String[] args) {
        String userString = getUserString();
        //会输出：{"code":"1","data":{"id":1,"name":"shenge"},"msg":"操作成功"}
        System.out.println(userString);

        //下面我们需要将userString反序列化为Result<UserModel>对象
        Result<UserModel> userModelResult = JSON.parseObject(userString, new TypeReference<Result<UserModel>>() {
        });

        //我们来看看Result中的data是不是UserModel类型的
        System.out.println(userModelResult.getData().getClass());
    }

}
