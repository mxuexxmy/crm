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
    public PageResult<Contact> findContactResult(int page, int limit) {
        PageResult<Contact> result = new PageResult<>();
        result.setCode(0);
        result.setMsg("");
        Map<String , Object> map = new HashMap<>();

        map.put("start", (page - 1) * limit);
        map.put("limit", limit);

        result.setCount(contactMapper.findCount(map));
        result.setData(contactMapper.findContact(map));
        return result;
    }


}
