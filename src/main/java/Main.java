import models.Currency;
import service.CurrencyExchangeProvider;

public class Main {
    public static void main(String[] args) {
        CurrencyExchangeProvider provider = new CurrencyExchangeProvider();
        Currency c = provider.pairConvert("USD","MXN");

        System.out.println(c.getConversionRate());

    }
}
