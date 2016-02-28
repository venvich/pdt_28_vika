package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
      click(By.linkText("Gruppen"));
  }

  public void gotoHauptseite() { click(By.linkText("Hauptseite")); }

  public void gotoHomePage() { click(By.linkText("home page")); }


}
