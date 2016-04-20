package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.Users;
import ru.stqa.pft.mantis.model.UsersData;

public class UserHelper extends HelperBase {

  public UserHelper(ApplicationManager app) {
    super(app);
  }

  public void selectUser(String name) {
    click(By.linkText("user1"));
  }

  public void resetPassword() {
    click(By.cssSelector("input[value='Reset Password']"));
  }

  public UsersData getAnyUserFromBD() {
    Users users = app.db().getUsersFromBD();
    return users.stream().filter((u) -> u.getAccessLevel() != 90).iterator().next();
  }

  public void login(String username, String password) {
    type(By.name("username"), username);
    type(By.name("password"), password);
    click(By.cssSelector("input[value=\"Login\"]"));
  }

  public UsersData getUserByIdFromBD(int id) {
    Users users = app.db().getUsersFromBD();
    return users.stream().filter((u) -> u.getId() == id).findFirst().get();
  }

  public String checkUser() {
    String username = wd.findElement(By.xpath("html/body/table[1]/tbody/tr/td[1]/span[1]")).getText();
    return username;
  }
}
