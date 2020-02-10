#!/usr/bin/env bash

echo "$ homework"
java -Dfile.encoding=UTF-8 -jar homework/target/homework-0.4.0-jre11.jar
echo "$ homework -h"
java -Dfile.encoding=UTF-8 -jar homework/target/homework-0.4.0-jre11.jar -h
echo "$ homework --help"
java -Dfile.encoding=UTF-8 -jar homework/target/homework-0.4.0-jre11.jar --help
echo "$ homework -v"
java -Dfile.encoding=UTF-8 -jar homework/target/homework-0.4.0-jre11.jar -v
echo "$ homework --version"
java -Dfile.encoding=UTF-8 -jar homework/target/homework-0.4.0-jre11.jar --version
echo "$ homework --version"
java -Dfile.encoding=UTF-8 -jar homework/target/homework-0.4.0-jre11.jar config user.email
echo "$ homework config user.smtp"
java -Dfile.encoding=UTF-8 -jar homework/target/homework-0.4.0-jre11.jar config user.smtp
echo "$ homework config user.key"
java -Dfile.encoding=UTF-8 -jar homework/target/homework-0.4.0-jre11.jar config user.key
echo "$ homework config user.email student@example.com"
java -Dfile.encoding=UTF-8 -jar homework/target/homework-0.4.0-jre11.jar \
 config user.email "$USER_EMAIL"
echo "$ homework config user.smtp smtp.example.com"
java -Dfile.encoding=UTF-8 -jar homework/target/homework-0.4.0-jre11.jar \
 config user.smtp "$USER_HOST"
echo "$ homework config user.key ****************"
java -Dfile.encoding=UTF-8 -jar homework/target/homework-0.4.0-jre11.jar \
 config user.key "$USER_KEY"
echo "$ homework archive archived homework/src"
java -Dfile.encoding=UTF-8 -jar homework/target/homework-0.4.0-jre11.jar \
 archive archived homework/src
echo "$ homework archived.zip teacher@example.com"
java -Dfile.encoding=UTF-8 -jar homework/target/homework-0.4.0-jre11.jar \
 push archived.zip "$TARGET_EMAIL" < homework/src/test/resources/comments.txt
echo "Test finished!"
