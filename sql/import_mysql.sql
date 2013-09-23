INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (1, 'Contestant A', '1');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (2, 'Contestant B', '2');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (3, 'Contestant C', '3');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (4, 'Contestant D', '4');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (5, 'Contestant E', '5');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (6, 'Contestant F', '6');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (7, 'Contestant G', '7');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (8, 'Contestant H', '8');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (9, 'Contestant I', '9');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (10, 'Contestant J', '10');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (11, 'Contestant K', '11');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (12, 'Contestant L', '12');

INSERT INTO Judge (JudgeID, JudgeName, JudgePW) VALUES (1, 'Judge A', '1');
INSERT INTO Judge (JudgeID, JudgeName, JudgePW) VALUES (2, 'Judge B', '2');
INSERT INTO Judge (JudgeID, JudgeName, JudgePW) VALUES (3, 'Judge C', '3');
INSERT INTO Judge (JudgeID, JudgeName, JudgePW) VALUES (4, 'Judge D', '4');

INSERT INTO Round (RoundName, Period, Year, TestTime, TestRoom, JudgeID) VALUES ('Round 1', 'Fall', 2013, '11:30 AM', 'Room 1', 1);
INSERT INTO Round (RoundName, Period, Year, TestTime, TestRoom, JudgeID) VALUES ('Round 2', 'Fall', 2013, '10:30 AM', 'Room 2', 1);
INSERT INTO Round (RoundName, Period, Year, TestTime, TestRoom, JudgeID) VALUES ('Round 3', 'Fall', 2013, '4:30 PM', 'Room 3', 2);
INSERT INTO Round (RoundName, Period, Year, TestTime, TestRoom, JudgeID) VALUES ('Round 4', 'Fall', 2013, '8:30 AM', 'Room 4', 3);
INSERT INTO Round (RoundName, Period, Year, TestTime, TestRoom, JudgeID) VALUES ('Round 5', 'Fall', 2013, '11:30 AM', 'Room 5', 4);

INSERT INTO Enrollment (ContestantID, RoundName) VALUES (1, 'Round 1');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (2, 'Round 1');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (3, 'Round 1');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (4, 'Round 1');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (5, 'Round 1');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (6, 'Round 1');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (12, 'Round 1');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (1, 'Round 2');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (11, 'Round 2');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (12, 'Round 2');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (1, 'Round 3');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (2, 'Round 3');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (3, 'Round 3');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (4, 'Round 3');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (5, 'Round 3');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (11, 'Round 3');

INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('Round 1', 'Singing', 50, '2013-12-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('Round 1', 'Dancing', 25, '2013-12-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('Round 1', 'Interaction', 25, '2013-12-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('Round 2', 'Singing', 50, '2013-12-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('Round 2', 'Dancing', 25, '2013-12-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('Round 2', 'Interaction', 25, '2013-12-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('Round 3', 'Singing', 50, '2013-12-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('Round 3', 'Dancing', 25, '2013-12-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('Round 3', 'Interaction', 25, '2013-12-03');

--
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (1, 1, 100);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (2, 1, 80);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (1, 2, 100);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (2, 2, 90);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (1, 3, 100);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (2, 3, 75);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (1, 4, 100);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (2, 4, 95);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (3, 1, 100);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (4, 1, 100);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (5, 1, 93);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (6, 1, 83);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (7, 1, 75);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (8, 1, 83);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (9, 1, 75);

INSERT INTO Notice (RoundName, Content) VALUES ('Round 1', 'Test Notice');
INSERT INTO Notice (RoundName, Content) VALUES ('Round 1', 'Test Notice');
INSERT INTO Notice (RoundName, Content) VALUES ('Round 1', 'Test Notice');
INSERT INTO Notice (RoundName, Content) VALUES ('Round 2', 'Test Notice');
INSERT INTO Notice (RoundName, Content) VALUES ('Round 2', 'Test Notice');
INSERT INTO Notice (RoundName, Content) VALUES ('Round 3', 'Test Notice');
INSERT INTO Notice (RoundName, Content) VALUES ('Round 3', 'Test Notice');

