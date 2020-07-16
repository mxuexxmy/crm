package xyz.mxue.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.mxue.crm.entity.Contact;
import xyz.mxue.crm.mapper.ContactMapper;
import xyz.mxue.crm.mapper.CustomerMapper;
import xyz.mxue.crm.model.PageResult;
import xyz.mxue.crm.service.ContactService;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public PageResult<Contact> findContactResult(Contact contact, int page, int limit) {
        PageResult<Contact> result = new PageResult<>();
        result.setCode(0);
        result.setMsg("");
        Map<String , Object> map = new HashMap<>();
        if(contact.getCtName()==""){
            contact.setCtName(null);
        }

        map.put("start", (page - 1) * limit);
        map.put("limit", limit);
        map.put("contact", contact);
        result.setCount(contactMapper.findCount(map));
        result.setData(contactMapper.findContact(map));
        return result;
    }

    @Override
    public boolean saveContact(Contact contact) {
        if (contactMapper.saveContact(contact) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteContact(int ctId) {
        contactMapper.deleteContact(ctId);
    }

    @Override
    public Contact getContactOne(int ctId) {
        return contactMapper.getContactOne(ctId);
    }

    @Override
    public boolean saveUpdateContact(Contact contact) {
        if (contactMapper.saveUpdateContact(contact) > 0) {
            return true;
        }
        return false;
    }


}
