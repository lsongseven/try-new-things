FROM java:8
MAINTAINER "lsongseven"<lsongseven@gmail.com>
ADD target/hello-world-1.0-SNAPSHOT.jar hello-world.jar
EXPOSE 8080
CMD java -XX:NativeMemoryTracking=detail -Xmx50m -jar hello-world.jar