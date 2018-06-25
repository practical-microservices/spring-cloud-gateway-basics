# Spring Cloud Gateway Basics

### Overview

This sample shows how to use Spring Cloud Gateway in order to provide a single API surface to backend microservices by configuring routing rules. You can see two ways to configure routes: fluent API as can be seen for `pricing-service` or via configuration as for `message-service`. Spring Cloud Gateway also integrates with Service Discovery, allowing services to be mounted by well known name instead of their endpoint as can be seen in `message-service`. Adding routes via configuration vs fluent has the advantage of being able to change it at runtime if using Config Server without having to redeploy the gateway. 

### Run the Demo

* Import the root of the repo into your favorite Java IDE
* Run eureka-server application
* Run `eb-api-gateway` application
* Run `message-service` application
* Run `pricing-service` application
* Confirm that it's working by accessing one of the gateway routes: http://localhost:8080/billboard/quotes 
 

### Things to try out 
* Examine controller mappings for `pricing-service` application and associated routing rules in `eb-api-gateway`. The routing rules for this app are configured using fluent api inside `EbApiGatewayApplication` class. Notice how any requests sent to `/prices/*` endpoint will be directed towards `pricing-service`, but the `/prices/` segment will be stripped off for any downstream requests.
* Examine controller mappings for `message-service` & routing rules configured in gateway `application.yml`. Notice how the URI is using special `lb://` prefix that will use Ribbon client side load balancing to call service over Eureka service discovery.
* Read on different predicates & filters available for spring cloud gateway and change routing rules to examine their effects. http://cloud.spring.io/spring-cloud-gateway/spring-cloud-gateway.html
 
### Resources to Learn More:
* https://cloud.spring.io/spring-cloud-gateway/