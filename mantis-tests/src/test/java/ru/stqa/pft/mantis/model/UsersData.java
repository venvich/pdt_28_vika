package ru.stqa.pft.mantis.model;

import java.util.HashSet;
import java.util.Set;

public class UsersData {

  private String username;
  private String email;
  private String accessLevel;

  private Set<UsersData> users = new HashSet<UsersData>();

  public String getEmail() {
    return email;
  }

  public UsersData setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getAccessLevel() {
    return accessLevel;
  }

  public UsersData setAccessLevel(String accessLevel) {
    this.accessLevel = accessLevel;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public UsersData setUsername(String username) {
    this.username = username;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UsersData usersData = (UsersData) o;

    if (username != null ? !username.equals(usersData.username) : usersData.username != null) return false;
    if (email != null ? !email.equals(usersData.email) : usersData.email != null) return false;
    return accessLevel != null ? accessLevel.equals(usersData.accessLevel) : usersData.accessLevel == null;

  }

  @Override
  public int hashCode() {
    int result = username != null ? username.hashCode() : 0;
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (accessLevel != null ? accessLevel.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "UsersData{" +
            "username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", accessLevel='" + accessLevel + '\'' +
            '}';
  }
}
