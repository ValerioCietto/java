

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class Subscribers extends JFrame implements ActionListener, ChangeListener, ItemListener{
	
private DefaultListModel<String> subscribers;
private JList<String> list;
protected JTextField textField;
protected JTextArea textArea;
protected String title;
protected String mr = "Mr";
protected String mrs = "Mrs";
protected String ms = "Ms";
protected String dr = "Dr";
protected int	age;
private final static String newline = "\n";
static final int AGE_MIN = 18;
static final int AGE_MAX = 120;
static final int AGE_INIT = 50;
protected JCheckBox goldButton;
protected boolean gold = true;
protected String	cognome;
	
public Subscribers(){
	super( "Subscribers" );
	
	
//pannello titolo (radio buttons)-------------------------------------------------------

	JPanel titlePanel = new JPanel(  );
	JLabel titleDummy = new JLabel("mr/mrs/ms/dr");
	titlePanel.add(titleDummy);
	//[modificare]
	
	JRadioButton birdButton = new JRadioButton(mr);
    birdButton.setMnemonic(KeyEvent.VK_1);
    birdButton.setActionCommand(mr);
    birdButton.setSelected(true);

    JRadioButton catButton = new JRadioButton(mrs);
    catButton.setMnemonic(KeyEvent.VK_2);
    catButton.setActionCommand(mrs);

    JRadioButton dogButton = new JRadioButton(ms);
    dogButton.setMnemonic(KeyEvent.VK_3);
    dogButton.setActionCommand(ms);

    JRadioButton rabbitButton = new JRadioButton(dr);
    rabbitButton.setMnemonic(KeyEvent.VK_4);
    rabbitButton.setActionCommand(dr);

   

    //Group the radio buttons.
    ButtonGroup group = new ButtonGroup();
    group.add(birdButton);
    group.add(catButton);
    group.add(dogButton);
    group.add(rabbitButton);
    

    //Register a listener for the radio buttons.
    birdButton.addActionListener(this);
    catButton.addActionListener(this);
    dogButton.addActionListener(this);
    rabbitButton.addActionListener(this);
    
    JPanel radioPanel = new JPanel();//new GridLayout(0, 1)
    radioPanel.add(birdButton);
    radioPanel.add(catButton);
    radioPanel.add(dogButton);
    radioPanel.add(rabbitButton);
    
    
    titlePanel.add(radioPanel);



//pannello nome (label + textarea)-------------------------------------------------------

	JPanel namePanel = new JPanel();
	JLabel nameDummy = new JLabel("cognome");
	namePanel.add(nameDummy);
	//[modificare]
	textField = new JTextField(20);
    textField.addActionListener(this);
    namePanel.add(textField);



//pannello età (slider)-------------------------------------------------------

	JPanel agePanel = new JPanel();
	JLabel ageDummy = new JLabel("eta\'");
	agePanel.add(ageDummy);
	//[modificare]
	JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL,
            AGE_MIN, AGE_MAX, AGE_INIT);
	framesPerSecond.addChangeListener((ChangeListener) this);

	//Turn on labels at major tick marks.
	framesPerSecond.setMajorTickSpacing(25);
	framesPerSecond.setMinorTickSpacing(5);
	framesPerSecond.setPaintTicks(true);
	framesPerSecond.setPaintLabels(true);
	framesPerSecond.addChangeListener(this);
	agePanel.add(framesPerSecond);



//pannello gold account (check)-------------------------------------------------------

	JPanel goldPanel = new JPanel();
	JLabel goldDummy = new JLabel("gold account?");
	goldPanel.add(goldDummy);
	//[modificare]
	goldButton = new JCheckBox("Gold");
    goldButton.setMnemonic(KeyEvent.VK_G);
    goldButton.setSelected(true);
    goldButton.addItemListener(this);
    goldPanel.add(goldButton);
	


//pannello bottoni-------------------------------------------------------
	  
	// create JButton for adding subscribers
	JButton addButton = new JButton( "Subscribe user" );
	addButton.addActionListener(
		new ActionListener() {
			

			public void actionPerformed( ActionEvent event ){
				// prompt user for new name
				String isGold = "";
				String user = "";

				// gather data from GUI
				
				if(gold){
					isGold = "gold account";
				}
				user = title + " " + cognome + ", " + age + ", " + isGold ;
				//[modificare]

				// add new user to model
				subscribers.addElement( user );
			}
		}
	);
		
	// create JButton for removing selected user
	JButton removeButton = new JButton( "Unsubscribe Selected user" );
	removeButton.addActionListener(
		new ActionListener() {
			public void actionPerformed( ActionEvent event ){
				// remove selected user from model
				subscribers.removeElement(list.getSelectedValue() );
			}
		}
	);
		
	// lay out GUI components
	JPanel inputPanel = new JPanel();
	inputPanel.add( addButton );
	inputPanel.add( removeButton );


//pannello JList-------------------------------------------------------

	// create a DefaultListModel to store subscribers
	subscribers = new DefaultListModel<String>();
	subscribers.addElement( "Dr Walter White, 52, gold account" );
	subscribers.addElement( "Mr Jesse Pinkman, 26" );
	subscribers.addElement( "Mrs Lydia Rodarte-Quayle, 35" );
	subscribers.addElement( "Mr Hank Schrader, 43" );
	subscribers.addElement( "Mr Saul Goodman, 47" );
	subscribers.addElement( "Mr Gustavo Fring, 53, gold account" );

	// create a JList for subscribers DefaultListModel
	list = new JList<String>( subscribers );
	// allow user to select only one name at a time
	list.setSelectionMode(
	ListSelectionModel.SINGLE_SELECTION );
	JScrollPane listScrollPane = new JScrollPane(list);
	listScrollPane.setPreferredSize(new Dimension(200, 200));

//main layout-------------------------------------------------------

	JPanel sub1 = new JPanel(); sub1.setLayout(new GridLayout(5,1));
	JPanel sub2 = new JPanel(); sub2.setLayout(new GridLayout(1,1));
	add(sub1, BorderLayout.CENTER); add(sub2, BorderLayout.SOUTH);

	sub1.add(titlePanel);
	sub1.add(namePanel);
	sub1.add(agePanel);
	sub1.add(goldPanel);
	sub1.add(inputPanel);
	sub2.add(listScrollPane);

	setDefaultCloseOperation( EXIT_ON_CLOSE );
	pack();
	setVisible( true );
} // end Ex constructor
 
    public void actionPerformed(ActionEvent e) {
    	Object source = e.getSource();
    	//System.out.println(e.getSource().toString().substring(12,22));
    	if(e.getSource().toString().substring(12,22).compareTo("JTextField")==0){
    		//System.out.println(true);
    		System.out.println(textField.getText());
    		cognome = textField.getText();
    	}
    	else{
    		title = e.getActionCommand();
    		System.out.println(title);
    		String text = textField.getText();
    	}
    	
    	
    	
    }
    
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            age = (int)source.getValue();
            System.out.println(age);
            
        }
    }
   @Override
   public void itemStateChanged(ItemEvent e) {
	   
       Object source = e.getItemSelectable();

       //if (source == goldButton) {
    	   
           if (e.getStateChange() == ItemEvent.DESELECTED) {
        	   gold = false;
        	   System.out.println("gold = no");
           }else{
        	   gold = true;
        	   System.out.println("gold = yes");
           }
           
       //}
       
	
   }
// execute application
public static void main( String args[] ){
	new Subscribers();
}



}