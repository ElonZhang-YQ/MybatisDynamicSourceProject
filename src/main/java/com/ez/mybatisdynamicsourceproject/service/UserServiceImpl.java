package com.ez.mybatisdynamicsourceproject.service;

import com.ez.mybatisdynamicsourceproject.bean.User;
import com.ez.mybatisdynamicsourceproject.mapper.s1.MasterUserMapper;
import com.ez.mybatisdynamicsourceproject.mapper.s2.SlaveUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/12
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private MasterUserMapper masterUserMapper;

	@Autowired
	private SlaveUserMapper slaveUserMapper;

	@Override
	public List<User> findAllMasterUser() {

		return masterUserMapper.selectAllUser();
	}

	@Override
	public List<User> findALlSlaveUser() {

		return slaveUserMapper.selectAllUser();
	}
}
