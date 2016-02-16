package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    app.openMainPage();
    app.goToGroupsPage();
    app.initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group";
    group.header = "header";
    group.footer = "footer";
	app.fillGroupForm(this, group);
    app.submitGroupCreation();
    app.returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.openMainPage();
    app.goToGroupsPage();
    app.initGroupCreation();
    app.fillGroupForm(this, new GroupData("", "", ""));
    app.submitGroupCreation();
    app.returnToGroupsPage();
  }
}
