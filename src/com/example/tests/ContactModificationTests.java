package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.ListOf;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomvalidContactGenerator")
	public void modifySomeContact(ContactData contact) {

		// save old state
		ListOf<ContactData> oldList = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		// actions
		app.getContactHelper().modifyContact(index, contact);

		// save new state
		ListOf<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		oldList.remove(index);
		oldList.add(contact);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertThat(oldList, equalTo(newList));
	}

}
