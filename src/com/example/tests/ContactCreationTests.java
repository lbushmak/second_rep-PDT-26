package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

@Test
public class ContactCreationTests extends TestBase {

	@Test(dataProvider = "randomvalidContactGenerator")
	public void testContactCreationwithValidData(ContactData contact) throws Exception {
		// app.navigateTo().mainPage();

		// save old state
		TestBase.writeTime("before save old ");
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		TestBase.writeTime("after save old ");
		// actions
		TestBase.writeTime("before save action ");
		app.getContactHelper().createContact(contact);
		TestBase.writeTime("after save action ");

		// save new state
		TestBase.writeTime("before save new state ");
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		TestBase.writeTime("after save new state ");

		// compare states
		assertThat(newList, equalTo(oldList.withAdded(contact)));
	}

}
