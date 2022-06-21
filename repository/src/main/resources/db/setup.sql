create database if not exists hsquare_db;

create user if not exists 'hsquare_user'@'localhost' identified by 'fabian';
grant all privileges on hsquare_db.* to 'hsquare_user'@'localhost';
flush privileges;

