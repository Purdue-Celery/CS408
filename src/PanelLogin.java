import javax.swing.JPanel;

public class PanelLogin extends JPanel {
	FrameMain f = null;

	public PanelLogin(FrameMain frameMain) {
		f = frameMain;
		setSize(FrameMain.WIDTH, FrameMain.HEIGHT);
	}
}
