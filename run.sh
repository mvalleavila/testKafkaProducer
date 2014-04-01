#!/bin/bash


# java lib/kafka_2.8.0-0.8.0.jar:lib/kafka-assembly-0.8.0-deps.jar:KafkaProducer.jar TestProducer <num menssages> 
# <file to read> <kafka brokers> <kafka topic> <print send messages>
java -cp /usr/lib/kafka/kafka_2.8.0-0.8.0.jar:/usr/lib/kafka/kafka-assembly-0.8.0-deps.jar:bin/TestKafkaProducer.jar TestKafkaProducer 10 \
resources/test.txt mvalle1:9092 camus 0
