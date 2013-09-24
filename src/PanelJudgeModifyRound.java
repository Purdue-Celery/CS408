import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelJudgeModifyRound extends JPanel implements ActionListener {
	FrameMain f = null;
	JLabel selectLabel = new JLabel("Select a round");
	JLabel nameLabel = new JLabel("Name");
	JLabel periodLabel = new JLabel("Season");
	JLabel yearLabel = new JLabel("Year");
	JLabel meetLabel = new JLabel("Time");
	JLabel roomLabel = new JLabel("Location");
	JButton submitButton = new JButton("Submit");
	JButton backButton = new JButton("Go back");

	JTextField nameField = new JTextField();
	JTextField periodField = new JTextField();
	JTextField yearField = new JTextField();
	JTextField meetField = new JTextField();
	JTextField roomField = new JTextField();

	JComboBox comboBox = null;

	public PanelJudgeModifyRound(FrameMain frameMain) {
		f = frameMain;
		setSize(FrameMain.WIDTH, FrameMain.HEIGHT);
		this.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(selectLabel, c);

		c.gridx = 0;
		c.gridy = 1;
		this.add(nameLabel, c);

		c.gridx = 1;
		c.gridy = 1;
		this.add(nameField, c);

		c.gridx = 0;
		c.gridy = 2;
		this.add(periodLabel, c);

		c.gridx = 1;
		c.gridy = 2;
		this.add(periodField, c);

		c.gridx = 0;
		c.gridy = 3;
		this.add(yearLabel, c);

		c.gridx = 1;
		c.gridy = 3;
		this.add(yearField, c);

		c.gridx = 0;
		c.gridy = 4;
		this.add(meetLabel, c);

		c.gridx = 1;
		c.gridy = 4;
		this.add(meetField, c);

		c.gridx = 0;
		c.gridy = 5;
		this.add(roomLabel, c);

		c.gridx = 1;
		c.gridy = 5;
		this.add(roomField, c);

		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 2;
		c.weightx = 0.5;
		c.fill = GridBagConstraints.NONE;
		this.add(submitButton, c);
		submitButton.addActionListener(this);

		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 2;
		c.weightx = 0.5;
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
		comboBox = new JComboBox(data_new);
		comboBox.addActionListener(this);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(comboBox, c);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == backButton) {
			this.f.getPanelJudgeMenu().setVisible(true);
			this.setVisible(false);
			this.remove(comboBox);
			nameField.setText("");
			periodField.setText("");
			yearField.setText("");
			meetField.setText("");
			roomField.setText("");
		} else if (e.getSource() == submitButton) {
//			if (comboBox.getSelectedIndex() != 0) {
				this.f.getMyQueryManager().modifyRound(comboBox.getSelectedItem().toString(), nameField.getText(),
						periodField.getText(), Integer.valueOf(yearField.getText()), meetField.getText(),
						roomField.getText());
				this.f.getMyQueryManager().printResultTable("Select * from Round");
				this.f.getPanelJudgeMenu().setVisible(true);
				this.setVisible(false);
				this.remove(comboBox);
				/***************************************************/
//				nameField.setText("");
//				periodField.setText("");
//				yearField.setText("");
//				meetField.setText("");
//				roomField.setText("");
				/***************************************************/
//			} else
				//System.out.println("You must select a round!");
		} else if (e.getSource() == comboBox) {
			// TODO update round info when a round is selected
		}

	}
}