package org.hanarki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateBooking  {
  
  String BookId,CustId,EventId,CampReq;
  
public void setBooking(String BookId, String CustId , String EventId, String CampReq)
{
 Connection connection = null;
  ResultSet resultSet = null;
  Statement statement = null;
  String DbQuery = "";
  
 
  DbQuery = "INSERT INTO BOOKING VALUES (" + BookId + "," + CustId+ ","+ EventId+ "," + CampReq +")";
  System.out.println(DbQuery);
  try 
  {
   Class.forName("org.h2.Driver");
   connection = DriverManager
     .getConnection("jdbc:h2:~/FFest", "SA", "");
   statement = connection.createStatement();
   statement.executeUpdate(DbQuery);
  } catch (Exception e) 
  {
   e.printStackTrace();
  } finally 
  {
   try 
   {
    statement.close();
    connection.close();
   } catch (Exception e) 
   {
    e.printStackTrace();
   }
  }
 }
}