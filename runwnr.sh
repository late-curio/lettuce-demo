./gradlew clean shadowJar
java -Dnewrelic.environment=staging -Dnewrelic.config.file=app/newrelic.yml -javaagent:newrelic.jar -jar app/build/libs/app-all.jar
