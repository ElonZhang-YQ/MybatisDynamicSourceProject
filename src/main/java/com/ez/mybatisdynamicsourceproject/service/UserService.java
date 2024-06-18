package com.ez.mybatisdynamicsourceproject.service;

import com.ez.mybatisdynamicsourceproject.bean.User;

import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/12
 */
public interface UserService {

	List<User> findAllMasterUser();

	List<User> findALlSlaveUser();

}
