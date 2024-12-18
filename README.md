# 1.07 - Scheduler app ingress
### k8s - service, ingress
#### Should be deployed with rawsourcefile not direct github url
- kubectl apply -f https://raw.githubusercontent.com/elygo/devops-kubernetes/refs/heads/107-scheduler-ingress/manifests/deployment.yaml;
- check: kubectl get pods;
- kubectl apply -f https://raw.githubusercontent.com/elygo/devops-kubernetes/refs/heads/107-scheduler-ingress/manifests/service.yaml;
- kubectl apply -f https://raw.githubusercontent.com/elygo/devops-kubernetes/refs/heads/107-scheduler-ingress/manifests/ingress.yaml;
- check: kubectl get svc,ing;

! be careful with caching, names and ports (target port 8080)
