package com.qianfeng.web;

import com.alibaba.druid.sql.visitor.functions.Concat;
import com.qianfeng.domain.Contact;
import com.qianfeng.service.ContactService;
import com.qianfeng.service.impl.ContactServiceimpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/update")
public class UpdateContactServlet extends HttpServlet {
    private ContactService service=new ContactServiceimpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1.接收
        Contact contact = new Contact();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(contact,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//2.处理
        service.update(contact);
//3.响应
        response.sendRedirect("query_contact_page");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
