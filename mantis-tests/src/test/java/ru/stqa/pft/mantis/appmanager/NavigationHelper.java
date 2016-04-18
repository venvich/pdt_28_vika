package ru.stqa.pft.mantis.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager applicationManager) {
    super(applicationManager);
  }

  public void manageUsers() {
    click(By.linkText("Manage Users"));
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }

  public void myView() {
    click(By.linkText("My View"));
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }

}
