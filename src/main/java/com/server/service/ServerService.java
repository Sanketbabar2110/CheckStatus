package com.server.service;

import com.server.Server;

public interface ServerService {

	public String isActive(String url) throws InterruptedException;
	
	public boolean saveServerDetails(Server server);
	
	public void provideStatus(Server server);
}
