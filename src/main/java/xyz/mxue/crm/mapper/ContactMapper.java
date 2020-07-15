package xyz.mxue.crm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.mxue.crm.entity.Contact;

import java.util.List;
import java.util.Map;

@Mapper
public interface ContactMapper {

    @Select("SELECT * FROM contact limit #{start},#{limit}")
    List<Contact> findContact(Map<String, Object> map);

    @Select("SELECT COUNT(*) FROM contact limit #{start},#{limit}")
    Integer findCount(Map<String, Object> map);
}
