package com.deloitte.assignment.employeewebservices.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class MessagingConfig {
	

	public static String queueName="Insurance";
	
	
	public static String exchangeName="Insurance";
	

	public static String keyName="InsuranceKey";

	@Bean 
	public Queue queue() {
		 return new Queue(queueName);
	 }
	 
	 
	@Bean 
	public TopicExchange exchange() {
		 return new TopicExchange(exchangeName);
	 }
	 
	@Bean 
	public Binding binding(Queue queue,TopicExchange exchange) {
		 return BindingBuilder.bind(queue).to(exchange).with(keyName);
		 }
	
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();	
	}
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionfactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionfactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}
}
