package com.harman.kafkaconfiguration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.harman.dto.CommandRequestFromWorkFlowControllerDto;

@Configuration
public class MyProducerConfiguration {
	
	@Bean
	  public Map<String, Object> producerConfigs() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	    props.put(ProducerConfig.RETRIES_CONFIG, 0);
	    props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
	    props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
	    props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);

	    return props;
	  }
	
	@Bean
	  public ProducerFactory<String, CommandRequestFromWorkFlowControllerDto> producerFactory() {
	    return new DefaultKafkaProducerFactory<>(producerConfigs());
	  }
	
	 @Bean
	  public KafkaTemplate<String, CommandRequestFromWorkFlowControllerDto> kafkaTemplate() {
	    return new KafkaTemplate<>(producerFactory());
	  }
	
	 @Bean
	  public Sender sender() {
	    return new Sender();
	  }
}
