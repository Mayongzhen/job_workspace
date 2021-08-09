package com.javaapi.reportsys.mapper;

import com.javaapi.reportsys.entity.SShBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface SShBeanMapper {

    @Insert("INSERT INTO `flowplatform`.`mulityrecods`(`id`, `port`, `ip`, `username`, `password`, `goreplaydir`,`replaystatus`,`recodeport`) VALUES (#{id}, #{port}, #{ip}, #{username}, #{password}, #{goreplaydir},#{replaystatus},#{recodeport})")
    int insertSShBean(SShBean sshbean);
    @Delete("delete from mulityrecods where id=#{id}")
    int deletebyId(Integer id);
    @Update("UPDATE `flowplatform`.`mulityrecods` SET `port` = #{port}, `ip` = #{ip}, `username` = #{username}, `password` = #{password}, `goreplaydir` = #{goreplaydir} ,`replaystatus` = #{replaystatus},`recodeport`= #{recodeport} WHERE `id` = #{id}")
    int updateSshbean(SShBean sshbean);
    @Select("select * from mulityrecods where id=#{id} ")
    SShBean selectOne(Integer id);
    @Select("select * from mulityrecods ORDER BY id asc")
    List<SShBean> selectall();

}
