package bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BankTest {

    private User user1;
    private User user2;
    private Account account1;
    private Account account2;
    private Bank bank;

    @Before
    public void createObjects() {
        user1 = new User("User #1", "1803-856111");
        user2 = new User("User #2", "1803-856222");
        account1 = new Account(1000, "12365-54665-1111");
        account2 = new Account(1000, "12365-54665-2222");
        bank = new Bank();
    }

    @Test
    public void whenAddUserThenUserExists() {
        bank.addUser(user1);
        assertTrue(bank.userExists(user1));
    }

    @Test
    public void whenAddUserThenReturnTrue() {
        assertTrue(bank.addUser(user1));
    }

    @Test
    public void whenAddExistingUserThenReturnFalse() {
        bank.addUser(user1);
        assertFalse(bank.addUser(user1));
    }

    @Test
    public void whenDeleteUserThenUserNotExists() {
        bank.addUser(user1);
        bank.delete(user1);
        assertFalse(bank.userExists(user1));
    }

    @Test
    public void whenDeleteUserThenReturnTrue() {
        bank.addUser(user1);
        assertTrue(bank.delete(user1));
    }

    @Test
    public void whenDeleteNonExistingUserThenReturnFalse() {
        assertFalse(bank.delete(user1));
    }

    @Test
    public void whenDeleteExistingAccountThenReturnTrue() {
        bank.addUser(user1);
        bank.addAccount(user1, account1);
        assertTrue(bank.deleteAccount(user1, account1));
    }

    @Test
    public void whenDeleteAccountThenAccountNotExists() {
        bank.addUser(user1);
        bank.addAccount(user1, account1);
        bank.deleteAccount(user1, account1);
        assertFalse(bank.accountExists(user1, account1));
    }

    @Test
    public void whenAddNewAccountToExistingUserThenReturnTrue() {
        bank.addUser(user1);
        assertTrue(bank.addAccount(user1, account1));
    }

    @Test
    public void whenAddNewAccountToExistingUserThenAccountExists() {
        bank.addUser(user1);
        bank.addAccount(user1, account1);
        assertTrue(bank.accountExists(user1, account1));
    }

    @Test
    public void whenAddAccountToNonExistingUserThenReturnFalse() {
        assertFalse(bank.addAccount(user1, account1));
    }

    @Test
    public void whenAddExistingAccountThenReturnFalse() {
        bank.addUser(user1);
        bank.addAccount(user1, account1);
        assertFalse(bank.addAccount(user1, account1));
    }

    @Test
    public void whenValidCrossUserTransfer() {
        bank.addUser(user1);
        bank.addAccount(user1, account1);
        bank.addUser(user2);
        bank.addAccount(user2, account2);
        assertTrue(bank.transfer(user1, account1, user2, account2, 50));
        assertThat(account1.getAmount(), is(950d));
        assertThat(account2.getAmount(), is(1050d));
    }

    @Test
    public void whenValidSameUserTransfer() {
        bank.addUser(user1);
        bank.addAccount(user1, account1);
        bank.addAccount(user1, account2);
        assertTrue(bank.transfer(user1, account1, account2, 50));
        assertThat(account1.getAmount(), is(950d));
        assertThat(account2.getAmount(), is(1050d));
    }

}
