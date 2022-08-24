

## AWS Regions 
* A cluster of DS 
* Services are region scope 
* eg. ap-xx-1, ap-yy-1, ap-zz-1
 
 * how to select Regions 
 	* Compliance gov. policy 
 	* latency  delay/lag 
 	* Availiable Services not all regions have all services 
 	* pricing  varies regions to regions 


## Availiablity Zones 
* each regions has many availity zones 
* 3 min max 6 
* each az has onr or more dc with redundeant power n/w and connectivity 
* each az are  seprate from each other for isolated for disaster 
* eg. ap-xx-1a, ap-xx-2a, ap-xx-3a 


## Edge Locations 
* aws 216 point of presence in 84 cities across 42 countries 


---

# IAM identity and Access Mgmt.
* iam is global service 
* Root User (default) a/c
* Users : perople within org 
	* user can belongs to multiple group 
	* policy can be attach to user directly 
* Groups: people with same work type can be group 
	* group only contains users 
	* policy can be attach to group
* Permissions: permission for access resources 
	* iam policies 
	* least previlalge principal 
```
{
  "Version": "2012-10-17", 
  "id": "xxx"  
  "Statement": [
    {
      "sid": "xxx" 
      "Effect": "Allow/Deny",
      "Principal":{ // account/user/role to which this policy applied to 
           "AWS":["arn:aws:iam::1234567:root"]
      	},
      "Action": "ec2:Describe*",  //action allow or deney 
      "Resource": "*"     // list of resource on which action is allow or deney 
    },
    {
      "Effect": "Allow",
      "Action": "elasticloadbalancing:Describe*",
      "Resource": "*"
    },
    {
      "Effect": "Allow",
      "Action": [
        "cloudwatch:ListMetrics",
        "cloudwatch:GetMetricStatistics",
        "cloudwatch:Describe*"
      ],
      "Resource": "*"
    }
  ]
}
```
 
* IAM USER CREATION 
	* IAM dashboard -> Users -> Add users -> 
	   username, credentails type , permission -> Add User to Group 
	       Group Name -> add policies 
	       add tags -> Create User 
	* IAM -> dashboard -> UserGroup -> group name -> and User belongs to group 
	* IAM -> dashboard -> User -> user name 

* IAM USER ALIAS 
	* IAM dashboard -> RHS -> create alias and get the login url 
* LOGIN WITH ALIAS 
	* IAM USER 
		* ACCOUNT ID -> USER NAME -> USER PWD 

