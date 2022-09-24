# 基础镜像，使用阿里云服务器中的jdk容器
FROM primetoninc/jdk:1.8

#系统编码
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

#声明一个挂载点，容器内此路径会对应宿主机的某个文件夹
VOLUME /tmp

ADD demo-0.0.1-SNAPSHOT.jar demo.jar

#启动容器时的进程
ENTRYPOINT ["java","-jar","/demo.jar"]

#暴露8080端口
EXPOSE 8080