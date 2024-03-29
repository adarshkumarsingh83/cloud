### PCF command documentation 
* http://cli.cloudfoundry.org/en-US/cf/

* https://docs.cloudfoundry.org/cf-cli/cf-help.html

### to validate the installation 
* $ cf help

### Navigate to the app directory:
* $ cd cf-sample-app-spring

### Sign in to PWS:
* $ cf login -a https://api.run.pivotal.io
````
-----------------------------------------------
Example:
akumar38$ cf login -a https://api.run.pivotal.io
API endpoint: https://api.run.pivotal.io
Email> adarshkumarsingh83@gmail.com
Password> **********
Authenticating...
OK
Targeted org espark-adarsh
Targeted space development                
API endpoint:   https://api.run.pivotal.io (API version: 2.137.0)
User:           adarshkumarsingh83@gmail.com
Org:            espark-adarsh
Space:          development
-----------------------------------------------
````

### logout from PWS 
* $ cf logout

### Push the app to PWS:
* $ cf push 

### View a snapshot of recent logs:
* $ cf logs <APP_NAME> --recent

### stream live logs:
* $ cf logs <APP_NAME>

### to delete the app from PWS:
* $ cf delete <APP_NAME> [-r] [-f]
````
 -f
Force deletion without confirmation
-r
Also delete any mapped routes
````



