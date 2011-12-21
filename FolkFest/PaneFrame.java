package org.hanarki;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class PaneFrame extends JFrame
{
//Setup up GUID
  
  h2dbInsTest DbIns = new h2dbInsTest();
        String BookingInfo;
        int CampReq;
        JLabel BookLbl;
        JLabel CustNumber;
        JLabel EventID;
        JTextField BookID, CustomerID,EventChID;
        JCheckBox CampingInput;
        JButton MakeBooking;
        JTextArea BookingDetails;
        JComboBox EventChoice;
        JComboBox StageChoice;
        String[] EventNames = {"Tull","Mue","Shatter Candy"};

        //Booking Variables

       String custname,BookingNo,EventNo;

public PaneFrame()
 {
  super ("FolkFest Booking System V0.1");

     JTabbedPane MainFrame = new JTabbedPane();

       

  // /labels and panel for first tab

        BookingInfo = "Booking info with appear here!";
  
        BookLbl = new JLabel("Booking Number");
        BookID = new JTextField(20);         //TODO look at panels to arrange components

        CustNumber= new JLabel("  Customer Number");
        CustomerID = new JTextField(20);

        EventID= new  JLabel("         Event ID");
        EventChID = new JTextField(20);

        CampingInput = new JCheckBox("Camping Required ?                                     ");

        MakeBooking = new JButton("Enter Details");

        BookingDetails = new JTextArea(BookingInfo);

//TODO code for pulling values in from widgets       
// need to learn how to debug
        
  JPanel panel1 = new JPanel();
  panel1.add (BookLbl);
        panel1.add(BookID);
        panel1.add (CustNumber);
        panel1.add(CustomerID);
        panel1.add (EventID);
        panel1.add(EventChID);
        panel1.add(CampingInput);
        panel1.add(MakeBooking);
        panel1.add(BookingDetails);
  
  MainFrame.addTab("Booking", null, panel1, "Make a booking here");
  
/*
 * second pane crap
 * /
*/
  JLabel label2 = new JLabel("Events", SwingConstants.CENTER);
  JPanel panel2 = new JPanel();
  JComboBox EventChoice = new JComboBox(EventNames); //adding event names from prepared string
  EventChoice.setMaximumRowCount(3);
  //combo box using addItem
  JComboBox StageChoice = new JComboBox();
  StageChoice.addItem("Main");
  StageChoice.addItem("Cube");
  StageChoice.addItem("Bacup");
  panel2.setBackground(Color.YELLOW);
  panel2.add (label2);
  panel2.add (EventChoice);
  panel2.add (StageChoice);


        MainFrame.addTab("Event", null, panel2, "Event Management Panel");

        JLabel label3 = new JLabel("Customer", SwingConstants.CENTER);
  JPanel panel3 = new JPanel();
  panel3.setBackground(Color.GRAY);
  panel3.add (label3);

        MainFrame.addTab("Customer", null, panel3, "Customer Management Panel");

        JLabel label4 = new JLabel("Reports", SwingConstants.CENTER);
  JPanel panel4 = new JPanel();
  panel4.setBackground(Color.BLUE);
  panel4.add (label4);
//TODO add a JTable to return reports 
        MainFrame.addTab("Reports", null, panel4, "Reports Panel");
  add(MainFrame); //add pane to frame

  //Database links and queries
     ButtonHandler handler = new ButtonHandler();
     
//     CheckBoxHandler handler = new CheckBoxHandler();
// TODO checkbox handler code
    MakeBooking.addActionListener(handler);
    }

  
// TODO check this work beacuse it is crap

/*
  
 
 class CheckBoxHandler implements ItemListener
 {
    private int CampReq;
  public void itemStateChanged(ItemEvent event) //method to check for boxes being selected
  {
   
   if (CampingInput.isSelected())
   CampReq = 1;
       
      }
 }*/
class ButtonHandler implements ActionListener
 {
  
  private String displayText;
  public void actionPerformed(ActionEvent event)
  {
      
   if (event.getSource()== MakeBooking)  // checks if fetch button has been clicked
   {
  //TODO code required for wring to db via h2InsTest - tesring simple at the moment
     custname=CustomerID.getText();
     BookingNo= BookID.getText();
     EventNo=EventChID.getText();

     CreateBooking newBooking = new CreateBooking();

     newBooking.setBooking(BookingNo,custname,EventNo,"1");
     displayText = BookingNo+ "can't be arsed";  // set id field to one to indicate first record
   }
   //TODO pulling back data
   BookingDetails.setText(displayText); // set text area in main window
  }
 }
}
