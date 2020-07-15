package xyz.mxue.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.mxue.crm.model.ReportResult;
import xyz.mxue.crm.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("report")
public class ReportsController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "countcustomer", method = RequestMethod.GET)
    public String countCustomer() {
        return "reports/countcustomer";
    }

    @RequestMapping(value = "countcustomerreport", method = RequestMethod.GET)
    @ResponseBody
    public List<ReportResult> countCustomerReport() {
        return customerService.countCustomerReport();
    }

}
