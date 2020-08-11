### Sign in to PWS:
* $ cf login -a https://api.run.pivotal.io

### Create a space
* $ cf create-space <SPACE_NAME> [-o ORG] [-q SPACE_QUOTA]
* $ cf create-space espark-space -o espark-adarsh

### Target the space of the pcf
* $ cf target [-o ORG] -s <SPACE_NAME>
* $ cf target -o espark-adarsh -s espark-space

### To list the apps in PCF
* $ cf apps

### To delete the space
* $ cf delete-space <SPACE_NAME> [-o ORG]
* $ cf delete-space  espark-space -o espark-adarsh

### logout from PWS
* $ cf logout

