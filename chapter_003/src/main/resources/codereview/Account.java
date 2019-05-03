package com;      // package name makes no sense 

// No javadocs provided
public class Account {

    double values;		// both fields can be protected/private
    String reqs;		// unnecessary abbreviation, could be just requisites

    public Account(double values, String requisites) {
        this.values = values;
        this.reqs = requisites;
    }

    public double getValues() {
        return this.values;
    }

    // no space required before ()
    public String getReqs () {
        return this.reqs;
    }

    // missing access modifier, must be public for testability
    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    // @Override - ?
    public String toString() {  // the whole method could be one-liner: return String.format();
        String otvet;
        otvet = "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";  // Can be replaced with String.format()
        return otvet;
    }

    // @Override - ?
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.reqs.equals(account.reqs);
    }

    // @Override - ?
    public int hashCode() {
        return this.reqs.hashCode();
    }
}