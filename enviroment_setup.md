Update packages

    ~$ sudo apt update

Install OpenJDK 8

    ~$ sudo apt install openjdk-8-jdk
    
   
Verify

    ~$ java -version

### Setting the JAVA_HOME Environment Variable

    sudo nano /etc/environment
    
At the end of this file, add the following line:

    JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/bin/"


Save the file and exit the editor. 

Reload this file to apply the changes to your current session:

    source /etc/environment
    
    
Verify that the environment variable is set:

    echo $JAVA_HOME
    
    
    
### Install Maven

Create '~/Downloads' folder if it is not exists

    ~$ mkdir Downloads
    
    ~$ cd ~/Downloads
    
Download maven

    ~/Downloads$ wget http://ftp.byfly.by/pub/apache.org/maven/maven-3/3.6.0/binaries/apache-maven-3.6.0-bin.tar.gz
    
Extract the apache-maven archive into the 'cd /opt' directory.

    ~$ cd /opt 
    ~$ sudo tar -xvzf ~/Downloads/apache-maven-3.6.0-bin.tar.gz
    
Edit the /etc/environment file and add the M2_HOME environment variable and update PATH:    

    ~$ sudo nano /etc/environment
    
    PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/java-8-openjdk-amd64/bin:/opt/apache-maven-3.6.0/bin"
    JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64"
    M2_HOME="/opt/apache-maven-3.6.0"

Save the file and exit the editor. 

Reload this file to apply the changes to your current session:

    source /etc/environment
    
Verify PATH variable:

    $ echo $PATH    
    
Update the mvn command:

    $ sudo update-alternatives --install "/usr/bin/mvn" "mvn" "/opt/apache-maven-3.6.0/bin/mvn" 0

    update-alternatives: using /opt/apache-maven-3.6.0/bin/mvn to provide /usr/bin/mvn (mvn) in auto mode
    
    $ sudo update-alternatives --set mvn /opt/apache-maven-3.6.0/bin/mvn

Add Bash completion to mvn so that you can complete complex Maven commands by hitting Tab multiple times.

    sudo wget https://raw.github.com/dimaj/maven-bash-completion/master/bash_completion.bash --output-document /etc/bash_completion.d/mvn

Verify maven installation

    $ mvn -version

    Maven home: /opt/apache-maven-3.6.0
    Java version: 1.8.0_191, vendor: Oracle Corporation, runtime: /usr/lib/jvm/java-8-openjdk-amd64/jre
    Default locale: en_US, platform encoding: UTF-8
    OS name: "linux", version: "4.15.0-45-generic", arch: "amd64", family: "unix"