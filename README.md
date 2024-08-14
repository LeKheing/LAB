
# LAB

### Create Docker Network

```bash
docker network create labtest
```

### Build Docker Image for Spring Boot App

```bash
docker build -t labtest .
```

### Run MySQL Container with Network
###### Chạy ở mà trùng port thì đổi sang 3308

```bash
docker run --network labtest --name mysqllab -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=labtest -d mysql:latest
```

### Run Spring Boot App with Network

```bash
docker run --network labtest --name labtest -p 8080:8080 -e DBMS_CONNECTION=jdbc:mysql://mysqllab:3306/labtest labtest:latest
```
