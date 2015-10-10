CREATE TABLE participant_listings (
  id                  INT NOT NULL AUTO_INCREMENT,
  participant_id      INT NOT NULL,
  participant_list_id INT NOT NULL,
  updated_at         DATETIME,
  created_at         DATETIME,
  PRIMARY KEY (id)
)