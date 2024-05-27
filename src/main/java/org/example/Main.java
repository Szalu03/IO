package org.example;

import static org.example.CryptoCurrency.CryptoCurrencyName.BITCOIN;
import static org.example.CryptoCurrency.CryptoCurrencyName.ETHEREUM;

public class Main {
    public static void main(String[] args) {
        Account account = Authentication.authenticate(Database.getInstance(),new Account("user1","password1"));

        if(account != null){
            account.getWallet().deposit(new Payment(999999));
            account.order(BITCOIN,5, Transaction.Type.BUY);
            account.order(ETHEREUM,5, Transaction.Type.BUY);
            account.order(BITCOIN,3, Transaction.Type.SELL);
            account.getWallet().display();
            account.getTransactionHistory().display();




        }




    }
}