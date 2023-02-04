package com.server;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Server {

	@Id
	@Column(name = "PortNumber")
	private int portNumber;

	@Column(name = "IpAddress")
	private String ipAddress;

	@Column(name = "ServerName")
	private String serverName;

	@Column(name = "Status")
	private String status;

	@Column(name = "URL")
	private String url;

	public Server() {
		super();
	}

	public Server(int portNumber, String ipAddress, String serverName, String status, String url) {
		super();
		this.portNumber = portNumber;
		this.ipAddress = ipAddress;
		this.serverName = serverName;
		this.status = status;
		this.url = url;
	}

	@Override
	public String toString() {
		return "Server [portNumber : " + portNumber + ", ipAddress : " + ipAddress + ", serverName : " + serverName
				+ ", status : " + status + ", url : " + url + "]";
	}

	public int getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
