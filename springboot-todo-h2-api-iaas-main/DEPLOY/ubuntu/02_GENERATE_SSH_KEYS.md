

### Generate your key

```bash
ssh-keygen -t rsa -b 4096

# 1) You wil be prompt to set a path and name for your key

# 2) You will be prompt to set a prase (optional) fory you key , if nothing just type enter

# 3) You will be prompt to confirm the prase (optional) fory you key , if nothing just type enter

```

### Copy the public key to the remote server
```bash
ssh-copy -i $HOME/.ssh/<KEY_NAME>.pub <REMOTE_USER>@<REMOTE_HOST_OR_IP>

# 1) You will be prompt for a remote user password
```


### Activate your key
```bash
eval "$(ssh-agent -s)"

ssh-add ${HOME}/.ssh/<PRIVATE_KEY_NAME>
```


### Create an alias for your key on .bash_aliases
```bash

# 1) edit with vim 
vim $HOME/.bash_aliases

# 2) Inside the file .bash_aliases set a name for you alias pointing to your private key
alias <SOME_ALIAS_NAME>="eval "'$(ssh-agent -s)'" && ssh-add ${HOME}/.ssh/<KEY_NAME>"

# Leave the editor an update with the source command
source $HOME/.bash_aliases

# Now you can use the alias to activate you key

```

### Login with ssh only with the remote user. 
```bash
ssh <REMOTE_USER>@<REMOTE_HOST_OR_IP>

## If the ssh key is activated, you will be login to the remote server

## If you ask for a password, the ssh key is not activated or is not created. Verify
# 1) You created the ssh key
# 2) You copy the ssh public key
# 3) The public key is copy to the remote server
# 4) Activate the key or create an alias to activate your key.

```
