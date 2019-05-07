package com.coda.visitors;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class VisitorRepo {

    Connection con = null;
    PreparedStatement pstmt = null;

    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Calendar cal = Calendar.getInstance();
    String timeValue = dateFormat.format(cal.getTime());

    DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    String dateValue = dateFormat1.format(date);


    //constructor to initialize objs and add to list
    public VisitorRepo() {

        String url = "jdbc:mysql://localhost:3306/visitors";
        String username = "root";
        String password = "Alldbest@123";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }


    public void createVisitor(VisitorModel visitor) throws SQLException {

        visitor.setOutTime("null");

        String sql = "insert into visitortable values(default,?,?,?,?,?,?,?)";

        pstmt = con.prepareStatement(sql);

        pstmt.setString(1,visitor.getVisitorName());
        pstmt.setString(2,visitor.getPhoneNum());
        pstmt.setString(3,visitor.getCompanyName());
        pstmt.setString(4,visitor.getCurrentdate(dateValue));
        pstmt.setString(5,visitor.getInTime(timeValue));
        pstmt.setString(6,visitor.getOutTime("null"));
        pstmt.setString(7,visitor.getPersonToContact());

        pstmt.executeUpdate();

    }

    public void updateOutTime(VisitorModel2 visitor) throws SQLException {

        visitor.setOutTime(timeValue);

        String sql =  "update visitortable set outTime = ? where visitorId = ?";

        pstmt = con.prepareStatement(sql);
        pstmt.setString(1,visitor.getOutTime(timeValue));
        pstmt.setInt(2,visitor.getVisitorId());
        pstmt.executeUpdate();

    }


    public void editVisitor(VisitorModel2 visitor) throws SQLException {

        String sql =  "update visitortable set visitorName =?, phoneNum=?, companyName=?, personToContact=?  where visitorId = ?";

        pstmt = con.prepareStatement(sql);

        pstmt.setString(1,visitor.getVisitorName());
        pstmt.setString(2,visitor.getPhoneNum());
        pstmt.setString(3,visitor.getCompanyName());
        pstmt.setString(4,visitor.getPersonToContact());
        pstmt.setInt(5,visitor.getVisitorId());

        pstmt.executeUpdate();

    }

    public void deleteVisitor(int VisitorId) throws SQLException {

        String sql =  "delete from visitortable where VisitorId=?";

        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,VisitorId);
        pstmt.executeUpdate();
    }

    public List<VisitorModel2> getvisitor() throws SQLException {

        List<VisitorModel2> list = new ArrayList();
        Statement st = con.createStatement();
        String sql =  "select * from visitortable";
        ResultSet rs = st.executeQuery(sql);


        while(rs.next()) {
            VisitorModel2 visitor = new VisitorModel2();
            visitor.setVisitorId(rs.getInt(1));
            visitor.setName(rs.getString(2));
            visitor.setPhoneNum(rs.getString(3));
            visitor.setCompanyName(rs.getString(4));
            visitor.setCurrentdate(rs.getString(5));
            visitor.setInTime(rs.getString(6));
            visitor.setOutTime(rs.getString(7));
            visitor.setPersonToContact(rs.getString(8));
            list.add(visitor);

        }

        return list;

    }

    public VisitorModel2 getsinglevisitor(Integer VisitorId) throws SQLException {


        List<VisitorModel2> list = new ArrayList();
        Statement st = con.createStatement();
        String sql = "select * from visitortable where VisitorId="+VisitorId;
        ResultSet rs = st.executeQuery(sql);
        st = con.createStatement();
        VisitorModel2 visitor = new VisitorModel2();
        if(rs.next()) {
            visitor.setVisitorId(rs.getInt(1));
            visitor.setName(rs.getString(2));

            list.add(visitor);
        }
        return visitor;
    }
}

