import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("D&D Toolbox - Made by Antonio Juric :D");
		frame.setSize(new Dimension(500, 100));
		frame.setLayout(new GridLayout(1, 2, 5, 5));
		
		JButton diceRoller = new JButton("Open new Dice Roller");
		diceRoller.addActionListener((event) -> new DiceRoller());
		frame.add(diceRoller);
		
		JButton characterRoller = new JButton("Open new Character? (WIP)");
		characterRoller.addActionListener((event) -> System.out.println(java.time.LocalDateTime.now().toString().replaceAll("[\\D]", "")));
		frame.add(characterRoller);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
