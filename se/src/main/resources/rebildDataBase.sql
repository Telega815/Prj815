DROP TABLE IF EXISTS passwords;
DROP TABLE IF EXISTS files;
DROP TABLE IF EXISTS users;

CREATE TABLE users(
  uid SERIAL PRIMARY KEY,
  name VARCHAR(200)
);


CREATE TABLE files(
  fid SERIAL PRIMARY KEY,
  owner_id int REFERENCES users(uid),
  filename VARCHAR(200)
);


CREATE TABLE passwords(
  pid SERIAL PRIMARY KEY,
  owner_id int REFERENCES users(uid),
  salt VARCHAR(100),
  pwd VARCHAR(100)
);