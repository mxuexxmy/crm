package xyz.mxue.crm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.mxue.crm.entity.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE phone = #{id}")
    User login(String phone);
}
