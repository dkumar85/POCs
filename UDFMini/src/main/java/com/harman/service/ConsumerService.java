/*
 * package com.harman.service;
 * 
 * import org.apache.logging.log4j.LogManager; import
 * org.apache.logging.log4j.Logger; import
 * org.springframework.kafka.annotation.KafkaListener; import
 * org.springframework.stereotype.Service;
 * 
 * import com.harman.dto.CommandDto;
 * 
 * @Service public class ConsumerService {
 * 
 * private static Logger logger = LogManager.getLogger();
 * 
 * @KafkaListener (topics = "users", groupId = "group_id") public void
 * consumeMessage (CommandDto command) {
 * logger.info(String.format("$$ -> Consumed Message -> %s",
 * command.toString())); }
 * 
 * }
 */