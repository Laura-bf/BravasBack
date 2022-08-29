CREATE TABLE IF NOT EXISTS Users (
  user_uuid VARCHAR(36) NOT NULL,
  user_name VARCHAR(15) NOT NULL,
  email VARCHAR(45) NOT NULL,
  password VARCHAR(15) NOT NULL,
  enabled BOOLEAN NOT NULL DEFAULT 0,
  PRIMARY KEY (user_uuid)
 );


CREATE TABLE IF NOT EXISTS Groups (
  group_uuid VARCHAR(36) NOT NULL,
  group_name VARCHAR(45) NOT NULL,
  pic BLOB NULL,
  description VARCHAR(200) NULL,
  owner VARCHAR(36) NOT NULL,
  PRIMARY KEY (group_uuid),
  FOREIGN KEY (owner) 
  	REFERENCES Users(user_uuid)
  		ON DELETE NO ACTION
    	ON UPDATE NO ACTION)
;

CREATE TABLE IF NOT EXISTS Groups_has_Users (
  Users_idUsers VARCHAR(36) NOT NULL,
  Groups_idGroups VARCHAR(36) NOT NULL,
  isAdmin BOOLEAN NOT NULL DEFAULT 0,
  PRIMARY KEY (Users_idUsers, Groups_idGroups),
  FOREIGN KEY (Groups_idGroups)
  	REFERENCES Groups (group_uuid)
    	ON DELETE NO ACTION
    	ON UPDATE NO ACTION,
  FOREIGN KEY (Users_idUsers)
    REFERENCES Users (user_uuid)
    	ON DELETE NO ACTION
    	ON UPDATE NO ACTION)
;

CREATE TABLE IF NOT EXISTS Posts (
  post_uuid VARCHAR(36) NOT NULL,
  title VARCHAR(45) NOT NULL,
  date DATETIME NOT NULL,
  body LONGTEXT NOT NULL,
  Groups_idGroups VARCHAR(36) NOT NULL,
  Users_idUsers VARCHAR(36) NOT NULL,
  PRIMARY KEY (post_uuid),
  FOREIGN KEY (Groups_idGroups)
    REFERENCES Groups (group_uuid)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (Users_idUsers)
    REFERENCES Users (user_uuid)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE TABLE IF NOT EXISTS Comments (
  comment_uuid VARCHAR(36) NOT NULL,
  comment_text VARCHAR(45) NOT NULL,
  date DATETIME NOT NULL,
  Users_idUsers VARCHAR(36) NOT NULL,
  Posts_idPosts VARCHAR(36) NOT NULL,
  PRIMARY KEY (comment_uuid),
  FOREIGN KEY (Users_idUsers)
    REFERENCES Users (user_uuid)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (Posts_idPosts)
    REFERENCES Posts (post_uuid)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE TABLE IF NOT EXISTS Likes (
  like_uuid VARCHAR(36) NOT NULL,
  Users_idUsers VARCHAR(36) NOT NULL,
  Posts_idPosts VARCHAR(36) NOT NULL COMMENT 'indica si el ususario está autorizado o no',
  date DATETIME NOT NULL,
  PRIMARY KEY (like_uuid),
  FOREIGN KEY (Users_idUsers)
    REFERENCES Users (user_uuid)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  FOREIGN KEY (Posts_idPosts)
    REFERENCES Posts (post_uuid)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

