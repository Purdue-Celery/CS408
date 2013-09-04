INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (1, 'Yuxi Chen', 's1');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (2, 'Yibo Ma', 's2');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (3, 'Yuheng Huang', 's3');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (4, 'Junyu Chen', 's4');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (5, 'Xi Zhu', 's5');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (6, 'Pan Ma', 's6');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (7, 'Zhongjun Jin', 's7');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (8, 'Zeying Guo', 's8');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (9, 'Yilin Long', 's9');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (10, 'Zhiyuan Zheng', 's10');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (11, 'Hongyuan Wang', 's11');
INSERT INTO Contestant (ContestantID, ContestantName, ContestantPW) VALUES (12, 'Mengchao Wang', 's12');

INSERT INTO Judge (JudgeID, JudgeName, JudgePW) VALUES (1, 'Walid Aref', 'f1');
INSERT INTO Judge (JudgeID, JudgeName, JudgePW) VALUES (2, 'Mikhail Atallah', 'f2');
INSERT INTO Judge (JudgeID, JudgeName, JudgePW) VALUES (3, 'Buster Dunsmore', 'f3');
INSERT INTO Judge (JudgeID, JudgeName, JudgePW) VALUES (4, 'Gustavo Rivera', 'f4');

INSERT INTO Round (RoundName, Period, Year, TestTime, TestRoom, JudgeID) VALUES ('CS348', 'Spring', 2013, '11:30 AM', 'LWSN B151', 1);
INSERT INTO Round (RoundName, Period, Year, TestTime, TestRoom, JudgeID) VALUES ('CS381', 'Spring', 2013, '10:30 AM', 'LWSN B155', 2);
INSERT INTO Round (RoundName, Period, Year, TestTime, TestRoom, JudgeID) VALUES ('CS426', 'Spring', 2013, '4:30 PM', 'HASS G066', 2);
INSERT INTO Round (RoundName, Period, Year, TestTime, TestRoom, JudgeID) VALUES ('CS307', 'Spring', 2013, '8:30 AM', 'HASS G066', 3);
INSERT INTO Round (RoundName, Period, Year, TestTime, TestRoom, JudgeID) VALUES ('CS250', 'Spring', 2013, '11:30 AM', 'WTHR 200', 4);
INSERT INTO Round (RoundName, Period, Year, TestTime, TestRoom, JudgeID) VALUES ('CS252', 'Spring', 2013, '1:30 PM', 'WTHR 200', 4);
INSERT INTO Round (RoundName, Period, Year, TestTime, TestRoom, JudgeID) VALUES ('CS390', 'Spring', 2013, '12:30 PM', 'LWSN B155', 4);

INSERT INTO Enrollment (ContestantID, RoundName) VALUES (1, 'CS348');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (2, 'CS348');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (3, 'CS348');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (4, 'CS348');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (5, 'CS348');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (6, 'CS348');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (12, 'CS348');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (1, 'CS426');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (11, 'CS426');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (12, 'CS426');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (1, 'CS381');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (2, 'CS381');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (3, 'CS381');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (4, 'CS381');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (5, 'CS381');
INSERT INTO Enrollment (ContestantID, RoundName) VALUES (11, 'CS381');

INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS348', 'Homework 1', 5, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS348', 'Homework 2', 5, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS348', 'Homework 3', 5, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS348', 'Homework 4', 5, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS348', 'Project 1', 10, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS348', 'Project 2', 10, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS348', 'Project 3', 10, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS348', 'Midterm', 20, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS348', 'Final', 30, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS381', 'Homework', 20, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS381', 'Project', 20, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS381', 'Midterm', 20, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS381', 'Final', 20, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS426', 'Homework', 20, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS426', 'Project', 15, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS426', 'Midterm', 30, '2013-05-03');
INSERT INTO Evaluation (RoundName, EvaluationType, PercentWeight, DeadlineDate) VALUES ('CS426', 'Final', 35, '2013-05-03');

--
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (1, 1, 100);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (2, 1, 80);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (1, 2, 100);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (2, 2, 90);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (1, 3, 100);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (2, 3, 75);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (1, 4, 100);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (2, 4, 95);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (5, 1, 100);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (7, 1, 100);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (8, 1, 93);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (10, 1, 83);
INSERT INTO EvaluationScore (EvaluationID, ContestantID, Score) VALUES (12, 1, 75);

INSERT INTO Notice (RoundName, Content) VALUES ('CS348', 'Test Notice');
INSERT INTO Notice (RoundName, Content) VALUES ('CS348', 'Test Notice');
INSERT INTO Notice (RoundName, Content) VALUES ('CS348', 'Test Notice');
INSERT INTO Notice (RoundName, Content) VALUES ('CS381', 'Test Notice');
INSERT INTO Notice (RoundName, Content) VALUES ('CS381', 'Test Notice');
INSERT INTO Notice (RoundName, Content) VALUES ('CS426', 'Test Notice');
INSERT INTO Notice (RoundName, Content) VALUES ('CS426', 'Test Notice');

