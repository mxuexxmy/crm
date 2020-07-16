package xyz.mxue.crm.service;

import xyz.mxue.crm.entity.Contact;
import xyz.mxue.crm.model.PageResult;

public interface ContactService {
    PageResult<Contact> findContactResult(Contact contact,int page, int limit);

    boolean saveContact(Contact contact);

    void deleteContact(int ctId);

    Contact getContactOne(int ctId);

    boolean saveUpdateContact(Contact contact);
}
