import java.awt.*;
import javax.swing.*;

public class Quiz{

	String[] questions = 	{
							"Which company created Java?",
							"Which year was Java created?",
							"What was Java originally called?",
							};
	String[][] options = 	{
							{"Sun MicroSystem","Starbucks","Microsoft","Alphabet"},
							{"1989","1996","1972","1420"},
							{"Apple","Latte","Oak","Koffing"},
							};
	char[] answers = {
						'A',
						'B',
						'C',
						};
	
	char guess;
	int index;
	int correctGuesses =0;
	int totalQuestions = questions.length;
	int result;
	int seconds = 10;
	
	JFrame frame = new JFrame();
	JTextField textField = new JTextField();
	JTextArea textArea = new JTextArea();
	JButton buttonA = new JButton("A"), buttonB = new JButton("B"), buttonC = new JButton("C"), buttonD = new JButton("D");
	JLabel answerLabelA = new JLabel(),answerLabelB = new JLabel(),answerLabelC = new JLabel(),answerLabelD = new JLabel();
	JLabel timeLabel = new JLabel();
	JLabel secondsLeft = new JLabel();
	JTextField numberRight = new JTextField();
	JTextField percentage = new JTextField();
	
	Timer timer = new Timer(1000, (e)->{
		seconds--;
		secondsLeft.setText(String.valueOf(seconds));
		if(seconds==0) {
			displayAnswer();
			}
		});
	
	Quiz(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,650);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(0x2f2f2f));
		frame.setResizable(false);
		
		textField.setBounds(0,0,600,50);
		textField.setBackground(new Color(0x252525));
		textField.setForeground(new Color(0x00cc44));
		textField.setFont(new Font("Consolas",Font.BOLD,30));
		textField.setBorder(BorderFactory.createBevelBorder(1));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setEditable(false);
		
		textArea.setBounds(0,50,600,75);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(new Color(0x252525));
		textArea.setForeground(new Color(0x00cc44));
		textArea.setFont(new Font("Consolas",Font.BOLD,25));
		textArea.setBorder(BorderFactory.createBevelBorder(1));
		textArea.setEditable(false);
		
		
		// A ===========================================
		buttonA.setBounds(0,150,100,100);
		buttonA.setFocusable(false);
		buttonA.setBorder(BorderFactory.createBevelBorder(0));
		buttonA.setBackground(new Color(0x151515));
		buttonA.setForeground(new Color(0x00cc44));
		buttonA.setFont(new Font("Consolas",Font.BOLD,50));
		buttonA.addActionListener(
				(e)->{
					guess = 'A';
					displayAnswer();
				});
		answerLabelA.setBounds(100,150,500,100);
		answerLabelA.setBorder(BorderFactory.createBevelBorder(1));
		answerLabelA.setOpaque(true);
		answerLabelA.setBackground(new Color(0x252525));
		answerLabelA.setForeground(new Color(0x00cc44));
		answerLabelA.setFont(new Font("Consolas",Font.BOLD,30));
		//==============================================
		
		// B ===========================================
		buttonB.setBounds(0,250,100,100);
		buttonB.setFocusable(false);
		buttonB.setBorder(BorderFactory.createBevelBorder(0));
		buttonB.setBackground(new Color(0x151515));
		buttonB.setForeground(new Color(0x00cc44));
		buttonB.setFont(new Font("Consolas",Font.BOLD,50));
		buttonB.addActionListener(
				(e)->{
					guess = 'B';
					displayAnswer();
				});
		answerLabelB.setBounds(100,250,500,100);
		answerLabelB.setBorder(BorderFactory.createBevelBorder(1));
		answerLabelB.setOpaque(true);
		answerLabelB.setBackground(new Color(0x252525));
		answerLabelB.setForeground(new Color(0x00cc44));
		answerLabelB.setFont(new Font("Consolas",Font.BOLD,30));
		//==============================================
		
		// C ===========================================
		buttonC.setBounds(0,350,100,100);
		buttonC.setFocusable(false);
		buttonC.setBorder(BorderFactory.createBevelBorder(0));
		buttonC.setBackground(new Color(0x151515));
		buttonC.setForeground(new Color(0x00cc44));
		buttonC.setFont(new Font("Consolas",Font.BOLD,50));
		buttonC.addActionListener(
				(e)->{
					guess = 'C';
					displayAnswer();
				});
		answerLabelC.setBounds(100,350,500,100);
		answerLabelC.setBorder(BorderFactory.createBevelBorder(1));
		answerLabelC.setOpaque(true);
		answerLabelC.setBackground(new Color(0x252525));
		answerLabelC.setForeground(new Color(0x00cc44));
		answerLabelC.setFont(new Font("Consolas",Font.BOLD,30));
		//==============================================
		
		// D ===========================================
		buttonD.setBounds(0,450,100,100);
		buttonD.setFocusable(false);
		buttonD.setBorder(BorderFactory.createBevelBorder(0));
		buttonD.setBackground(new Color(0x151515));
		buttonD.setForeground(new Color(0x00cc44));
		buttonD.setFont(new Font("Consolas",Font.BOLD,50));
		buttonD.addActionListener(
				(e)->{
					guess = 'D';
					displayAnswer();
				});
		answerLabelD.setBounds(100,450,500,100);
		answerLabelD.setBorder(BorderFactory.createBevelBorder(1));
		answerLabelD.setOpaque(true);
		answerLabelD.setBackground(new Color(0x252525));
		answerLabelD.setForeground(new Color(0x00cc44));
		answerLabelD.setFont(new Font("Consolas",Font.BOLD,30));
		//==============================================
		
		secondsLeft.setBounds(490,550,100,60);
		secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
		secondsLeft.setOpaque(true);
		secondsLeft.setBackground(new Color(0x252525));
		secondsLeft.setForeground(new Color(0xcc0044));
		secondsLeft.setFont(new Font("Consolas",Font.BOLD,35));
		secondsLeft.setHorizontalAlignment(JTextField.CENTER);
		secondsLeft.setVerticalAlignment(JTextField.CENTER);
		secondsLeft.setText(String.valueOf(seconds));
		
		timeLabel.setBounds(340,550,150,60);
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setBackground(new Color(0x252525));
		timeLabel.setForeground(new Color(0xcc0044));
		timeLabel.setFont(new Font("Consolas",Font.BOLD,30));
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		timeLabel.setVerticalAlignment(JTextField.CENTER);
		timeLabel.setText("Timer: ");
		
		numberRight.setBounds(225,225,200,100);
		numberRight.setBorder(BorderFactory.createBevelBorder(1));
		numberRight.setOpaque(true);
		numberRight.setBackground(new Color(0x252525));
		numberRight.setForeground(new Color(0x00cc44));
		numberRight.setFont(new Font("Consolas",Font.BOLD,50));
		numberRight.setHorizontalAlignment(JTextField.CENTER);
		numberRight.setText("0");
		numberRight.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(0x252525));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setForeground(new Color(0x00cc44)); 
		percentage.setFont(new Font("Consolas",Font.BOLD,50));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setText("0");
		percentage.setEditable(false);
		
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(answerLabelA);
		frame.add(answerLabelB);
		frame.add(answerLabelC);
		frame.add(answerLabelD);
		frame.add(secondsLeft);
		frame.add(timeLabel);
		frame.add(textArea);
		frame.add(textField);
		frame.setVisible(true);
		
		nextQuestion();
	}
	
	public void nextQuestion() {
		
		if(index==totalQuestions) {
			results();
		}else {
			timer.start();
			textField.setText("Question "+(index+1));
			textArea.setText(questions[index]);
			answerLabelA.setText(options[index][0]);
			answerLabelB.setText(options[index][1]);
			answerLabelC.setText(options[index][2]);
			answerLabelD.setText(options[index][3]);	
		}
	}
	
	public void displayAnswer() {
		timer.stop();
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(guess==answers[index]) {
			correctGuesses++;
		}
		if(answers[index] != 'A') {
			answerLabelA.setForeground(new Color(0xcc4400));
		}
		if(answers[index] != 'B') {
			answerLabelB.setForeground(new Color(0xcc4400));
		}
		if(answers[index] != 'C') {
			answerLabelC.setForeground(new Color(0xcc4400));
		}
		if(answers[index] != 'D') {
			answerLabelD.setForeground(new Color(0xcc4400));
		}

		Timer pause = new Timer(2000, (e)->{
					answerLabelA.setForeground(new Color(0x00cc44));
					answerLabelB.setForeground(new Color(0x00cc44));
					answerLabelC.setForeground(new Color(0x00cc44));
					answerLabelD.setForeground(new Color(0x00cc44));
					guess=' ';
					seconds=10;
					secondsLeft.setText(String.valueOf(seconds));
					index++;
					buttonA.setEnabled(true);
					buttonB.setEnabled(true);
					buttonC.setEnabled(true);
					buttonD.setEnabled(true);
					nextQuestion();
					});
		pause.setRepeats(false);
		pause.start();
	}
	
	public void results() {
		buttonA.setVisible(false);
		buttonB.setVisible(false);
		buttonC.setVisible(false);
		buttonD.setVisible(false);
		
		result = (int) ((correctGuesses/(double)totalQuestions)*100);
		textField.setText("RESULTS!");
		textArea.setVisible(false);
		answerLabelA.setVisible(false);
		answerLabelB.setVisible(false);
		answerLabelC.setVisible(false);
		answerLabelD.setVisible(false);
		secondsLeft.setVisible(false);
		timeLabel.setVisible(false);
		
		numberRight.setText("("+correctGuesses+"/"+totalQuestions+")");
		percentage.setText(result+"%");


		frame.add(numberRight);
		frame.add(percentage);
	}
	
	
}
