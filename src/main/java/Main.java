import http.HttpService;
import service.CurrencyExchangeProvider;

public class Main {
    public static void main(String[] args) {
        CurrencyExchangeProvider provider = new CurrencyExchangeProvider();
        provider.convert();
    }
}
