package xyz.mxue.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.mxue.crm.entity.Customer;
import xyz.mxue.crm.mapper.CustomerMapper;
import xyz.mxue.crm.model.*;
import xyz.mxue.crm.service.CustomerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public PageResult<Customer> findPageResult(Customer customer, int page, int limit) {
        PageResult<Customer> result = new PageResult<>();
        result.setCode(0);
        result.setMsg("");
        Map<String , Object> map = new HashMap<>();

        if(String.valueOf(customer.getCusNo())==""){
            customer.setCusNo(null);
        }
        if(customer.getCusName()==""){
            customer.setCusName(null);
        }

        map.put("start", (page - 1) * limit);
        map.put("limit", limit);
        map.put("customer", customer);
        result.setCount(customerMapper.findCount(map));
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

    @Override
    public Customer getCustomerOne(int cusNo) {
        return customerMapper.customerDetail(cusNo);
    }

    @Override
    public Boolean saveUpdateCustomer(Customer customer) {
        if (customerMapper.saveUpdateCustomer(customer) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<ReportResult> countCustomerReport() {
        return customerMapper.countCustomerReport();
    }

    @Override
    public List<Customer> customerList() {
        return customerMapper.customerList();
    }

    @Override
    public List<SourceResult> SourceCustomerReport() {
        List<SourceResult> results = new ArrayList<>();
        List<BaseSource> sources = customerMapper.findSourceResult();;

        String [] sourceName = {"搜索引擎", "邀请", "电话咨询", "邮件咨询", "广告", "其他"};

        for (BaseSource source : sources) {
            SourceResult sourceResult = new SourceResult();
            sourceResult.setValue(source.getValue());
            sourceResult.setName(sourceName[source.getName() - 1]);
            results.add(sourceResult);
        }

        return results;
    }

    @Override
    public List<CreditResult> CreditCustomerReport() {
        List<CreditResult> results = new ArrayList<>();
        List<BaseCredit> credits = customerMapper.findSCreditResult();;

        String [] creditName = {"一级", "二级", "三级", "四级", "五级"};

        for (BaseCredit credit : credits) {
            CreditResult creditResult = new CreditResult();
            creditResult.setValue(credit.getValue());
            creditResult.setName(creditName[credit.getName() - 1]);
            results.add(creditResult);
        }

        return results;
    }

}
