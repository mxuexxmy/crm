package xyz.mxue.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.mxue.crm.entity.Customer;
import xyz.mxue.crm.mapper.CustomerMapper;
import xyz.mxue.crm.model.PageResult;
import xyz.mxue.crm.service.CustomerService;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public PageResult<Customer> findPageResult(int page, int limit) {
        PageResult<Customer> result = new PageResult<>();
        result.setCode(0);
        result.setMsg("");
        Map<String , Object> map = new HashMap<>();
        map.put("start", (page - 1) * limit);
        map.put("limit", limit);
        result.setCount(customerMapper.findCount());
        result.setData(customerMapper.findCustomer(map));
        return result;
    }

    /**
     * 保存用户信息
     * @param customer
     * @return
     */
    @Override
    public Boolean saveCustomer(Customer customer) {
        if (customerMapper.saveCustomer(customer) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Customer customerDetail(int cusNo) {
        return customerMapper.customerDetail(cusNo);
    }

    @Override
    public Boolean deleteCustomer(int cusNo) {
        if (customerMapper.deleteCustomer(cusNo) > 0) {
            return true;
        }
        return false;
    }

}
