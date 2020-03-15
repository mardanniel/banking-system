package BANK_SYS;

import javax.swing.*;
import java.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.border.EmptyBorder;

public class AccountInfo_Sys {
    private final JFrame account;
    private final JPanel accountPanel;
    private final JLabel accountFN;
    private final JLabel accountLN;
    private final JLabel accountBD;
    private final JLabel accountUID;
    private final JLabel accountBalance;
    private final JButton backButton;
    private final String UserIDcopy;
    File openFile;
    Scanner scanFile;
    String UName;
    String ULName;
    String MM;
    String DD;
    String YYYY;
    int UserBalance;
    
    public AccountInfo_Sys (String UserID) throws ParseException, FileNotFoundException
    {
        // Instantiations
        UserIDcopy = UserID;
        openFile = new File("BANKDB\\"+UserIDcopy+"-info.txt");
        scanFile = new Scanner(openFile);
        UName = scanFile.nextLine();
        ULName = scanFile.nextLine();
        MM = scanFile.nextLine();
        DD = scanFile.nextLine();
        YYYY = scanFile.nextLine();
        UserBalance = scanFile.nextInt();
        account = new JFrame("User Account Information | Current User: "+UserIDcopy);
        accountPanel = new JPanel();
        
        accountUID = new JLabel("User Account ID: "+UserID);
        accountFN = new JLabel("First Name: "+UName); 
        accountLN = new JLabel("Last Name: "+ULName);
        accountBD = new JLabel("Birth Date: "+MM+" "+DD+" "+YYYY+" ");
        accountBalance = new JLabel("Current Balance: P"+UserBalance);
        backButton = new JButton("Back");
        
         // Components Properties

        accountFN.setFont(new Font("Century Gothic",Font.BOLD,20));
        accountFN.setBounds(20, 85, 250, 20);
        accountFN.setForeground(Color.white);
         
        accountLN.setFont(new Font("Century Gothic",Font.BOLD,20));
        accountLN.setBounds(20, 145, 250, 20);
        accountLN.setForeground(Color.white);
        
        accountBD.setFont(new Font("Century Gothic",Font.BOLD,20));
        accountBD.setBounds(20, 205, 250, 20);
        accountBD.setForeground(Color.white);
        
        accountUID.setFont(new Font("Century Gothic",Font.BOLD,20));
        accountUID.setBounds(20, 265, 300, 20);
        accountUID.setForeground(Color.white);
        
        accountBalance.setFont(new Font("Century Gothic",Font.BOLD,20));
        accountBalance.setBounds(20, 315, 250, 20);
        accountBalance.setForeground(Color.white);
        
        backButton.setBounds(200, 460, 90, 50);
        
        //Details in the JPanel
        accountPanel.setBackground(new Color(114, 142, 149));
        accountPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        accountPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        accountPanel.add(accountUID, gbc);
        accountPanel.add(accountFN, gbc);
        accountPanel.add(accountLN, gbc);
        accountPanel.add(accountBD, gbc);
        accountPanel.add(accountBalance, gbc);
        accountPanel.add(backButton, gbc);
        
        account.getContentPane().setBackground(new Color(114, 142, 149));
        account.add(accountPanel);
        account.setVisible(true);
        account.setSize(500, 600);
        account.setResizable(false);
        account.setLocationRelativeTo(null);
        account.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        backButton.addActionListener(new backButtonListener());
        scanFile.close();
    }
    
    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            MainMenu_Sys goback = new MainMenu_Sys(UserIDcopy);
            account.dispose();
        }
    }
    
    // FOR INDIVIDUAL TESTING OF FRAMES
    public static void main(String args[]) throws ParseException, FileNotFoundException{
        AccountInfo_Sys test = new AccountInfo_Sys("199997180");
    }
}