//generic Select Booking Class
//TODO clean up to make usefull

package org.hanarki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectBooking  {
 

  Connection connection = null;
  ResultSet resultSet = null;
  Statement statement = null;
  
  String DbQuery = "";
  int custNumber;

  public String DbQueryMth()
    {
 
  DbQuery = "SELECT * FROM BOOKING WHERE CUSTID = " + custNumber;
    
  try {
   Class.forName("org.h2.Driver");
   connection = DriverManager
     .getConnection("jdbc:h2:~/FFest", "SA", "");
   statement = connection.createStatement();
   resultSet = statement
     .executeQuery(DbQuery);
   while (resultSet.next()) {
    System.out.println("Test booking:"
      + resultSet.getString("BOOKID") + " Cust Id " + resultSet.getString("CUSTID"));
         }
  } catch (Exception e) {
   e.printStackTrace();
  } finally {
   try {
    resultSet.close();
    statement.close();
    connection.close();
   } catch (Exception e) {
    e.printStackTrace();
   }
  }
  return(DbQuery); //TODO just returns DbQuery Majke it do something usefull
 }
}