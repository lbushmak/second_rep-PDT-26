package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.home);
		type(By.name("mobile"), contact.mobile);
		type(By.name("work"), contact.work);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);
		selectByText(By.name("bday"), contact.bday);
		selectByText(By.name("bmonth"), contact.bmonth);
		type(By.name("byear"), contact.byear);
		// selectByText(By.name("new_group"), contact.group);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phone2);
	}

	public void deleteContact(int contactIndex) {
		selectContactByIndex(contactIndex);
		click(By.xpath("(//input[@name='update'])[2]"));

	}

	private void selectContactByIndex(int contactIndex) {
		click(By.xpath("(//img[@alt='Edit'])[" + (contactIndex + 1) + "]"));
	}

	public void initContactModification(int contactIndex) {
		selectContactByIndex(contactIndex);
	}

	public void submitContactModification() {
		click(By.xpath("(//input[@name='update'])[1]"));

	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			String title = checkbox.getAttribute("title");
			title = title.substring("Select (".length(), title.lastIndexOf(")"));
			if (title.length() == 0) {
				contact.firstname = "";
				contact.lastname = "";
			} else {
				contact.firstname = title.substring(0, title.indexOf(" "));
				contact.lastname = title.substring(title.indexOf(" ") + 1);
			}
			contacts.add(contact);
		}
		return contacts;

	}
}
