# smartup

Simple OSGi bundle example with all dependencies
Embed-Dependency for common 3rd party jars
Example show how to build self-contained OSGi bundles managing dependencies

```sh
mvn clean install
# scp /home/ihor/.m2/repository/com/github/smartup/0.0.1/smartup-0.0.1.jar pi@192.168.95.252:/home/pi/.m2/repository/com/github/smartup/0.0.1/smartup-0.0.1.jar
./karaf
bundle:install -s mvn:com.github/smartup/0.0.1
# bundle:update mvn:com.github/smartup/0.0.1
# knopflerfish_osgi
# java -jar framework_compact.jar -istart file:/home/pi/.m2/repository/com/github/smartup/0.0.1/smartup-0.0.1.jar
```