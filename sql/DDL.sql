use handywork;

CREATE TABLE images_urls
  (
     job_id    BIGINT NOT NULL,
     image_url VARCHAR(255)
  )
engine=innodb;

CREATE TABLE `job-reviews`
  (
     id           BIGINT NOT NULL auto_increment,
     publish_date DATETIME NOT NULL,
     rating       TINYINT NOT NULL,
     review_text  TEXT NOT NULL,
     type         VARCHAR(255) NOT NULL,
     update_date  DATETIME,
     job_id       BIGINT NOT NULL,
     user_id      BIGINT NOT NULL,
     PRIMARY KEY (id)
  )
engine=innodb;

CREATE TABLE jobs
  (
     id           BIGINT NOT NULL auto_increment,
     description  TEXT NOT NULL,
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

CREATE TABLE users
  (
     id              BIGINT NOT NULL auto_increment,
     email           VARCHAR(255) NOT NULL,
     first_name      VARCHAR(36),
     last_name       VARCHAR(36),
     password        VARCHAR(36) NOT NULL,
     profile_picture VARCHAR(255),
     phone_number    VARCHAR(10) NOT NULL,
     username        VARCHAR(36) NOT NULL,
     PRIMARY KEY (id)
  )
engine=innodb;

ALTER TABLE users
  ADD CONSTRAINT UNIQUE_EMAIL UNIQUE (email);

ALTER TABLE users
  ADD CONSTRAINT UNIQUE_PHONE_NUMBER UNIQUE (phone_number);

ALTER TABLE users
  ADD CONSTRAINT UNIQUE_USERNAME UNIQUE (username);

ALTER TABLE images_urls
  ADD CONSTRAINT JOB_FOREIGN_KEY FOREIGN KEY (job_id) REFERENCES jobs (id);

ALTER TABLE `job-reviews`
  ADD CONSTRAINT JOB_FOREIGN_KEY FOREIGN KEY (job_id) REFERENCES jobs (id);
  ADD CONSTRAINT USER_FOREIGN_KEY FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE jobs
  ADD CONSTRAINT USER_DONE_BY_FOREIGN_KEY FOREIGN KEY (done_by_id) REFERENCES users (id);
  ADD CONSTRAINT USER_OWNER_FOREIGN_KEY FOREIGN KEY (owner_id) REFERENCES users (id); 
