DROP TABLE IF EXISTS utility;

CREATE TABLE utility (
                           id int(11) NOT NULL AUTO_INCREMENT,
                           name varchar(100) NOT NULL,
                           author varchar(100) NOT NULL,
                           edition_count int(11) NOT NULL,
                           description text NOT NULL,
                           date_created datetime NOT NULL,
                           last_modified datetime DEFAULT NULL,
                           user_last_modified varchar(100) DEFAULT NULL,
                           repository_id bigint(20) NOT NULL,
                           utility_file_sha varchar(100) DEFAULT NULL,
                           PRIMARY KEY (id),
                           UNIQUE KEY name (name)
)