package Accessment;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomationAnalystAssignment {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.fitpeo.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();

		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,300)");
		Thread.sleep(5000);
		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
		Robot r = new Robot();
		Actions actions = new Actions(driver);
		actions.clickAndHold(slider).moveByOffset(93, 0).perform();
		for (;;) {
			r.keyPress(KeyEvent.VK_RIGHT);
			r.keyRelease(KeyEvent.VK_RIGHT);
			if (slider.getAttribute("aria-valuenow").equals("820")) {
				break;
			}
		}
		js.executeScript("window.scrollTo(0,300)");
		assertEquals(slider.getAttribute("aria-valuenow"), "820");
		js.executeScript("window.scrollTo(0,300)");
		WebElement textfield = driver.findElement(By.xpath("//input[@id=':r0:']"));
		textfield.click();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(000);
		js.executeScript("window.scrollTo(0,300)");
		textfield.sendKeys("560");
		Thread.sleep(5000);
		assertEquals(slider.getAttribute("aria-valuenow"), "560");

		Thread.sleep(5000);

		js.executeScript("window.scrollTo(0,800)");

		WebElement first_check_box = driver.findElement(By.xpath(
				"//p[text()='CPT-99091']/ancestor::div[@class='MuiBox-root css-1eynrej']/descendant::input[@type='checkbox']"));
		first_check_box.click();
		if (first_check_box.isSelected()) {
			System.out.println("first box selected");
		}
		WebElement second_check_box = driver.findElement(By.xpath(
				"//p[text()='CPT-99453']/ancestor::div[@class='MuiBox-root css-1eynrej']/descendant::input[@type='checkbox']"));
		second_check_box.click();
		if (second_check_box.isSelected()) {
			System.out.println("second box selected");
		}
		WebElement third_check_box = driver.findElement(By.xpath(
				"//p[text()='CPT-99454']/ancestor::div[@class='MuiBox-root css-1eynrej']/descendant::input[@type='checkbox']"));
		third_check_box.click();
		if (third_check_box.isSelected()) {
			System.out.println("third box selected");
		}
		js.executeScript("window.scrollTo(0,1500)");
		WebElement fourth_check_box = driver.findElement(By.xpath(
				"//p[text()='CPT-99474']/ancestor::div[@class='MuiBox-root css-1eynrej']/descendant::input[@type='checkbox']"));
		fourth_check_box.click();
		if (fourth_check_box.isSelected()) {
			System.out.println("fourth box selected");
		}

		String Total_R_Reimbursement = driver.findElement(By.xpath(
				"//p[@class='MuiTypography-root MuiTypography-body2 inter css-1xroguk' and contains(.,'Total Recurring Reimbursement for all Patients Per Month:')]/p"))
				.getText();
		if (Total_R_Reimbursement.contains("$110700")) {
			System.out.println("Total recurring reimbursement is : $110700");
		} else {
			System.out.println("Test successfull");
		}

		driver.quit();

	}
}
