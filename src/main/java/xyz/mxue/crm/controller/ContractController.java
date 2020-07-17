package xyz.mxue.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.mxue.crm.entity.Contract;
import xyz.mxue.crm.model.CRUDResult;
import xyz.mxue.crm.model.PageResult;
import xyz.mxue.crm.service.ContactService;
import xyz.mxue.crm.service.ContractService;
import xyz.mxue.crm.service.CustomerService;

@Controller
@RequestMapping(value = "contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "contract/contractlist";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String contractAdd() {
        return "contract/contractadd";
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String contractDetail() {
        return "contract/contractdetail";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String contractUpdate() {
        return "contract/contractdetail";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public CRUDResult deleteCustomer(int conNo) {
        CRUDResult result = new CRUDResult();
        result.setSuccess(0);
        contractService.deleteContract(conNo);
        result.setMsg("删除客户成功");
        return result;
    }

    /**
     *  如果我们想给页面返回 JSON ，可以用 ResponseBody 返回
     *   @return
     */
    @ResponseBody
    @RequestMapping(value = "listJson", method = RequestMethod.GET)
    public PageResult<Contract> listJson(Contract contract, int page, int limit) {
        return  contractService.findPageResult(contract, page, limit);
    }


}
