### Các bước build ứng dụng với Dockerfile
Cách 1: Chia làm 2 stage:

![image](https://user-images.githubusercontent.com/80346800/131122386-90058c96-a7f7-431c-aa07-ff1badb9930c.png)

1. Stage 1
- Sử dụng base image ***maven:ibmjava-alpine***

- Copy source code vào image

- Từ source code build ra file ***websocket-demo-0.0.1-SNAPSHOT.jar*** bằng lệnh: `mvn clean package`.

- File ***websocket-demo-0.0.1-SNAPSHOT.jar*** sẽ nằm trong thư mục **target** của source code

2. Stage 2

- Sử dụng base image ***openjdk:8-alpine***

- Copy file ***websocket-demo-0.0.1-SNAPSHOT.jar*** từ stage 1 sang stage 2

- Dùng lệnh sau để start container: `java -Djava.security.egd=file:/dev/./urandom -jar websocket-demo-0.0.1-SNAPSHOT.jar`

Cách 2: 

![image](https://user-images.githubusercontent.com/80346800/131123312-344e163a-b1b7-41fe-9e9f-a365f47a64f5.png)

- Clone source code  về máy

- Bên trong thư mục chứa source code chạy câu lệnh `mvn clean package` để build source code ra thư mục target 

- Viết dockerfile: 
       * Sử dụng base image openjdk:8-alpine
       * Copy file websocket-demo-0.0.1-SNAPSHOT.jar vào docker image
       * Dùng lệnh sau làm CMD: `java -Djava.security.egd=file:/dev/./urandom -jar websocket-demo-0.0.1-SNAPSHOT.jar`

#### Chạy container

1. Từ Dockerfile sử dụng câu lệnh `docker build -t spring-app:latest .` build thành Docker Image có tên là spring-app.

2. Khởi động container từ image spring-app: ```docker run -d --name spring-app -p 8088:8080 spring-app:latest ``` container chạy ngầm, expose cổng 8080 của container ra cổng 8088 của host.

3. Truy cập localhost:8088 để kiểm tra kết quả.

![image](https://user-images.githubusercontent.com/80346800/131124740-a810c34d-b381-48fb-96d5-3ec763aef3ed.png)

  
