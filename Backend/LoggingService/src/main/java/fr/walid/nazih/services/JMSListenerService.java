package fr.walid.nazih.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import fr.walid.nazih.models.Log;
import fr.walid.nazih.repositories.LogRepository;

@Service
public class JMSListenerService implements IJMSListenerService{
	
	@Autowired
	private LogRepository logRepository;

	@JmsListener(destination="product_topic")
	@Override
	public void listenForIncomingMessages(String message) {
		
		Log log = new Log();
		log.setMessage(message);
		log.setDateCreated(LocalDate.now());
		
		addLog(log);
	}

	@Override
	public Log addLog(Log log) {
		return logRepository.save(log);
	}

}
