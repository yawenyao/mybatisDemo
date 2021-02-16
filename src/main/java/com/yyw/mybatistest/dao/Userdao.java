package com.yyw.mybatistest.dao;

import com.yyw.mybatistest.domain.User;

import java.util.List;

public interface Userdao {
    List<User> findAll();
}
