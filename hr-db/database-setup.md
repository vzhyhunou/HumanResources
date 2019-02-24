#### PostgreSql Setup instruction for Ubuntu 18.04 LTS

Update packages and install postgresql

    $ sudo apt update   
    
## Setup PostgreSQL    

    $ sudo apt install postgresql postgresql-contrib

## 
Switch over to the postgres account on your server by typing:

    $ sudo -i -u postgres
  
To access a Postgres prompt type:

    postgres@localhost:~$ psql
   
This will log into Postgres.
   
    postgres=# 

You can exit the interactive Postgres session by typing:

    postgres=# \q

Verify installation

    $ ls /etc/postgresql/10/main/
    conf.d  environment  pg_ctl.conf  pg_hba.conf  pg_ident.conf  postgresql.conf  start.conf

PostgreSql configuration stored in the `postgresql.conf`

To check PostgreSql server status use:

    $ service postgresql status
     postgresql.service - PostgreSQL RDBMS
       Loaded: loaded (/lib/systemd/system/postgresql.service; enabled; vendor preset: enabled)
       Active: active (exited) since Sun 2019-02-03 05:00:16 EST; 14min ago
     Main PID: 11524 (code=exited, status=0/SUCCESS)
       CGroup: /system.slice/postgresql.service

All service commands are:

    $ service postgresql
    Usage: /etc/init.d/postgresql {start|stop|restart|reload|force-reload|status} [version ..] 

    postgres@~$ exit

Main commands executed as `postgres` user

    $ sudo su postgres
    [sudo] password for berdachuk: 
    postgres@berdachuk-pc:/home/berdachuk$
    
To execute some postgres commands use `psql` tool 

    postgres@berdachuk-pc:/home/berdachuk$ psql
    psql (10.6 (Ubuntu 10.6-0ubuntu0.18.04.1))
    Type "help" for help.
    
    postgres=# 

List current databases

    postgres=# \l   
                                            List of databases
       Name    |  Owner   | Encoding |   Collate   |    Ctype    |   Access privileges   
    -----------+----------+----------+-------------+-------------+-----------------------
     postgres  | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
     template0 | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/postgres          +
               |          |          |             |             | postgres=CTc/postgres
     template1 | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/postgres          +
               |          |          |             |             | postgres=CTc/postgres
    (3 rows)

List current users

    postgres-# \du
                                       List of roles
     Role name |                         Attributes                         | Member of 
    -----------+------------------------------------------------------------+-----------
     postgres  | Superuser, Create role, Create DB, Replication, Bypass RLS | {}
    
Change default user password

    postgres=# ALTER USER postgres WITH PASSWORD 'postgres123';
    ALTER ROLE
    postgres=# 

Its not a good practice use default user to databases, lets create new user

    postgres=# CREATE USER hrdba WITH PASSWORD 'admin123';
    CREATE ROLE


List created user

    postgres=# \du
                                       List of roles
     Role name |                         Attributes                         | Member of 
    -----------+------------------------------------------------------------+-----------
     hrdba     |                                                            | {}
     postgres  | Superuser, Create role, Create DB, Replication, Bypass RLS | {}


Grant privileges to user

    postgres=# ALTER USER hrdba WITH SUPERUSER CREATEROLE CREATEDB;
    
    postgres=# \du
                                       List of roles
     Role name |                         Attributes                         | Member of 
    -----------+------------------------------------------------------------+-----------
     hrdba     | Superuser, Create role, Create DB                          | {}
     postgres  | Superuser, Create role, Create DB, Replication, Bypass RLS | {}


Create database.

    postgres=# CREATE DATABASE hrdb WITH ENCODING='UTF8' OWNER=hrdba;
    CREATE DATABASE
    postgres=# \l
                                      List of databases
       Name    |  Owner   | Encoding |   Collate   |    Ctype    |   Access privileges   
    -----------+----------+----------+-------------+-------------+-----------------------
     hrdb      | hrdba | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
     postgres  | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
     template0 | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/postgres          +
               |          |          |             |             | postgres=CTc/postgres
     template1 | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/postgres          +
               |          |          |             |             | postgres=CTc/postgres
    (4 rows)
    
    postgres=# 

You can install pgAdmin or dbeaver UI for simplify work with database.



























