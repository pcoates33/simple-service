Example of actuator/refresh throwing java.lang.IllegalStateException: org.springframework.boot.context.properties.bind.Binder has not been registered

Need consul server on port 8500

e.g. to run consul in docker if you don't have it
* docker run --name consul -p 8500:8500 consul agent -dev -ui -client=0.0.0.0 -bind=0.0.0.0

Need associated configserver project.
* configserver is set to use native profile, so, change the searchLocations in bootstrap.yml of configserver project
to match the actual location on your machine 
* configserver starts on port 8888

With consul and configserver started, start the simple-service project.
* starts on port 8011 by default. Change server.port in bootstrap.yml if necessary
* goto http://localhost:8011 in a browser
* should see 2 values from config server displayed, and a button to refresh them
* the button does a POST to actuator/refresh
* Click the button and see the exception
java.lang.IllegalStateException: org.springframework.boot.context.properties.bind.Binder has not been registered
