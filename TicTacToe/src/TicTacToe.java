import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener{

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean playerXTurn;
	
	TicTacToe(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,600);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(00,197,50));
		textField.setFont(new Font("Consalis",Font.BOLD,75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("TIC TAC TOE");
		textField.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0,0,500,100);
		titlePanel.add(textField);
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBounds(0,100,500,500);
//		buttonPanel.setBackground(new Color(150,150,150));
		
		for(int i =0; i<9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("Consalis",Font.BOLD,50));
			buttons[i].setFocusable(false);
			buttons[i].setForeground(new Color(0x00cc44));
			buttons[i].addActionListener(this);
			buttons[i].setEnabled(false);
		}
		
		frame.add(buttonPanel);
		frame.add(titlePanel,BorderLayout.NORTH);
		frame.setVisible(true);
		
		firstTurn();
	}
	
	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
			for(int i=0; i<9; i++) {
				buttons[i].setEnabled(true);

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			playerXTurn = true;
			textField.setText("X turn");
		}else {
			playerXTurn = false;
			textField.setText("0 turn");
		}
		
	}
	
	public void check() {
		boolean win = false;
		int[] combination = new int[3];
		for(int i=0; i<3; i++) {
			if(buttons[i*3].getText().equals(buttons[i*3+1].getText()) && buttons[i*3].getText().equals(buttons[i*3+2].getText()) && !buttons[i*3].getText().equals("")) {
				win = true;
				combination[0] = i*3;
				combination[1] = i*3+1;
				combination[2] = i*3+2;				
				break;
			}else if(buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText()) && !buttons[i].getText().equals("")) {
				win = true;
				combination[0] = i;
				combination[1] = i+3;
				combination[2] = i+6;
				break;
			}
		}
		if(!win) {
			if(buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[4].getText().equals("")) {
				win = true;
				combination[0] = 0;
				combination[1] = 4;
				combination[2] = 8;
			}else if(buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[4].getText().equals("")) {
				combination[0] = 2;
				combination[1] = 4;
				combination[2] = 6;
				win = true;
			}
		}
		
		if(win) {
			if(playerXTurn) {
				System.out.println("X Won");
				xWins(combination);
			} else {
				System.out.println("0 Won");
				oWins(combination);
			}
		}
	}
	
	public void xWins(int[] combo) {
		for(int i=0; i<3; i++) {
			buttons[combo[i]].setBackground(Color.green);
		}
		
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("X WINS");
	}
	
	public void oWins(int[] combo) {
		for(int i=0; i<3; i++) {
			buttons[combo[i]].setBackground(Color.green);
		}
		
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("0 WINS");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<9; i++) {
			if(e.getSource()==buttons[i]) {
					if(playerXTurn) {
						if(buttons[i].getText().equals("")) {
							buttons[i].setText("X");
							buttons[i].setForeground(new Color(0x0044cc));
							textField.setText("0 turn");
							check();
							playerXTurn = false;
						}
					}else {
						if(buttons[i].getText().equals("")) {
							buttons[i].setText("0");
							buttons[i].setForeground(new Color(0xcc4400));		
							textField.setText("X turn");
							check();
							playerXTurn = true;
						}
					}
				}
			}
		}
}