package org.example;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Market {

    private static Market market;




    private List<Pair<CryptoCurrency, Integer>> cryptoCurrencies;

    public Market() {
        cryptoCurrencies = new ArrayList<>();
        cryptoCurrencies.add(new Pair<>(new CryptoCurrency(CryptoCurrency.CryptoCurrencyName.BITCOIN,  50000.0), 1000));
        cryptoCurrencies.add(new Pair<>(new CryptoCurrency(CryptoCurrency.CryptoCurrencyName.ETHEREUM,  4000.0), 1000));
        cryptoCurrencies.add(new Pair<>(new CryptoCurrency(CryptoCurrency.CryptoCurrencyName.SOLANA,  200.0), 1000));
    }


    public static Market getInstance(){
        if(market == null){
            market = new Market();
        }
        return market;


    }

    public boolean sell(Transaction transaction, Wallet wallet, TransactionHistory transactionHistory) {
        for (Pair<CryptoCurrency, Integer> crypto : cryptoCurrencies) {
            if (crypto.getKey().getType().equals(transaction.getName())) {
                wallet.setFreeFunds(wallet.getFreeFunds() + crypto.getKey().getPrice() * transaction.getAmount());
                crypto.setValue(crypto.getValue() + transaction.getAmount());
                transactionHistory.add(transaction);
                wallet.remove(crypto.getKey(),transaction.getAmount());
                return true;
            }
        }
        return false;
    }

    public boolean buy(Transaction transaction, Wallet wallet, TransactionHistory transactionHistory) {
        for (Pair<CryptoCurrency, Integer> crypto : cryptoCurrencies) {
            if (crypto.getKey().getType().equals(transaction.getName())) {
                if (wallet.getFreeFunds() >= crypto.getKey().getPrice() * transaction.getAmount()) {
                    wallet.setFreeFunds(wallet.getFreeFunds() - crypto.getKey().getPrice() * transaction.getAmount());
                    crypto.setValue(crypto.getValue() - transaction.getAmount());
                    transactionHistory.add(transaction);
                    wallet.add(crypto.getKey(),transaction.getAmount());
                    return true;
                }
            }
        }
        return false;
    }

}
