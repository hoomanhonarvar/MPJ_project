package com.example.demo.config.OpenApi;


import com.rabbitmq.client.AMQP;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Properties;

@Configuration
public class OpenApiConfig {
    private Properties  properties= new Properties();

    public Properties getProperties() {
        return properties;
    }


    @Bean
    public OpenAPI OpenAPIConfig (){
        Server devServer =new Server();
        devServer.setUrl(properties.getProperty("devUrl"));
        devServer.setDescription("Server URL in Development environment __H.H");
        Contact contact = new Contact();
        contact.setEmail("hooman.honarvar2770@gmail.com");
        contact.setName("Hooman");


        Info info = new Info()
                .title("Messenger Management API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage my messenger.")
                ;
        return new OpenAPI().info(info).servers(List.of(devServer));


            }
}
