package org.example;

public class Account {
    private String login;
    private String password;
    private Wallet wallet;
    private TransactionHistory transactionHistory;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(TransactionHistory transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
        this.wallet = new Wallet();
        this.transactionHistory = new TransactionHistory();
    }



    public Boolean order(CryptoCurrency.CryptoCurrencyName name, int amount, Transaction.Type type){
        Market market = Market.getInstance();
        Transaction transaction = new Transaction(name,amount,type);
        if(type == Transaction.Type.SELL){
            return market.sell(transaction,wallet,transactionHistory);
        }
        else if(type == Transaction.Type.BUY){
            return  market.buy(transaction,wallet,transactionHistory);
        }
        return false;
    }
    public Boolean equals(Account account) {
        return (this.login.equals(account.login) && this.password.equals(account.password));

    }



}
