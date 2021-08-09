package com.javaapi.reportsys.mapper;

import com.javaapi.reportsys.entity.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user (id, username, password, realname) VALUES (#{id},#{username},#{password},#{realname})")
    int insert(@Param("bean")User user);
    @Delete("delete from user where id=#{id}")
    int deletebyId(Integer id);
    @Update("UPDATE `reportsystem`.`user` SET `username` = #{username}, `password` = #{password}, `realname` = #{realname} WHERE `id` = #{id}")
    int updatebyId(Integer id);
    @Select("select * from user where username=#{username} and password=#{password}")
    User findbyUser(@Param("username")String username,@Param("password")String password);


}
