package kr.co.bit.coffee.dao;

import kr.co.bit.coffee.connectionManager.ConnectionManager;
import kr.co.bit.coffee.vo.MemberVO;
import oracle.jdbc.connector.OracleConnectionManager;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

    public boolean regist(MemberVO vo) {
        System.out.println("regist DAO 들어옴");

        Boolean flag = false;
        ConnectionManager mgr = new ConnectionManager();
        String sql = "insert into coffee_tbl values (?,?,?,?,?,?,?)";
        Connection con = mgr.getConnection();

        PreparedStatement pstmt = null;
        try {
            System.out.println("트라이 안에 들어옴");
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getPw());
            pstmt.setString(4, vo.getBirth());
            pstmt.setString(5, vo.getZipcode());
            pstmt.setString(6, vo.getLang());
            pstmt.setString(7, vo.getTool());

            int affectedcount = pstmt.executeUpdate();
            System.out.println("트라이 마지막 줄");
            if (affectedcount > 0) {
                System.out.println("AFFECTEDCOUNT");
                flag = true;
                System.out.println(flag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mgr.connectClose(con, pstmt, null);
        }

        return flag;
    }

    public ArrayList<MemberVO> request_list() {

        ArrayList<MemberVO> list = null;
        ConnectionManager mgr = new ConnectionManager();
        String sql = ("select * from coffee_tbl");
        Connection con = mgr.getConnection();
        System.out.println("request_list 안에 들어옴");
        PreparedStatement pstmt = null;
        try {
            list = new ArrayList<MemberVO>();
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("while 문 안에 들어옴");
                MemberVO vo = new MemberVO();
                vo.setId(rs.getString(1));
                vo.setName(rs.getString(2));
                vo.setPw(rs.getString(3));
                vo.setBirth(rs.getString(4));
                vo.setZipcode(rs.getString(5));
                vo.setLang(rs.getString(6));
                vo.setTool(rs.getString(7));
                list.add(vo);
            }

            System.out.println("request_list 끝남");
            mgr.connectClose(con, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    public ArrayList<MemberVO> request_list_part(String id){
        System.out.println("리퀘스트리스트파트1");
        System.out.println(id);
        ArrayList<MemberVO> list = null;
        ConnectionManager mgr = new ConnectionManager();
        String sql = ("select * from coffee_tbl where user_id ='"+id+"'");
        Connection con = mgr.getConnection();
        PreparedStatement pstmt = null;
        System.out.println("리퀘스트리스트파트22");
        try {
            list = new ArrayList<MemberVO>();
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("리퀘스트리스트파트3");
            while(rs.next()){
                System.out.println("리퀘스트리스트파트44");
                MemberVO vo = new MemberVO();
                vo.setId(rs.getString(1));
                vo.setName(rs.getString(2));
                vo.setPw(rs.getString(3));
                vo.setBirth(rs.getString(4));
                vo.setZipcode(rs.getString(5));
                vo.setLang(rs.getString(6));
                vo.setTool(rs.getString(7));
                list.add(vo);
            }
            mgr.connectClose(con, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
}
