#!/bin/bash

#Location of kafka-assembly-0.8.0-deps.jar and kafka_2.8.0-0.8.0.jar
KAFKA_LIBS="/usr/lib/kafka"

./clean.sh
cd src
javac -cp $KAFKA_LIBS/kafka-assembly-0.8.0-deps.jar:$KAFKA_LIBS/kafka_2.8.0-0.8.0.jar TestKafkaProducer.java
jar cf TestKafkaProducer.jar TestKafkaProducer.class
rm TestKafkaProducer.class
cd ..
mkdir bin
mv src/TestKafkaProducer.jar bin
