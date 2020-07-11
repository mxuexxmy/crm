package xyz.mxue.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.mxue.crm.entity.Customer;
import xyz.mxue.crm.model.PageResult;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @RequestMapping(value = "customerlist", method = RequestMethod.GET)
    public String toCustomerPage() {
       return "customer/customerList";
    }

    @RequestMapping(value = "listJson", method = RequestMethod.GET)
    public PageResult<Customer> listJson() {

        return null;
    }

}
