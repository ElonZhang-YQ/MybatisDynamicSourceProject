package com.ez.mybatisdynamicsourceproject.mapper.s2;

import com.ez.mybatisdynamicsourceproject.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/12
 */
@Mapper
public interface SlaveUserMapper {

	@Select("SELECT id,username,password FROM user")
	List<User> selectAllUser();

}
