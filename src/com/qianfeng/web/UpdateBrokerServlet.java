package com.qianfeng.web;

import com.qianfeng.domain.Contact;
import com.qianfeng.service.ContactService;
import com.qianfeng.service.impl.ContactServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update_broker")
public class UpdateBrokerServlet extends HttpServlet {
    private ContactService service=new ContactServiceimpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1.接收
        String contactId = request.getParameter("id");

//2.处理
        Contact contact=service.queryById(contactId);
//3.响应
        request.setAttribute("contact",contact);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
