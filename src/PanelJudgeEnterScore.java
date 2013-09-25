import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelJudgeEnterScore extends JPanel implements ActionListener {
	FrameMain f = null;
	JButton submitButton = new JButton("Submit");
	JButton backButton = new JButton("Go back");

	public PanelJudgeEnterScore(FrameMain frameMain) {
		f = frameMain;
		setSize(FrameMain.WIDTH, FrameMain.HEIGHT);
		this.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;

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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			this.f.getPanelJudgeMenu().setVisible(true);
			this.setVisible(false);
		} else if (e.getSource() == submitButton) {
			this.f.getPanelJudgeMenu().setVisible(true);
			this.setVisible(false);

		}
	}

}
