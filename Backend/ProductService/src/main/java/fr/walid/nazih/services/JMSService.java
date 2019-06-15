package fr.walid.nazih.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JMSService implements IJMSService{
	
	@Autowired
	private JmsTemplate template;

	@Override
	public void sendMessage(String destination, String message) {
		template.convertAndSend(destination, message);
	}

}
