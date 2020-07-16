package xyz.mxue.crm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xyz.mxue.crm.entity.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE phone = #{id}")
    User login(String phone);

    @Select("SELECT * FROM user WHERE email = #{email}")
    User findEmail(String email);

    @Update("UPDATE user SET password = #{newPassword} WHERE email = #{email}")
    void resetPassword(String email, String newPassword);

    @Update("UPDATE user SET password = #{password} WHERE id = #{id}")
    void saveUpdatePassword(int id, String password);
}
