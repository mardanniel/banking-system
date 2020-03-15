package BANK_SYS;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Login_Sys {
    private final JFrame login;
    private final JPanel loginPanel;
    private final JLabel loginACID;
    private final JLabel loginPW;
    private final MaskFormatter loginAccIDF;
    private final JFormattedTextField loginAccID;
    private final JPasswordField loginPassword;
    private final JButton loginButton;
    private final JButton registerButton;
    
    public Login_Sys () throws ParseException
    {
        // Instantiations  
        
        login = new JFrame("Banking System Login");                                 
        loginPanel = new JPanel();

        loginACID = new JLabel("Enter Account ID: "); 
        loginPW = new JLabel("Enter Password: ");  

        loginAccIDF = new MaskFormatter("#########");
        loginAccID = new JFormattedTextField(loginAccIDF);                                  
        loginPassword = new JPasswordField(1); 
                       
        loginButton = new JButton("Login");                           
        registerButton = new JButton("No Account? Register now!");
        
        // Components Properties

        loginACID.setFont(new Font("Century Gothic",Font.BOLD,20));
        loginACID.setBounds(20, 85, 250, 20);
        loginACID.setForeground(Color.white);
        
        loginAccID.setBounds(200, 80, 250, 40);
        loginAccID.setForeground(new Color(114, 142, 149));
        loginAccID.setBackground(Color.white);
        loginAccID.setHorizontalAlignment(JTextField.CENTER);
              
        loginPW.setFont(new Font("Century Gothic",Font.BOLD,20));
        loginPW.setBounds(20, 155, 250, 20);
        loginPW.setForeground(Color.white);
        
        loginPassword.setBounds(200, 150, 250, 40);
        loginPassword.setForeground(new Color(114, 142, 149));
        loginPassword.setBackground(Color.white);
        loginPassword.setHorizontalAlignment(JPasswordField.CENTER);
        
        loginButton.setBounds(200, 225, 90, 50);
        
        registerButton.setBounds(150, 300, 200, 30);
        
        loginPanel.setBackground(new Color(114, 142, 149));
        loginPanel.setLayout(null);
        loginPanel.add(loginACID);
        loginPanel.add(loginAccID);
        loginPanel.add(loginPW);
        loginPanel.add(loginPassword);
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);
        
        login.getContentPane().setBackground(new Color(114, 142, 149));
        login.add(loginPanel);
        login.setVisible(true);
        login.setSize(500, 400);
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        
        loginButton.addActionListener(new loginButtonListener());
        registerButton.addActionListener(new registerButtonListener());
    }
    
    class loginButtonListener implements ActionListener{ 
        @Override
        public void actionPerformed(ActionEvent e){
            if(loginAccID.getText().equals("")){
                JOptionPane.showMessageDialog(null, "No Input on\nID Field / Password Field!");
            }
            else{
                File readFile = new File("BANKDB\\"+"\\"+loginAccID.getText()+".txt");
                try {
                    String DBPass= "";  
                    Scanner fileScanner = new Scanner(readFile);
                    while(fileScanner.hasNext()){
                        DBPass = fileScanner.nextLine();
                    }
                    if (loginPassword.getText().equals(DBPass)){
                        JOptionPane.showMessageDialog(null, "Login Confirmed!");
                        MainMenu_Sys userAccess = new MainMenu_Sys(loginAccID.getText());
                        login.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Username OR Password Incorrect!");
                        fileScanner.close();
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Login_Sys.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "No Records Detected");
                }
            }  
        }
    }
    
    class registerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                Register_Sys userRegister = new Register_Sys();
                login.dispose();
            } catch (ParseException ex) {
                Logger.getLogger(Login_Sys.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // FOR INDIVIDUAL TESTING OF FRAMES
    public static void main(String args[]) throws ParseException{
        Login_Sys newUser = new Login_Sys();
    }
}
