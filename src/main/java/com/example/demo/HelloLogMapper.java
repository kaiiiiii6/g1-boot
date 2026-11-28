package com.example.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HelloLogMapper {
    @Select("select message from hello_log where id = #{id}")
     String findmessageById(@Param("id")  Long id);

}

