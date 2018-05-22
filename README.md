###Spring boot application with swagger in version 2.5 
to build application call 
```
mvn clean install docker:build
```
### Part of the docker-compose file 

```
 swagger:
  image: michalnawrocki/springfox-swagger-ui
  environment:
    - API_URL=http://${APP_HOST}/v2/api-docs
  ports:
    - 9999:8888
```

