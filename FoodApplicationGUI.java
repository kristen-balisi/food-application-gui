/* Name: Kristen Balisi   341426344
 * Date: 27/02/2023
 * Program Description: This program is a GUI Food Application for Tim Hortons. 
 * It allows users to toggle between two frames using the order and back buttons. 
 * In the first frame, users may enter their details and choose food items from a menu. 
 * In the second frame, they can select delivery and payment options. After the user presses 
 * the save button or interacts with the checkboxes and radio buttons, the program updates 
 * corresponding labels on the current panel with the user's entered or selected data.
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class FoodApplicationGUI extends JPanel implements ActionListener {
  // first frame - user details and order information
  JLabel timHortonsLabel = new JLabel ("Tim Hortons");
  JFrame userInputFrame = new JFrame("Tim Hortons Online Ordering - User Details and Order Information");
  
  // user details - labels and text fields
  JLabel nameLabel = new JLabel("Full Name: ");
  JTextField nameText = new JTextField(100);
  JLabel addressLabel = new JLabel("Address: ");
  JTextField addressText = new JTextField(100);
  JLabel phoneNumberLabel = new JLabel("Phone Number: ");
  JTextField phoneNumberText = new JTextField(100);
  JLabel emailLabel = new JLabel("Email: ");
  JTextField emailText = new JTextField(100);
  
  // order information
  JLabel menuItemLabel = new JLabel("Menu Item: ");
  JLabel quantityLabel = new JLabel("Quantity: ");
  JLabel priceLabel = new JLabel("Price: ");
  JLabel foodSelectionLabel = new JLabel("Status: ");

  // menu food items - check boxes
  JCheckBox donutCheckBox = new JCheckBox("Donut");
  JCheckBox timbitCheckBox = new JCheckBox("Timbit");
  JCheckBox croissantCheckBox = new JCheckBox("Croissant");
  JCheckBox bagelCheckBox = new JCheckBox("Bagel");
  
  // food quantity - list items
  String[] donutQuantity = {"0","1","2","3","4","5","6","7","8","9","10"};
  JList<String> donutList = new JList<String>(donutQuantity);
  String[] timbitQuantity = {"0","1","2","3","4","5","6","7","8","9","10"};
  JList<String> timbitList = new JList<String>(timbitQuantity);
  String[] croissantQuantity = {"0","1","2","3","4","5","6","7","8","9","10"};
  JList<String> croissantList = new JList<String>(croissantQuantity);
  String[] bagelQuantity = {"0","1","2","3","4","5","6","7","8","9","10"};
  JList<String> bagelList = new JList<String>(bagelQuantity);
  
  // food prices - labels
  JLabel donutPriceLabel = new JLabel("$1.99");
  JLabel timbitPriceLabel = new JLabel("$1.49");
  JLabel croissantPriceLabel = new JLabel("$0.33");
  JLabel bagelPriceLabel = new JLabel("$1.99");
  
  // food selection status - labels
  JLabel donutSelectionLabel = new JLabel("Unselected");
  JLabel timbitSelectionLabel = new JLabel("Unselected");
  JLabel croissantSelectionLabel = new JLabel("Unselected");
  JLabel bagelSelectionLabel = new JLabel("Unselected");

  // featured food items - labels and images
  JLabel featuredItemsLabel = new JLabel("Featured Food Items: ");
  JLabel donutLabel = new JLabel("Assorted Donuts");
  JLabel timbitLabel = new JLabel("Assorted Timbits");
  JLabel croissantLabel = new JLabel("Croissants");
  JLabel bagelLabel = new JLabel("Bagels");
  
  ImageIcon donutImage = new ImageIcon("Donut.png");
  JLabel donutImageLabel = new JLabel(donutImage);
  ImageIcon timbitImage = new ImageIcon("Timbit.png");
  JLabel timbitImageLabel = new JLabel(timbitImage);
  ImageIcon croissantImage = new ImageIcon("Croissant.png");
  JLabel croissantImageLabel = new JLabel(croissantImage);
  ImageIcon bagelImage = new ImageIcon("Bagel.png");
  JLabel bagelImageLabel = new JLabel(bagelImage);
  
  // save and order - buttons
  JButton orderButton = new JButton("Order");
  JButton saveButton = new JButton("Save");

  // user details entered - label
  JLabel userDetailsLabel = new JLabel("User Details: ");
  
  
  // second frame - confirm order
  JLabel confirmOrderLabel = new JLabel ("Confirm Order");
  JFrame confirmOrderFrame = new JFrame("Tim Hortons Online Ordering - Confirm Order");
  
  // delivery speed types - radio buttons
  JLabel deliveryTypeLabel = new JLabel ("Delivery Type: ");
  JRadioButton standardDeliveryButton = new JRadioButton("Standard");
  JRadioButton expressDeliveryButton = new JRadioButton("Express");
  JRadioButton nextDayDeliveryButton = new JRadioButton("Next-day");
  
  // delivery and payment details entered - labels
  JLabel deliveryDetailsLabel = new JLabel("Delivery Details: ");
  JLabel paymentDetailsLabel = new JLabel("Payment Details: ");
  
  // payment types - radio buttons
  JLabel paymentTypeLabel = new JLabel ("Payment Type: ");
  JRadioButton creditCardButton = new JRadioButton("Credit Card");
  JRadioButton debitCardButton = new JRadioButton("Debit Card");
  JRadioButton paypalButton = new JRadioButton("PayPal");
  
  // thank you for ordering - image
  ImageIcon thankYouImage = new ImageIcon("ThankYou.jpg");
  JLabel thankYouImageLabel = new JLabel(thankYouImage);
  
  // save and back - buttons
  JButton backButton = new JButton("Back");
  JButton confirmSaveButton = new JButton("Save");

  // order status - label
  JLabel orderStatusLabel = new JLabel("Order Status: Your order is pending (press save to confirm).");
  
  public static void main(String[] args) {
    // create instance of FoodApplicationGUI class
    FoodApplicationGUI timHortons = new FoodApplicationGUI();
    timHortons.Interface();
  }

  public void Interface() {
    int frameWidth = 600;
    int frameHeight = 900;
    
    // user input - frame and panel
    userInputFrame.setSize(frameWidth,frameHeight);
    userInputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    userInputFrame.setIconImage(new ImageIcon("TimHortonsLogo.png").getImage());

    JPanel userInputPanel = new JPanel();
    userInputFrame.add(userInputPanel);
    
    placeComponents1(userInputPanel);
    userInputFrame.setVisible(true);
    
    // confirm order - frame and panel
    confirmOrderFrame.setSize(frameWidth,frameHeight);
    confirmOrderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    confirmOrderFrame.setIconImage(new ImageIcon("TimHortonsLogo.png").getImage());
    
    JPanel confirmOrderPanel = new JPanel();
    confirmOrderFrame.add(confirmOrderPanel);
    
    placeComponents2(confirmOrderPanel);
    
    if (userInputFrame.isShowing()) {
      confirmOrderFrame.setVisible(false);
    }
  }
   
  public void placeComponents1(JPanel userInputPanel) {
    // place components - first frame
    userInputPanel.setLayout(null);

    // Tim Hortons title - label
    timHortonsLabel.setBounds(250,20,80,20);
    userInputPanel.add(timHortonsLabel);
    
    // user details - labels
    nameLabel.setBounds(10,60,150,20);
    userInputPanel.add(nameLabel);
    addressLabel.setBounds(10,90,150,20);
    userInputPanel.add(addressLabel);
    phoneNumberLabel.setBounds(10,120,150,20);
    userInputPanel.add(phoneNumberLabel);
    emailLabel.setBounds(10,150,150,20);
    userInputPanel.add(emailLabel);
    
    // user details - text fields
    nameText.setBounds(200,60,150,20);
    userInputPanel.add(nameText);
    addressText.setBounds(200,90,150,20);
    userInputPanel.add(addressText);
    phoneNumberText.setBounds(200,120,150,20);
    userInputPanel.add(phoneNumberText);
    emailText.setBounds(200,150,150,20);
    userInputPanel.add(emailText); 
    
    // menu items - labels
    menuItemLabel.setBounds(10,190,200,20);
    userInputPanel.add(menuItemLabel);
    
    // menu items - check boxes
    donutCheckBox.setBounds(10,220,100,25);
    userInputPanel.add(donutCheckBox);
    donutCheckBox.addActionListener(this);
    timbitCheckBox.setBounds(10,250,100,25);
    userInputPanel.add(timbitCheckBox);
    timbitCheckBox.addActionListener(this);
    croissantCheckBox.setBounds(10,280,100,25);
    userInputPanel.add(croissantCheckBox);
    croissantCheckBox.addActionListener(this);
    bagelCheckBox.setBounds(10,310,100,25);
    userInputPanel.add(bagelCheckBox);
    bagelCheckBox.addActionListener(this);
    
    // food quantity - label and list items
    quantityLabel.setBounds(160,190,200,20);
    userInputPanel.add(quantityLabel);
    
    donutList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    donutList.setLayoutOrientation(JList.VERTICAL);
    userInputPanel.add(donutList);
    JScrollPane donutListScroller = new JScrollPane(donutList);
    donutListScroller.setBounds(160,220,125,20);
    userInputPanel.add(donutListScroller);
    
    timbitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    timbitList.setLayoutOrientation(JList.VERTICAL);
    userInputPanel.add(timbitList);
    JScrollPane timbitListScroller = new JScrollPane(timbitList);
    timbitListScroller.setBounds(160,250,125,20);
    userInputPanel.add(timbitListScroller);
    
    croissantList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    croissantList.setLayoutOrientation(JList.VERTICAL);
    userInputPanel.add(croissantList);
    JScrollPane croissantListScroller = new JScrollPane(croissantList);
    croissantListScroller.setBounds(160,280,125,20);
    userInputPanel.add(croissantListScroller);
    
    bagelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    bagelList.setLayoutOrientation(JList.VERTICAL);
    userInputPanel.add(bagelList);
    JScrollPane bagelListScroller = new JScrollPane(bagelList);
    bagelListScroller.setBounds(160,310,125,20);
    userInputPanel.add(bagelListScroller);
    
    // food prices - labels
    priceLabel.setBounds(350,190,200,20);
    userInputPanel.add(priceLabel);
    
    donutPriceLabel.setBounds(350,220,200,20);
    userInputPanel.add(donutPriceLabel);
    timbitPriceLabel.setBounds(350,250,200,20);
    userInputPanel.add(timbitPriceLabel);
    croissantPriceLabel.setBounds(350,280,200,20);
    userInputPanel.add(croissantPriceLabel);
    bagelPriceLabel.setBounds(350,310,200,20);
    userInputPanel.add(bagelPriceLabel);
    
    // food selection status - labels
    foodSelectionLabel.setBounds(460,190,200,20);
    userInputPanel.add(foodSelectionLabel);
    
    donutSelectionLabel.setBounds(460,220,200,20);
    userInputPanel.add(donutSelectionLabel);
    timbitSelectionLabel.setBounds(460,250,200,20);
    userInputPanel.add(timbitSelectionLabel);
    croissantSelectionLabel.setBounds(460,280,200,20);
    userInputPanel.add(croissantSelectionLabel);
    bagelSelectionLabel.setBounds(460,310,200,20);
    userInputPanel.add(bagelSelectionLabel);

    // featured items - labels and images
    featuredItemsLabel.setBounds(10,315,200,100);
    userInputPanel.add(featuredItemsLabel);
    
    donutImageLabel.setBounds(10,390,100,100);
    userInputPanel.add(donutImageLabel);
    donutLabel.setBounds(10,460,100,100);
    userInputPanel.add(donutLabel);
    timbitImageLabel.setBounds(10,530,100,100);
    userInputPanel.add(timbitImageLabel);
    timbitLabel.setBounds(10,600,100,100);
    userInputPanel.add(timbitLabel);
    croissantImageLabel.setBounds(200,390,100,100);
    userInputPanel.add(croissantImageLabel);
    croissantLabel.setBounds(210,460,100,100);
    userInputPanel.add(croissantLabel);
    bagelImageLabel.setBounds(200,530,100,100);
    userInputPanel.add(bagelImageLabel);
    bagelLabel.setBounds(210,600,100,100);
    userInputPanel.add(bagelLabel);
    
    // order - button
    orderButton.setBounds(490,710,80,25);
    userInputPanel.add(orderButton);
    orderButton.addActionListener(this);
     
    // save - button
    saveButton.setBounds(10,710,80,25);
    userInputPanel.add(saveButton);
    saveButton.addActionListener(this); 
    
    // user details entered - label
    userDetailsLabel.setBounds(10,760,800,20);
    userInputPanel.add(userDetailsLabel);
  }
  
  public void placeComponents2(JPanel confirmOrderPanel) {
    // place components - second frame
    confirmOrderPanel.setLayout(null);

    // confirm order - title
    confirmOrderLabel.setBounds(250,10,100,25);
    confirmOrderPanel.add(confirmOrderLabel);
    
    // delivery speeds buttons - action listeners
    standardDeliveryButton.addActionListener(this);
    expressDeliveryButton.addActionListener(this);
    nextDayDeliveryButton.addActionListener(this);
    
    // delivery type - button group
    ButtonGroup deliveryButtonGroup = new ButtonGroup();
    deliveryButtonGroup.add(standardDeliveryButton);
    deliveryButtonGroup.add(expressDeliveryButton);
    deliveryButtonGroup.add(nextDayDeliveryButton);
    
    // delivery type - labels and buttons
    deliveryTypeLabel.setBounds(10,60,150,20);
    confirmOrderPanel.add(deliveryTypeLabel);
    
    standardDeliveryButton.setBounds(10,90,150,20);
    confirmOrderPanel.add(standardDeliveryButton);
    expressDeliveryButton.setBounds(10,120,150,20);
    confirmOrderPanel.add(expressDeliveryButton);
    nextDayDeliveryButton.setBounds(10,150,150,20);
    confirmOrderPanel.add(nextDayDeliveryButton);
    
    // payment type buttons - action listeners
    creditCardButton.addActionListener(this);
    debitCardButton.addActionListener(this);
    paypalButton.addActionListener(this);
    
    // payment type - button group
    ButtonGroup paymentButtonGroup = new ButtonGroup();
    paymentButtonGroup.add(creditCardButton);
    paymentButtonGroup.add(debitCardButton);
    paymentButtonGroup.add(paypalButton);
    
    // payment type - labels and buttons
    paymentTypeLabel.setBounds(10,190,100,25);
    confirmOrderPanel.add(paymentTypeLabel);
    
    creditCardButton.setBounds(10,220,150,20);
    confirmOrderPanel.add(creditCardButton);
    debitCardButton.setBounds(10,250,150,20);
    confirmOrderPanel.add(debitCardButton);
    paypalButton.setBounds(10,280,150,20);
    confirmOrderPanel.add(paypalButton);
    
    // delivery and payment - display user selections
    deliveryDetailsLabel.setBounds(10,320,800,20);
    confirmOrderPanel.add(deliveryDetailsLabel);
    
    paymentDetailsLabel.setBounds(10,350,800,20);
    confirmOrderPanel.add(paymentDetailsLabel);
    
    // thank you - image
    thankYouImageLabel.setBounds(30,290,500,500);
    confirmOrderPanel.add(thankYouImageLabel);
    
    // back button
    backButton.setBounds(490,710,80,25);
    confirmOrderPanel.add(backButton);
    backButton.addActionListener(this);
    
    // confirm save
    confirmSaveButton.setBounds(10,710,80,25);
    confirmOrderPanel.add(confirmSaveButton);
    confirmSaveButton.addActionListener(this);
        
    // order status - label
    orderStatusLabel.setBounds(10,760,800,20);
    confirmOrderPanel.add(orderStatusLabel);
  }
  
  public void actionPerformed(ActionEvent e) {
    
    // user information frame - buttons
    if (e.getSource() == saveButton) {
      userDetailsLabel.setText("User Details: " + nameText.getText() + "; " + addressText.getText() + "; " + phoneNumberText.getText() + "; " + emailText.getText());
    } 
    if (e.getSource() == orderButton) {
      userInputFrame.setVisible(false);
      confirmOrderFrame.setVisible(true);
    } 
    
    // food menu items - checkboxes
    if (donutCheckBox.isSelected()) {
        donutSelectionLabel.setText("Selected");
    }
    else {
      donutSelectionLabel.setText("Unselected");
    }
    
    
    if (timbitCheckBox.isSelected()) {
        timbitSelectionLabel.setText("Selected");
    }
    else {
      timbitSelectionLabel.setText("Unselected");
    }
    
    if (croissantCheckBox.isSelected()) {
        croissantSelectionLabel.setText("Selected");
    }
    else {
      croissantSelectionLabel.setText("Unselected");
    }
    
    if (bagelCheckBox.isSelected()) {
        bagelSelectionLabel.setText("Selected");
    }
    else {
      bagelSelectionLabel.setText("Unselected");
    }
    
    // confirm order frame - buttons
    if (e.getSource() == confirmSaveButton) {
      orderStatusLabel.setText("Order Status: Saved.");
    }
    if (e.getSource() == backButton) {
      confirmOrderFrame.setVisible(false);
      userInputFrame.setVisible(true);
    }
    
    // delivery speed type - radio buttons
    if (standardDeliveryButton.isSelected()) {
      deliveryDetailsLabel.setText("Delivery Details: " + standardDeliveryButton.getText());
    }
    else if (expressDeliveryButton.isSelected()) {
      deliveryDetailsLabel.setText("Delivery Details: " + expressDeliveryButton.getText());
    }
    else if (nextDayDeliveryButton.isSelected()) {
      deliveryDetailsLabel.setText("Delivery Details: " + nextDayDeliveryButton.getText());
    }
    else {
      deliveryDetailsLabel.setText("Delivery Details: Select delivery method.");
    }
    
    // payment type - radio buttons
    if (creditCardButton.isSelected()) {
      paymentDetailsLabel.setText("Payment Details: " + creditCardButton.getText());
    }
    else if (debitCardButton.isSelected()) {
      paymentDetailsLabel.setText("Payment Details: " + debitCardButton.getText());
    }
    else if (paypalButton.isSelected()) {
      paymentDetailsLabel.setText("Payment Details: " + paypalButton.getText());
    }
    else {
      paymentDetailsLabel.setText("Payment Details: Select payment method.");
    }
    
  }
}