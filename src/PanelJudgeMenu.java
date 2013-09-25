import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelJudgeMenu extends JPanel implements ActionListener {
	FrameMain f = null;
	JButton CreateRoundButton = new JButton("Create a Round");
	JButton ModifyRoundButton = new JButton("Modify a Round");
	JButton EnrollButton = new JButton("Assign Contestant to Round");
	JButton CreateEvalButton = new JButton("Create an Evaluation");
	JButton ModifyEvalButton = new JButton("Modify an Evaluation");
	JButton EnterScoreButton = new JButton("Enter Score");
	JButton ReportRoundesButton = new JButton("Report of Rounds");
	JButton ReportScoresButton = new JButton("Report of Contestants and Scores");
	JButton LogoutButton = new JButton("Logout");

	public PanelJudgeMenu(FrameMain frameMain) {
		f = frameMain;
		setSize(FrameMain.WIDTH, FrameMain.HEIGHT);
		this.setLayout(new GridBagLayout());

		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.gridx = 0;
		c1.gridy = 0;
		c1.insets = new Insets(3, 0, 0, 0);
		CreateRoundButton.setBackground(new Color(197, 179, 88));
		this.add(CreateRoundButton, c1);
		CreateRoundButton.addActionListener(this);

		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.gridx = 0;
		c2.gridy = 1;
		c2.insets = new Insets(3, 0, 0, 0);
		ModifyRoundButton.setBackground(new Color(197, 179, 88));
		this.add(ModifyRoundButton, c2);
		ModifyRoundButton.addActionListener(this);

		GridBagConstraints c3 = new GridBagConstraints();
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.gridx = 0;
		c3.gridy = 2;
		c3.insets = new Insets(3, 0, 0, 0);
		EnrollButton.setBackground(new Color(197, 179, 88));
		this.add(EnrollButton, c3);
		EnrollButton.addActionListener(this);

		GridBagConstraints c4 = new GridBagConstraints();
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.gridx = 0;
		c4.gridy = 3;
		c4.insets = new Insets(3, 0, 0, 0);
		CreateEvalButton.setBackground(new Color(197, 179, 88));
		this.add(CreateEvalButton, c4);
		CreateEvalButton.addActionListener(this);

		GridBagConstraints c5 = new GridBagConstraints();
		c5.fill = GridBagConstraints.HORIZONTAL;
		c5.gridx = 0;
		c5.gridy = 4;
		c5.insets = new Insets(3, 0, 0, 0);
		ModifyEvalButton.setBackground(new Color(197, 179, 88));
		this.add(ModifyEvalButton, c5);
		ModifyEvalButton.addActionListener(this);

		GridBagConstraints c6 = new GridBagConstraints();
		c6.fill = GridBagConstraints.HORIZONTAL;
		c6.gridx = 0;
		c6.gridy = 5;
		c6.insets = new Insets(3, 0, 0, 0);
		EnterScoreButton.setBackground(new Color(197, 179, 88));
		this.add(EnterScoreButton, c6);
		EnterScoreButton.addActionListener(this);

		GridBagConstraints c7 = new GridBagConstraints();
		c7.fill = GridBagConstraints.HORIZONTAL;
		c7.gridx = 0;
		c7.gridy = 6;
		c7.insets = new Insets(3, 0, 0, 0);
		ReportRoundesButton.setBackground(new Color(197, 179, 88));
		this.add(ReportRoundesButton, c7);
		ReportRoundesButton.addActionListener(this);

		GridBagConstraints c8 = new GridBagConstraints();
		c8.fill = GridBagConstraints.HORIZONTAL;
		c8.gridx = 0;
		c8.gridy = 7;
		c8.insets = new Insets(3, 0, 0, 0);
		ReportScoresButton.setBackground(new Color(197, 179, 88));
		this.add(ReportScoresButton, c8);
		ReportScoresButton.addActionListener(this);

		GridBagConstraints c9 = new GridBagConstraints();
		c9.fill = GridBagConstraints.HORIZONTAL;
		c9.gridx = 0;
		c9.gridy = 8;
		c9.insets = new Insets(21, 0, 0, 0);
		LogoutButton.setBackground(new Color(197, 179, 88));
		this.add(LogoutButton, c9);
		LogoutButton.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		if (e.getSource() == CreateRoundButton) {
			this.f.getPanelJudgeCreateRound().setVisible(true);
		} else if (e.getSource() == ModifyRoundButton) {
			this.f.getPanelJudgeModifyRound().updateComboBox();
			this.f.getPanelJudgeModifyRound().setVisible(true);
		} else if (e.getSource() == EnrollButton) {
			this.f.getPanelJudgeEnroll().updateComboBox();
			this.f.getPanelJudgeEnroll().setVisible(true);
		} else if (e.getSource() == CreateEvalButton) {
			this.f.getPanelJudgeCreateEval().updateComboBox();
			this.f.getPanelJudgeCreateEval().setVisible(true);
		} else if (e.getSource() == ModifyEvalButton) {
			this.f.getPanelJudgeModifyEval().updateComboBox();
			this.f.getPanelJudgeModifyEval().setVisible(true);
		} else if (e.getSource() == EnterScoreButton) {
			this.f.getPanelJudgeEnterScore().setVisible(true);
		} else if (e.getSource() == ReportRoundesButton) {
			this.f.getPanelJudgeReportRoundes().displayReport();
			this.f.getPanelJudgeReportRoundes().setVisible(true);
		} else if (e.getSource() == ReportScoresButton) {
			this.f.getPanelJudgeReportScores().displayReport();
			this.f.getPanelJudgeReportScores().setVisible(true);
		} else if (e.getSource() == LogoutButton) {
			this.f.getPanelLogin().setVisible(true);
		}
	}

}