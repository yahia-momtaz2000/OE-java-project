/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.guiTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javase.oop.customers.Customer;
import javase.oop.customers.CustomerHandler;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class TestGUIManual  extends JFrame{
    private JPanel jPanelContent = new JPanel();
    private JLabel jLabelUserName = new JLabel("User Name");
    private JTextField jTextFieldUserName = new JTextField();
    private JButton jButtonUserName = new JButton("Read User Name");
    
    public TestGUIManual(){
        
         this.setVisible(true);
         this.setTitle("Welcome Frame");
         this.setBounds(0, 0, 700, 550);
         this.setLocationRelativeTo(null);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.add(jPanelContent);

         jPanelContent.setLayout(null);
       
         jPanelContent.add(jLabelUserName);
         jLabelUserName.setBounds(10, 10, 80, 40);
         
         jPanelContent.add(jTextFieldUserName);
         jTextFieldUserName.setBounds(90, 10, 120, 40);

        jPanelContent.add(jButtonUserName);
        jButtonUserName.setBounds(220, 10, 160, 40);
        jButtonUserName.addActionListener((e) -> x());

    } // end constructor
    
     private void x() {
               Customer customer = CustomerHandler.getCustomerById(100);
                jTextFieldUserName.setText( customer.getName() );
     }
            
    public static void main(String[] args) {
         TestGUIManual tgm = new TestGUIManual();
    }
    
}
