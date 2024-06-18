package com.ez.mybatisdynamicsourceproject.mapper.s1;

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
public interface MasterUserMapper {

	@Select("SELECT id,username,password FROM user")
	List<User> selectAllUser();

}
