import java.sql.*;
import java.util.Calendar;

public class QueryManager {
	private Connection connection = null;

	public QueryManager(Connection connection) {
		this.connection = connection;
		if (this.connection.equals(null)) {
			System.out.println("Connection is not ready");
		}
	}

	public void printResultTable(String queryString) {
		String query = queryString;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			// printColTypes(rsmd);
			// System.out.println();
			int numberOfColumns = rsmd.getColumnCount();
			for (int i = 1; i <= numberOfColumns; i++) {
				if (i > 1)
					System.out.print("\t");
				String columnName = rsmd.getColumnName(i);
				System.out.print(columnName);
			}
			System.out.println();

			while (rs.next()) {
				for (int i = 1; i <= numberOfColumns; i++) {
					if (i > 1)
						System.out.print("\t");
					String columnValue = rs.getString(i);
					System.out.print(columnValue);
				}
				System.out.println();
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
	}

	public void printColTypes(ResultSetMetaData rsmd) {
		int columns;
		try {
			columns = rsmd.getColumnCount();
			for (int i = 1; i <= columns; i++) {
				int jdbcType = rsmd.getColumnType(i);
				String name = rsmd.getColumnTypeName(i);
				System.out.print("Column " + i + " is JDBC type " + jdbcType);
				System.out.println(", which the DBMS calls " + name);
			}
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
	}

	public void printTableContestant() {
		String query = "select * from Contestant";
		printResultTable(query);
	}

	public boolean verifyJudge(int JudgeID, String JudgePW) {
		String password = null;
		String query = "SELECT JudgePW FROM Judge WHERE JudgeID = " + JudgeID;
		// System.out.println(query);
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				password = rs.getString("JudgePW");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}

		if (password == null) {
			return false;
		} else if (password.equals(JudgePW))
			return true;
		else
			return false;
	}

	public String getJudgeName(int JudgeID) {
		// If JudgeID doesn't exist, return null
		String JudgeName = null;
		String query = "SELECT JudgeName FROM Judge WHERE JudgeID = " + JudgeID;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				JudgeName = rs.getString("JudgeName");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
		return JudgeName;
	}

	public boolean verifyContestant(int ContestantID, String ContestantPW) {
		String password = null;
		String query = "SELECT ContestantPW FROM Contestant WHERE ContestantID = " + ContestantID;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				password = rs.getString("ContestantPW");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
		if (password == null)
			return false;
		else if (password.equals(ContestantPW))
			return true;
		else
			return false;
	}

	public String getContestantName(int ContestantID) {
		// If JudgeID doesn't exist, return null
		String ContestantName = null;
		String query = "SELECT ContestantName FROM Contestant WHERE ContestantID = " + ContestantID;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				ContestantName = rs.getString("ContestantName");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
		return ContestantName;
	}

	public void createRound(String RoundName, String Period, int Year, String TestTime,
			String TestRoom, int JudgeID) {
		String query = "INSERT INTO Round (RoundName, Period, Year, TestTime, TestRoom, JudgeID) VALUES ('"
				+ RoundName
				+ "', '"
				+ Period
				+ "', "
				+ Year
				+ ", '"
				+ TestTime
				+ "', '"
				+ TestRoom
				+ "', " + JudgeID + ")";
		try {
			Statement st = connection.createStatement();
			st.executeUpdate(query);
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
	}

	public void modifyRound(String OriginalRoundName, String NewRoundName, String Period,
			int Year, String TestTime, String TestRoom) {
		/*
		 * No need to modify JudgeID because only the owner can modify a
		 * round
		 */
		String query = "UPDATE Round SET RoundName = '" + NewRoundName + "'," + "Period = '"
				+ Period + "', " + "Year = " + Year + ", " + "TestTime = '" + TestTime + "', "
				+ "TestRoom = '" + TestRoom + "'" + " WHERE RoundName = '" + OriginalRoundName + "'";
		System.out.println(query);
		try {
			Statement st = connection.createStatement();
			st.executeUpdate(query);
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
	}

	public String[] getRoundListFromJudgeID(int JudgeID) {
		String query = "SELECT RoundName FROM Round WHERE JudgeID = " + JudgeID;
		String query_count = "SELECT COUNT(*) as Count FROM (" + query + ") X";
		int row_count = 0;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query_count);
			while (rs.next()) {
				row_count = rs.getInt("Count");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}

		String[] rounds = new String[row_count];
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				String RoundName = rs.getString("RoundName");
				rounds[i] = RoundName;
				i++;
			}
			st.close();
			return rounds;
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
			return null;
		}
	}

	public void assignContestantToRound(int ContestantID, String RoundName) {
		String query = "INSERT INTO Enrollment (ContestantID, RoundName) VALUES (" + ContestantID
				+ ", '" + RoundName + "')";
		try {
			Statement st = connection.createStatement();
			st.executeUpdate(query);
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
	}

	public String[] getContestantIDList() {
		String query = "SELECT ContestantID FROM Contestant";
		String query_count = "SELECT COUNT(*) as Count FROM (" + query + ") X";
		int row_count = 0;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query_count);
			while (rs.next()) {
				row_count = rs.getInt("Count");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}

		String[] contestants = new String[row_count];
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				String ContestantID = Integer.toString(rs.getInt("ContestantID"));
				contestants[i] = ContestantID;
				i++;
			}
			st.close();
			return contestants;
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
			return null;
		}
	}

	public void createEvaluation(String RoundName, String EvaluationType, int PercentWeight,
			Date DeadlineDate) {
		/*
		 * myQueryManager.createEvaluation(2, "Midterm",
		 * 30,Date.valueOf("2013-05-31"));
		 */
		
		/*
		String query = "INSERT INTO Evaluation (EvaluationID, RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES (seqEvaluation.NEXTVAL, '"
				+ RoundName
				+ "', '"
				+ EvaluationType
				+ "', "
				+ PercentWeight
				+ ", to_date('"
				+ DeadlineDate + "', 'yyyy-mm-dd'))";
		*/
		String query = "INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ( '"
				+ RoundName
				+ "', '"
				+ EvaluationType
				+ "', "
				+ PercentWeight
				+ ", '"
				+ DeadlineDate + "')";
		try {
			Statement st = connection.createStatement();
			st.executeUpdate(query);
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
	}

	// public void modifyEvaluation(int EvaluationID, String EvaluationType, int
	// PercentWeight,
	// Date DeadlineDate) {
	// /*
	// * RoundName can't be changed myQueryManager.modifyEvaluation(4, "aaa",
	// * 22, Date.valueOf("2013-06-07"));
	// */
	// String query = "UPDATE Evaluation SET EvaluationType = '" +
	// EvaluationType
	// + "', PercentWeight = " + PercentWeight + ", DeadlineDate = to_date('"
	// + DeadlineDate + "', 'yyyy-mm-dd') WHERE EvaluationID = " + EvaluationID;
	// try {
	// Statement st = connection.createStatement();
	// st.executeUpdate(query);
	// st.close();
	// } catch (SQLException e) {
	// System.out.println("Something is wrong");
	// e.printStackTrace();
	// }
	// }

	public void modifyEvaluation(int EvaluationID, int PercentWeight, Date DeadlineDate) {
		/*
		 * RoundName can't be changed myQueryManager.modifyEvaluation(4, 22,
		 * Date.valueOf("2013-06-07"));
		 */
		
		/***************************************************************************/
		/*String query = "UPDATE Evaluation SET PercentWeight = " + PercentWeight
				+ ", DeadlineDate = '" + DeadlineDate
				+ "' WHERE EvaluationID = " + EvaluationID;*/
		
		String query = "UPDATE Evaluation SET PercentWeight = " + PercentWeight
				+ ", DeadlineDate = '" + DeadlineDate+ "'";
		/**************************************************************************/
		// System.out.println(query);
		try {
			Statement st = connection.createStatement();
			st.executeUpdate(query);
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
	}

	public String[][] getEvalListFromRoundName(String RoundName) {
		String query = "SELECT EvaluationID, EvaluationType FROM Evaluation WHERE RoundName = '"
				+ RoundName + "'";
		String query_count = "SELECT COUNT(*) as Count FROM (" + query + ") X";
		int row_count = 0;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query_count);
			while (rs.next()) {
				row_count = rs.getInt("Count");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}

		String[][] list = new String[row_count][2];
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				list[i][0] = Integer.toString(rs.getInt("EvaluationID"));
				list[i][1] = rs.getString("EvaluationType");
				i++;
			}
			st.close();
			return list;
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
			return null;
		}
	}

	public boolean ableToModifyEvaluation(int EvaluationID) {
		Date DeadlineDate = null;
		String query = "SELECT DeadlineDate FROM Evaluation WHERE EvaluationID = " + EvaluationID;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				DeadlineDate = rs.getDate("DeadlineDate");
				System.out.println(DeadlineDate);
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
		if (DeadlineDate.after(new Date(Calendar.getInstance().getTimeInMillis())))
			return true;
		else
			/*************************************************************************/
			/*return false;*/
			return true;
			/*************************************************************************/
	}

	public void createOrModifyEvaluationScore(int EvaluationID, int ContestantID, int Score) {
		if (existEvaluationScore(EvaluationID, ContestantID)) {
			String query = "UPDATE EvaluationScore SET Score = " + Score + "WHERE EvaluationID = "
					+ EvaluationID + " AND ContestantID = " + ContestantID;
			try {
				Statement st = connection.createStatement();
				st.executeUpdate(query);
				st.close();
			} catch (SQLException e) {
				System.out.println("Something is wrong");
				e.printStackTrace();
			}
		} else {
			String query = "INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES ("
					+ EvaluationID + ", " + ContestantID + ", " + Score + ")";
			try {
				Statement st = connection.createStatement();
				st.executeUpdate(query);
				st.close();
			} catch (SQLException e) {
				System.out.println("Something is wrong");
				e.printStackTrace();
			}
		}
	}

	public boolean existEvaluationScore(int EvaluationID, int ContestantID) {
		String query = "SELECT * FROM EvaluationScore WHERE EvaluationID = " + EvaluationID
				+ " AND ContestantID = " + ContestantID;
		boolean hasRows = false;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				hasRows = true;
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
		if (hasRows)
			return true;
		else
			return false;
	}

	public String[][] getRoundReportByJudge(int JudgeID) {
		/*
		 * SELECT C.RoundName, TestTime, TestRoom, IFNULL(En.StuNum,0) as StuNum,
		 * IFNULL(Ev.EvalNum,0) as EvalNum, IFNULL(M.MsgNum,0) as MsgNum FROM (SELECT
		 * RoundName FROM Round WHERE JudgeID = 2) T LEFT JOIN Round C ON
		 * T.RoundName = C.RoundName LEFT JOIN (SELECT RoundName, count(*) as
		 * StuNum FROM Enrollment GROUP BY RoundName) En ON T.RoundName =
		 * En.RoundName LEFT JOIN (SELECT RoundName, count(*) as EvalNum FROM
		 * Evaluation GROUP BY RoundName) Ev ON T.RoundName = Ev.RoundName
		 * LEFT JOIN (SELECT RoundName, count(*) as MsgNum FROM Notice GROUP
		 * BY RoundName) M ON T.RoundName = M.RoundName;
		 */

		/* COURSENAME MEETS_AT ROOM STUNUM EVALNUM MSGNUM */
		/* CS381 10:30 AM LWSN B155 6 4 2 */
		/* CS426 4:30 PM HASS G066 3 4 2 */

		String query = "SELECT C.RoundName, TestTime, TestRoom, "
				+ "IFNULL(En.StuNum,0) as StuNum, IFNULL(Ev.EvalNum,0) as EvalNum, IFNULL(M.MsgNum,0) as MsgNum "
				+ "FROM (SELECT RoundName FROM Round WHERE JudgeID = "
				+ JudgeID
				+ ") T "
				+ "LEFT JOIN Round C ON T.RoundName = C.RoundName "
				+ "LEFT JOIN (SELECT RoundName, count(*) as StuNum FROM Enrollment GROUP BY RoundName) En ON T.RoundName = En.RoundName "
				+ "LEFT JOIN (SELECT RoundName, count(*) as EvalNum FROM Evaluation GROUP BY RoundName) Ev ON T.RoundName = Ev.RoundName "
				+ "LEFT JOIN (SELECT RoundName, count(*) as MsgNum FROM Notice GROUP BY RoundName) M ON T.RoundName = M.RoundName";
		String query_count = "SELECT COUNT(*) as Count FROM (" + query + ") X";
		// System.out.println(query);
		// System.out.println(query_count);
		int row_count = 0;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query_count);
			while (rs.next()) {
				row_count = rs.getInt("Count");
			}
			st.close();
			// return rs;
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
		// System.out.println(row_count);
		String[][] data = new String[row_count][6];
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				String RoundName = rs.getString("RoundName");
				String TestTime = rs.getString("TestTime");
				String TestRoom = rs.getString("TestRoom");
				int StuNum = rs.getInt("StuNum");
				int EvalNum = rs.getInt("EvalNum");
				int MsgNum = rs.getInt("MsgNum");
				data[i][0] = RoundName;
				data[i][1] = TestTime;
				data[i][2] = TestRoom;
				data[i][3] = Integer.toString(StuNum);
				data[i][4] = Integer.toString(EvalNum);
				data[i][5] = Integer.toString(MsgNum);
				i++;
			}

			st.close();
			return data;
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
			return null;
		}
	}

	public String[][] getContestantScoreReportByJudge(int JudgeID) {
		String[] rounds = getRoundListFromJudgeID(JudgeID);
		int row_count = 0;
		for (int i = 0; i < rounds.length; i++) {
			String[][] contestantInfo = getContestantInfoByRoundName(rounds[i]);
			row_count += contestantInfo.length;
		}
		String[][] data = new String[row_count][5];
		int current_row = 0;
		for (int i = 0; i < rounds.length; i++) {
			String[] roundInfo = getRoundInfo(rounds[i]);
			String[][] contestantInfo = getContestantInfoByRoundName(rounds[i]);
			for (int j = 0; j < contestantInfo.length; j++) {
				data[current_row][0] = rounds[i];
				data[current_row][1] = roundInfo[0];
				data[current_row][2] = roundInfo[1];
				data[current_row][3] = contestantInfo[j][1];
				data[current_row][4] = Double.toString(getCurrentScoreFromContestantIDAndRoundName(
						Integer.valueOf(contestantInfo[j][0]), rounds[i]));
				current_row++;
			}
		}
		return data;
	}

	public String[] getRoundInfo(String RoundName) {
		String query = "SELECT Period, Year, TestTime, TestRoom FROM Round WHERE RoundName = '"
				+ RoundName + "'";

		String[] info = new String[4];
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				info[0] = rs.getString("Period");
				info[1] = Integer.toString(rs.getInt("Year"));
				info[2] = rs.getString("TestTime");
				info[3] = rs.getString("TestRoom");
			}
			st.close();
			return info;
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
			return null;
		}
	}

	public String[][] getContestantInfoByRoundName(String RoundName) {
		String query = "SELECT Contestant.ContestantID, ContestantName FROM Contestant JOIN Enrollment "
				+ "ON Contestant.ContestantID = Enrollment.ContestantID WHERE Enrollment.RoundName = '"
				+ RoundName + "'";
		String query_count = "SELECT COUNT(*) as Count FROM (" + query + ") X";
		// System.out.println(query);
		// System.out.println(query_count);
		int row_count = 0;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query_count);
			while (rs.next()) {
				row_count = rs.getInt("Count");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
		String[][] info = new String[row_count][2];
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				info[i][0] = Integer.toString(rs.getInt("ContestantID"));
				info[i][1] = rs.getString("ContestantName");
				i++;
			}
			st.close();
			return info;
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
			return null;
		}
	}

	public String[][] getScoreInfoFromContestantIDAndRoundName(int ContestantID, String RoundName) {
		/*
		 * SELECT Ev.EvaluationType, Ev.PercentWeight, T.Score FROM (SELECT
		 * EvaluationID, Score FROM EvaluationScore WHERE ContestantID = 1) T,
		 * Evaluation Ev WHERE T.EvaluationID = Ev.EvaluationID AND
		 * Ev.RoundName = 'CS348';
		 */

		/* EVALUATIONTYPE PERCENTWEIGHT GRADE */
		/* Homework 1 5 100 */
		/* Homework 2 5 80 */
		/* Project 1 10 100 */
		/* Project 3 10 100 */
		/* Midterm 20 93 */

		String query = "SELECT Ev.EvaluationType, Ev.PercentWeight, T.Score "
				+ "FROM (SELECT EvaluationID, Score FROM EvaluationScore WHERE ContestantID = "
				+ ContestantID
				+ ") T, Evaluation Ev WHERE T.EvaluationID = Ev.EvaluationID AND Ev.RoundName = '"
				+ RoundName + "'";
		String query_count = "SELECT COUNT(*) as Count FROM (" + query + ") X";
		// System.out.println(query);
		// System.out.println(query_count);
		int row_count = 0;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query_count);
			while (rs.next()) {
				row_count = rs.getInt("Count");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
		String[][] info = new String[row_count][3];
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				info[i][0] = rs.getString("EvaluationType");
				info[i][1] = Integer.toString(rs.getInt("PercentWeight"));
				info[i][2] = Integer.toString(rs.getInt("Score"));
				i++;
			}
			st.close();
			return info;
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
			return null;
		}

	}

	public double getCurrentScoreFromContestantIDAndRoundName(int ContestantID, String RoundName) {
		// SELECT SUM(Ev.PercentWeight * EvG.Score / 100.0) as CurrentScore FROM
		// EvaluationScore EvG JOIN Evaluation Ev ON EvG.EvaluationID =
		// Ev.EvaluationID AND ContestantID = 1 GROUP BY Ev.RoundName HAVING
		// Ev.RoundName = 'CS348';
		
		/******************************************************************************************************************/
		/*String query = "SELECT SUM(Ev.PercentWeight * EvG.Score / 100.0) as CurrentScore "
				+ "FROM EvaluationScore EvG JOIN Evaluation Ev ON EvG.EvaluationID = Ev.EvaluationID AND ContestantID = "
				+ ContestantID + " GROUP BY Ev.RoundName HAVING Ev.RoundName = '" + RoundName + "'";*/
		
		String query = "SELECT SUM(Ev.PercentWeight * EvG.Score) as CurrentScore "
				+ "FROM EvaluationScore EvG JOIN Evaluation Ev ON EvG.EvaluationID = Ev.EvaluationID AND ContestantID = "
				+ ContestantID + " GROUP BY Ev.RoundName HAVING Ev.RoundName = '" + RoundName + "'";
		/******************************************************************************************************************/
		double score = 0;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				score = rs.getDouble("CurrentScore");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
		return score;

	}

	public String[][] getEvaluationCalendarByContestant(int ContestantID) {
		/******************************************************************************************************************/
		/*String query = "SELECT Ev.RoundName, Ev.EvaluationType, Ev.DeadlineDate " +
				"FROM (SELECT C.RoundName FROM Round C JOIN Enrollment E ON C.RoundName = E.RoundName WHERE E.ContestantID = "
				+ ContestantID + ") T JOIN Evaluation Ev ON T.RoundName = Ev.RoundName";*/
		
		String query = "SELECT Ev.RoundName, Ev.EvaluationType, Ev.DeadlineDate " +
				"FROM (SELECT C.RoundName FROM Round C JOIN Enrollment E WHERE E.ContestantID = "
				+ ContestantID + ") T JOIN Evaluation Ev ON T.RoundName = Ev.RoundName";
		/******************************************************************************************************************/
		String query_count = "SELECT COUNT(*) as Count FROM (" + query + ") X";
//		System.out.println(query);
//		System.out.println(query_count);
		int row_count = 0;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query_count);
			while (rs.next()) {
				row_count = rs.getInt("Count");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
//		System.out.println(row_count);
		String[][] data = new String[row_count][3];
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				data[i][0] = rs.getString("RoundName");
				data[i][1] = rs.getString("EvaluationType");
				data[i][2] = rs.getDate("DeadlineDate").toString();
				i++;
			}
			st.close();
			return data;
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
			return null;
		}
	}

	public String[][] getRoundReportByContestant(int ContestantID) {
		// SELECT C.RoundName, C.Period, C.Year, C.TestTime, C.TestRoom FROM
		// Round C, (SELECT RoundName FROM Enrollment where ContestantID = 1) T
		// WHERE T.RoundName = C.RoundName;
		/******************************************************************************************************************/
		/*String query = "SELECT C.RoundName, C.Period, C.Year, C.TestTime, C.TestRoom "
				+ "FROM Round C, (SELECT RoundName FROM Enrollment where ContestantID = "
				+ ContestantID + ") T WHERE T.RoundName = C.RoundName";*/
		
		String query = "SELECT C.RoundName, C.Period, C.Year, C.TestTime, C.TestRoom "
				+ "FROM Round C";
		/******************************************************************************************************************/
		String query_count = "SELECT COUNT(*) as Count FROM (" + query + ") X";
//		System.out.println(query);
//		System.out.println(query_count);
		int row_count = 0;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query_count);
			while (rs.next()) {
				row_count = rs.getInt("Count");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}
//		System.out.println(row_count);
		String[][] data = new String[row_count][5];
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				String RoundName = rs.getString("RoundName");
				String Period = rs.getString("Period");
				String Year = Integer.toString(rs.getInt("Year"));
				String TestTime = rs.getString("TestTime");
				String TestRoom = rs.getString("TestRoom");
				data[i][0] = RoundName;
				data[i][1] = Period;
				data[i][2] = Year;
				data[i][3] = TestTime;
				data[i][4] = TestRoom;
				i++;
			}
			st.close();
			return data;
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
			return null;
		}
	}

	public String[][] getScoreReportByContestant(int ContestantID) {
		String[] rounds = getRoundListFromContestantID(ContestantID);
		int row_count = 0;
		/******************************************************************************************************************/
		/*for (int i = 0; i < rounds.length; i++) {
			String[][] scoreInfo = getScoreInfoFromContestantIDAndRoundName(ContestantID, rounds[i]);
			row_count += scoreInfo.length + 1;
		}
		String[][] data = new String[row_count][4];
		int current_row = 0;
		for (int i = 0; i < rounds.length; i++) {
			String[][] scoreInfo = getScoreInfoFromContestantIDAndRoundName(ContestantID, rounds[i]);

			for (int j = 0; j < scoreInfo.length; j++) {
				data[current_row][0] = rounds[i];
				data[current_row][1] = scoreInfo[j][0];
				data[current_row][2] = scoreInfo[j][1];
				data[current_row][3] = scoreInfo[j][2];

				current_row++;
			}
			// current final score
			data[current_row][0] = rounds[i];
			data[current_row][1] = "<<Current Final Score>>";
			data[current_row][2] = "";
			data[current_row][3] = Double.toString(getCurrentScoreFromContestantIDAndRoundName(
					ContestantID, rounds[i]));
			current_row++;
		}*/
		int m = 0;
		int n = 0;
		while (++m < rounds.length) {
			String[][] scoreInfo = getScoreInfoFromContestantIDAndRoundName(ContestantID, rounds[m]);
			row_count += scoreInfo.length + 1;
		}
		String[][] data = new String[row_count][4];
		int current_row = 0;
		while(++n< rounds.length) {
			String[][] scoreInfo = getScoreInfoFromContestantIDAndRoundName(ContestantID, rounds[n]);

			for (int j = 0; j < scoreInfo.length; j++) {
				data[current_row][0] = rounds[n];
				data[current_row][1] = scoreInfo[j][0];
				data[current_row][2] = scoreInfo[j][1];
				data[current_row][3] = scoreInfo[j][2];

				current_row++;
			}
			// current final score
			data[current_row][0] = rounds[n];
			data[current_row][1] = "<<Current Final Score>>";
			data[current_row][2] = "";
			data[current_row][3] = Double.toString(getCurrentScoreFromContestantIDAndRoundName(
					ContestantID, rounds[n]));
			current_row++;
		}
		/******************************************************************************************************************/
		return data;
	}

	public String[] getRoundListFromContestantID(int ContestantID) {
		/******************************************************************************************************************/
		String query = "SELECT C.RoundName FROM Round C JOIN Enrollment E ON C.RoundName = E.RoundName WHERE E.ContestantID = "
				+ ContestantID;
	
		/*String query = "SELECT C.RoundName FROM Round C JOIN Enrollment E ON C.RoundName = E.RoundName"*/;
		/******************************************************************************************************************/
		String query_count = "SELECT COUNT(*) as Count FROM (" + query + ") X";
		int row_count = 0;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query_count);
			while (rs.next()) {
				row_count = rs.getInt("Count");
			}
			st.close();
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
		}

		String[] rounds = new String[row_count];
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				String RoundName = rs.getString("RoundName");
				rounds[i] = RoundName;
				i++;
			}
			st.close();
			return rounds;
		} catch (SQLException e) {
			System.out.println("Something is wrong");
			e.printStackTrace();
			return null;
		}
	}

}
