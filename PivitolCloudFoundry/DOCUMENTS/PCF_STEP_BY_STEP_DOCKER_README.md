### To Build the Source Code 
* $ mvn clean package 

### To Build the Docker image 
* $ docker build -t espark-springboot-sample:latest .

### To view in the local docker repository 
* $ docker image ls 


### STEP BY STEP DOCKER IMAGE TO PFC
----
### Sign in to PWS:
* $ cf login -a https://api.run.pivotal.io

### Create a space
* cf create-space <SPACE_NAME> [-o ORG] [-q SPACE_QUOTA]
* $ cf create-space espark-space -o espark-adarsh

### Target the space of the pcf
* $ cf target [-o ORG] -s <SPACE_NAME>
* $ cf target -o espark-adarsh -s espark-space

### To push the docker image to the pivitol cloud foundry
* $ cf push APP-NAME --docker-image REPO/IMAGE:TAG
* $ cf push <application-name> --docker-image <docker repository>:<tags>
* Example
* $ cf push espark-springboot-sample --docker-image adarshkumarsingh83/espark:espark-springboot-sample -i 1 -m 128M

### To View the logs
* $ cf logs espark-springboot-sample --recent

### To list the apps in PCF
* $ cf apps
----