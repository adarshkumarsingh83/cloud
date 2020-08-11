### List Marketplace Services
* $ cf marketplace


### Creating Service Instances
* $ cf create-service <service-name> <plan> <serice-instace-name>

### Example
* $ cf create-service rabbitmq small-plan my-rabbitmq
* $ cf create-service my-db-service small-plan my-db -c '{"storage_gb":4}'

### Rename a Service Instance
* $ cf rename-service <old-serice-instace-name>  <new-serice-instace-name>
* $ cf rename-service mydb mydb1

### Delete a Service Instance
* $ cf delete-service <serice-instace-name>
* $ cf delete-service mydb

### Instance Tags
* $ cf create-service <SERVICE> <PLAN> <SERVICE_INSTANCE> -t <"tag,names">
* $ cf create-service my-db-service small-plan my-db -t "prod, workers"

### Update a Service Instance
* $ cf update-service <serice-instace-name> -t <"tag,names">

* $ cf update-service my-db -t "staging, web"
* $ cf update-service mydb -c '{"storage_gb":4}'


### List Service Instances
* $ cf services

### Details for a Particular Service Instance
* $ cf service <service-name>
* $ cf service mydb

### Bind a Service Instance to an App
* $ cf bind-service <application-name> <service-name>
* $ cf bind-service my-app mydb

### Unbind a Service Instance from an App
* $ cf unbind-service <application-name> <service-name>
* $ cf unbind-service my-app mydb

### Bind a Service Instance to a Route
* $ cf bind-route-service <domain-namexxx.com> --hostname <application-name> <service-instance-name>
* $ cf bind-route-service shared-domain.example.com --hostname my-app my-service-instance

### Unbind a Service Instance from a Route
* $ cf unbind-route-service <domain-namexxx.com> --hostname <application-name> <service-instance-name>
* $ cf unbind-route-service shared-domain.example.com --hostname my-app my-service-instance
