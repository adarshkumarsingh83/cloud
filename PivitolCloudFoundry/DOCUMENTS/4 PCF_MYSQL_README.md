

### To check the serice in marketplace 
* $ cf marketplace

### To create mysql services 
* $ cf create-service p.mysql PLAN SERVICE-INSTANCE
* $ cf create-service p.mysql db-small espark-mysql

### To list the services 
* $ cf services

### Create service key
* $ cf create-service-key <service-instance-name> <service-key-name>
* $ cf create-service-key espark-mysql espark-db-key

### View service key information
* $ cf service-key <service-instance-name> <service-key-name>
* $ cf service-key espark-mysql espark-db-key

----
* $ cf create-service-key service-key espark-mysql espark-db-key
````
{
"hostname": "q-n3s3y1.q-g693.bosh",
"jdbcUrl": "jdbc:mysql://q-n3s3y1.q-g693.bosh:3306/service_instance_db?user=6bf07ae455a14064a9073cec8696366c\u0026password=a22aaa2a2a2aaaaa\u0026=true",
"name": "service_instance_db",
"password": "a22aaa2a2a2aaaaa",
"port": 3306,
"tls": {
"cert": {
 "ca": "-----BEGIN CERTIFICATE-----...n-----END CERTIFICATE-----\n"
}
},
"uri": "mysql://6bf07ae455a14064a9073cec8696366c:a22aaa2a2a2aaaaa@q-n3s3y1.q-g693.bosh:3306/service_instance_db?reconnect=true",
"username": "6bf07ae455a14064a9073cec8696366c"
}

NOTE :
1.copy the content of tls.cert.ca and paste it into a file root.pem

2.copy the values for username, password, and hostname 

3.mysql --host=HOSTNAME --user=USERNAME --password=PASSWORD --ssl-ca=root.pem --ssl-verify-server-cert
example 
$ mysql --hostname=q-n3s3y1.q-g693.bosh --user=6bf07ae455a14064a9073cec8696366c --password=a22aaa2a2a2aaaaa --ssl-ca=root.pem --ssl-verify-server-cert

````
----

### Delete service key
* $ cf delete-service-key <service-instance-name> <service-key-name>
* $ cf delete-service-key espark-mysql espark-db-key

### Bind a Service Instance to Your App
* $ cf bind-service APP SERVICE-INSTANCE
* $ cf bind-service espark-app espark-mysql

### Update a Service Instance to a Larger
* $ cf update-service SERVICE-INSTANCE -p PLAN
* $ cf update-service espark-mysql -p db-large

### Unbind an App from a Service Instance
* $ cf unbind-service APP SERVICE-INSTANCE
* $ cf unbind-service espark-app espark-mysql

### Delete a Service Instance
* $ cf delete-service SERVICE-INSTANCE
* $ cf delete-service espark-mysql
