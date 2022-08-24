## cloning branch 
* $ git clone <'url'>

## creating branch 
* $ git checkout -b <'branch name'>

## getting only one file from the branch 
* $ git checkout origin/<'branch name'> <'file path'>

## resetting the file to the remote 
* $ git reset HEAD <'file path'>

## adding to local repository
* $ git add <'file name with path'>

## adding all to the local repostory
* $ git add --all 
* or 
* $ git add . 

## committing to the local repostory
* $ git commit -m <'msg to the commit [ticket number with description]'>  

## pushing to the remote branch 
* $ git push origin <'branch'>

## to rebase the detached head 
* $ git rebase --hard 

## to cherry pick the code from one branch to another 
* $ git cherry-pick <'commit id'>

## to delete the branch 
* $ git branch -D <'branch'>

## to look the branches in local repository
* $ git branch 


## to delete remote branch 
* $ git push origin --delete <'branch name'>

## to stash the changes 
* $ git stash 

## to bring back the stash changes 
* $ git stash pop 

## deleting branch 
* $ git branch -D <'branch name'>

## aborting merge 
* $ git merge --abort

## list of branch 
* $ git branch 

## to list the tags
* $ git tag 

## to create tags
* $ git tag <'tagname'>

## to push tag to remote 
* $ git push origin --tags

## renaming the branch 
*  Rename branch locally    
	* $ git branch -m <'old_branch'> <'new_branch'>        
* Delete the old branch    
	* $ git push origin <'old_branch'>                 
*  push the changes to remote 
	* $ git push --set-upstream origin <'new_branch'> 



## GIT FORK PROCESS
* $ git remote -v

* $ git remote add upstream  <'actual remote repo url (clone url from the repository)'>

* $ git remote -v 

## to remove the upstream 
* $ git remote remove <'upstream'>

## to pull data from upstream 
* $ git pull upstream <'branch name'>

## To checkout remote branch 
* $ git checkout  <'same name of branch upstream/<'branch name'> 

## To Create a new branch from the remote branch 
* $ git checkout -b <'branch name'> upstream/<'remote/branch'>
* example 
* $ git checkout -b <'bugfix/PROJ-'> upstream/develop  
* $ git checkout -b <'bugfix/PROJ-'> upstream/release/2020.01.00               

## TO GET THE FORK BRANCH OF ANOTHER USER baba
* $ git remote add <OTHER_USER_NAME> https://github.com/<OTHER_USER_NAME>/<OTHER_USER_REPOSITORY>
* $ git fetch <OTHER_USER_NAME>
* $ git checkout -b <LOCAL_BRANCH_NAME> <OTHER_USER_NAME>/<OTHER_USER_REPOSITORY>
