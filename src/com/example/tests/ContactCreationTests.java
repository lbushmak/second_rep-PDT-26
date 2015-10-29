package com.example.tests;

import org.testng.annotations.Test;

@Test
public class ContactCreationTests extends TestBase{
	
  @Test
public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
    initContactCreation();
    ContactData contact = new ContactData();
	contact.firstname = "name_1";
	contact.lastname = "last_name_1";
	contact.address = "address_1";
	contact.home = "111";
	contact.mobile  = "+777";
	contact.work = "222";
	contact.email = "a@b.ru";
	contact.email2 = "a1@b.ru";
	contact.bday = "1";
	contact.bmonth = "January";
	contact.byear = "1990";
	contact.group = "new_group";
	contact.address2 = "address_2";
	contact.phone2 = "222";
	fillContactForm(contact);
    submitContactCreation();
    returnToMainPage();
  }

  @Test
public void testEmptyContactCreation() throws Exception {
	openMainPage();
    initContactCreation();
    fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "", ""));
    submitContactCreation();
    returnToMainPage();
  }
}

