package BANK_SYS;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.text.ParseException;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainMenu_Sys {
    private final JFrame mainM;
    private final JPanel mainMPanel;
    private final JLabel mainMIntro;
    private final JButton mainMWithdraw;
    private final JButton mainMDeposit;
    private final JButton mainMAccount;
    private final JButton mainMLogout;
    private final JButton mainMAuditlog;
    private final String UserIDcopy;
    
    public MainMenu_Sys (String UserID)
    {
        // Instantiations 
        
        UserIDcopy = UserID;
        mainM = new JFrame("Banking System Main Menu | Current User: "+UserIDcopy);
        mainMPanel = new JPanel();
        
        mainMIntro = new JLabel("Welcome, "+UserID);
        mainMWithdraw = new JButton("Cash Withdrawal");
        mainMDeposit = new JButton("Cash Deposit");
        mainMAccount = new JButton("Account Information");
        mainMLogout = new JButton("Log Out");
        mainMAuditlog = new JButton("Audit Log - Soon!");
        
        // Components Properties 
        
        mainMIntro.setFont(new Font("Coolvetica",Font.BOLD,40));
        mainMIntro.setForeground(Color.white);
        
        mainMPanel.setBackground(new Color(114, 142, 149));
        mainMPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        mainMPanel.setLayout(new GridBagLayout());
        
        mainMWithdraw.setFont(new Font("Coolvetica",Font.BOLD,20));
        mainMWithdraw.setOpaque(true);
        mainMDeposit.setFont(new Font("Coolvetica",Font.BOLD,20));
        mainMAccount.setFont(new Font("Coolvetica",Font.BOLD,20));
        mainMLogout.setFont(new Font("Coolvetica",Font.BOLD,20));
        mainMAuditlog.setFont(new Font("Coolvetica",Font.BOLD,20));
        mainMAuditlog.setEnabled(false);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        mainMPanel.add(mainMIntro, gbc);
        mainMPanel.add(mainMWithdraw, gbc);
        mainMPanel.add(mainMDeposit, gbc);
        mainMPanel.add(mainMAccount, gbc);
        mainMPanel.add(mainMLogout, gbc);
        mainMPanel.add(mainMAuditlog, gbc);
        
        mainM.getContentPane().setBackground(new Color(114, 142, 149));
        mainM.add(mainMPanel);
        mainM.setVisible(true);
        mainM.setSize(600, 800);
        mainM.setResizable(false);
        mainM.setLocationRelativeTo(null);
        mainM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainMWithdraw.addActionListener(new withdrawListener());
        mainMDeposit.addActionListener(new depositListener());
        mainMAccount.addActionListener(new accountListener());
        mainMLogout.addActionListener(new logoutListener());
    }
    
    class withdrawListener implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e){
            try {
                Withdraw_Sys newUser = new Withdraw_Sys(UserIDcopy);
                mainM.dispose();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainMenu_Sys.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(MainMenu_Sys.class.getName()).log(Level.SEVERE, null, ex);
            }
            mainM.dispose();            
        }
    }
    
    class depositListener implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e){
            try {
                Deposit_Sys newUser = new Deposit_Sys(UserIDcopy);
                mainM.dispose();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainMenu_Sys.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(MainMenu_Sys.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class accountListener implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e){
            try {
                AccountInfo_Sys openUser = new AccountInfo_Sys(UserIDcopy);
                mainM.dispose();
            } catch (ParseException ex) {
                Logger.getLogger(MainMenu_Sys.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainMenu_Sys.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class logoutListener implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e){
            try {
                Login_Sys newUser = new Login_Sys();
                mainM.dispose();
            } catch (ParseException ex) {
                Logger.getLogger(MainMenu_Sys.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // FOR INDIVIDUAL TESTING OF FRAMES
    public static void main(String args[]){
        MainMenu_Sys test = new MainMenu_Sys("duqyewquehuqw");
    }
}
