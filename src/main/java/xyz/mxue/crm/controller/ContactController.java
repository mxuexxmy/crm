package xyz.mxue.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.mxue.crm.entity.Contact;
import xyz.mxue.crm.entity.Customer;
import xyz.mxue.crm.model.CRUDResult;
import xyz.mxue.crm.model.PageResult;
import xyz.mxue.crm.service.ContactService;
import xyz.mxue.crm.service.CustomerService;

@Controller
@RequestMapping(value = "contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "contact/contactList";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        map.addAttribute("customers", customerService.customerList());
        return "contact/contactadd";
    }


    @RequestMapping(value = "saveContact", method = RequestMethod.POST)
    @ResponseBody
    public CRUDResult saveContact(Contact contact) {
        CRUDResult result = new CRUDResult();
        result.setSuccess(0);
        if (contactService.saveContact(contact)) {
           result.setMsg("保存联系人成功");
        } else {
           result.setMsg("保存联系人失败");
        }
       return result;
    }

    /**
     * 跳转修改页面
     * @param ctId
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String updateCustomer(ModelMap map,int ctId) {
        Contact contact = contactService.getContactOne(ctId);
        map.addAttribute("customer", customerService.getCustomerOne(contact.getCusNo()));
        map.addAttribute("contact", contact);
        return "contact/contactupdate";
    }

    @RequestMapping(value = "saveUpdate", method = RequestMethod.POST)
    @ResponseBody
    public CRUDResult saveUpdateCustomer(Contact contact) {
        CRUDResult result = new CRUDResult();
        if ( contactService.saveUpdateContact(contact)) {
            result.setSuccess(0);
            result.setMsg("修改联系人成功");
        } else {
            result.setSuccess(0);
            result.setMsg("修改联系人失败");
        }
        return result;
    }

    /**
     * 联系人详情
     * @param map
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String customerDetail(ModelMap map,int ctId) {
        Contact contact = contactService.getContactOne(ctId);
        map.addAttribute("customer", customerService.getCustomerOne(contact.getCusNo()));
        map.addAttribute("contact", contact);
        return "contact/contactdetail";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public CRUDResult deleteCustomer(int ctId) {
        CRUDResult result = new CRUDResult();
        result.setSuccess(0);
        contactService.deleteContact(ctId);
        result.setMsg("删除联系人成功");
        return result;
    }


    @RequestMapping(value = "listJson", method = RequestMethod.GET)
    @ResponseBody
    public PageResult<Contact> listJson(Contact contact,int page, int limit) {
        return contactService.findContactResult(contact, page, limit);
    }

}
