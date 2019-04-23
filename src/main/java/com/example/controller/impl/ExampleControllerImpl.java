package com.example.controller.impl;

import java.util.List;


import com.example.bean.User;

public interface ExampleControllerImpl {
/**
 * 查看已经添加了的用户所有信息
 * @return 用户信息列表
 */
public List<User> getUserList();

public String postUser(User user);

public  User getUser(Long id); 

public String putUser(Long id, User user);

public String deleUser(Long id); 
}
