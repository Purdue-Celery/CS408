import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelJudgeCreateEval extends JPanel implements ActionListener {
	FrameMain f = null;
	JComboBox roundCombo = null;
	JTextField typeField = new JTextField();
	JTextField weightField = new JTextField();
	JTextField deadlineField = new JTextField();

	JLabel roundLabel = new JLabel("Round");
	JLabel typeLabel = new JLabel("Evaluation Type");
	JLabel weightLabel = new JLabel("Percent Weight");
	JLabel deadlineLabel = new JLabel("Deadline");

	JButton submitButton = new JButton("Submit");
	JButton backButton = new JButton("Go back");

	public PanelJudgeCreateEval(FrameMain frameMain) {
		f = frameMain;
		setSize(FrameMain.WIDTH, FrameMain.HEIGHT);
		this.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(roundLabel, c);

		c.gridx = 0;
		c.gridy = 1;
		this.add(typeLabel, c);

		c.gridx = 1;
		c.gridy = 1;
		this.add(typeField, c);

		c.gridx = 0;
		c.gridy = 2;
		this.add(weightLabel, c);

		c.gridx = 1;
		c.gridy = 2;
		this.add(weightField, c);

		c.gridx = 0;
		c.gridy = 3;
		this.add(deadlineLabel, c);

		c.gridx = 1;
		c.gridy = 3;
		this.add(deadlineField, c);

		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		c.weightx = 0.5;
		c.fill = GridBagConstraints.NONE;
		submitButton.setBackground(new Color(197, 179, 88));
		this.add(submitButton, c);
		submitButton.addActionListener(this);

		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		c.weightx = 0.5;
		backButton.setBackground(new Color(197, 179, 88));
		this.add(backButton, c);
		backButton.addActionListener(this);
	}

	public void updateComboBox() {
		String[] data = f.getMyQueryManager().getRoundListFromJudgeID(f.getJudgeID());
		String[] data_new = new String[data.length + 1];
		data_new[0] = "";
		for (int i = 1; i < data_new.length; i++) {
			data_new[i] = data[i - 1];
		}
		roundCombo = new JComboBox(data_new);
		roundCombo.addActionListener(this);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(roundCombo, c);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			this.f.getPanelJudgeMenu().setVisible(true);
			this.setVisible(false);
			this.remove(roundCombo);
			/***************************************************/
//			this.typeField.setText("");
//			this.weightField.setText("");
//			this.deadlineField.setText("");
			/***************************************************/
		} else if (e.getSource() == submitButton) {
			if (roundCombo.getSelectedIndex() != 0) {
				this.f.getMyQueryManager().createEvaluation(
						roundCombo.getSelectedItem().toString(), typeField.getText(),
						Integer.valueOf(weightField.getText()),
						Date.valueOf(deadlineField.getText()));
				this.f.getMyQueryManager().printResultTable("Select * from Evaluation");
				this.f.getPanelJudgeMenu().setVisible(true);
				this.setVisible(false);
				this.remove(roundCombo);
				/***************************************************/
//				this.typeField.setText("");
//				this.weightField.setText("");
//				this.deadlineField.setText("");
				/***************************************************/
			} else
				System.out.println("You must select a round!");
		}
	}
}
