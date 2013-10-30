import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 

public class CalculatorGUI implements ActionListener { 

  private Calculator c = new Calculator (); 

  private JFrame frame = new JFrame ("Calculator"); 
  private JPanel[] panels = new JPanel [6]; 
  private JTextField textField = new JTextField(); 
  private JButton resetButton = new JButton(" C "); 
  private JButton[] numberButtons = new JButton[10]; 
  private JButton divideButton = new JButton ("/"); 
  private JButton multiplyButton = new JButton ("*"); 
  private JButton subtractButton = new JButton ("-"); 
  private JButton plusMinusButton = new JButton ("+/-"); 
  private JButton dotButton = new JButton (" . "); 
  private JButton addButton = new JButton ("+"); 
  private JButton equateButton = new JButton (" = "); 
  private JButton sqrtButton = new JButton ("sqrt"); 

  public void buildGUI () { 

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    JPanel contentPane = (JPanel) frame.getContentPane(); 

    // initialize panels 
    for (int i = 0; i < panels.length; i++) { 
      panels[i] = new JPanel (); 
    } 

    // initialize button 0-9 
    for (int i = 0; i < numberButtons.length; i++) { 
      numberButtons[i] = new JButton (" " + i + " "); 
      numberButtons[i].setActionCommand (String.valueOf(i)); 
      numberButtons[i].addActionListener (this); 
    } 

    // default layout = BorderLayout.CENTER 
    textField.setColumns(20); 
    textField.setText ("0"); 
    textField.setHorizontalAlignment (JTextField.RIGHT); 
    panels[0].add (textField); 

    // layout = FlowLayout.RIGHT 
    panels[1].setLayout (new FlowLayout (FlowLayout.RIGHT)); 
    panels[1].add (resetButton); 
    resetButton.setActionCommand ("RESET"); 
    resetButton.addActionListener (this); 

    // layout = FlowLayout.LEFT 
    panels[2].setLayout (new FlowLayout (FlowLayout.LEFT)); 
    panels[2].add (numberButtons[7]); 
    panels[2].add (numberButtons[8]); 
    panels[2].add (numberButtons[9]); 
    panels[2].add (divideButton); 
    panels[2].add (sqrtButton); 
    divideButton.setActionCommand ("DIVIDE"); 
    divideButton.addActionListener (this); 
    sqrtButton.setActionCommand ("SQRT"); 
    sqrtButton.addActionListener (this); 

    // layout = FlowLayout.LEFT 
    panels[3].setLayout (new FlowLayout (FlowLayout.LEFT)); 
    panels[3].add (numberButtons[4]); 
    panels[3].add (numberButtons[5]); 
    panels[3].add (numberButtons[6]); 
    panels[3].add (multiplyButton); 
    multiplyButton.setActionCommand ("MULTIPLY"); 
    multiplyButton.addActionListener (this); 

    // layout = FlowLayout.LEFT 
    panels[4].setLayout (new FlowLayout (FlowLayout.LEFT)); 
    panels[4].add (numberButtons[1]); 
    panels[4].add (numberButtons[2]); 
    panels[4].add (numberButtons[3]); 
    panels[4].add (subtractButton); 
    subtractButton.setActionCommand ("SUBTRACT"); 
    subtractButton.addActionListener (this); 

    // layout = FlowLayout.LEFT 
    panels[5].setLayout (new FlowLayout (FlowLayout.LEFT)); 
    panels[5].add (numberButtons[0]); 
    panels[5].add (plusMinusButton); 
    panels[5].add (dotButton); 
    panels[5].add (addButton); 
    panels[5].add (equateButton); 
    plusMinusButton.setActionCommand ("PLUSMINUS"); 
    plusMinusButton.addActionListener (this); 
    dotButton.setActionCommand ("DOT"); 
    dotButton.addActionListener (this); 
    addButton.setActionCommand ("ADD"); 
    addButton.addActionListener (this); 
    equateButton.setActionCommand ("EQUATE"); 
    equateButton.addActionListener (this); 

    contentPane.setLayout (new BoxLayout (contentPane, BoxLayout.Y_AXIS)); 
    for (JPanel jPanel : panels) { 
      contentPane.add (jPanel); 
    } 

    frame.pack (); 
    frame.setVisible (true); 
  } 

  public void actionPerformed (ActionEvent e) { 
    String actionCommand = e.getActionCommand(); 
    if (actionCommand == null || actionCommand.trim().length() <= 0) { 
      return; 
    } 

    int number = -1; 
    try { 
      number = Integer.parseInt (actionCommand); 
    } catch (NumberFormatException e1) { 
    } 

    if (number >= 0) { 
      // this is a number 
      textField.setText ("" + (c.number (number))); 
    } else { 
      // this is not a number 
      if (actionCommand.equals ("RESET")) { 
        textField.setText ("" + (c.reset())); 
      } else if (actionCommand.equals ("DIVIDE")) { 
        textField.setText ("" + (c.divide())); 
      } else if (actionCommand.equals ("SQRT")) { 
        textField.setText ("" + (c.sqrt())); 
      } else if (actionCommand.equals ("MULTIPLY")) { 
        textField.setText ("" + (c.multiply())); 
      } else if (actionCommand.equals ("SUBTRACT")) { 
        textField.setText ("" + (c.subtract())); 
      } else if (actionCommand.equals ("PLUSMINUS")) { 
        textField.setText ("" + (c.plusMinus())); 
      } else if (actionCommand.equals ("DOT")) { 
        textField.setText ("" + (c.dot())); 
      } else if (actionCommand.equals ("ADD")) { 
        textField.setText ("" + (c.add())); 
      } else if (actionCommand.equals ("EQUATE")) { 
        textField.setText ("" + (c.equate())); 
      } 
    } 
  } 

  public static void main(String[] args) { 
    CalculatorGUI gui = new CalculatorGUI(); 
    gui.buildGUI (); 
  } 
}
