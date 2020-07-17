package xyz.mxue.crm.service;

import xyz.mxue.crm.entity.Contract;
import xyz.mxue.crm.entity.Customer;
import xyz.mxue.crm.model.PageResult;

public interface ContractService {
    PageResult<Contract> findPageResult(Contract contract, int page, int limit);

    void deleteContract(int conNo);
}
