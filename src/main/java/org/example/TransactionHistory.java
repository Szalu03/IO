package org.example;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    private List<Transaction> transactions;

    public TransactionHistory() {
        this.transactions = new ArrayList<>();

    }

    public void display(){
        for(Transaction trans: transactions){
            System.out.println(trans);

        }
    }
    public void add(Transaction transaction){
        transactions.add(transaction);

    }
    public void delete(Transaction transaction){
        for(Transaction trans: transactions){
            if(transaction.getId() == trans.getId()){
                transactions.remove(trans);
            }
        }

    }
}
