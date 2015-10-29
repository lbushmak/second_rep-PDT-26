package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();

		// save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();

		Random rnd = new Random();
		int groupIndex = rnd.nextInt(oldList.size() - 1);

		// actions
		app.getGroupHelper().initGroupModification(groupIndex);
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getNavigationHelper().gotoGroupsPage();

		// save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();

		// compare states
		oldList.remove(groupIndex);
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);

	}

}
