package com.yu.activemq.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**消费者类*/
public class AppConsumer {

	public static void main(String[] args) {
		//消费者直接把类加载到上下文就可以了，消息的处理在listener里面去处理
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("consumer.xml");
		// 注意：这里不能context.close(); 这里关闭了上下文，那么就会关闭listener，而消息接受是异步的，就会导致消息接受不全
		
	}
	
}
