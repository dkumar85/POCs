/*
 * package com.harman.service;
 * 
 * import org.apache.logging.log4j.LogManager; import
 * org.apache.logging.log4j.Logger; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.kafka.core.KafkaTemplate; import
 * org.springframework.stereotype.Service;
 * 
 * import com.harman.dto.CommandDto;
 * 
 * @Service public class ProducerService {
 * 
 * private static Logger logger = LogManager.getLogger();
 * 
 * private static final String TOPIC = "users";
 * 
 * @Autowired private KafkaTemplate<String,CommandDto> kafkaTemplate;
 * 
 * public void sendMessage(CommandDto command) {
 * 
 * logger.info(String.format ("$$ -> Producing message --> %s",
 * command.toString())); this.kafkaTemplate.send(TOPIC,command);
 * 
 * } }
 */