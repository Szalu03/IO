package org.example;

public class Authentication {

    public static Account authenticate(Database db, Account account) {
        for (Account acc : db.accounts) {
            if (acc.equals(account)) {
                return account;
            }
        }
        return null;

    }
}
