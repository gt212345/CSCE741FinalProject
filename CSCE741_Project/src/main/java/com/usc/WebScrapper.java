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
	private String filePath = "..\\sections.csv";
	private String driverPath = "..\\chromedriver.exe";

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		WebScrapper ws = new WebScrapper();

		campusList.add("USC Columbia");
		//subList.add("CSCE - Comp Sci & Comp Engr");
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
		
		boolean newSub = false;

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
			
			//WebScrapper.populate();
			campusList.add("USC Columbia");
			//subList.add("CSCE - Comp Sci & Comp Engr");
			subList.add("AFYS - First Year Seminar");
			subList.add("CHIN - Chinese");
			subList.add("ARAB - Arabic");
			subList.add("ANES - Anesthesiology");

			for (String campus : campusList) {
				
				String lastCampus = campus;

				System.out.println(campus);

				for (String sub : subList) {
					
//					if(newSub) {
//						driver.findElement(By.xpath("//*[@id=\"camp_id\"]")).sendKeys(campus);
//						driver.findElement(By.xpath("//*[@id=\"subj_id\"]")).sendKeys(sub);
//						driver.findElement(By.id("id____UID5")).click();
//					}

					System.out.println(sub);
					
					String lastSub = sub;

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
						
						if (allButtons.size() <= 4) {
							driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
							driver.findElement(By.xpath("//*[@id=\"crumb\"]/div[1]/a")).click();
							driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
							driver.findElement(By.id("contentItem12")).click();
							Select dropdown1 = new Select(driver.findElement(By.id("term_input_id")));
							dropdown1.selectByVisibleText("Spring 2018");
							driver.findElement(By.id("id____UID7")).click();
							break;
						}

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
														
								for(int ic = cells.size(); ic < 18; ic++) {
									line += " ,";
								}

								SectionScrapper s = new SectionScrapper();

								s = addSection(line);

								sections.add(s);
							}

						}
						
						if(!campus.equals(lastCampus)) {
							System.out.println(campus);
							System.out.println(lastCampus);
						}
						

						driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
						driver.findElement(By.xpath("//*[@id=\"crumb\"]/div[1]/a")).click();
						driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
						driver.findElement(By.id("contentItem12")).click();

						Select dropdown1 = new Select(driver.findElement(By.id("term_input_id")));
						dropdown1.selectByVisibleText("Spring 2018");
						driver.findElement(By.id("id____UID7")).click();

						driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
						
						if(allButtons.size() - 4 == buttonsClicked.size()) {
							buttonsClicked.clear();
							//newSub = true;	

						} else {
							driver.findElement(By.xpath("//*[@id=\"camp_id\"]")).sendKeys(campus);
							driver.findElement(By.xpath("//*[@id=\"subj_id\"]")).sendKeys(sub);
							driver.findElement(By.id("id____UID5")).click();
							newSub = false;
						}
						

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
	
	private static void populate() {
		
		campusList.add("USC Columbia");
		subList.add("ACCT - Accounting");
		subList.add("AERO - Aerospace Studies");
		subList.add("AFAM - African Amer Studies");
		subList.add("AFCI - Critical Inquiry");
		subList.add("AFYS - First Year Seminar");
		subList.add("AMST - American Studies");
		subList.add("ANES - Anesthesiology");
		subList.add("ANTH - Anthropology");
		subList.add("ARAB - Arabic");
		subList.add("ARMY - Military Science");
		subList.add("ARTE - Art Education");
		subList.add("ARTH - Art History");
		subList.add("ARTS - Art Studio");
		subList.add("ASLG - American Sign Language");
		subList.add("ASTR - Astronomy");
		subList.add("ASUP - Academic Support Svcs");
		subList.add("ATEP - Athletic Training");
		subList.add("BADM - Business Administration");
		subList.add("BIOL - Biology");
		subList.add("BIOS - Biostatistics");
		subList.add("BMEN - Biomedical Engineering");
		subList.add("BMSC - Biomedical Science");
		subList.add("CAST - Child Advocacy Studies");
		subList.add("CHEM - Chemistry");
		subList.add("CHIN - Chinese");
		subList.add("CLAS - Classics");
		subList.add("COLA - Coll of Liberal Arts");
		subList.add("COMD -Communication Disorders");
		subList.add("COMM - Communications");
		subList.add("COSM - Prof Master of Sci Prog");
		subList.add("CPLT - Comparative Literature");
		subList.add("CRJU - Criminal Justice");
		subList.add("CSCE - Comp Sci &amp; Comp Engr");
		subList.add("CSCI - Computer Science");
		subList.add("DANC - Dance");
		subList.add("DMED - Medical Topics");
		subList.add("DMSB - Darla Moore Sch of Busn");
		subList.add("ECHE - Chemical Engineering");
		subList.add("ECIV - Civil Engineering");
		subList.add("ECON - Economics");
		subList.add("EDCE - Counseling Education");
		subList.add("EDCF - Child Dev &amp; Family Stds");
		subList.add("EDCI - Curriculum, Instruction");
		subList.add("EDCS - Curriculum Studies");
		subList.add("EDEC - Early Childhood Educ");
		subList.add("EDEL - Elementary Education");
		subList.add("EDET - Educational Technology");
		subList.add("EDEX - Exceptional Children");
		subList.add("EDFI - Educ Foundations &amp; Inq");
		subList.add("EDFN - Foundations of Educ");
		subList.add("EDFO - Educ - Foundations");
		subList.add("EDHE - Higher Education");
		subList.add("EDHL - Health Education");
		subList.add("EDIT - Instructer &amp; Teacher Ed");
		subList.add("EDLC - Literacy Education");
		subList.add("EDLD - Learning Disabilities");
		subList.add("EDLP - School Leadership");
		subList.add("EDML - Middle Level Education");
		subList.add("EDPH - Physical Education");
		subList.add("EDPS - Professional Studies");
		subList.add("EDPY - Educational Psychology");
		subList.add("EDRD - Reading");
		subList.add("EDRE - Reading Education");
		subList.add("EDRM - Research &amp; Measurement");
		subList.add("EDSC - Secondary Education");
		subList.add("EDSE - Secondary Education");
		subList.add("EDTE - Instr and Teacher Educ");
		subList.add("EDUC - Education");
		subList.add("EDVI - Visual Impairment");
		subList.add("ELCT - Electrical Engineering");
		subList.add("EMCH - Mechanical Engineering");
		subList.add("EMED - Emergency Medicine");
		subList.add("ENCP - Engr and Computing");
		subList.add("ENFS - Engl - Foreign Students");
		subList.add("ENGL - English");
		subList.add("ENHS - Environmental Hlth Sci");
		subList.add("ENSL - Engl as a Sec Language");
		subList.add("ENVR - Environment");
		subList.add("EPID - Epidemiology");
		subList.add("ETMG - Engineering Tech Mgmt");
		subList.add("EURO - European Studies");
		subList.add("EXSC - Exercise Science");
		subList.add("FAMS - Film and Media Studies");
		subList.add("FILM - Film Studies");
		subList.add("FINA - Finance");
		subList.add("FORL - Foreign Languages");
		subList.add("FPMD - Family &amp; Preventive Med");
		subList.add("FREN - French");
		subList.add("GENE - Genetics");
		subList.add("GEOG - Geography");
		subList.add("GEOL - Geology");
		subList.add("GERM - German");
		subList.add("GLST - Global Studies");
		subList.add("GMED - Greenville Medicine");
		subList.add("GRAD - The Graduate School");
		subList.add("GREK - Greek");
		subList.add("HGEN - Genetic Counseling");
		subList.add("HIMS - Health Care Info Mgmt");
		subList.add("HIST - History");
		subList.add("HMSV - Human Services");
		subList.add("HONS - Honors");
		subList.add("HPEB - Hlth Promo Educ &amp; Beh");
		subList.add("HPRO - Health Promotion");
		subList.add("HRSM - Hosp Retail Sport Mgmt");
		subList.add("HRTM - Hotel Rest Tourism Mgmt");
		subList.add("HSPM - Hlth Serv Policy Mgmt");
		subList.add("IBUS - International Business");
		subList.add("IDST - Interdisciplnry Studies");
		subList.add("INFO - Info Mgmt Systems");
		subList.add("INTL - Intl Study Abroad");
		subList.add("ITAL - Italian");
		subList.add("ITEC - Integrated Info Tech");
		subList.add("JAPA - Japanese");
		subList.add("JOUR - Journalism");
		subList.add("JSTU - Jewish Studies");
		subList.add("LANU - Nursing");
		subList.add("LASP - Latin American Studies");
		subList.add("LATN - Latin");
		subList.add("LAWS - Law School");
		subList.add("LBST - Liberal Studies");
		subList.add("LIBR - Libraries");
		subList.add("LING - Linguistics");
		subList.add("LOGC - Logic");
		subList.add("MART - Media Arts");
		subList.add("MATH - Mathematics");
		subList.add("MBAD - Master Busn Admin Prog");
		subList.add("MBIM - Microblgy &amp; Immunology");
		subList.add("MCBA - Cell Biol &amp; Anatomy");
		subList.add("MEDI - Medicine Clinical");
		subList.add("MGMT - Management");
		subList.add("MGSC - Management Science");
		subList.add("MILS - Military Science");
		subList.add("MKTG - Marketing");
		subList.add("MSCI - Marine Science");
		subList.add("MUED - Music Education");
		subList.add("MUSC - Music");
		subList.add("MUSM - Museum Management");
		subList.add("NAVY - Navy");
		subList.add("NEUR - Neurology");
		subList.add("NPAD - Non-profit Admin");
		subList.add("NPSY - Neuropsychiatry");
		subList.add("NURS - Nursing");
		subList.add("OBGY - Obstetrics / Gynecology");
		subList.add("OPTH - Ophthalmology");
		subList.add("ORSU - Orthopaedic Surgery");
		subList.add("PALM - Palmetto Programs");
		subList.add("PAMB - Patholgy &amp; Microbiology");
		subList.add("PATH - Pathology");
		subList.add("PEDI - Pediatrics");
		subList.add("PEDU - Physical Education");
		subList.add("PHAR - Pharmacy");
		subList.add("PHIL - Philosophy");
		subList.add("PHMY - Pharmacy Professional");
		subList.add("PHPH - Physlgy &amp; Pharmacology");
		subList.add("PHYS - Physics");
		subList.add("PHYT - Physical Therapy");
		subList.add("PMDR - Phys Medicine &amp; Rehab");
		subList.add("POLI - Political Science");
		subList.add("PORT - Portuguese");
		subList.add("PSYC - Psychology");
		subList.add("PUBH - Public Health");
		subList.add("Palmetto College");
		subList.add("RADI - Radiology");
		subList.add("RELG - Religious Studies");
		subList.add("RETL - Retailing");
		subList.add("RHAB - Rehab Counseling");
		subList.add("RUSS - Russian");
		subList.add("SAEL - Soc Advoc &amp; Ethicl Life");
		subList.add("SCCP - SC College of Pharmacy");
		subList.add("SCHC - SC Honors College");
		subList.add("SLIS - Library &amp; Info Science");
		subList.add("SMED - Science and Math Educ");
		subList.add("SOCY - Sociology");
		subList.add("SOST - Southern Studies");
		subList.add("SOWK - Social Work");
		subList.add("SPAN - Spanish");
		subList.add("SPCH - Speech");
		subList.add("SPTE - Sport &amp; Entertnmnt Mgmt");
		subList.add("STAT - Statistics");
		subList.add("SURG - Surgery");
		subList.add("THEA - Theatre");
		subList.add("UNIV - University Experience");
		subList.add("WGST - Women &amp; Gender Studies");

		
	}

	private static SectionScrapper addSection(String line) {
		String[] fields = line.split(",");

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
