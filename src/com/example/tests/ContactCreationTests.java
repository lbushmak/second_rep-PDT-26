package com.example.tests;

import static org.junit.Assert.assertThat;

import java.util.Collections;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.ListOf;

@Test
public class ContactCreationTests extends TestBase {

	@Test(dataProvider = "randomvalidContactGenerator")
	public void testContactCreationwithValidData(ContactData contact) throws Exception {

		// save old state

		ListOf<ContactData> oldList = app.getContactHelper().getContacts();

		// actions

		app.getContactHelper().createContact(contact);

		// save new state

		ListOf<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		oldList.add(contact);
		Collections.sort(oldList);
		Collections.sort(newList);

		assertThat(oldList, equalTo(newList));
	}

}
