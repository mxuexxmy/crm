package xyz.mxue.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.mxue.crm.model.CreditResult;
import xyz.mxue.crm.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/report")
public class CreditController {

    @Autowired
    private CustomerService customerService;
    @RequestMapping("/creditcustomer")
    public String toSourceCustomer(){
        return "reports/creditcustomer";
    }

    @RequestMapping("/creditcustomerreport")
    @ResponseBody
    public List<CreditResult> CreditCustomerReport(){
        return  customerService.CreditCustomerReport();
    }
}
