package xyz.mxue.crm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.mxue.crm.entity.Customer;
import xyz.mxue.crm.mapper.CustomerMapper;
import xyz.mxue.crm.service.CustomerService;

import java.util.List;

@SpringBootTest
class CrmApplicationTests {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerService customerService;

    @Test
    void contextLoads() {
    }

    @Test
   public void testDeleteCustomer() {
     if (customerService.deleteCustomer(53)) {
         System.out.println("成功");
     }
   }

}
