package xyz.mxue.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.mxue.crm.entity.Contract;
import xyz.mxue.crm.entity.Customer;
import xyz.mxue.crm.mapper.ContractMapper;
import xyz.mxue.crm.model.PageResult;
import xyz.mxue.crm.service.ContractService;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public PageResult<Contract> findPageResult(Contract contract, int page, int limit) {
        PageResult<Contract> result = new PageResult<>();
        result.setCode(0);
        result.setMsg("");
        Map<String , Object> map = new HashMap<>();

        if (contract.getConName() == "") {
            contract.setConName(null);
        }

        map.put("start", (page - 1) * limit);
        map.put("limit", limit);
        map.put("contract", contract);
        result.setCount(contractMapper.findCount(map));
        result.setData(contractMapper.findCustomer(map));
        return result;
    }

    @Override
    public void deleteContract(int conNo) {
        contractMapper.deleteContract(conNo);
    }


}
