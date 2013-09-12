import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelContestantReportScores extends JPanel implements ActionListener {
	FrameMain f = null;
	String[] columnNames = { "Round Name", "Evaluation Type", "Percent Weight", "Score" };

	JTable table;
	JButton backButton = new JButton("Go back");
	JScrollPane scroll;

	public PanelContestantReportScores(FrameMain frameMain) {
		f = frameMain;
		setSize(FrameMain.WIDTH, FrameMain.HEIGHT);
		this.setLayout(new BorderLayout());

		backButton.setPreferredSize(new Dimension(this.getWidth(), 30));
		this.add(backButton, BorderLayout.SOUTH);
		backButton.addActionListener(this);

	}

	public void displayReport() {
		String[][] data = f.getMyQueryManager().getScoreReportByContestant(f.getContestantID());
		table = new JTable(data, columnNames);
		scroll = new JScrollPane(table);
		this.add(scroll, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		if (e.getSource() == backButton) {
			// TODO clear panel
			this.remove(table);
			this.remove(scroll);
			this.f.getPanelContestantMenu().setVisible(true);
		}
	}
}
