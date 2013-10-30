import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


class PuzzleFrame extends JFrame{  

	private int size;
	private PuzzleButton emptyButton;//lo 'spazio vuoto'

	public PuzzleFrame(int board_size){  
		size = board_size;
		setLayout(new GridLayout(size, size));

//TODO: inserire bottoni in griglia

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PuzzleFrame");
		setSize(size * 50 + 10,  size * 50 + 20);
		setVisible(true);
   }


//********************************


class PuzzleButton extends JButton implements ActionListener{ //2a_TO DO: implementare un'interfaccia -listener  
	private int row, column;

	public PuzzleButton(int r, int c, int val){  
		row = r;
		column = c;
		if (val>0){
			setBackground(Color.white);
       		setText("" + val);
       	}
       	else{
			setBackground(Color.black);
			setText("");
       	}

        addActionListener(this);
	}


	private boolean adjacent(PuzzleButton b){
//1_TO DO: return true if bottoni adiacenti
		return false;
	}


	public void actionPerformed(){ 
		//2b_TO DO: inserire l'evento come parametro
		//3_TO DO: controllare se la sorgente è adiacente all'empty button e modificare i bottoni di conseguenza
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}//end of class PuzzleButton


}//end of class PuzzleFrame


//********************************


class Puzzle15{ 
	
	public static void main(String[] args){ 
  		int size = 4;
    	PuzzleFrame frame = new PuzzleFrame(size);
	}
}//end of class Puzzle

