# For build:
#    $docker build -t dockerjavaexample .
# For run (interactive):
#    $docker run -it --rm -p 9090:9090 dockerjavaexample
FROM cogniteev/oracle-java:java8
MAINTAINER benitojcv@gmail.com
RUN mkdir /opt/dockerjavaexample
WORKDIR /opt/dockerjavaexample
COPY ./target/dockerjavaexample*.jar /opt/dockerjavaexample/
COPY ./startup.sh /opt/dockerjavaexample/
RUN chmod +x /opt/dockerjavaexample/startup.sh
RUN mkdir /opt/dockerjavaexample/lib
COPY ./target/lib/*.jar /opt/dockerjavaexample/lib/
EXPOSE 9090
CMD /opt/dockerjavaexample/startup.sh