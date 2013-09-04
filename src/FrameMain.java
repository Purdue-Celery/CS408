import javax.swing.*;

public class FrameMain extends JFrame {
	private PanelLogin panelLogin = new PanelLogin(this);
	private PanelJudgeMenu panelJudgeMenu = new PanelJudgeMenu(this);
	private PanelJudgeCreateRound panelJudgeCreateRound = new PanelJudgeCreateRound(this);
	private PanelJudgeModifyRound panelJudgeModifyRound = new PanelJudgeModifyRound(this);
	private PanelJudgeEnroll panelJudgeEnroll = new PanelJudgeEnroll(this);
	private PanelJudgeCreateEval panelJudgeCreateEval = new PanelJudgeCreateEval(this);
	private PanelJudgeModifyEval panelJudgeModifyEval = new PanelJudgeModifyEval(this);
	private PanelJudgeEnterScore panelJudgeEnterScore = new PanelJudgeEnterScore(this);
	private PanelJudgeReportRoundes panelJudgeReportRoundes = new PanelJudgeReportRoundes(this);
	private PanelJudgeReportScores panelJudgeReportScores = new PanelJudgeReportScores(this);

	private PanelContestantMenu panelContestantMenu = new PanelContestantMenu(this);
	private PanelContestantEvalCalendar panelContestantEvalCalendar = new PanelContestantEvalCalendar(this);
	private PanelContestantReportRoundes panelContestantReportRoundes = new PanelContestantReportRoundes(this);
	private PanelContestantReportScores panelContestantReportScores = new PanelContestantReportScores(this);
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	private int judgeID = 0;
	private int contestantID = 0;

	// Create database connection when creating DatabaseServer object
	private DatabaseServer myDBServer;
	private QueryManager myQueryManager;
	public FrameMain() {
		myDBServer = new DatabaseServer();
		myQueryManager = new QueryManager(myDBServer.getConnection());
		
		setSize(WIDTH+9, HEIGHT+26);
        setTitle("Purdue-CT");
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        
        this.add(panelLogin);
        this.add(panelJudgeMenu);
        this.add(panelJudgeCreateRound);
        this.add(panelJudgeModifyRound);
        this.add(panelJudgeEnroll);
        this.add(panelJudgeCreateEval);
        this.add(panelJudgeModifyEval);
        this.add(panelJudgeEnterScore);
        this.add(panelJudgeReportRoundes);
        this.add(panelJudgeReportScores);
        this.add(panelContestantMenu);
        this.add(panelContestantEvalCalendar);
        this.add(panelContestantReportRoundes);
        this.add(panelContestantReportScores);
        
        panelLogin.setVisible(true);
        panelJudgeMenu.setVisible(false);
        panelJudgeCreateRound.setVisible(false);
        panelJudgeModifyRound.setVisible(false);
        panelJudgeEnroll.setVisible(false);
        panelJudgeCreateEval.setVisible(false);
        panelJudgeModifyEval.setVisible(false);
        panelJudgeEnterScore.setVisible(false);
        panelJudgeReportRoundes.setVisible(false);
        panelJudgeReportScores.setVisible(false);
        panelContestantMenu.setVisible(false);
        panelContestantEvalCalendar.setVisible(false);
        panelContestantReportRoundes.setVisible(false);
        panelContestantReportScores.setVisible(false);

	}

	public DatabaseServer getMyDBServer() {
		return myDBServer;
	}

	public QueryManager getMyQueryManager() {
		return myQueryManager;
	}

	public int getJudgeID() {
		return judgeID;
	}

	public void setJudgeID(int judgeID) {
		this.judgeID = judgeID;
	}

	public int getContestantID() {
		return contestantID;
	}

	public void setContestantID(int contestantID) {
		this.contestantID = contestantID;
	}

	public PanelLogin getPanelLogin() {
		return panelLogin;
	}

	public PanelJudgeMenu getPanelJudgeMenu() {
		return panelJudgeMenu;
	}

	public PanelJudgeCreateRound getPanelJudgeCreateRound() {
		return panelJudgeCreateRound;
	}

	public PanelJudgeModifyRound getPanelJudgeModifyRound() {
		return panelJudgeModifyRound;
	}

	public PanelJudgeEnroll getPanelJudgeEnroll() {
		return panelJudgeEnroll;
	}

	public PanelJudgeCreateEval getPanelJudgeCreateEval() {
		return panelJudgeCreateEval;
	}

	public PanelJudgeModifyEval getPanelJudgeModifyEval() {
		return panelJudgeModifyEval;
	}

	public PanelJudgeEnterScore getPanelJudgeEnterScore() {
		return panelJudgeEnterScore;
	}

	public PanelJudgeReportRoundes getPanelJudgeReportRoundes() {
		return panelJudgeReportRoundes;
	}

	public PanelJudgeReportScores getPanelJudgeReportScores() {
		return panelJudgeReportScores;
	}

	public PanelContestantMenu getPanelContestantMenu() {
		return panelContestantMenu;
	}

	public PanelContestantEvalCalendar getPanelContestantEvalCalendar() {
		return panelContestantEvalCalendar;
	}

	public PanelContestantReportRoundes getPanelContestantReportRoundes() {
		return panelContestantReportRoundes;
	}

	public PanelContestantReportScores getPanelContestantReportScores() {
		return panelContestantReportScores;
	}

}
