package bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AccountTest {

    private Account account1;
    private Account account2;

    @Before
    public void createAccounts() {
        account1 = new Account(1000, "12365-54665-1111");
        account2 = new Account(1000, "12365-54665-2222");
    }

    @Test
    public void whenCreateAccount() {
        assertThat(account1.getAmount(), is(1000d));
        assertThat(account1.getRequisites(), is("12365-54665-1111"));
    }

    @Test
    public void whenAccountToString() {
        assertThat(account1.toString(), is("Account{amount=1000.00, requisites=12365-54665-1111}"));
    }

    @Test
    public void whenDifferentRequisitesThenEqualsFalse() {
        assertFalse(account1.equals(account2));
    }

    @Test
    public void whenSameRequisitesThenEqualsTrue() {
        account2 = new Account(1000, "12365-54665-1111");
        assertTrue(account1.equals(account2));
    }

    @Test
    public void whenDifferentRequisitesThenDifferentHashCode() {
        assertNotEquals(account1.hashCode(), account2.hashCode());
    }

    @Test
    public void whenSameRequisitesThenSameHashCode() {
        account2 = new Account(1000, "12365-54665-1111");
        assertEquals(account1.hashCode(), account2.hashCode());
    }

    @Test
    public void whenValidTransferThenReturnTrue() {
        assertTrue(account1.transferTo(account2, 500));
    }

    @Test
    public void whenTransferZeroThenReturnFalse() {
        assertFalse(account1.transferTo(account2, 0));
    }

    @Test
    public void whenTransferNegativeThenReturnFalse() {
        assertFalse(account1.transferTo(account2, -50));
    }

    @Test
    public void whenTransferExceedsFundsThenReturnFalse() {
        assertFalse(account1.transferTo(account2, 1001));
    }

    @Test
    public void whenValidTransferThenBothAccountsChangeAppropriately() {
        account1.transferTo(account2, 50);
        assertThat(account1.getAmount(), is(950d));
        assertThat(account2.getAmount(), is(1050d));
    }

    @Test
    public void whenTransferZeroThenNoChange() {
        account1.transferTo(account2, 0);
        assertThat(account1.getAmount(), is(1000d));
        assertThat(account2.getAmount(), is(1000d));
    }

    @Test
    public void whenTransferNegativeThenNoChange() {
        account1.transferTo(account2, -50);
        assertThat(account1.getAmount(), is(1000d));
        assertThat(account2.getAmount(), is(1000d));
    }

    @Test
    public void whenTransferExceedsFundsThenNoChange() {
        account1.transferTo(account2, 1001);
        assertThat(account1.getAmount(), is(1000d));
        assertThat(account2.getAmount(), is(1000d));
    }

}
