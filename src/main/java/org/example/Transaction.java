package org.example;

import java.lang.reflect.Type;

public class Transaction {
    private CryptoCurrency.CryptoCurrencyName name;
    private int amount;
    private static int generatorId = 0;
    private int id;
    private Type type;

    public Transaction(CryptoCurrency.CryptoCurrencyName name, int amount, Type type) {
        this.name = name;
        this.amount = amount;
        generatorId++;
        id = generatorId;
        this.type = type;

    }
    public String toString(){
        return (id + " " + name + " " + amount + " " + type);

    }

    public static int getGeneratorId() {
        return generatorId;
    }

    public int getId() {
        return id;
    }


    public CryptoCurrency.CryptoCurrencyName getName() {
        return name;
    }

    public void setName(CryptoCurrency.CryptoCurrencyName name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public enum Type{SELL,BUY}
}
