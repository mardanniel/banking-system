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

public class Withdraw_Sys {
    private final JFrame wd;
    private final JPanel wdPanel;
    private final JLabel wdUName;
    private final JLabel wdUBalance;
    private final JLabel wdLbl;
    private final JTextField wdDep;
    private final JButton wdDepButt;
    private final JButton wdGoBackMM;
    private final String UserIDcopy;
    File openFile;
    Scanner scanFile;
    String UName;
    String ULName;
    String MM;
    String DD;
    String YYYY;
    int UserBalance;
    
    public Withdraw_Sys (String UserID) throws FileNotFoundException, ParseException
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
        
        wd = new JFrame("Banking System Withdraw | Current User: "+UserIDcopy);
        wdPanel = new JPanel();
        
        wdUName = new JLabel("User: "+UName);
        wdUBalance = new JLabel("Balance: P" + UserBalance);
        wdLbl = new JLabel("Enter Amount: ");
        wdDep = new JTextField(1);
        wdDepButt = new JButton("Withdraw");
        wdGoBackMM = new JButton("Go Back to Main Menu");
        
        // Components Properties 
        
        wdUName.setFont(new Font("Coolvetica",Font.BOLD,40));
        wdUName.setForeground(Color.white);
        
        wdPanel.setBackground(new Color(114, 142, 149));
        wdPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        wdPanel.setLayout(new GridBagLayout());
        
        wdUBalance.setFont(new Font("Coolvetica",Font.BOLD,20));
        wdUBalance.setForeground(Color.white);
        
        wdLbl.setFont(new Font("Coolvetica",Font.BOLD,20));
        wdLbl.setForeground(Color.white);
        
        wdDep.setFont(new Font("Coolvetica",Font.BOLD,20));
        
        wdDepButt.setFont(new Font("Coolvetica",Font.BOLD,20));
        
        wdGoBackMM.setFont(new Font("Coolvetica",Font.BOLD,20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        wdPanel.add(wdUName, gbc);
        wdPanel.add(wdUBalance, gbc);
        wdPanel.add(wdLbl, gbc);
        wdPanel.add(wdDep, gbc);
        wdPanel.add(wdDepButt, gbc);
        wdPanel.add(wdGoBackMM, gbc);
        
        wd.getContentPane().setBackground(new Color(114, 142, 149));
        wd.add(wdPanel);
        wd.setVisible(true);
        wd.setSize(600, 500);
        wd.setResizable(false);
        wd.setLocationRelativeTo(null);
        wd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        wdDepButt.addActionListener(new withdrawButtListener());
        wdGoBackMM.addActionListener(new backButtonListener());
        scanFile.close();
    }
    
    class withdrawButtListener implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e){
            if (UserBalance - parseInt(wdDep.getText()) < 500){
                JOptionPane.showMessageDialog(null, "Minimum Account Balance should go below P500!\n Try Again!");
            }
            else {
                try {
                    PrintWriter clearData = new PrintWriter(openFile);
                    clearData.print("");
                    clearData.close();

                    FileWriter printNewData = new FileWriter(openFile);
                    int newBalance = UserBalance - parseInt(wdDep.getText());

                    printNewData.write(UName+"\n");
                    printNewData.write(ULName+"\n");
                    printNewData.write(MM+"\n");
                    printNewData.write(DD+"\n");
                    printNewData.write(YYYY+"\n");
                    printNewData.write(newBalance+"\n");

                    wd.dispose();
                    JOptionPane.showMessageDialog(null, "Withdraw Completed!");
                    printNewData.close();
                    scanFile.close();
                    Withdraw_Sys update = new Withdraw_Sys(UserIDcopy);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Withdraw_Sys.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Withdraw_Sys.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Withdraw_Sys.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            MainMenu_Sys goback = new MainMenu_Sys(UserIDcopy);
        }
    }
    
    // FOR INDIVIDUAL TESTING OF FRAMES
    public static void main(String args[]) throws FileNotFoundException, ParseException{
        Withdraw_Sys test = new Withdraw_Sys("199997180");
    }    
}
