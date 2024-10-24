
```bash
mvn archetype:generate -DgroupId=com.example.demo.soap.client -DartifactId=tasktracker-soap-client -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

cd tasktracker-soap-client 

mvn clean jaxws:wsimport
```


- [](https://www.baeldung.com/java-soap-web-service)
- [](https://www.baeldung.com/maven)
- [](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
- [](https://www.baeldung.com/maven-plugin)
- [](https://docs.oracle.com/javase/7/docs/technotes/tools/share/wsimport.html)
- [](https://www.tutorialspoint.com/maven/maven_plugins.htm)
- [](https://stackoverflow.com/questions/2490737/how-to-change-webservice-url-endpoint)
