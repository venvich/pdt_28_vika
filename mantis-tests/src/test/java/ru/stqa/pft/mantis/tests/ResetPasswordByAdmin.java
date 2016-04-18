package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ResetPasswordByAdmin extends TestBase {

  @Test
  public void testRegistration() throws IOException, MessagingException {
    HttpSession session = app.newSession();
    assertTrue(session.login("administrator", "root"));
    assertTrue(session.isLoggedInAs("administrator"));
    app.navi().manageUsers();
    selectUserById(user.getId());
    resetPassword();
    List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
    String resetPasswordLink = findResetPasswordLink(mailMessages, user.getEmail());
    clickLinkResetPassword();
    String newPassword = "password";
    setNewPassword(newPassword);
    assertTrue(app.newSession().login(user, newPassword));


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
