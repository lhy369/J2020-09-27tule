package com.qianfeng.dao;

import com.alibaba.druid.sql.visitor.functions.Concat;
import com.qianfeng.domain.Contact;

import java.util.List;

public interface ContactDAO {
    List<Contact> queryAll(int pageOffset, int pageSize);

    int queryCount();

    int deleteById(String contactid);

    Contact queryById(String contactId);

    int update(Contact contact);

    int Add(Contact contact);
}