### View the PostgreSQL Service
* $ cf marketplace

### Create a Service Instance
* $ cf create-service a9s-postgresql postgresql-single-small <service-name>
* $ cf create-service a9s-postgresql postgresql-single-small espark-postgresql

### Bind an App to a Service Instance
* $ cf bind-service <application-name> <service-name>
* $ cf bind-service espark-app espark-postgresql

### To Reset or Restart
* $ cf restage 
* or 
* $ cf restart

### Obtain Service Instance Access Credentials
* $ cf env <application-name>
* $ cf env espark-app

### To List the services 
* $ cf services

### Unbind a Service Instance
* $ cf unbind-service <application-name> <service-name>
* $ cf unbind-service espark-app espark-postgresql

### Delete a Service Instance
* $ cf delete-service <service-name>
* $ cf delete-service espark-postgresql

### Service Instance GUID
* $ cf service <service-name> --guid
* $ cf service espark-postgresql --guid

### Get the Service URL and Credentials
* $ cf env espark-app

### Creating a Service Key
* $ cf create-service-key <instance-name> <key-name>

### Listing Service Keys
* $ cf service-keys <instance-name>

### Accessing Service Keys
* $ cf service-key <instance-name> <key-name>

### Deleting Service Keys
* $ cf delete-service-key <instance-name> <key-name>








