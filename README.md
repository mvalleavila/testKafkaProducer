# Intro
testKafkaProducer is a simple kafka producer for read a file content and write in a kafka topic  

## Compilation
Edit compilePackage.sh:  
	Change KAFKA_LIBS to the location of kafka-assembly-0.8.0-deps.jar and kafka_2.8.0-0.8.0.jar  
  
Run compilePackage.sh  

## Running example
Edit run.sh
	The parameters in order are:  
	1. Number of messagess to write in kafka topic (one for content of file readed)  
	2. File to read the content of message  
	3. Kafka broker lists (TODO: Test with more than one broker)  
	4. Kafka topic to write  
	5. Print messages sent in console (0 dissable, 1 enable)  

Run run.sh  

#TODO
	Read all execution options from a configuration file.		
