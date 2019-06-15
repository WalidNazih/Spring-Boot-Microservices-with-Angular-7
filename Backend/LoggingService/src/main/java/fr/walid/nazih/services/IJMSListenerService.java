package fr.walid.nazih.services;

import fr.walid.nazih.models.Log;

public interface IJMSListenerService {

	void listenForIncomingMessages(String message);
	Log addLog(Log log);
	
	
}
