FROM java:8
EXPOSE 8082

VOLUME /tmp
ADD renren-admin.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
