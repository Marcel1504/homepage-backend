DROP TABLE IF EXISTS content;
CREATE TABLE content (
  id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  type VARCHAR(20) NOT NULL,
  language VARCHAR(2) NOT NULL,
  version_date DATE NOT NULL,
  data JSON NOT NULL,
  CONSTRAINT c_type_version_date_unique UNIQUE (type, version_date, language)
);

DROP TABLE IF EXISTS chat;
CREATE TABLE chat (
  id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  content JSON NOT NULL,
  last_activity_time_utc DATETIME(6) DEFAULT NULL
);

