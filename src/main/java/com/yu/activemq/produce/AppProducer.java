package com.yu.activemq.produce;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**生产者类**/
public class AppProducer {
	
	public static void main(String[] args) {
		//先装xml，一般的框架，可以把xml直接放到web.xml里面
		//本来返回ApplicationContext 但是我们最后需要关闭context.close(); 
		// 所以只能用ClassPathXmlApplicationContext
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("producer.xml");
		ProducerService service = context.getBean(ProducerService.class);
		for(int i=0;i<10;i++){
			service.sendMessage("消息："+i);
		}
		context.close();
	}
	
}
