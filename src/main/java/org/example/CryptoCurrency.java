package org.example;

public class CryptoCurrency {
    private CryptoCurrencyName type;

    private double price;

    public CryptoCurrency(CryptoCurrencyName type, double price) {
        this.type = type;
        this.price = price;
    }

    public CryptoCurrencyName getType() {
        return type;
    }

    public void setType(CryptoCurrencyName type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public enum CryptoCurrencyName{BITCOIN , ETHEREUM, SOLANA}
}

