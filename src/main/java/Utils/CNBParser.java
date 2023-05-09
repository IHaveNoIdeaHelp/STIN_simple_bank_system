package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CNBParser {


    /**
     * Method that tries to connect to CNB and download its exchange rate
     * @throws IOException if the link cannot be reached (no internet)
     */
    public List<ExchangeRate> ConnectToCNB() throws IOException{
        URL url = new URL("https://www.cnb.cz/cs/financni-trhy/devizovy-trh/kurzy-devizoveho-trhu/kurzy-devizoveho-trhu/denni_kurz.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        CSVParser parser = CSVFormat.DEFAULT.withDelimiter('|').parse(reader);
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        for (CSVRecord record : parser) {
            if (record.size() == 5 && !record.get(4).equals("kurz")) {
                String currencyCode = record.get(3);
                double exchangeRate = Double.parseDouble(record.get(4).replace(",", "."));
                double amount = Double.parseDouble(record.get(2));
                double trueExchangeRate = exchangeRate/amount;
                exchangeRates.add(new ExchangeRate(currencyCode, trueExchangeRate));
            }
        }
        /*
        for (ExchangeRate rate : exchangeRates) {
            //System.out.println(rate);
        }*/
        return exchangeRates;
    }

    public void getExchangeRates(){

    }

}
