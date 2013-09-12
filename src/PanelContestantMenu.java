import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelContestantMenu extends JPanel implements ActionListener {
	FrameMain f = null;

	JButton EvalCalendarButton = new JButton("Calendar of evaluations");
	JButton ReportRoundesButton = new JButton("Report of rounds");
	JButton ReportScoresButton = new JButton("Report of scores");
	JButton LogoutButton = new JButton("Logout");

	public PanelContestantMenu(FrameMain frameMain) {
		f = frameMain;
		setSize(FrameMain.WIDTH, FrameMain.HEIGHT);
		this.setLayout(new GridBagLayout());

		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.gridx = 0;
		c1.gridy = 0;
		this.add(EvalCalendarButton, c1);
		EvalCalendarButton.addActionListener(this);

		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.gridx = 0;
		c2.gridy = 1;
		this.add(ReportRoundesButton, c2);
		ReportRoundesButton.addActionListener(this);

		GridBagConstraints c3 = new GridBagConstraints();
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.gridx = 0;
		c3.gridy = 2;
		this.add(ReportScoresButton, c3);
		ReportScoresButton.addActionListener(this);

		GridBagConstraints c4 = new GridBagConstraints();
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.gridx = 0;
		c4.gridy = 3;
		this.add(LogoutButton, c4);
		LogoutButton.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		if (e.getSource() == EvalCalendarButton) {
			this.f.getPanelContestantEvalCalendar().displayReport();
			this.f.getPanelContestantEvalCalendar().setVisible(true);
		} else if (e.getSource() == ReportRoundesButton) {
			this.f.getPanelContestantReportRoundes().displayReport();
			this.f.getPanelContestantReportRoundes().setVisible(true);
		} else if (e.getSource() == ReportScoresButton) {
			this.f.getPanelContestantReportScores().displayReport();
			this.f.getPanelContestantReportScores().setVisible(true);
		} else if (e.getSource() == LogoutButton) {
			this.f.getPanelLogin().setVisible(true);
		}
	}

}
