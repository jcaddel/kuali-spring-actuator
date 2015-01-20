Kuali Spring Actuator
-------

This project demo's using [Spring Boot](http://projects.spring.io/spring-boot/) (with [Boot Actuator](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready)) + [Spring HATEOAS](http://projects.spring.io/spring-hateoas/) to publish a simple Rest API on [Heroku](http://en.wikipedia.org/wiki/Heroku)

https://kuali-spring-actuator.herokuapp.com/api/v1/devops/endpoints/filter 

This is a read-only API that displays internal metrics and information about the application (system properties, memory consumption, environment variables, etc) 

Deploy to Heroku
-------
```
git push heroku master
```