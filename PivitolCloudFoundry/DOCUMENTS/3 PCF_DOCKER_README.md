
### To build the docker tag from the image 
* docker build --rn -t <docker repository url/application-name:tag> <path of dir or dot for current dir> 
* $ docker build --rm -t adarshkumarsingh83/espark-springboot-sample:latest .
 
### To list the images in system 
* $ docker images 
 
### To run the image locally in system
* docker run -d = background -p port <docker image repo :tag>
* $ docker run -d -p 8080:8080 adarshkumarsingh83/espark-springboot-sample:latest
 
### To list the running docker container 
* $ docker ps 
 
### To hit the application 
* $ curl http://localhost:8080/wish
 
### To kill the docker container locally 
* $ docker stop <container-id>
 
### To push the docker image to the docker hub 
* docker push <repository : tag>
* $ docker push adarshkumarsingh83/espark-springboot-sample:latest
 
### To login into the pcf 
* $ cf login -a https://api.run.pivotal.io
 
### To create a space in the pcf 
* $ cf create-space espark-space -o espark-adarsh

### to link the space to the org
* $ cf target -o espark-adarsh -s espark-space
 
### to push the image to the pcf form the docker hub 
* cf push <illias name> --docker-image <repository url:tag>
* $ cf push  espark-springboot-sample --docker-image adarshkumarsingh83/espark-springboot-sample:latest
 
### to hit the application 
* $ curl espark-springboot-sample.cfapps.io/wish
 
### to list the running application in pcf space 
* $ cf apps 
 
### To list the logs 
* $ cf logs espark-springboot-sample --recent
 
### To delete the space in pcf 
* $ cf delete-space espark-space -o espark-adarsh
 
 