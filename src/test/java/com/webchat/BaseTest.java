package com.webchat;

import com.webchat.core.AppFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * @author w29530
 * @date 2021/12/15
 * @desc
 */
public class BaseTest {

	private static AppiumDriver<MobileElement> driver;

	public AppiumDriver<MobileElement> getDriver() {
		return driver;
	}

	@BeforeAll
	public static void setUp() {
		try {
			driver = AppFactory.getDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}


	@AfterAll
	public static void tearDown(){
		driver.quit();
	}
}
