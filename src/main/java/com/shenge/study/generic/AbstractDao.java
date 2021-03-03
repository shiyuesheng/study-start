package com.shenge.study.generic;

import java.lang.reflect.ParameterizedType;

/**
 * @Author : Shi Yue Sheng
 * @Date : 2020/6/8
 * @Time : 下午1:14
 * @Desc : 范型类
 */
public abstract class AbstractDao<T> {
    protected final Class<T> tClass =
            (Class)
                    ((ParameterizedType) this.getClass().getGenericSuperclass())
                            .getActualTypeArguments()[0];
    public T find() {
        return null;//使用tClass做数据库映射
    }
}

class User {
}

class Account {
}

class UserDao extends AbstractDao<User> {

    public User findUser() {
        return find();
    }
}

class AccountDao extends AbstractDao<Account> {

    public Account findAccount() {
        return find();
    }
}
