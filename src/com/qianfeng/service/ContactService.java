package com.qianfeng.service;

import com.alibaba.druid.sql.visitor.functions.Concat;
import com.qianfeng.domain.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> queryAll(int currentPage, int pageSize);

    int queryPageCount(int pageSize);

    boolean deleteById(String contactid);

    Contact queryById(String contactId);

    boolean update(Contact contact);

    boolean Add(Contact contact);
}