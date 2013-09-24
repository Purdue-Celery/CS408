import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelJudgeCreateRound extends JPanel implements ActionListener {
	FrameMain f = null;
	JTextField nameField = new JTextField();
	JTextField periodField = new JTextField();
	JTextField yearField = new JTextField();
	JTextField meetField = new JTextField();
	JTextField roomField = new JTextField();

	JLabel nameLabel = new JLabel("Name");
	JLabel periodLabel = new JLabel("Season");
	JLabel yearLabel = new JLabel("Year");
	JLabel meetLabel = new JLabel("Time");
	JLabel roomLabel = new JLabel("Location");
	JButton submitButton = new JButton("Submit");
	JButton backButton = new JButton("Go back");

	public PanelJudgeCreateRound(FrameMain frameMain) {
		f = frameMain;
		setSize(FrameMain.WIDTH, FrameMain.HEIGHT);
		this.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(nameLabel, c);

		c.gridx = 1;
		c.gridy = 0;
		this.add(nameField, c);

		c.gridx = 0;
		c.gridy = 1;
		this.add(periodLabel, c);

		c.gridx = 1;
		c.gridy = 1;
		this.add(periodField, c);

		c.gridx = 0;
		c.gridy = 2;
		this.add(yearLabel, c);

		c.gridx = 1;
		c.gridy = 2;
		this.add(yearField, c);

		c.gridx = 0;
		c.gridy = 3;
		this.add(meetLabel, c);

		c.gridx = 1;
		c.gridy = 3;
		this.add(meetField, c);

		c.gridx = 0;
		c.gridy = 4;
		this.add(roomLabel, c);

		c.gridx = 1;
		c.gridy = 4;
		this.add(roomField, c);

		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		c.weightx = 0.5;
		c.fill = GridBagConstraints.NONE;
		this.add(submitButton, c);
		submitButton.addActionListener(this);

		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 2;
		c.weightx = 0.5;
		this.add(backButton, c);
		backButton.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == backButton) {
			this.f.getPanelJudgeMenu().setVisible(true);
		} else if (e.getSource() == submitButton) {
			this.f.getMyQueryManager().createRound(nameField.getText(), periodField.getText(),
					Integer.valueOf(yearField.getText()), meetField.getText(), roomField.getText(),
					this.f.getJudgeID());
			this.f.getMyQueryManager().printResultTable("Select * from Round");
			this.f.getPanelJudgeMenu().setVisible(true);
		}
		this.setVisible(false);
		/***************************************************/
//		nameField.setText("");
//		periodField.setText("");
//		yearField.setText("");
//		meetField.setText("");
//		roomField.setText("");
		/***************************************************/
	}
}
