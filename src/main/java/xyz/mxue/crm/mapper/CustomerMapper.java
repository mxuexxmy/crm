package xyz.mxue.crm.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.mxue.crm.entity.Customer;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerMapper {
    /**
     * 查询数据条数
     * @return
     */
    @Select("select count(*) from customer")
    int findCount();

    /**
     * 分页数据
     * @param map
     * @return
     */
    @Select("select * from customer limit #{start},#{limit}")
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
}
