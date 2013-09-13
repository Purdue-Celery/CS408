import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelJudgeReportRoundes extends JPanel implements ActionListener {
	FrameMain f = null;
	String[] columnNames = { "Round Name", "Test Time", "Test Room", "# of contestants", "# of evaluations", "# of notices" };

	JTable table;
	JButton backButton = new JButton("Go back");
	JScrollPane scroll;

	public PanelJudgeReportRoundes(FrameMain frameMain) {
		f = frameMain;
		setSize(FrameMain.WIDTH, FrameMain.HEIGHT);
		this.setLayout(new BorderLayout());

		backButton.setPreferredSize(new Dimension(this.getWidth(), 30));
		this.add(backButton, BorderLayout.SOUTH);
		backButton.addActionListener(this);
	}

	public void displayReport() {
		String[][] data = f.getMyQueryManager().getRoundReportByJudge(f.getJudgeID());
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
			this.f.getPanelJudgeMenu().setVisible(true);
		}
	}

}
