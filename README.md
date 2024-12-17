# 102 - TODO App
### Tomcat server and dockerfile with env port
- docker build -t elygo/102-todo-kube
- docker run -d -e PORT=9999 --name todo elygo/102-todo-kube
