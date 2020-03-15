package BANK_SYS;

import javax.swing.*;
import java.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.Random;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Register_Sys {
    private final JFrame register;
    private final JPanel registerPanel;
    private final JLabel regFN;
    private final JLabel regLN;
    private final JLabel regBD;
    private final JLabel regUN;
    private final JLabel regUP;
    private final JLabel regInitD;
    private final JTextField regFName;
    private final JTextField regLName;
    private final JComboBox regBdayMM;
    private final JComboBox regBdayDD;
    private final JComboBox regBdayYY;
    private final JTextField regUName;
    private final JPasswordField regUPass;
    private final JTextField regInitDep;
    private final JButton loginButton;
    private final JButton registerButton;

    public Register_Sys () throws ParseException
    {
        // Instantiations

        register = new JFrame("Banking System Register");
        registerPanel = new JPanel();

        regFN = new JLabel("Enter First Name: ");
        regLN = new JLabel("Enter Last Name: ");
        regBD = new JLabel("Enter Birth date: ");
        regUN = new JLabel("Enter Username: ");
        regUP = new JLabel("Enter Password: ");
        regInitD = new JLabel("Enter Initial Deposit: ");
        
        regFName = new JTextField(1);
        regLName = new JTextField(1);
        
        String MM[] = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
        String DD[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
            "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
            "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String YY[] = {"1900","1901","1902","1903","1904","1905","1906","1907",
            "1908","1909","1910","1911","1912","1913","1914","1915","1916",
            "1917","1918","1919","1920","1921","1922","1923","1924","1925",
            "1926","1927","1928","1929","1930","1931","1932","1933","1934",
            "1935","1936","1937","1938","1939","1940","1941","1942","1943",
            "1944","1945","1946","1947","1948","1949","1950","1951","1952",
            "1954","1955","1956","1957","1958","1959","1960","1961","1962",
            "1963","1964","1965","1966","1967","1968","1969","1970","1971",
            "1972","1973","1974","1975","1976","1977","1978","1979","1980",
            "1981","1982","1983","1984","1985","1986","1987","1988","1989",
            "1990","1991","1992","1993","1994","1995","1996","1997","1998",
            "1999","2000","2001","2002","2003","2004","2005","2006","2007",
            "2008","2009","2010","2011","2012","2013","2014","2015","2016",
            "2017","2018","2019"};
        
        regBdayMM = new JComboBox(MM);
        regBdayDD = new JComboBox(DD);
        regBdayYY = new JComboBox(YY);
        regUName = new JTextField(1);
        regUPass = new JPasswordField(1);
        regInitDep = new JTextField(1);
        loginButton = new JButton("Already have an account? Go Login!");
        registerButton = new JButton("Register");

        // Components Properties

        regFN.setFont(new Font("Century Gothic",Font.BOLD,20));
        regFN.setBounds(20, 85, 250, 20);
        regFN.setForeground(Color.white);
         
        regLN.setFont(new Font("Century Gothic",Font.BOLD,20));
        regLN.setBounds(20, 145, 250, 20);
        regLN.setForeground(Color.white);
        
        regBD.setFont(new Font("Century Gothic",Font.BOLD,20));
        regBD.setBounds(20, 205, 250, 20);
        regBD.setForeground(Color.white);
        
        regUN.setFont(new Font("Century Gothic",Font.BOLD,20));
        regUN.setBounds(20, 265, 250, 20);
        regUN.setForeground(Color.white);        
        
        regUP.setFont(new Font("Century Gothic",Font.BOLD,20));   
        regUP.setBounds(20, 325, 250, 20);
        regUP.setForeground(Color.white);  
        
        regInitD.setFont(new Font("Century Gothic",Font.BOLD,19));   
        regInitD.setBounds(20, 390, 250, 20);
        regInitD.setForeground(Color.white);
        
        regFName.setBounds(200, 80, 250, 40);
        regFName.setForeground(new Color(114, 142, 149));
        regFName.setBackground(Color.white);
        regFName.setHorizontalAlignment(JTextField.CENTER);
        regFName.setFont(new Font("Century Gothic",Font.BOLD,20));
        
        regLName.setBounds(200, 140, 250, 40);
        regLName.setForeground(new Color(114, 142, 149));
        regLName.setBackground(Color.white);
        regLName.setHorizontalAlignment(JTextField.CENTER);
        regLName.setFont(new Font("Century Gothic",Font.BOLD,20));
        
        regBdayMM.setFont(new Font("Century Gothic",Font.BOLD,15));
        regBdayMM.setBounds(200, 205, 100, 40);
        
        regBdayDD.setFont(new Font("Century Gothic",Font.BOLD,15));
        regBdayDD.setBounds(310, 205, 50, 40);
        
        regBdayYY.setFont(new Font("Century Gothic",Font.BOLD,15));
        regBdayYY.setBounds(370, 205, 80, 40);
        
        regUName.setBounds(200, 260, 250, 40);
        regUName.setForeground(new Color(114, 142, 149));
        regUName.setBackground(Color.white);
        regUName.setHorizontalAlignment(JTextField.CENTER);
        regUName.setFont(new Font("Century Gothic",Font.BOLD,20));
        
        regUPass.setBounds(200, 320, 250, 40);
        regUPass.setForeground(new Color(114, 142, 149));
        regUPass.setBackground(Color.white);
        regUPass.setHorizontalAlignment(JPasswordField.CENTER);
        regUPass.setFont(new Font("Century Gothic",Font.BOLD,20));  
        
        regInitDep.setBounds(200, 380, 250, 40);
        regInitDep.setForeground(new Color(114, 142, 149));
        regInitDep.setBackground(Color.white);
        regInitDep.setHorizontalAlignment(JPasswordField.CENTER);
        regInitDep.setFont(new Font("Century Gothic",Font.BOLD,20));
        
        registerButton.setBounds(200, 610, 90, 50);
        
        loginButton.setBounds(120, 685, 250, 30);
        
        registerPanel.setBackground(new Color(114, 142, 149));
        registerPanel.setLayout(null);
        registerPanel.add(regFN);
        registerPanel.add(regLN);
        registerPanel.add(regBD);
        registerPanel.add(regUP);
        registerPanel.add(regInitD);
        registerPanel.add(regFName);
        registerPanel.add(regLName);
        registerPanel.add(regBdayMM);
        registerPanel.add(regBdayDD);
        registerPanel.add(regBdayYY);
        registerPanel.add(regUPass);
        registerPanel.add(regInitDep);
        registerPanel.add(loginButton);
        registerPanel.add(registerButton);
        
        register.getContentPane().setBackground(new Color(114, 142, 149));
        register.add(registerPanel);
        register.setVisible(true);
        register.setExtendedState(JFrame.MAXIMIZED_BOTH);
        register.setSize(500, 800);
        register.setResizable(false);
        register.setLocationRelativeTo(null);
        register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Components Listeners
        
        registerButton.addActionListener(new registerButtonListener());
    }
    
    public String IDRandomizer (){
        Random genRand = new Random();
        String constantIDPrim = regBdayYY.getSelectedItem().toString();
        String constructedSecID = "";
        String constructedID = "";
        
        for (int i=0; i < 5; i++){
            constructedSecID += Integer.toString(genRand.nextInt((9-0)+1)+0);
        }
        
        constructedID = constantIDPrim+constructedSecID;
        
        return constructedID;
    }
    
    class registerButtonListener implements ActionListener {
               
       @Override  
       public void actionPerformed(ActionEvent e){
           PrintWriter printData1 = null;
           PrintWriter printData2 = null;
           String catchNewId = "";
           if(parseInt(regInitDep.getText()) < 5000){
                JOptionPane.showMessageDialog(null, "Initial Deposit should be greater than P5000!\nTry Again!");
           }
           else {
               try {
               catchNewId = IDRandomizer();
               File createFile1 = new File("BANKDB\\"+catchNewId+".txt");
               File createFile2 = new File("BANKDB\\"+catchNewId+"-info.txt");
               
               printData1 = new PrintWriter(createFile1);
               printData2 = new PrintWriter(createFile2);
               
               printData1.println(regUPass.getPassword());
               
               printData2.println((String) regFName.getText());
               printData2.println((String) regLName.getText());
               printData2.println((String) regBdayMM.getSelectedItem());
               printData2.println((String) regBdayDD.getSelectedItem());
               printData2.println((String) regBdayYY.getSelectedItem());
               printData2.println((String) regInitDep.getText());
               
               
               JOptionPane.showMessageDialog(null, "Account Creation Complete!\nYour ID is: "+catchNewId);
               register.dispose();
               Login_Sys loginNow = new Login_Sys();
               } catch (FileNotFoundException ex) {
               Logger.getLogger(Register_Sys.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ParseException ex) {
               Logger.getLogger(Register_Sys.class.getName()).log(Level.SEVERE, null, ex);
               } 
               finally {
               printData1.close();
               printData2.close();
               }
           }
           
           
       }
    }
    
    // FOR INDIVIDUAL TESTING OF FRAMES
    public static void main(String args[]) throws ParseException{
        Register_Sys test = new Register_Sys();
    }
}