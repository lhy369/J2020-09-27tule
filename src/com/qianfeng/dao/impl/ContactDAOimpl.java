package com.qianfeng.dao.impl;

import com.alibaba.druid.sql.visitor.functions.Concat;
import com.qianfeng.dao.ContactDAO;
import com.qianfeng.domain.Contact;
import com.qianfeng.utils.DataSourceUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ContactDAOimpl implements ContactDAO {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(DataSourceUtils.getDateSource());
    @Override
    public List<Contact> queryAll(int pageOffset, int pageSize) {
        String sql="select * from contact_info where del=0 limit ?,? ";
        List<Contact> query=null;
        try {
            query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contact.class),pageOffset,pageSize);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return query;
    }

    @Override
    public int queryCount() {

        String sql="select count(*) from contact_info where del=0";
        int integer = jdbcTemplate.queryForObject(sql, Integer.class);
        return integer;
    }

    @Override
    public int deleteById(String contactid) {
        String sql="update contact_info set del=1 where id=?";
        int update = jdbcTemplate.update(sql,contactid);
        return update;
    }

    @Override
    public Contact queryById(String contactId) {
        String sql="select * from contact_info where id=? and del=0";
        List<Contact> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contact.class), contactId);
        if(query.size()==1){
            return query.get(0);
        }else {
            return null;
        }
    }

    @Override
    public int update(Contact contact) {
        String sql="update contact_info set name=?, gender=?, birthday=?, birthplace=?, mobile=?, email=? where id=?";
        int update = jdbcTemplate.update(sql,
                contact.getName(),
                contact.getGender(),
                contact.getBirthday(),
                contact.getBirthplace(),
                contact.getMobile(),
                contact.getEmail(),
                contact.getId());
        return update;
    }

    @Override
    public int Add(Contact contact) {
        String sql="insert into contact_info (`name`,`gender`,`birthday`,`birthplace`,`mobile`,`email`) values (?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql,
                contact.getName(),
                contact.getGender(),
                contact.getBirthday(),
                contact.getBirthplace(),
                contact.getMobile(),
                contact.getEmail()
        );
        return update;
    }
}
