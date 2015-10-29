package com.example.tests;

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

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();

		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData();

			group.groupname = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();

			list.add(new Object[] { group });
		}
		return list.iterator();
	}

	@DataProvider
	public Iterator<Object[]> randomvalidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();

		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData();
			contact.firstname = generateRandomString();
			contact.lastname = generateRandomString();
			contact.address = generateRandomString();
			contact.address2 = generateRandomString();
			contact.email = generateRandomString();
			contact.email2 = generateRandomString();
			contact.home = generateRandomString();
			contact.mobile = generateRandomString();
			contact.phone2 = generateRandomString();
			contact.work = generateRandomString();

			contact.bday = generateRandomBDay();
			contact.byear = generateRandomBYear();
			contact.bmonth = generateRandomBMonth();

			contact.group = chooseRandomGroup();
			list.add(new Object[] { contact });
		}
		return list.iterator();
	}

	public GroupData chooseRandomGroup() {

		app.getNavigationHelper().getGroupList();
		List<GroupData> groupList = app.getGroupHelper().getGroups();
		Random rnd = new Random();// initiate random value
		int groupIndex = rnd.nextInt(groupList.size() + 1); // get random value
															// from
															// 0 to list size

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
