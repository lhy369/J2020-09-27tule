package com.qianfeng.web;

import com.qianfeng.service.ContactService;
import com.qianfeng.service.impl.ContactServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_contact")
public class DeleteContactServlet extends HttpServlet {
    private ContactService service=new ContactServiceimpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1.接收
        String contactid = request.getParameter("id");


//2.处理
        service.deleteById(contactid);
//3.响应
// request.getRequestDispatcher("query_contact_page").forward(request,response);
        response.sendRedirect("query_contact_page");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
