package BANK_SYS;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class Deposit_Sys {
    private final JFrame dp;
    private final JPanel dpPanel;
    private final JLabel dpUName;
    private JLabel dpUBalance;
    private final JLabel dpLbl;
    private final JTextField dpDep;
    private final JButton dpDepButt;
    private final JButton dpGoBackMM;
    private final String UserIDcopy;
    private final String UserBal;
    File openFile;
    Scanner scanFile;
    String UName;
    String ULName;
    String MM;
    String DD;
    String YYYY;
    int UserBalance;
    
    public Deposit_Sys (String UserID) throws FileNotFoundException, ParseException
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
        
        dp = new JFrame("Banking System Deposit | Current User: "+UserIDcopy);
        dpPanel = new JPanel();
        
        UserBal = "";
        dpUName = new JLabel("User: "+UName);
        dpUBalance = new JLabel("Balance: P" + UserBalance);
        dpLbl = new JLabel("Enter Amount: ");
        dpDep = new JTextField(1);
        dpDepButt = new JButton("Deposit");
        dpGoBackMM = new JButton("Go Back to Main Menu");
        
        // Components Properties 
        
        dpUName.setFont(new Font("Coolvetica",Font.BOLD,40));
        dpUName.setForeground(Color.white);
        
        dpPanel.setBackground(new Color(114, 142, 149));
        dpPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        dpPanel.setLayout(new GridBagLayout());
        
        dpUBalance.setFont(new Font("Coolvetica",Font.BOLD,20));
        dpUBalance.setForeground(Color.white);
        
        dpLbl.setFont(new Font("Coolvetica",Font.BOLD,20));
        dpLbl.setForeground(Color.white);
        
        dpDep.setFont(new Font("Coolvetica",Font.BOLD,20));
        
        dpDepButt.setFont(new Font("Coolvetica",Font.BOLD,20));
        
        dpGoBackMM.setFont(new Font("Coolvetica",Font.BOLD,20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        dpPanel.add(dpUName, gbc);
        dpPanel.add(dpUBalance, gbc);
        dpPanel.add(dpLbl, gbc);
        dpPanel.add(dpDep, gbc);
        dpPanel.add(dpDepButt, gbc);
        dpPanel.add(dpGoBackMM, gbc);
        
        dp.getContentPane().setBackground(new Color(114, 142, 149));
        dp.add(dpPanel);
        dp.setVisible(true);
        dp.setSize(600, 500);
        dp.setResizable(false);
        dp.setLocationRelativeTo(null);
        dp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        dpDepButt.addActionListener(new withdrawButtListener());
        dpGoBackMM.addActionListener(new backButtonListener());
        scanFile.close();
    }
    
    class withdrawButtListener implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e){
                try {
                    PrintWriter clearData = new PrintWriter(openFile);
                    clearData.print("");
                    clearData.close();
                    
                    FileWriter printNewData = new FileWriter(openFile);
                    int newBalance = UserBalance + parseInt(dpDep.getText());
                    
                    printNewData.write(UName+"\n");
                    printNewData.write(ULName+"\n");
                    printNewData.write(MM+"\n");
                    printNewData.write(DD+"\n");
                    printNewData.write(YYYY+"\n");
                    printNewData.write(newBalance+"\n");
                    
                    dp.dispose();
                    JOptionPane.showMessageDialog(null, "Deposit Completed!");
                    printNewData.close();
                    scanFile.close();
                    Deposit_Sys update = new Deposit_Sys(UserIDcopy); 
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Withdraw_Sys.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                Logger.getLogger(Withdraw_Sys.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Deposit_Sys.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            MainMenu_Sys goback = new MainMenu_Sys(UserIDcopy);
        }
    }
    
    class balancefocusListener implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
    // FOR INDIVIDUAL TESTING OF FRAMES
    public static void main(String args[]) throws FileNotFoundException, ParseException{
        Deposit_Sys test = new Deposit_Sys("199997180");
    }    
}
