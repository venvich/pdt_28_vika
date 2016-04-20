package ru.stqa.pft.mantis.model;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")
public class UsersData {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "username")
  private String username;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "access_level")
  @Type(type = "short")
  private short accessLevel;

  //private Set<UsersData> users = new HashSet<UsersData>();

  public int getId() {
    return id;
  }

  public UsersData setId(int id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public UsersData setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public UsersData setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UsersData setPassword(String password) {
    this.password = password;
    return this;
  }

  public int getAccessLevel() {
    return accessLevel;
  }

  public UsersData setAccessLevel(short accessLevel) {
    this.accessLevel = accessLevel;
    return this;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", accessLevel=" + accessLevel +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UsersData user = (UsersData) o;

    if (id != user.id) return false;
    if (accessLevel != user.accessLevel) return false;
    if (username != null ? !username.equals(user.username) : user.username != null) return false;
    if (email != null ? !email.equals(user.email) : user.email != null) return false;
    return password != null ? password.equals(user.password) : user.password == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (username != null ? username.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + accessLevel;
    return result;
  }
}
