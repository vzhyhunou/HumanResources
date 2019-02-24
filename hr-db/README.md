## hrdb Database ##

PostgreSql 10 used as main database, see https://www.postgresql.org

Setup instruction: [database-setup.md](database-setup.md) 


## Create database

    CREATE USER hrdba WITH PASSWORD 'admin123';
    
    ALTER USER hrdba WITH SUPERUSER CREATEROLE CREATEDB;
    
    CREATE DATABASE hrdb WITH ENCODING='UTF8' OWNER=hrdba;
    

### migration database scripts

This module contains all database scripts that should be applied on hrdb database with each new feature.  

We are using Flyway Maven plugin to apply changes in database.
By default it works with localhost database, which can be cleared and build again from scratch, so switching between different feature branches that might be not compatible with each other yet is very easy.

Before data migrate change folder

    $ cd ./hr-db

To clean the local database execute command:

    $ mvn flyway:clean

To apply changes from the scripts:

    $ mvn flyway:migrate

You can also execute both commands together:

    $ mvn flyway:clean flyway:migrate
    
    
### Sample queries

    SELECT * FROM DEPT
    
    SELECT * FROM emp ORDER BY firstname
    
    SELECT * FROM emp ORDER BY salary, firstname
    
    SELECT *, salary*10 FROM emp ORDER BY firstname
    
    SELECT *, salary*10 as extra_salary FROM emp ORDER BY firstname
    
    SELECT firstname FROM emp ORDER BY firstname
    
    SELECT DISTINCT firstname FROM emp ORDER BY firstname
    
    SELECT firstname, COUNT(*) FROM emp GROUP BY firstname
    
    SELECT firstname, COUNT(*) FROM emp GROUP BY firstname HAVING COUNT(*) > 1
    
    SELECT MAX(emp_id), MAX(firstname)  MAX FROM emp
    UNION 
    SELECT 5, 'BlaBlaBla' FROM emp
    
    select S.* from
    (SELECT MAX(emp_id) as ID, MAX(firstname)  MAX FROM emp
    UNION
    SELECT 5  as ID, 'BlaBlaBla' FROM emp) as S
    ORDER BY S.ID DESC
    
    SELECT LENGTH(firstname) FROM emp
    
    SELECT firstname FROM emp OFFSET 0 LIMIT 5
    
    SELECT d.dept_id, d.dept_name, e.firstname || ' ' || e.lastname AS fio 
      FROM  dept AS d
    JOIN emp AS e ON (d.dept_id = e.dept_id)
    
    SELECT d.dept_id, d.dept_name, AVG(e.sal)
      FROM  dept AS d
    LEFT JOIN emp AS e ON (d.dept_id = e.dept_id)
    
    SELECT d.dept_id, d.dept_name, AVG(e.salary)
      FROM  dept AS d
    LEFT JOIN emp AS e ON (d.dept_id = e.dept_id)
    GROUP BY d.dept_id, d.dept_name
    ORDER BY d.dept_name

    SELECT d.dept_id, d.dept_name
      FROM dept d
     WHERE d.dep_id 
       IN (SELECT d2.dept_id
             FROM  dept AS d2
           LEFT JOIN emp AS e ON (d2.dept_id = e.dept_id)
           WHERE e.salary > 1000)
           
   SELECT e.emp_id, e.firstname, e.salary
   FROM  emp AS e
   WHERE e.salary > (select AVG(salary) from emp
     where e.dept_id = dept_id)        
           
           
        
    
    