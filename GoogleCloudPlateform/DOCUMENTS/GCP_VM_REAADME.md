## 1 step:
```
compute -> vm instance -> create 
name = xxxxx
zone = xxxxx
machine type = xxxx 
boot disk = xxxx
Firewall = allow http traffic 
           allow https traffic 
```   

## 2 step: 
```          
management 
 available policy -> Preemption = on  (same as spot price of aws)          
```

## 3 step: 
```
security tab 
ssh keys (locally for vm)

#To generate the ssh key pair
$ ssh-keygen -t rsa -f ~/.ssh/gcp_rsa -C espark
Enter Enter: espark
Enter same Enter again: espark 

#To verify the ssh key 
$ cd ~/.ssh

$ ls -ll 
gcp_rsa
gcp_rsa.pub

#To Provide permission to the rsa file 
$ chmod 400 gcp_rsa

$ cat gcp_rsa.pub 
Note:gcp_rsa.pub which is need to copy to the gcp 

or (globally
 compute engine -> metadata -> ssh 
 
 -> create    
```

## 4 step: 
```
 copy external ip xxxxxxxxxx
  
#to login into the server 
$ ssh <username>@<external id> 
$ ssh -i gcp_rsa <username>@<external ip>

-----------------------------------------------------------------------
Ubuntu Server 
$ sudo apt-get update 
$ sudo apt install curl
$ sudo apt-get install apache2
$ curl http://<external ip> 

$ sudo /etc/init.d/apache2 start 
$ sudo /etc/init.d/apache2 stop 
$ sudo /etc/init.d/apache2 restart

$ cd /var/www/html
$ ls 
index.html  
#granting the permission 
$ sudo chmod 777 index.html  
change the content of index.html create a new file 
-----------------------------------------------------------------------
To Download the file zilla 
https://filezilla-project.org/download.php

FileZilla 
-> settings -> Ftp -> Sftp -> Add key file -> select the gcp_rsa (private key file)
-> ask for conversion -> pass phase of private key - > save the file gcp_rsa.ppk 
-> ok 

SiteManager -> new site -> 
hostname = external ip of the server 
protocol = sftp 
login by = key file 
user name = <server user name>
key file= brose for key file which is saved as gcp_rsa.ppk 
-> connect 
-> add in trusted host and provide the pass phase 
```
 
 