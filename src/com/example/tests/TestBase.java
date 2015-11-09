package com.example.tests;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	public static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();

	}

	public static void writeTime(String msg) {
		SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
		String current_time_str = time_formatter.format(System.currentTimeMillis());
		System.out.println(msg + current_time_str);
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();

		for (int i = 0; i < 1; i++) {
			GroupData group = new GroupData().withGroupname(generateRandomString()).withHeader(generateRandomString())
					.withFooter(generateRandomString());

			list.add(new Object[] { group });
		}
		return list.iterator();
	}

	@DataProvider
	public Iterator<Object[]> randomvalidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();

		for (int i = 0; i < 1; i++) {
			ContactData contact = new ContactData().withFirstname(generateRandomString())
					.withLastname(generateRandomString()).withAdress(generateRandomString())
					.withAdress2(generateRandomString()).withEmail(generateRandomString())
					.withEmail2(generateRandomString()).withHome(generateRandomString())
					.withMobile(generateRandomString()).withPhone2(generateRandomString())
					.withWork(generateRandomString()).withBday(generateRandomBDay()).withByear(generateRandomBYear())
					.withBmonth(generateRandomBMonth()).withGroup(chooseRandomGroup());

			list.add(new Object[] { contact });
		}
		return list.iterator();
	}

	public GroupData chooseRandomGroup() {

		app.navigateTo().getGroupList();
		List<GroupData> groupList = app.getGroupHelper().getGroups();
		Random rnd = new Random();// initiate random value
		int groupIndex = 0;
		if (groupList.size() > 1) {
			groupIndex = rnd.nextInt(groupList.size() - 1); // get random value
															// from 0 to list
															// size
		}
		return groupList.get(groupIndex); // get random group element
	}

	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(5) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}

	}

	public String generateRandomBDay() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "-";
		} else {
			return String.valueOf(rnd.nextInt(31) + 1);
		}
	}

	public String generateRandomBMonth() {
		String[] month = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "November", "December" };
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "-";
		} else {
			return month[rnd.nextInt(month.length)];
		}
	}

	public String generateRandomBYear() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return String.valueOf(rnd.nextInt(1015) + 1001);
		}
	}

}
