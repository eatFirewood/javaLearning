package com.example.spring_boot_mybatis_demo.mapper;

import com.example.spring_boot_mybatis_demo.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select name, no, gender, phone, id_card, degree, graduation_date, create_time, update_time from student" )
    List<Student> selectAll();

    @Insert("insert into student (name, no, gender, phone, id_card) values(#{name}, #{no}, #{gender}, #{phone}, #{id_card})")
    int insert(@Param("name") String name, @Param("no") String no,@Param("gender") Integer gender, @Param("phone") String phone, @Param("id_card") String id_card);

    @Delete("delete from student where id = #{id}")
    int delete(@Param("id") int id);

    @Update("update student set no = #{no}, phone = #{phone}, id_card = #{id_card} where id = #{id}")
    boolean update(@Param("id") Integer id ,@Param("no") String no, @Param("phone") String phone, @Param("id_card") String id_card);
}
