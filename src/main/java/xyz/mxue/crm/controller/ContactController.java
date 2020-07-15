package xyz.mxue.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.mxue.crm.entity.Contact;
import xyz.mxue.crm.model.PageResult;
import xyz.mxue.crm.service.ContactService;

@Controller
@RequestMapping(value = "contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "contact/contactList";
    }

    @RequestMapping(value = "listJson", method = RequestMethod.GET)
    @ResponseBody
    public PageResult<Contact> listJson(int page, int limit) {
        return contactService.findContactResult(page, limit);
    }

}
