package ru.stqa.pft.mantis.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void goToLoginPage() {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
  }

  public void manageUsers() {
    click(By.linkText("Manage Users"));
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }

  public void myView() {
    click(By.linkText("My View"));
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }

  public void selectUserById(int id) {
    click(By.cssSelector("a[href=\"manage_user_edit_page.php?user_id=" + id +"\"]"));
  }

}
