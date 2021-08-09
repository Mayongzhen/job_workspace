package com.javaapi.reportsys.mapper;


import com.javaapi.reportsys.entity.TestCase;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface TestCaseMapper {

    @Insert("INSERT INTO apitestcases (`protocol`, `ServerOrIP`, `port`, `method`, `Path`, `Header`, `Encode`, `Parametric`, `Paramter`, `Assert`, `ApiName`) VALUES (#{protocol},#{ServerOrIP},#{port},#{method},#{Path}, #{Header},#{Encode},#{Parametric},#{Paramter},#{Assert}, #{ApiName})")
    int insertTestcase(TestCase testCase);
    @Delete("delete from apitestcases where id=#{id}")
    int deletebyId(Integer id);
    @Update("UPDATE `reportsystem`.`apitestcases` SET `protocol` = #{protocol}, `ServerOrIP` = #{ServerOrIP}, `port` = #{port}, `method` = #{method}, `Path` = #{Path}, `Header` = #{Header}, `Encode` = #{Encode}, `Parametric` = #{Parametric}, `Paramter` = #{Paramter}, `Assert` = #{Assert}, `ApiName` = #{ApiName} WHERE `id` = #{id}")
    int updateTestcase(TestCase testCase);
    @Select("select * from apitestcases where id=#{id} ")
    TestCase selectOne(Integer id);
    @Select("select * from apitestcases ORDER BY id desc")
    List<TestCase> selectall();
}

