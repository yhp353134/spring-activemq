package com.yu.activemq.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener{

	//得到消费者
	public void onMessage(Message message) {
		try {
			TextMessage tm  = (TextMessage)message;
			System.out.println("消费消息："+tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
