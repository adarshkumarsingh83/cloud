#!/bin/sh
#updating the os
sudo yum update -y
#instaling the apache server
sudo yum install -y httpd24
#starting the apache server
sudo service httpd start
#adding the apache in startup of the os 
sudo chkconfig httpd on
#removing the old open jdk
sudo yum remove java-1.7.0-openjdk
#downlading the jdk8 
sudo wget -c --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u5-b13/jdk-8u5-linux-x64.rpm" --output-document="jdk-8u5-linux-x64.rpm"
#adding the jdk8 to the default
sudo rpm -ivh jdk-8u5-linux-x64.rpm