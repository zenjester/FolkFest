/**
 * use java -cp .:h2-1.2.143.jar h2dbTest to connect
 * this is the insert version
 */
package org.hanarki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class h2dbInsTest {
 public static void main(String[] args) {

  Connection connection = null;
  ResultSet resultSet = null;
  Statement statement = null;
  String DbQuery = "";
  
  int bookId = 5;
  int custId = 163;
  int eventId= 2;
  int campreq = 1;

  DbQuery = "INSERT INTO BOOKING VALUES (" + bookId + "," + custId+ ","+ eventId+ "," + campreq +")";
  System.out.println(DbQuery);
  try {
   Class.forName("org.h2.Driver");
   connection = DriverManager
     .getConnection("jdbc:h2:~/FFest", "SA", "");
   statement = connection.createStatement();
   statement.executeUpdate(DbQuery);
  } catch (Exception e) {
   e.printStackTrace();
  } finally {
   try {
    statement.close();
    connection.close();
   } catch (Exception e) {
    e.printStackTrace();
   }
  }
 }
}

