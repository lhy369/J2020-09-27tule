package com.qianfeng.service.impl;

import com.alibaba.druid.sql.visitor.functions.Concat;
import com.qianfeng.dao.ContactDAO;
import com.qianfeng.dao.impl.ContactDAOimpl;
import com.qianfeng.domain.Contact;
import com.qianfeng.service.ContactService;

import java.util.List;

public class ContactServiceimpl implements ContactService {
    private ContactDAO dao=new ContactDAOimpl();
    @Override
    public List<Contact> queryAll(int currentPage, int pageSize) {
        int pageOffset=(currentPage-1)*pageSize;
        return dao.queryAll(pageOffset,pageSize);

    }

    @Override
    public int queryPageCount(int pageSize) {
        int recordCount=dao.queryCount();
        double ceil = Math.ceil(recordCount / (double) pageSize);
        return (int) ceil;
    }

    @Override
    public boolean deleteById(String contactid) {
        int i=dao.deleteById(contactid);
        return i==1;
    }

    @Override
    public Contact queryById(String contactId) {
        return dao.queryById(contactId);
    }

    @Override
    public boolean update(Contact contact) {
        int i=dao.update(contact);
        return i==1;
    }

    @Override
    public boolean Add(Contact contact) {
        int i=dao.Add(contact);
        return i==1;
    }
}