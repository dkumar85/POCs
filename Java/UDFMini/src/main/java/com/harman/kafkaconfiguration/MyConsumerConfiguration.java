package com.harman.kafkaconfiguration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.harman.dto.CommandDto;

@Configuration
@EnableKafka
public class MyConsumerConfiguration {

	@Bean
	  public Map<String, Object> consumerConfigs() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
	    props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
	    props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
	    return props;
	  }

	  @Bean
	  public ConsumerFactory<String, CommandDto> consumerFactory() {
	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
	        new JsonDeserializer<>(CommandDto.class));
	  }

	  @Bean
	  public ConcurrentKafkaListenerContainerFactory<String, CommandDto> kafkaListenerContainerFactory() {
	    ConcurrentKafkaListenerContainerFactory<String, CommandDto> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactory());

	    return factory;
	  }

	  @Bean
	  public Receiver receiver() {
	    return new Receiver();
	  }
}
