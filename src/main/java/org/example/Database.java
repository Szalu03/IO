package org.example;

import java.util.List;

public class Database {
    List<Account> accounts;
    private static Database instance;

    public static Database getInstance(){
        if( instance == null){
            instance = new Database();
        }
        return instance;


    }
    public Database() {
        accounts = List.of(
                new Account("user1", "password1"),
                new Account("user2", "password2"),
                new Account("user3", "password3")
        );
    }
}
