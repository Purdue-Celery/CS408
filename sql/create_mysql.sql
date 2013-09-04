CREATE TABLE Contestant (
  ContestantID integer NOT NULL,
  ContestantName varchar(20) NULL,
  ContestantPW varchar(20) NULL,
  PRIMARY KEY (ContestantID)
);

CREATE TABLE Judge (
  JudgeID integer NOT NULL,
  JudgeName varchar(20) NULL,
  JudgePW varchar(20) NULL,
  PRIMARY KEY (JudgeID)
);

CREATE TABLE Round (
  RoundName varchar(20) NOT NULL,
  Period varchar(20) NULL,
  Year integer NULL,
  TestTime varchar(20) NULL,
  TestRoom varchar(20) NULL,
  JudgeID integer NULL REFERENCES Judge (JudgeID),
  PRIMARY KEY (RoundName)
);

CREATE TABLE Enrollment (
  ContestantID integer NOT NULL REFERENCES Contestant (ContestantID),
  RoundName varchar(20) NOT NULL REFERENCES Round (RoundName),
  PRIMARY KEY (ContestantID,RoundName)
);

CREATE TABLE Evaluation (
  EvaluationID integer NOT NULL AUTO_INCREMENT,
  RoundName varchar(20) NULL REFERENCES Round (RoundName),
  EvaluationType varchar(20) NULL,
  PercentWeight integer NULL,
  DeadlineDate date NULL,
  PRIMARY KEY (EvaluationID)
);

CREATE TABLE EvaluationScore (
  EvaluationID integer NOT NULL REFERENCES Evaluation (EvaluationID),
  ContestantID integer NOT NULL REFERENCES Contestant (ContestantID),
  Score integer NULL,
  PRIMARY KEY (EvaluationID,ContestantID)
);

CREATE TABLE Notice (
  NoticeID integer NOT NULL AUTO_INCREMENT,
  RoundName varchar(20) NULL REFERENCES Round (RoundName),
  Content varchar(50) NULL,
  PRIMARY KEY (NoticeID)
);
