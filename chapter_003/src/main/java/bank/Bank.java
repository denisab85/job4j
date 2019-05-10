package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Represents a bank institution with multiple accounts.
 */
public class Bank {

    private final SortedMap<User, List<Account>> userAccounts = new TreeMap<>();

    /**
     * If the specified user does not exist in the bank, adds the user with an empty account list.
     *
     * @param user user to add.
     * @return {@code true} if the user did not exist.
     */
    public boolean addUser(User user) {
        return this.userAccounts.putIfAbsent(user, new ArrayList<>()) == null;
    }

    /**
     * Removes the user and all its associated accounts from the bank.
     *
     * @param user user to delete
     * @return {@code true} if @param user existed.
     */
    public boolean delete(User user) {
        return this.userAccounts.remove(user) != null;
    }

    /**
     * Adds a new account to the specified user.
     *
     * @param user    user to add account to.
     * @param account account to add.
     * @return {@code true} if @param user existed and @param account was added to it.
     */
    public boolean addAccount(User user, Account account) {
        boolean result = false;
        if (userExists(user) && !accountExists(user, account)) {
            this.userAccounts.get(user).add(account);
            result = true;
        }
        return result;
    }

    /**
     * Checks whether the specified user exists in this bank.
     *
     * @param user user to search.
     * @return {@code true} if @param user exists.
     */
    public boolean userExists(User user) {
        return (this.userAccounts.containsKey(user));
    }

    /**
     * Checks whether the specified account belongs to the user.
     *
     * @param user    user to search.
     * @param account account to verify.
     * @return {@code true} if @param user exists and @param account belongs to it.
     */
    public boolean accountExists(User user, Account account) {
        return userExists(user) && this.userAccounts.get(user).contains(account);
    }

    /**
     * Deletes specified account belonging to the user.
     *
     * @param user    user whose account should be deleted.
     * @param account account to delete.
     * @return {@code true} if @param account existed in @param user's accounts.
     */
    public boolean deleteAccount(User user, Account account) {
        boolean result = false;
        if (accountExists(user, account)) {
            result = this.userAccounts.get(user).remove(account);
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return this.userAccounts.get(user);
    }

    /**
     * Transfer specified @param amount from @param account1 to @param account2, both belonging to @param user.
     *
     * @param user     the owner of both accounts.
     * @param account1 source account.
     * @param account2 destination account.
     * @param amount   USD amount to transferTo.
     * @return {@code true} if transaction was successful.
     */
    public boolean transfer(User user, Account account1, Account account2, double amount) {
        return transfer(user, account1, user, account2, amount);
    }

    /**
     * Transfer specified @param amount from @param account1 belonging to @param user1 to @param account2 belonging to @param user2.
     *
     * @param user1    the owner of the source account.
     * @param account1 source account.
     * @param user2    the owner of the source account.
     * @param account2 destination account.
     * @param amount   USD amount to transferTo.
     * @return {@code true} if transaction was successful.
     */
    public boolean transfer(User user1, Account account1, User user2, Account account2, double amount) {
        return accountExists(user1, account1) && accountExists(user2, account2)
                && account1.transferTo(account2, amount);
    }

    @Override
    public String toString() {
        return String.format("Bank{accounts=%s}", userAccounts);
    }
}