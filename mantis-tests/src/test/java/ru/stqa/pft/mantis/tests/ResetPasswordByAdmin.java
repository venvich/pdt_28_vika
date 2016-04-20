package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UsersData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ResetPasswordByAdmin extends TestBase {

  @Test
  public void testRegistration() throws IOException, MessagingException {
    String newPassword = "password1";
    app.navi().goToLoginPage();
    app.userHelper().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
    app.navi().manageUsers();

    UsersData changedUser = app.userHelper().getAnyUserFromBD();
    app.navi().selectUserById(changedUser.getId());
    app.userHelper().resetPassword();
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String pwResetConfirmationLink = findResetPasswordLink(mailMessages, changedUser.getEmail());
    app.registration().finish(pwResetConfirmationLink, newPassword);
    
    app.navi().goToLoginPage();
    app.userHelper().login(changedUser.getUsername(), newPassword);
    app.navi().myView();
    String guiUser = app.userHelper().checkUser();
    assertEquals(guiUser, changedUser.getUsername());
  }

  private String findResetPasswordLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }


  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
