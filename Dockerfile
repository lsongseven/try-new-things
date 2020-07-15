FROM openjdk:8
MAINTAINER "lsongseven"<lsongseven@gmail.com>
ADD target/hello-world-1.0-SNAPSHOT.jar hello-world.jar
ADD stop.sh pre-stop.sh
ADD start.sh start.sh
run chmod 777 start.sh
run chmod 777 pre-stop.sh
EXPOSE 8080
ENTRYPOINT ["bash","./start.sh"]
