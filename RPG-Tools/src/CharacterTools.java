import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CharacterTools {

	public CharacterTools() {
		JFrame frame = new JFrame();
		frame.setTitle("Select A Character");
		frame.setSize(new Dimension(700, 700));
		
		JPanel panel1 = CharSelectPanel();
		
		frame.add(panel1, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private JPanel CharSelectPanel() {
		JPanel content = new JPanel();
		
		
		
		return content;
	}
	
}
