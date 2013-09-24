import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelJudgeEnroll extends JPanel implements ActionListener {
	FrameMain f = null;

	JButton submitButton = new JButton("Submit");
	JButton backButton = new JButton("Go back");

	JLabel contestantLabel = new JLabel("Contestant ID");
	JLabel roundLabel = new JLabel("Round Name");
	JComboBox contestantBox = null;
	JComboBox roundBox = null;

	public PanelJudgeEnroll(FrameMain frameMain) {
		f = frameMain;
		setSize(FrameMain.WIDTH, FrameMain.HEIGHT);
		this.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(contestantLabel, c);

		c.gridx = 0;
		c.gridy = 1;
		this.add(roundLabel, c);

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.weightx = 0.5;
		c.fill = GridBagConstraints.NONE;
		this.add(submitButton, c);
		submitButton.addActionListener(this);

		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.weightx = 0.5;
		this.add(backButton, c);
		backButton.addActionListener(this);

	}

	public void updateComboBox() {
		String[] contestants = f.getMyQueryManager().getContestantIDList();
		String[] contestants_new = new String[contestants.length + 1];
		contestants_new[0] = "";
		for (int i = 1; i < contestants_new.length; i++) {
			contestants_new[i] = contestants[i - 1];
		}
		contestantBox = new JComboBox(contestants_new);

		String[] rounds = f.getMyQueryManager().getRoundListFromJudgeID(f.getJudgeID());
		String[] rounds_new = new String[rounds.length + 1];
		rounds_new[0] = "";
		for (int i = 1; i < rounds_new.length; i++) {
			rounds_new[i] = rounds[i - 1];
		}
		roundBox = new JComboBox(rounds_new);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(contestantBox, c);

		c.gridx = 1;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(roundBox, c);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			this.f.getPanelJudgeMenu().setVisible(true);
			this.setVisible(false);
			this.remove(contestantBox);
			this.remove(roundBox);
		} else if (e.getSource() == submitButton) {
			/***************************************************/
//			if (contestantBox.getSelectedIndex() != 0 && roundBox.getSelectedIndex() != 0) {
				this.f.getMyQueryManager().assignContestantToRound(
						Integer.valueOf(contestantBox.getSelectedItem().toString()),
						roundBox.getSelectedItem().toString());
				this.f.getMyQueryManager().printResultTable("Select * from Enrollment");
				this.f.getPanelJudgeMenu().setVisible(true);
				this.setVisible(false);
				this.remove(contestantBox);
				this.remove(roundBox);
//			} else
//				System.out.println("You must select both the contestant and round!");
			/***************************************************/
		}

	}
}