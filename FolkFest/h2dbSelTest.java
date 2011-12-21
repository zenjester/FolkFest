package org.hanarki;

/**
 * cinection to H2 with select statement
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author www.javaworkspace.com
 * 
 */
public class h2dbSelTest {
 public static void main(String[] args) {

  Connection connection = null;
  ResultSet resultSet = null;
  Statement statement = null;

  try {
   Class.forName("org.h2.Driver");
   connection = DriverManager
     .getConnection("jdbc:h2:~/FFest", "SA", "");
   statement = connection.createStatement();
   resultSet = statement
     .executeQuery("SELECT * FROM booking");
   while (resultSet.next()) {
    System.out.println("Booking ID:"
      + resultSet.getString("bookID") + " " + resultSet.getString("eventID"));
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
 }
}

