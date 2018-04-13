package kr.co.bit.coffee.controller;

import kr.co.bit.coffee.dao.MemberDAO;
import kr.co.bit.coffee.vo.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String cmd = req.getParameter("cmd" );
        cmd=cmd==null?"":cmd;
        String url = "./mvc/home.jsp";
        System.out.println(cmd + "**" + url+"end//");
        if(cmd.equals("regist")) {
            String id = req.getParameter("id");
            String name= req.getParameter("name");
            String pw = req.getParameter("pw");
            String birth = req.getParameter("birth");
            String zipcode = req.getParameter("zipcode");
            String lang = req.getParameter("lang");
            String tool = req.getParameter("tool");

            MemberVO vo = new MemberVO();
            vo.setId(id);
            vo.setPw(pw);
            vo.setName(name);
            vo.setBirth(birth);
            vo.setZipcode(zipcode);
            vo.setLang(lang);
            vo.setTool(tool);

            MemberDAO dao = new MemberDAO();
            dao.regist(vo);
            url = "./mvc/home.jsp";
        } else if(cmd.equals("regist_form")){
            url = "./mvc/regist_form.jsp";
        }else if(cmd.equals("request_list")){

            MemberDAO dao = new MemberDAO();
            ArrayList<MemberVO> list = dao.request_list();
            req.setAttribute("list",list);
            url = "./mvc/request_list.jsp";
        }
        System.out.println(url);
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req, resp);
    }


}
