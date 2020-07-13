package xyz.mxue.crm.service;

import xyz.mxue.crm.entity.Customer;
import xyz.mxue.crm.model.PageResult;

public interface CustomerService {

    /**
     * 客户基本信息列表及分页
     * @param page
     * @param limit
     * @return
     */
    PageResult<Customer> findPageResult(int page, int limit);

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
}
