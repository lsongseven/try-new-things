FROM java:8
MAINTAINER "lsongseven"<lsongseven@gmail.com>
ADD target/hello-world-1.0-SNAPSHOT.jar hello-world.jar
EXPOSE 8080
CMD java -jar hello-world.jar