# 1.01 - Scheduler app

### Should be deployed with rawsourcefile not direct github url
- kubectl apply -f https://raw.githubusercontent.com/elygo/devops-kubernetes/master/manifests/deployment.yaml
- kubectl get deployments (check deployment)
- kubectl get pods (copy name)
- kubectl logs -f <name-hash>
