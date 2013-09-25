import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelContestantReportRoundes extends JPanel implements ActionListener {
	FrameMain f = null;
	String[] columnNames = { "Round Name", "Season", "Year", "Time", "Location" };

	JTable table;
	JButton backButton = new JButton("Go back");
	JScrollPane scroll;

	public PanelContestantReportRoundes(FrameMain frameMain) {
		f = frameMain;
		setSize(FrameMain.WIDTH, FrameMain.HEIGHT);
		this.setLayout(new BorderLayout());

		backButton.setPreferredSize(new Dimension(this.getWidth(), 30));
		backButton.setBackground(new Color(197, 179, 88));
		this.add(backButton, BorderLayout.SOUTH);
		backButton.addActionListener(this);
	}

	public void displayReport() {
		String[][] data = f.getMyQueryManager().getRoundReportByContestant(f.getContestantID());
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
