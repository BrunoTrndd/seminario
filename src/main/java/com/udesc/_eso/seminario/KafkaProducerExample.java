package com.udesc._eso.seminario;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class KafkaProducerExample {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		KafkaProducer<String, String> producer = new KafkaProducer<>(props);
		ProducerRecord<String, String> record = new ProducerRecord<>("meu-topico2", "chave", "mensagem");

		producer.send(record);
		producer.close();
	}

}
