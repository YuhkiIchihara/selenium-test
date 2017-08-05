package com.example.selenium.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class SampleScript {

	public static void main(String[] args) throws IOException {
		//Driverサーバーの実行ファイルはC:\apache-maven-3.5.0-bin\apache-maven-3.5.0\bin配下に配置
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new PhantomJSDriver();
		driver.get("http://example.selenium.jp/reserveApp");
		driver.findElement(By.id("guestname")).sendKeys("サンプルユーザ");
		//画面キャプチャ
		File tempFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.moveFile(tempFile, new File("C:\\020_WORKS\\screenshots\\01.png"));
		driver.findElement(By.id("goto_next")).click();
		driver.quit();
	}

}
