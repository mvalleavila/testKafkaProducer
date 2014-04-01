import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class TestKafkaProducer 
{
    public static void main(String[] args) throws InterruptedException	
    {
	try
	{
	        int numMessages = Integer.parseInt(args[0]);
        	String avroFile = args[1];
	        File file = new File(avroFile);
	        String brokersList = args[2];
		String topic = args[3];
		int printMessages = Integer.parseInt(args[4]);

		int fileLength=(int)file.length();
		FileInputStream fis = new FileInputStream(file);

        	Properties props = new Properties();
	        props.put("metadata.broker.list", brokersList);
	        props.put("serializer.class", "kafka.serializer.DefaultEncoder");
	        props.put("key.serializer.class", "kafka.serializer.StringEncoder");
	        props.put("request.required.acks", "1");

        	ProducerConfig config = new ProducerConfig(props);

	        Producer<String, byte[]> producer = new Producer<String, byte[]>(config);

        	int content;
	        byte[] fileContent = new byte[fileLength-1];
		int i=0;

	        while (i<fileLength -1)
		{
	        	content = fis.read();
	                fileContent[i] = (byte)(content);
	                i++;
		}

        	for (int j=0; j<numMessages;j++)
	        {
			KeyedMessage<String, byte[]> data = new KeyedMessage<String, byte[]>(topic, fileContent);
	                producer.send(data);
			if (printMessages == 1)
			{
				System.out.print(j+1 + ".  ");
				for (int k=0; k<fileLength-1; k++)
				{
		                	System.out.print((char) fileContent[k]);
				}
				System.out.println();
			}
			else
			{
				System.out.print("\r"+(j+1));
			}
		}
		System.out.println();
		fis.close();
		producer.close();
	}	
        catch (IOException e)
        {
		e.printStackTrace();		
        }
   }
}
