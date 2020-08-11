### Log into Cloud Foundry by using the CLI 
* $ cf login -a https://api.cf.eu1.mindsphere.io --sso

### Select the space with enabled SSH or enable 
* $ cf allow-space-ssh {spaceName}

### Check if SSH is enabled.
* $ cf space-ssh-allowed {spaceName}

### Enable SSH for your application.
* $ cf enable-ssh {appName}

### Restart your application.

### connect to your application.
* $ cf ssh {appName}
````
You are now connected to application container. 
Test the connection by running commands like ls or top inside the container.
Exit and disable the access afterwards::
````

### Run the command exit to close the connection.
* $ exit

### To disable the SSH application access.
* $ cf disable-ssh {appName}

### Restart your application.

### To deactivate the SSH access for the space.
* $ cf disallow-space-ssh {spaceName}