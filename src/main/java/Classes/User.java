package Classes;
import Utils.ExchangeRate;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private List<Account> accounts = new ArrayList<>();
    public User(){

    }

    public void addAccount(Account acc){
        accounts.add(acc);
    }

}
