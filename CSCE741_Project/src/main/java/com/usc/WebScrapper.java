package com.usc;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebScrapper {

	private static List<String> campusList = new ArrayList<>();
	private static List<String> subList = new ArrayList<>();

	// Set File Path
	private String filePath = "C:\\Users\\Hassan\\Documents\\Scrape\\sections.txt";
	private String driverPath = "C:\\Users\\Hassan\\Documents\\Scrape\\chromedriver.exe";

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		WebScrapper ws = new WebScrapper();

		campusList.add("USC Columbia");
		subList.add("CSCE - Comp Sci & Comp Engr");
		subList.add("CHIN - Chinese");

		String u = "";
		String pw = "";

		ws.scrape(u, pw);

	}

	public void scrape(String usr, String psw) {
		List<SectionScrapper> sections = new ArrayList<>();
		List<String> buttonsClicked = new ArrayList<>();

		PrintWriter writer = null;
		WebDriver driver = null;

		try {
			writer = new PrintWriter(filePath, "UTF-8");
			System.setProperty("webdriver.chrome.driver", driverPath);

			driver = new ChromeDriver();

			driver.navigate().to("https://my.sc.edu");

			driver.findElement(By.linkText("Sign in to Self Service Carolina (SSC)")).click();

			WebElement userName = driver.findElement(By.id("generic-username"));
			WebElement password = driver.findElement(By.id("generic-password"));
			WebElement submit = driver.findElement(By.className("btn-submit"));

			userName.sendKeys(usr);
			password.sendKeys(psw);
			submit.click();

			driver.switchTo().frame("duo_iframe");
			// List<WebElement> duoButton = driver.findElements(By.className("button"));
			WebElement bt = driver.findElement(By.xpath("//*[@id='login-form']/fieldset[2]/div[1]/button"));
			// *[@id="login-form"]/fieldset[2]/div[1]/button
			bt.click();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.findElement(By.xpath("//span[text()='Student']")).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//h3[text()='Registration']")).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.findElement(By.id("contentItem12")).click();

			Select dropdown = new Select(driver.findElement(By.id("term_input_id")));
			dropdown.selectByVisibleText("Spring 2018");
			driver.findElement(By.id("id____UID7")).click();

			for (String campus : campusList) {

				System.out.println(campus);

				for (String sub : subList) {

					System.out.println(sub);

					driver.findElement(By.xpath("//*[@id=\"camp_id\"]")).sendKeys(campus);
					driver.findElement(By.xpath("//*[@id=\"subj_id\"]")).sendKeys(sub);

					driver.findElement(By.id("id____UID5")).click();

					List<WebElement> allButtons = driver.findElements(By.className("htmlButton"));

					// for (WebElement b : allButtons) {
					for (int i = 1; i <= allButtons.size() - 1; i++) {

						// String id = b.getAttribute("id");
						List<WebElement> allButtons1 = driver.findElements(By.className("htmlButton"));
						WebElement b = allButtons1.get(i);

						String id = b.getAttribute("id");

						System.out.println(id);

						if (!id.substring(0, 9).equals("id____UID")) {
							continue;
						}

						if (buttonsClicked.contains(id)) {
							continue;
						}

						b.click();
						buttonsClicked.add(id);

						WebElement table = driver.findElement(By.className("datadisplaytable"));
						List<WebElement> allRows = table.findElements(By.tagName("tr"));
						for (WebElement row : allRows) {
							List<WebElement> cells = row.findElements(By.tagName("td"));

							String line = "";
							String sep = ",";

							for (WebElement cell : cells) {
								line += cell.getText() + sep;
							}

							if (!line.equals("")) {

								SectionScrapper s = new SectionScrapper();

								s = addSection(line);

								sections.add(s);
							}

						}

						driver.findElement(By.xpath("//*[@id=\"crumb\"]/div[1]/a")).click();
						driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
						driver.findElement(By.id("contentItem12")).click();

						Select dropdown1 = new Select(driver.findElement(By.id("term_input_id")));
						dropdown1.selectByVisibleText("Spring 2018");
						driver.findElement(By.id("id____UID7")).click();

						driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

						driver.findElement(By.xpath("//*[@id=\"camp_id\"]")).sendKeys("USC Columbia");
						driver.findElement(By.xpath("//*[@id=\"subj_id\"]")).sendKeys("CSCE - Comp Sci & Comp Engr");

						driver.findElement(By.id("id____UID5")).click();

					}

				}

			}

			// driver.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}

		for (SectionScrapper s : sections) {
			String out = s.toString();
			writer.println("NR," + out);
		}

		writer.close();
	}

	private static SectionScrapper addSection(String line) {
		String[] fields = line.split(";");

		SectionScrapper s = new SectionScrapper();
		s.setActual(fields[12]);
		s.setAttribute(fields[17]);
		s.setCampus(fields[5]);
		s.setCapacity(fields[11]);
		s.setCourse(fields[3]);
		s.setCred(fields[6]);
		s.setCrn(fields[1]);
		s.setDate(fields[15]);
		s.setDays(fields[9]);
		s.setInstructor(fields[14]);
		s.setLocation(fields[16]);
		s.setRemaing(fields[13]);
		s.setSec(fields[4]);
		s.setSubj(fields[2]);
		s.setTerm(fields[7]);
		s.setTime(fields[10]);
		s.setTitle(fields[8]);

		return s;
	}

}
