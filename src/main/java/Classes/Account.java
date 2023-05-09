package Classes;
import java.math.BigDecimal;
public class Account {
    private String currency;
    private BigDecimal amount;
    private User owner;
    public Account(User owner){

    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public void AddToAmount(BigDecimal addAmount){
        amount = amount.add(addAmount);
    }


}
