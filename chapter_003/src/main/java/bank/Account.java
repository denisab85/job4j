package bank;

/**
 * Represents a client's bank account.
 */
public class Account {

    private double amount;
    private final String requisites;

    public Account(double values, String requisites) {
        this.amount = values;
        this.requisites = requisites;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getRequisites() {
        return this.requisites;
    }

    /**
     * Transfers the specified amount to the destination account.
     *
     * @param destination account to accept the transferTo.
     * @param amount      USD amount to transferTo.
     * @return {@code true} if transferTo was successful.
     */
    public boolean transferTo(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.amount && destination != null) {
            success = true;
            this.amount -= amount;
            destination.amount += amount;
        }
        return success;
    }

    @Override
    public String toString() {
        return String.format("Account{amount=%.2f, requisites=%s}", amount, requisites);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.requisites.equals(account.requisites);
    }

    @Override
    public int hashCode() {
        return this.requisites.hashCode();
    }
}