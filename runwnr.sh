./gradlew clean shadowJar
export NEW_RELIC_EXTENSIONS_DIR=extensions
java -Dnewrelic.environment=staging -Dnewrelic.config.file=app/newrelic.yml -javaagent:newrelic.jar -jar app/build/libs/app-all.jar
