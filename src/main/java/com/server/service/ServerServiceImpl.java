package com.server.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.server.Server;

@Service
public class ServerServiceImpl implements ServerService {

	@Value("${DevServer}")
	String url;

	@Autowired
	SessionFactory factory;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public String isActive(String url) throws InterruptedException {
		System.out.println(url);

		System.setProperty("webdriver.chrome.driver", "D:\\JAVA\\Chrome_Jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		try {
			driver.get(url);
		} catch (Exception e) {

		}

		Thread.sleep(3000);
		String response = null;

		try {

			String expected = "This site can’t be reached";
			String actual = driver.findElement(By.xpath("//*[text()='This site can’t be reached']")).getText();
			Thread.sleep(2000);

			if (expected.equals(actual))
				response = "Server status is : DOWN";

		} catch (NoSuchElementException e) {

			response = "Server status is : UP";

		} finally {

			driver.close();

		}
		return response;
	}

	@Override
	public boolean saveServerDetails(Server server) {

		Session session = null;
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();

			session.persist(server);

			tx.commit();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void provideStatus(Server server) {

		restTemplate.postForEntity("http://192.168.1.122:8080/SpringMvcAnnotation/addServerDetails", server.getStatus(), ResponseEntity.class);
	}
}
