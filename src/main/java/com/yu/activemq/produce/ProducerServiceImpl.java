package com.yu.activemq.produce;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ProducerServiceImpl implements ProducerService{

	@Autowired
	JmsTemplate jmsTemplate;
	
	//引入目的地，用@Resource是因为里面有多个目的地，就是jms向不同队列传输消息，name就是xml里面配置的name
	@Resource(name="queueDestination")
	Destination qDestination;
	
	@Resource(name="topicDestination")
	Destination tDestination;
	
	public void sendMessage(final String message) {
		//使用jmsTemplate发送消息
		jmsTemplate.send(tDestination,new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage tm = session.createTextMessage(message);
				return tm;
			}
		});
		System.out.println("发送消息："+message);
	}

}
