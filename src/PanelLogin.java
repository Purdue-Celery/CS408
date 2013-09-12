import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelLogin extends JPanel implements ActionListener {
	FrameMain f = null;

	JTextField useridField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JLabel useridLabel = new JLabel("User ID");
	JLabel passwordLabel = new JLabel("Password");
	JRadioButton judgeRadioButton = new JRadioButton("Judge");
	JRadioButton contestantRadioButton = new JRadioButton("Contestant");
	ButtonGroup group = new ButtonGroup();
	JButton loginButton = new JButton("Login");

	public PanelLogin(FrameMain frameMain) {
		f = frameMain;
		setSize(FrameMain.WIDTH, FrameMain.HEIGHT);
		this.setLayout(new GridBagLayout());

		group.add(judgeRadioButton);
		group.add(contestantRadioButton);

		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.gridy = 0;
		c1.fill = GridBagConstraints.HORIZONTAL;
		this.add(useridLabel, c1);

		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 1;
		c2.fill = GridBagConstraints.HORIZONTAL;
		this.add(passwordLabel, c2);

		GridBagConstraints c3 = new GridBagConstraints();
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.gridx = 1;
		c3.gridy = 0;
		this.add(useridField, c3);

		GridBagConstraints c4 = new GridBagConstraints();
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.gridx = 1;
		c4.gridy = 1;
		this.add(passwordField, c4);

		GridBagConstraints c5 = new GridBagConstraints();
		c5.gridx = 0;
		c5.gridy = 2;
		this.add(judgeRadioButton, c5);

		GridBagConstraints c6 = new GridBagConstraints();
		c6.gridx = 1;
		c6.gridy = 2;
		this.add(contestantRadioButton, c6);

		GridBagConstraints c7 = new GridBagConstraints();
		c7.gridx = 0;
		c7.gridwidth = 2;
		c7.gridy = 3;
		this.add(loginButton, c7);
		loginButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			if (judgeRadioButton.isSelected()) {
				int JudgeID = Integer.valueOf(useridField.getText());
				String JudgePW = passwordField.getText();
				if (this.f.getMyQueryManager().verifyJudge(JudgeID, JudgePW)) {
					this.f.setJudgeID(JudgeID);
					useridField.setText("");
					passwordField.setText("");
					this.setVisible(false);
					this.f.getPanelJudgeMenu().setVisible(true);
				} else {
					System.out.println("Login fail. Try again");
				}
			} else if (contestantRadioButton.isSelected()) {
				int ContestantID = Integer.valueOf(useridField.getText());
				String ContestantPW = passwordField.getText();
				if (this.f.getMyQueryManager().verifyContestant(ContestantID, ContestantPW)) {
					this.f.setContestantID(ContestantID);
					useridField.setText("");
					passwordField.setText("");
					this.setVisible(false);
					this.f.getPanelContestantMenu().setVisible(true);
				} else {
					System.out.println("Login fail. Try again");
				}
			}
		}
	}
}