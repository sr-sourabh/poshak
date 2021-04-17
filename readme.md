# Poshak

### commands

### mongo

```
sudo systemctl start mongod.service
```

### minikube and kubectl

```
    sudo apt-get install curl
    sudo apt-get install apt-transport-https
    sudo apt install virtualbox virtualbox-ext-pack
    
    wget https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
    sudo cp minikube-linux-amd64 /usr/local/bin/minikube
    sudo chmod 755 /usr/local/bin/minikube
    minikube version
    
    curl -LO https://storage.googleapis.com/kubernetes-release/release/`curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl
    chmod +x ./kubectl
    sudo mv ./kubectl /usr/local/bin/kubectl
    kubectl version -o json
    
    sudo systemctl start virtualbox
    
    minikube start
    kubectl config view
    kubectl cluster-info
    kubectl get nodes
    kubectl get pod
    minikube ssh
    exit
    minikube stop
    minikube status
    minikube delete
    minikube addons list
    minikube dashboard
    
    kubectl describe service <service-name>
    kubectl get pod -o wide
    kubectl delete -f deployment.yaml
    kubectl apply deployment.yaml
    kubectl get all
   
   --assign ip address to open in browser
   minikube service poshak-ui
   
   kubectl delete service --all
   kubectl delete deployment --all
   
```

### Kafka and zookeeper

```
    docker run --name zookeeper --restart always -p 2181:2181 -d zookeeper
    
    docker run -p 9092:9092 --name kafka  -e KAFKA_ZOOKEEPER_CONNECT=localhost:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 -d confluentinc/cp-kafka 
    
```

