package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<GroupData> cachedGroups;

	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups == null) {
			rebuildCache();
		}
		return cachedGroups;
	}

	private void rebuildCache() {
		cachedGroups = new SortedListOf<GroupData>();

		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {

			String title = checkbox.getAttribute("title");
			String groupname = title.substring("Select (".length(), title.length() - ")".length());
			cachedGroups.add(new GroupData().withGroupname(groupname));
		}

	}

	public void createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();
		returnToGroupsPage();
		rebuildCache();

	}

	public GroupHelper deleteGroup(int groupIndex) {
		selectGroupByIndex(groupIndex);
		submitGroupRemoval();
		returnToGroupsPage();
		rebuildCache();
		return this;

	}

	public GroupHelper modifyGroup(int groupIndex, GroupData group) {
		initGroupModification(groupIndex);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupsPage();
		rebuildCache();
		return this;
	}

	// ----------------------------------------------------------------------------------------------------------------------------

	public GroupHelper initGroupCreation() {
		manager.navigateTo().groupsPage();
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getGroupname());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	public GroupHelper returnToGroupsPage() {
		click(By.linkText("groups"));
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		return this;
	}

	private void selectGroupByIndex(int groupIndex) {
		click(By.xpath("//input[@name='selected[]'][" + (groupIndex + 1) + "]"));
	}

	public GroupHelper initGroupModification(int groupIndex) {
		selectGroupByIndex(groupIndex);
		click(By.name("edit"));
		return this;

	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups = null;
		return this;

	}

	public void submitGroupRemoval() {
		click(By.name("delete"));
		cachedGroups = null;
	}

}
