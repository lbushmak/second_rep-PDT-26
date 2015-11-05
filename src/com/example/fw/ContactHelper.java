package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<ContactData> cachedContacts;

	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}

	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();

		List<WebElement> firstNames = driver.findElements(By.xpath("//tr[@name='entry']//td[3]"));
		List<WebElement> lastNames = driver.findElements(By.xpath("//tr[@name='entry']//td[2]"));
		assert firstNames.size() == lastNames.size();

		for (int i = 0; i < firstNames.size(); i++) {
			ContactData contact = new ContactData();
			contact.lastname = lastNames.get(i).getText();
			contact.firstname = firstNames.get(i).getText();
			cachedContacts.add(contact);
		}

	}

	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		initContactCreation();
		fillContactForm(contact, CREATION);
		submitContactCreation();
		returnToMainPage();
		rebuildCache();
		return this;

	}

	public ContactHelper deleteContact(int contactIndex) {
		selectContactByIndex(contactIndex);
		submitContactRemoval();
		returnToMainPage();
		rebuildCache();
		return this;

	}

	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactModification(index);
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		returnToMainPage();
		rebuildCache();
		return this;

	}
	// ---------------------------------------------------------------------------------

	private ContactHelper submitContactRemoval() {
		click(By.xpath("(//input[@name='update'])[2]"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHome());
		type(By.name("mobile"), contact.getMobile());
		type(By.name("work"), contact.getWork());
		type(By.name("email"), contact.getEmail());
		type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), contact.getBday());
		selectByText(By.name("bmonth"), contact.getBmonth());
		type(By.name("byear"), contact.getByear());
		if (formType == CREATION) {
			// selectByText(By.name("new_group"), contact.group);
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error("Group selector exists in contact modification form");
			}
		}
		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getPhone2());
		return this;
	}

	private ContactHelper selectContactByIndex(int contactIndex) {
		click(By.xpath("(//img[@alt='Edit'])[" + (contactIndex + 1) + "]"));
		return this;
	}

	public ContactHelper initContactModification(int contactIndex) {
		selectContactByIndex(contactIndex);
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToMainPage() {
		click(By.linkText("home"));
		return this;
	}

	public ContactHelper submitContactModification() {
		click(By.xpath("(//input[@name='update'])[1]"));
		cachedContacts = null;
		return this;

	}

}
