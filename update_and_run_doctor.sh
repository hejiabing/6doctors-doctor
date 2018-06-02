#!/bin/bash
#####################################
#     created by wangpengcheng      #
# update and run doctor.jar project #
#####################################

kill -s 9 `ps -aux | grep doctor | awk '{print $2}'`
if [ $? -eq 0 ]; then
    echo "kill doctor.jar success !"
else
    echo "kill doctor.jar fail !"
fi
if [ -d "/root/6doctors-doctor" ]; then
    cd /root/6doctors-doctor
    git pull
    git merge master
    mvn clean package -Dmaven.test.skip=true
    if [ -f "/root/6doctors-doctor/target/doctor-0.0.1-SNAPSHOT.jar" ]; then
        echo "maven package success !"
        mv target/doctor-0.0.1-SNAPSHOT.jar target/doctor.jar
        nohup java -Xmx512M -Xms512M -Djava.security.egd=/dev/urandom -jar /root/6doctors-doctor/target/doctor.jar > /root/doctor.log 2>&1 &
        if [ $? -eq 0 ]; then
            echo "running success !"
        else
            echo "running fail !"
        fi
    else
        echo "maven package fail !"
    fi
else
    echo "the project file not exist !"
fi