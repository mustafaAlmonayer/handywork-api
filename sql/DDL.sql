use handywork;

DROP TABLE IF EXISTS image_url;
DROP TABLE IF EXISTS job_review;
DROP TABLE IF EXISTS job;
DROP TABLE IF EXISTS user;

CREATE TABLE user
  (
     id              BIGINT NOT NULL auto_increment,
     email           VARCHAR(255) NOT NULL,
     city            VARCHAR(255) NOT NULL,
     first_name      VARCHAR(36),
     last_name       VARCHAR(36),
     password        VARCHAR(255) NOT NULL,
     profile_picture VARCHAR(255),
     phone_number    VARCHAR(10) NOT NULL,
     username        VARCHAR(36) NOT NULL,
     PRIMARY KEY (id)
  )
engine=innodb;

ALTER TABLE user
  ADD CONSTRAINT UNIQUE_EMAIL UNIQUE (email),
  ADD CONSTRAINT UNIQUE_PHONE_NUMBER UNIQUE (phone_number),
  ADD CONSTRAINT UNIQUE_USERNAME UNIQUE (username);


CREATE TABLE job
  (
     id           BIGINT NOT NULL auto_increment,
     description  TEXT NOT NULL,
     city         VARCHAR(255) NOT NULL,
     field        VARCHAR(50) NOT NULL,
     is_done      BIT NOT NULL DEFAULT 0,
     job_name     VARCHAR(50) NOT NULL,
     pay          DECIMAL(6, 2) NOT NULL,
     publish_date DATETIME NOT NULL,
     update_date  DATETIME,
     done_by_id   BIGINT,
     owner_id     BIGINT NOT NULL,
     PRIMARY KEY (id)
  )
engine=innodb;

ALTER TABLE job
  ADD CONSTRAINT USER_DONE_BY_FOREIGN_KEY FOREIGN KEY (done_by_id) REFERENCES user (id),
  ADD CONSTRAINT USER_OWNER_FOREIGN_KEY FOREIGN KEY (owner_id) REFERENCES user (id); 

CREATE TABLE image_url
  (
     id        BIGINT NOT NULL auto_increment,
     job_id    BIGINT NOT NULL,
     url VARCHAR(255),
     PRIMARY KEY (id)
  )
engine=innodb;

ALTER TABLE image_url
  ADD CONSTRAINT JOB_FOREIGN_KEY FOREIGN KEY (job_id) REFERENCES job (id);

CREATE TABLE job_review
  (
     id           BIGINT NOT NULL auto_increment,
     publish_date DATETIME NOT NULL,
     rating       TINYINT NOT NULL,
     review_text  TEXT NOT NULL,
     type         ENUM('JOB_REVIEW', 'USER_REVIEW') NOT NULL,
     update_date  DATETIME,
     job_id       BIGINT NOT NULL,
     user_id      BIGINT NOT NULL,
     PRIMARY KEY (id)
  )
engine=innodb;

ALTER TABLE job_review
  ADD CONSTRAINT JOB_IMAGE_FOREIGN_KEY FOREIGN KEY (job_id) REFERENCES job (id),
  ADD CONSTRAINT USER_FOREIGN_KEY FOREIGN KEY (user_id) REFERENCES user (id);



