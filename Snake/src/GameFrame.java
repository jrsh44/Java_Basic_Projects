import javax.swing.JFrame;

public class GameFrame extends JFrame{


	GameFrame(){
		this.add(new GamePanel());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("SssssNAKE");
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}
