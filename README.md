[![Build Status](https://travis-ci.org/Brest-Java-Course-2019/HumanResources.svg?branch=master)](https://travis-ci.org/Brest-Java-Course-2019/HumanResources)
[![Coverage Status](https://coveralls.io/repos/github/Brest-Java-Course-2019/HumanResources/badge.svg?branch=master)](https://coveralls.io/github/Brest-Java-Course-2019/HumanResources?branch=master)

# HumanResources
Human Resources demo application


## How build

Setup java 8 and Maven, see [enviroment_setup.md](enviroment_setup.md) 
  
    
### build project 

Goto Project folder and execute  
    
    mvn clean install

### Server test

For server test jetty plugin can be used

    mvn jetty:run 
    
Open [http://localhost:8080](http://localhost:8080/hello)    