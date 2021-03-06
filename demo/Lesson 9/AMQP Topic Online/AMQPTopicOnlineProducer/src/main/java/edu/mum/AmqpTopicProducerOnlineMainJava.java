package edu.mum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.mum.amqp.OrderService;
import edu.mum.amqp.OrderServiceImpl;

public class AmqpTopicProducerOnlineMainJava {
	
    public static void main(String[] args) {
  //       ApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/order-app-context.xml");
 
         AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AmqpConfiguration.class);
         
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                   System.out.println();
                  System.out.print("*************HIT RETURN To Send orders on TOPIC Exchange  to online queue[s] *********************::   ");
         System.out.println();
         try {
			in.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
                       
         RabbitTemplate topicTemplate =  context.getBean("topicTemplate",RabbitTemplate.class);
     	OrderService orderService = new OrderServiceImpl();   // Publish to Topic
     	orderService.publish(topicTemplate);

    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

     }
}
