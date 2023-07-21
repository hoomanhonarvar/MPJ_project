package com.example.demo.config.rabbitmq;


import org.hibernate.sql.Template;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mqconfig {
    public static final String QUEUE = "message_queue";
    public static final String ROUTING_KEY = "message_routing_key";

    public static final String JSON_QUEUE="json_queue";
    public static final String EXCHANGE= "message_exchange";
    public static final String JSON_ROUTING_KEY= "json_message_exchange";

//    @Bean
//    public CachingConnectionFactory connectionFactory() {
//        return new CachingConnectionFactory("localhost:3310");
//    }
//    @Bean
//    public RabbitAdmin amqpAdmin() {
//        return new RabbitAdmin(connectionFactory());
//    }
//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        return new RabbitTemplate(connectionFactory());
//    }

    @Bean
    public Queue queue(){
        return new Queue(QUEUE);

    }
    @Bean
    public Queue jsonQueue(){
        return new Queue(JSON_QUEUE,true);
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);

    }
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(ROUTING_KEY);
    }
    @Bean
    public Binding jsonBinding (){
        return BindingBuilder
                .bind(jsonQueue())
                .to(exchange())
                .with(JSON_ROUTING_KEY);
    }


    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate (ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate= new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
//    @Bean
//    public MessageConverter messageConverter(){
//
//        return new Jackson2JsonMessageConverter ();
//    }
//    @Bean
//    public AmqpTemplate template(ConnectionFactory connectionFactory){
//        RabbitTemplate template=new RabbitTemplate( connectionFactory());
//        template.setMessageConverter(messageConverter());
//        return template;
//
//    }


}
























