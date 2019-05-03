package com;       // package name makes no sense 

// too many empty lines


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


//No javadocs provided
public class Bank {
    // Interface name should be preferred in declarations: SortedMap<User, List<Account>> treemap = new TreeMap<>();
    private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();

    public void addUser(User user) {
        // A check for existing user should be done before possible overwriting
        this.treemap.put(user, new ArrayList<>());
    }

    public void delete(User user) {
        // This method could return a boolean to show that a delete took place
        this.treemap.remove(user);
    }

    public void add(User user, Account account) {
        // Null value should be checked before doing .add()
        this.treemap.get(user).add(account);
    }

    // must be public for testability
    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> list = this.treemap.get(user);
        // list may be null and should be checked
        return list.get(list.indexOf(account));
    }

    public void deleteAccount(User user, Account account) {
        // Null value should be checked before doing .remove()
        this.treemap.get(user).remove(account);
    }

    public List<Account> getAccounts(User user) {
        return this.treemap.get(user);
    }

    public boolean transfer(User user1, Account account1,
                            User user2, Account account2, double amount) {
        // Null value should be checked before doing .contains()
        return this.treemap.get(user1).contains(account1)
                && this.treemap.get(user2).contains(account2)
                // getActualAccount() may also result in a null - should be checked
                && getActualAccount(user1, account1).transfer(
                getActualAccount(user2, account2), amount);
    }

    // @Override - ?
    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";  // Can be replaced with String.format()
    }
}