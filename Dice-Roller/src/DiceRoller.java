import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * @author Antonio Juric
 */
public class DiceRoller {
	
	private JTextField _numDice;
	private JTextField _numSides;
	private JLabel _results;
	private JLabel _resultsTotal;
	
	public DiceRoller() {
		JFrame frame = new JFrame();
		frame.setTitle("Dice Roller");
		frame.setSize(new Dimension(700, 400));
		
		JPanel panel1 = CreateDicePanel();
		
		frame.add(panel1, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private JPanel CreateDicePanel() {
		
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(5, 2, 20, 20));
		content.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JLabel numDice = new JLabel("Number of Dice to roll:");
		content.add(numDice);
		
		JTextField numDiceField = new JTextField();
		content.add(numDiceField);
		this._numDice = numDiceField;
		
		JLabel numSides = new JLabel("Number of Sides on Dice to be rolled:");
		content.add(numSides);
		
		JTextField numSidesField = new JTextField();
		content.add(numSidesField);
		this._numSides = numSidesField;
		
		JLabel results = new JLabel("Results:");
		content.add(results);
		
		JLabel resultsDice = new JLabel("");
		content.add(resultsDice);
		this._results = resultsDice;
		
		JLabel resultsTotal = new JLabel("Total of Results:");
		content.add(resultsTotal);
		
		JLabel resultsDiceTotal = new JLabel("");
		content.add(resultsDiceTotal);
		this._resultsTotal = resultsDiceTotal;
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new SubmitListener());
		content.add(submit);
		
		return content;
	}
	
	
	private class SubmitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (_numDice.getText().equals("") || _numSides.getText().equals("")) {
				return;
			}
			int numDice = Integer.parseInt(_numDice.getText());
			int numSides = Integer.parseInt(_numSides.getText());
			String results = "";
			int resultsTotal = 0;
			Random rand = new Random(Integer.parseInt(java.time.LocalTime.now().toString().replaceAll("[\\D]", "")));
			
			for (int i = 0; i < numDice; i++) {
				int randInt = rand.ints(1, 1, numSides + 1).sum();
				
				if (i == 0) {
					results += Integer.toString(randInt);
				} else {
					results += ", "+ Integer.toString(randInt);
				}
				resultsTotal += randInt;
			}
			
			_results.setText(results);
			_resultsTotal.setText(Integer.toString(resultsTotal));
			_numDice.setText("");
			_numSides.setText("");
		}
	}

}
