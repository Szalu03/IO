package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private List<Pair<CryptoCurrency, Integer>> cryptoCurrencies;
    private double freeFunds;

    public Wallet() {
        this.freeFunds = 0.0;
        this.cryptoCurrencies = new ArrayList<>();
    }

    public boolean withdrawal(Payment payment) {
        if (freeFunds >= payment.getValue()) {
            freeFunds -= payment.getValue();
            return true;
        }
        return false;
    }
    public void display() {
        System.out.println("Stan portfela:");
        for (Pair<CryptoCurrency, Integer> crypto : cryptoCurrencies) {
            System.out.println("Nazwa: " + crypto.getKey().getType()+ ", Ilość: " + crypto.getValue() + ", Cena: " + crypto.getKey().getPrice());
        }
        System.out.println("Wolne środki: " + freeFunds);
    }


    public boolean deposit(Payment payment) {
        freeFunds += payment.getValue();
        return true;
    }

    public Boolean remove(CryptoCurrency cryptoCurrency, int amount) {
        for (Pair<CryptoCurrency, Integer> crypto : cryptoCurrencies) {
            if (crypto.getKey().getType().equals(cryptoCurrency.getType())) {
                int currentAmount = crypto.getValue();
                if (currentAmount >= amount) {
                    crypto.setValue(currentAmount - amount);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }


    public Boolean add(CryptoCurrency cryptoCurrency, int amount) {
        for (Pair<CryptoCurrency, Integer> crypto : cryptoCurrencies) {
            if (crypto.getKey().getType().equals(cryptoCurrency.getType())) {
                crypto.setValue(crypto.getValue() + amount);
                return true;
            }
        }

            Pair<CryptoCurrency, Integer> newPair = new Pair<>(cryptoCurrency, amount);
            cryptoCurrencies.add(newPair);
            return true;

    }




    public void setFreeFunds(double freeFunds) {
        this.freeFunds = freeFunds;
    }

    public double getFreeFunds() {
        return freeFunds;
    }
}
