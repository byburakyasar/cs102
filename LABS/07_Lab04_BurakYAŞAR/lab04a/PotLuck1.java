/* 
 * Author: Ege Darcin 
 * Lab04a
 * Version 1.1
 */

//importing required methods
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PotLuck1 extends JFrame implements ActionListener {
  
  private JPanel contentPane;
  private JPanel panel;
  
  //Main method
  public static void main(String[] args) { 
    
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        PotLuck1 frame = new PotLuck1();
        frame.setVisible(true);
        
      }
    });
  }
  
  //building label, button, row, column
  
  JLabel    label;
  JButton   but;
  JButton   b1But;
  JButton   b2But;
  int       prize = 0;
  int       bomb1 = 0;
  int       bomb2 = 0;
  int       count;
  JButton   restart;
  final int ROW = 5;
  final int COLUMN = 5;

  
  
  //Constructor
  public PotLuck1() {
    
    //setMethod 
    setTitle("Find secret treasure");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 500, 500);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(ROW, ROW, COLUMN, COLUMN));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);
    
    //addMethod panel
    
    panel = new JPanel();
    contentPane.add(panel, BorderLayout.CENTER);
    panel.setLayout(new GridLayout(ROW, COLUMN, ROW*2, COLUMN*2));
    
    
    //trycounter, button builder
    count = 0;
    while (prize == bomb1 ||  prize == bomb2 ||bomb1 == bomb2){
      prize = (int)(Math.random()*(ROW*COLUMN));
      bomb1 = (int)(Math.random()*(ROW*COLUMN));
      bomb2 = (int)(Math.random()*(ROW*COLUMN));
    }
    System.out.println(prize);
    System.out.println(bomb1);
    System.out.println(bomb2);
    
    for(int i = 0; i < (ROW*COLUMN); i++){
      if(prize == i){
        but = new JButton();
        but.addActionListener(this);
        panel.add(but);
      }
      else if  (bomb1 ==i ){
        b1But = new JButton();
        b1But.addActionListener(this);
        panel.add(b1But);
      }
      else if  (bomb2 ==i ){
        b2But = new JButton();
        b2But.addActionListener(this);
        panel.add(b2But);
      }
      else{
        JButton temp = new JButton();
        panel.add(temp);
        temp.addActionListener(this);
      }
    }
    
    //Finished label
    label = new JLabel("YOU CLICKED "+count+" times\r\n");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    contentPane.add(label, BorderLayout.NORTH);
  }
  
  //Action Performed method, 
  public void actionPerformed( ActionEvent e)
  {
    if ( e.getSource() != but && e.getSource() != b1But && e.getSource() != b2But){
      count ++;
      ((JButton) e.getSource()).setEnabled(false);
      label.setText("YOU CLICKED "+count+" times");
    }
    
    else if ( e.getSource() == but){ 
      label.setText("You got it in " + (count + 1) + " attempts!" );
      for(int i = 0; i < (ROW*COLUMN); i++){
        if(panel.getComponent(i) != but){
          ((JButton) panel.getComponent(i)).setEnabled(false);   
           
        }
      }
    }
    else {
      label.setText("Sorry! You are blown up at attempt " + (count + 1));
      for(int i = 0; i < (ROW*COLUMN); i++){
        if(panel.getComponent(i) != but || panel.getComponent(i) != b1But || panel.getComponent(i) != b2But){
          ((JButton) panel.getComponent(i)).setEnabled(false);   

        }
      }
    }
  }
}