package xyz.mxue.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import xyz.mxue.crm.entity.Customer;
import xyz.mxue.crm.model.CRUDResult;
import xyz.mxue.crm.model.PageResult;
import xyz.mxue.crm.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toCustomerPage() {
       return "customer/customerList";
    }

    /**
     * 创建客户页面
     * @param map
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String toCustomerAddPage(ModelMap map) {
        return  "customer/customeradd";
    }


    /**
     * 保存用户信息
     * @param customer
     * @return
     */
    @RequestMapping(value = "saveCustomer", method = RequestMethod.POST)
    @ResponseBody
    public CRUDResult saveUser(Customer customer) {
        CRUDResult result = new CRUDResult();
        result.setSuccess(0);
        if (customerService.saveCustomer(customer)) {
           result.setMeg("添加客户成功");
        } else {
           result.setMeg("添加客户失败");
        }
       return result;
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public String deleteCustomer(int cusNo) {
        customerService.deleteCustomer(cusNo);
        System.out.println(cusNo);
        return "";
    }

    public String updateCustomer() {
        return "customr/";
    }

    /**
     * 客户详情
     * @param map
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String customerDetail(ModelMap map,int cusNo) {
        map.addAttribute("customer", customerService.customerDetail(cusNo));
        return "customer/customerDetail";
    }

    /**
     *  如果我们想给页面返回 JSON ，可以用 ResponseBody 返回
     *   @return
     */
    @ResponseBody
    @RequestMapping(value = "listJson", method = RequestMethod.GET)
    public PageResult<Customer> listJson(int page, int limit) {
        return  customerService.findPageResult(page, limit);
    }

}
