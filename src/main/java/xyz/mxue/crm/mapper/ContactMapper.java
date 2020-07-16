package xyz.mxue.crm.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.mxue.crm.entity.Contact;

import java.util.List;
import java.util.Map;

@Mapper
public interface ContactMapper {


   // @Select("SELECT * FROM contact limit #{start},#{limit}")
    @Select({"<script>" +
            "select * from contact " +
            "<if test='contact.ctName != null'>where ct_name like concat('%',#{contact.ctName},'%') </if>" +
            "limit #{start},#{limit}" +
            "</script>"})
    List<Contact> findContact(Map<String, Object> map);

    @Select({"<script>" +
            "select count(*) from contact" +
            "<if test='contact.ctName != null'>where ct_name like concat('%',#{contact.ctName},'%') </if>" +
            "</script>"})
    Integer findCount(Map<String, Object> map);

    @Insert("INSERT INTO contact(ct_name, ct_gender, ct_phone, ct_title, ct_notes, cus_no) VALUES(#{ctName}, #{ctGender}, #{ctPhone}, #{ctTitle}, #{ctNotes}, #{cusNo})")
    Integer saveContact(Contact contact);

   @Delete("DELETE FROM contact WHERE ct_id = #{ctId}")
   void deleteContact(int ctId);

   @Select("SELECT * FROM contact WHERE ct_id = #{ctId}")
   Contact getContactOne(int ctId);

   @Select("UPDATE contact set ct_name = #{ctName}, ct_gender = #{ctGender}, ct_phone = #{ctPhone}, ct_notes = #{ctNotes} WHERE ct_id = #{ctId}")
   int saveUpdateContact(Contact contact);
}
