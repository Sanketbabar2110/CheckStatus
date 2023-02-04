package com.server;

public class ServerUtil {
	
	public static Server getServer(Server server) {
		 
		Server newServer = new Server();
		
		newServer.setPortNumber(server.getPortNumber());
		newServer.setIpAddress(server.getIpAddress());
		newServer.setServerName(server.getIpAddress());
		newServer.setStatus(server.getStatus());
		
		String url = new StringBuilder("http://")
							.append(server.getIpAddress())
							.append(":")
							.append(server.getPortNumber())
							.append("/")
							.append(server.getServerName())
							.toString();
		
		newServer.setUrl(url);
		newServer.setStatus("");
							  
		return newServer;
	}
}
