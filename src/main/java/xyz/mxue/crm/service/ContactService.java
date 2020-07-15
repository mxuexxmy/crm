package xyz.mxue.crm.service;

import xyz.mxue.crm.entity.Contact;
import xyz.mxue.crm.model.PageResult;

public interface ContactService {
    PageResult<Contact> findContactResult(int page, int limit);
}
