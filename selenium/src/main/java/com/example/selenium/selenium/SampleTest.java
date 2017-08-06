package com.example.selenium.selenium;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class SampleTest {
	//WebDriverのインスタンス変数
		private WebDriver driver;

		@Before
		public void setUp() {
			driver = new PhantomJSDriver();
			driver.get("http://example.selenium.jp/reserveApp");
		}

		@Test
		public void タイトルチェック() throws IOException {
			assertThat(driver.getTitle(), is("予約情報入力"));
			//画面キャプチャ
			File tempFile01 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.moveFile(tempFile01, new File("/var/lib/jenkins/workspace/SampleTest/01.png"));
			//FileUtils.moveFile(tempFile01, new File("C:\\020_WORKS\\screenshots\\01.png"));
		}

		@Test
		public void 名前だけを入力して次へを押すとエラー画面に遷移すること() throws IOException {
			driver.findElement(By.id("guestname")).sendKeys("市原佑樹");
			//画面キャプチャ
			File tempFile02 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.moveFile(tempFile02, new File("/var/lib/jenkins/workspace/SampleTest/02.png"));
			//FileUtils.moveFile(tempFile02, new File("C:\\020_WORKS\\screenshots\\02.png"));
			driver.findElement(By.id("goto_next")).click();
			assertThat(driver.getTitle(), is("予約エラー"));
			//画面キャプチャ
			File tempFile03 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.moveFile(tempFile03, new File("/var/lib/jenkins/workspace/SampleTest/03.png"));
			//FileUtils.moveFile(tempFile03, new File("C:\\020_WORKS\\screenshots\\03.png"));
		}

		@After
		public void tearDown() {
			driver.quit();
		}

}
