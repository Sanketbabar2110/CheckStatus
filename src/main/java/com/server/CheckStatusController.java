package com.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.server.service.ServerService;

@RestController
public class CheckStatusController {
	
	@Autowired
	Server server;
	
	@Autowired
	ServerService service;
	
	@PostMapping(value = "/status")
	public String isUp(@RequestBody Server entity) throws InterruptedException {

		server = ServerUtil.getServer(entity);
		String status = service.isActive(server.getUrl());
		
		if(status != null){
			server.setStatus(status);
			service.saveServerDetails(server);
			service.provideStatus(server);
		}
		return status;
	}
}
