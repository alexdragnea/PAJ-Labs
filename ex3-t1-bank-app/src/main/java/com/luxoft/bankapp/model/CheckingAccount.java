package com.luxoft.bankapp.model;

import com.luxoft.bankapp.exceptions.OverDraftLimitExceededException;

public class CheckingAccount extends AbstractAccount {

    private double overdraft = 0;

    public CheckingAccount() {
    }

    public CheckingAccount(double overdraft) {

        setOverdraft(overdraft);
    }

    public double getOverdraft() {

        return overdraft;
    }

    public void setOverdraft(double amount) {

        if (overdraft < 0) {
            return;
        }

        overdraft = amount;
    }

    @Override
    public void withdraw(double amount) throws OverDraftLimitExceededException {

        if (getBalance() + overdraft < amount) {

            throw new OverDraftLimitExceededException(
                    this.getClass().getSimpleName(), getBalance() + overdraft);
        }

        setBalance(getBalance() - amount);
    }
}
