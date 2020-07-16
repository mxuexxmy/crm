package xyz.mxue.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.mxue.crm.model.SourceResult;
import xyz.mxue.crm.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/report")
public class SourceController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/sourcecustomer")
    public String toSourceCustomer(){
        return "reports/sourcecustomer";
    }

    @RequestMapping("/sourcecustomerreport")
    @ResponseBody
    public List<SourceResult> SourceCustomerReport(){
        return customerService.SourceCustomerReport();
    }
}
