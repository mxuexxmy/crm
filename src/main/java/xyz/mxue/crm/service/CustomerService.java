package xyz.mxue.crm.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import xyz.mxue.crm.entity.Customer;
import xyz.mxue.crm.model.PageResult;
import xyz.mxue.crm.model.ReportResult;

import java.util.List;

public interface CustomerService {

    /**
     * 客户基本信息列表及分页
     * @param page
     * @param limit
     * @return
     */
    PageResult<Customer> findPageResult(Customer customer,int page, int limit);

    /**
     * 保存用户信息
     * @param customer
     * @return
     */
    Boolean saveCustomer(Customer customer);

    /**
     * 客户详情
     * @param cusNo
     * @return
     */
    Customer customerDetail(int cusNo);

    /**
     * 删除客户信息
     * @param cusNo
     * @return
     */
    Boolean deleteCustomer(int cusNo);

    /**
     * 根据 cusNo 查询客户
     * @param cusNo
     * @return
     */
    Customer getCustomerOne(int cusNo);

    Boolean saveUpdateCustomer(Customer customer);


    List<ReportResult> countCustomerReport();
}
