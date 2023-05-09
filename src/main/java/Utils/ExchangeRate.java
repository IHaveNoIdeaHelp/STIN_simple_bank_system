package Utils;

public class ExchangeRate {
    private String currencyCode;
    private double exchangeRate;

    public ExchangeRate(String currencyCode, double exchangeRate) {
        this.currencyCode = currencyCode;
        this.exchangeRate = exchangeRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    @Override
    public String toString() {
        return currencyCode + " : " + exchangeRate;
    }
}
