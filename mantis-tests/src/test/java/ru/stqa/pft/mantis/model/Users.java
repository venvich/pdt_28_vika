package ru.stqa.pft.mantis.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Users extends ForwardingSet<UsersData> {

  private Set<UsersData> delegate;
  public Users(Users users) {
    this.delegate = new HashSet<UsersData>(users.delegate());
  }

  public Users(Collection<UsersData> users) {
    this.delegate = new HashSet<UsersData>(users);
  }

  public Users() {
    this.delegate = new HashSet<UsersData>();
  }

  @Override
  protected Set<UsersData> delegate() {
    return delegate;
  }

  public Users withAdded(UsersData user) {
    Users users = new Users(this);
    users.add(user);
    return users;
  }

  public Users without(UsersData user) {
    Users users = new Users(this);
    users.remove(user);
    return users;
  }
}
