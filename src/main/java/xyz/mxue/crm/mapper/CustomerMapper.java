package xyz.mxue.crm.mapper;

import org.apache.ibatis.annotations.*;
import xyz.mxue.crm.entity.Customer;
import xyz.mxue.crm.model.BaseCredit;
import xyz.mxue.crm.model.BaseSource;
import xyz.mxue.crm.model.ReportResult;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerMapper {
    /**
     * 查询数据条数
     * @return
     */
    @Select({"<script>" +
            "select count(*) from customer" +
            "<if test='customer.cusNo != null'>where cus_no like concat('%',#{customer.cusNo},'%') </if>" +
            "<if test='customer.cusNo != null and customer.cusName != null'>and</if>" +
            "<if test='customer.cusNo == null and customer.cusName!=null'>where</if>" +
            "<if test='customer.cusName != null'>cus_name like concat('%',#{customer.cusName},'%') </if>" +
            "</script>"})
    int findCount(Map<String, Object> map);

    /**
     * 分页数据
     * @param map
     * @return
     */
    @Select({"<script>" +
            "select * from customer " +
            "<if test='customer.cusNo != null'>where cus_no like concat('%',#{customer.cusNo},'%') </if>" +
            "<if test='customer.cusNo != null and customer.cusName != null'>and </if>" +
            "<if test='customer.cusNo == null and customer.cusName!=null'>where</if>" +
            "<if test='customer.cusName != null'>cus_name like concat('%',#{customer.cusName},'%') </if>" +
            "limit #{start},#{limit}" +
            "</script>"})
    List<Customer> findCustomer(Map<String, Object> map);

    /**
     * 插入用户信息
     * @param customer
     * @return
     */
    @Insert("INSERT INTO customer(cus_name, cus_region,cus_url, cus_level, cus_credit) VALUES(#{cusName}, #{cusRegion}, #{cusUrl}, #{cusLevel}, #{cusCredit})")
    int saveCustomer(Customer customer);

    /**
     * 查询用户信息
     * @param cusNo
     * @return
     */
    @Select("select * from customer where cus_no = #{cusNo}")
    Customer customerDetail(int cusNo);

    /**
     * 用户删除
     * @param cusNo
     * @return
     */
    @Delete("delete from customer where cus_no = #{cusNo}")
    int deleteCustomer(int cusNo);

    /**
     * 修改客户信息
     * @param customer
     * @return
     */
    @Update("update customer set cus_name = #{cusName}, cus_region = #{cusRegion}, cus_url = #{cusUrl}, cus_level = #{cusLevel}, cus_credit = ${cusCredit} where cus_no = #{cusNo}")
    int saveUpdateCustomer(Customer customer);

    @Select("SELECT cus_region as region,COUNT(*) as total FROM customer GROUP BY cus_region")
    List<ReportResult> countCustomerReport();

    @Select("SELECT * FROM customer")
    List<Customer> customerList();

    @Select("SELECT cus_source as name , COUNT(*) as value FROM customer  GROUP BY  cus_source")
    List<BaseSource> findSourceResult();

    @Select("SELECT cus_credit as name , COUNT(*) as value FROM customer  GROUP BY  cus_credit")
    List<BaseCredit> findSCreditResult();
}
