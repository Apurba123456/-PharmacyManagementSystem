/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author apurb
 */
public class tables {
    public static void main (String args[]){
        try{
          Connection con=ConnectionProvider.getCon();
          Statement st=con.createStatement();
          //st.executeUpdate("create table appuser11(appuser11_pk int AUTO_INCREMENT primary key,userole varchar(200),name varchar(200),dob varchar(50),mobileNumber varchar(50),email varchar(200),username varchar(200),password varchar(50),address varchar(200))");
          //st.executeUpdate("insert into appuser11(userole,name,dob,mobileNumber,email,username,password,address)values('Admin','Admin','16-12-1992','0000111122','admin@email.com','admin','admin','India')");
          //st.executeUpdate("create table medicine(medicine_pk int AUTO_INCREMENT primary key,uniqueID varchar(200),name varchar(200),companyName varchar(200),quantity bigint,price bigint)");
          st.executeUpdate("create table bill(bill_pk int AUTO_INCREMENT primary key,billId varchar(200),billDate varchar(50),totalPaid bigint,generatedBy varchar(50))");
          JOptionPane.showMessageDialog(null,"Table created sucessfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
