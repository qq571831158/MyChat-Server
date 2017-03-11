package com.ch.utils;


import com.ch.model.Message;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by apple on 2017/3/11.
 */
public class DBConnection {
    public static final String dbURL = "jdbc:mysql://182.254.152.99:3306/qqchat";
    public static final String driverName = "com.mysql.jdbc.Driver";
    public static final String userName = "cheng";
    public static final String userPassword = "CHENGhengok.1314";

    private static Connection ct=null;
    private static PreparedStatement ps=null;
    private static ResultSet rs=null;


    public static Connection getConnection() throws SQLException{
        Connection dbConn=null;
        try{
            Class.forName(driverName);
            dbConn=DriverManager.getConnection(dbURL,userName,userPassword);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return dbConn;
    }
    public static ArrayList executeQuery(String sql, String [] paras){
        try{
            ct=getConnection();
            ps=ct.prepareStatement(sql);
            if(paras!=null){
                for(int i=0;i<paras.length;i++)
                {
                    ps.setString(i+1, paras[i]);
                }
            }
            rs=ps.executeQuery();
            ArrayList al=new ArrayList();
            ResultSetMetaData rsmd=rs.getMetaData();
            int column=rsmd.getColumnCount();
            while(rs.next()){
                Object [] obj=new Object[column];
                for(int i=0;i<obj.length;i++){
                    obj[i]=rs.getObject(i+1);
                }
                al.add(obj);
            }
            return al;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
        finally{
            close(rs,ps,ct);
        }
    }

    public void executeUpdate(String sql, Message message){

        try {
            ct=getConnection();
            ps=ct.prepareStatement(sql);
            ps.setInt(1,0);
            ps.setString(2,message.getMessageContent());
            ps.setString(3,message.getMessageFromuser());
            ps.setTimestamp(4,message.getMessageTime());
            ps.setString(5,message.getMessageTouser());
            ps.setInt(6,message.getMessageIsread());
            ps.executeUpdate();
        }


        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        finally{
            close(rs,ps,ct);
        }

    }

    public static void close(ResultSet rs,Statement ps,Connection ct){
        if(rs!=null){
            try{
                rs.close();
            }catch (Exception e){
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ps=null;
        }
    }

}
