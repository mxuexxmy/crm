package xyz.mxue.crm.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.mxue.crm.entity.Contract;

import java.util.List;
import java.util.Map;

@Mapper
public interface ContractMapper {

    @Select({"<script>" +
            "select count(*) from contract" +
            "<if test='contract.conName != null'>where con_name like concat('%',#{contract.conName},'%') </if>" +
            "</script>"})
    Integer findCount(Map<String, Object> map);

    @Select({"<script>" +
            "select * from contract" +
            "<if test='contract.conName != null'>where con_name like concat('%',#{contract.conName},'%') </if>" +
            "limit #{start},#{limit}" +
            "</script>"})
    List<Contract> findCustomer(Map<String, Object> map);

    @Delete("DELETE FROM contract WHERE con_no = #{conNo}")
    void deleteContract(int conNo);
}
