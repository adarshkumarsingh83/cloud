

### To login into the pcf 
* $ cf login -a https://api.run.pivotal.io

### Create a space
* $ cf create-space <SPACE_NAME> [-o ORG] [-q SPACE_QUOTA]
* $ cf create-space espark-space -o espark-adarsh

### Target the space of the pcf
* $ cf target [-o ORG] -s <SPACE_NAME>
* $ cf target -o espark-adarsh -s espark-space

### To push the application jar file to the pcf 
* $ cf push <application-name> -p <target/jar file-0.0.1-SNAPSHOT.jar>
* $ cf logs espark-environment --recent $ cf push espark-environment -p target/employee-producer-0.0.1-SNAPSHOT.jar
 
### To list the apps in PCF
* $ cf apps
 
### To view the logs 
* $ cf logs <application-name>  --recent
* $ cf logs espark-environment  --recent
 
### To delte the application 
* $ cf delete <application-name>t -r -f
* $ cf delete espark-environment -r -f
 
### To delete the space
* $ cf delete-space <SPACE_NAME> [-o ORG]
* $ cf delete-space  espark-space -o espark-adarsh

### logout from PWS
* $ cf logout
