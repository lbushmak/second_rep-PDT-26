package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator extends TestBase {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please, specify following parametrs: <amount of test data> <file> <format>");
			return;
		}

		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];

		if (file.exists()) {
			System.out.println("File exists, please remove it manually: " + file);
		}

		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
		}
	}

	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");

			ContactData contact = new ContactData().withFirstname(part[0]).withLastname(part[1]).withAdress(part[2])
					.withHome(part[3]).withMobile(part[4]).withWork(part[5]).withEmail(part[6]).withEmail2(part[7])
					.withBday(part[8]).withBmonth(part[9]).withByear(part[10]).withGroup(part[11]).withAdress2(part[12])
					.withPhone2(part[13]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();

	}

	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);

		return (List<ContactData>) xstream.fromXML(file);

	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstname() + "," + contact.getLastname() + "," + contact.getAddress() + ","
					+ contact.getHome() + "," + contact.getMobile() + "," + contact.getWork() + "," + contact.getEmail()
					+ "," + contact.getEmail2() + "," + contact.getBday() + "," + contact.getBmonth() + ","
					+ contact.getByear() + "," + contact.getAddress2() + "," + contact.getPhone2() + ",!" + "\n");
		}
		writer.close();

	}

	public static List<ContactData> generateRandomContacts(int amount) {

		List<ContactData> list = new ArrayList<ContactData>();

		for (int i = 0; i < amount; i++) {
			ContactData contact = new ContactData().withFirstname(generateRandomString())
					.withLastname(generateRandomString()).withAdress(generateRandomString())
					.withHome(generateRandomString()).withWork(generateRandomString())
					.withMobile(generateRandomString()).withEmail(generateRandomString())
					.withEmail2(generateRandomString()).withBday(generateRandomBDay())
					.withBmonth(generateRandomBMonth()).withByear(generateRandomBYear()).withGroup(chooseRandomGroup())
					.withAdress2(generateRandomString()).withPhone2(generateRandomString());

			list.add(contact);
		}
		return list;
	}

	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(5) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}

	}

	public static String chooseRandomGroup() {
		String[] group = new String[] { "group1", "123456", "no group", "1first_group", "!&^", " " };
		Random rnd = new Random();
		if (rnd.nextInt(6) == 0) {
			return "-";
		} else {
			return group[rnd.nextInt(group.length)];
		}
	}

	/*
	 * public static String chooseRandomGroup() {
	 * 
	 * app.navigateTo().getGroupList(); List<GroupData> groupList =
	 * app.getGroupHelper().getGroups(); Random rnd = new Random();// initiate
	 * random value int groupIndex = 0; if (groupList.size() > 1) { groupIndex =
	 * rnd.nextInt(groupList.size() - 1); // get random value // from 0 to list
	 * // size } return groupList.get(groupIndex).getGroupname(); // get random
	 * group // element }
	 */
	public static String generateRandomBDay() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "-";
		} else {
			return String.valueOf(rnd.nextInt(31) + 1);
		}
	}

	public static String generateRandomBMonth() {
		String[] month = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "November", "December" };
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "-";
		} else {
			return month[rnd.nextInt(month.length)];
		}
	}

	public static String generateRandomBYear() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return String.valueOf(rnd.nextInt(1015) + 1001);
		}
	}

}