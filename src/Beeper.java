import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class Beeper extends JFrame {
   private JButton button;
   private JPanel panel;
   private static JLabel label;
   private JButton button1;
   public static int beppeCounter = 0;


   Beeper() {
	   
      button = new JButton("Click Me");
      panel = new JPanel();
      panel.add(button);
      add(panel);
      label = new JLabel();
      label.setText("number of beeps "+ beppeCounter);
      panel.add(label);
      button1 = new JButton("No click me instead!");
      panel.add(button1);
      button1.addActionListener(new BeppeEraseListener());
      panel.setBackground(Color.yellow);
      button.addActionListener(new BeppeListener());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
   }
   
   public static void incBeppeCounter(){
	   
	   beppeCounter = beppeCounter+1;
	   label.setText("number of beeps "+ beppeCounter);
	   System.out.println("beppe");
	   
   }
   public static void eraseBeppeCounter(){
	   
	   beppeCounter = 0;
	   label.setText("number of beeps "+ beppeCounter);
	   System.out.println("beppe no");
	   
   }

   public static void main(String[] args) {
      Beeper beppe = new Beeper();
      beppe.setTitle("Hello World");
      beppe.setBounds(200, 200, (int)((Math.random()*200)+100), 200);
      //beppe.getContentPane().setBackground(new Color(200,200,30,0));
      beppe.setVisible(true);
   }
}

class BeppeListener implements ActionListener {
   public void actionPerformed(ActionEvent e) {
      Toolkit.getDefaultToolkit().beep();
      
      //Beeper.beppeCounter=  Beeper.beppeCounter++;
      Beeper.incBeppeCounter();
   }
}
class BeppeEraseListener implements ActionListener {
	   public void actionPerformed(ActionEvent e) {
	      //Toolkit.getDefaultToolkit().beep();
	      //incBeppeCounter();
		  Beeper.eraseBeppeCounter();
	   }
	}
