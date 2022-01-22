CREATE TABLE member (
	memNo INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    memEmail VARCHAR(30) NOT NULL,
    memPwd VARCHAR(20) NOT NULL,
    memName VARCHAR(30)
);

CREATE TABLE diary (
	diaryNo INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    diaryDate VARCHAR(30),
    diaryEmoji VARCHAR(10),
    diaryText VARCHAR(2048),
    memNo INT,
	CONSTRAINT FK_diary_member FOREIGN KEY (memNo) REFERENCES member (memNo) ON DELETE CASCADE
);

CREATE TABLE profile (
	fileNo INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    memNo INT,
    serverFileName VARCHAR(500),
    originFileName VARCHAR(300),
    filePath  VARCHAR(500),
    CONSTRAINT FK_profile_member FOREIGN KEY (memNo) REFERENCES member (memNo) ON DELETE CASCADE
);
