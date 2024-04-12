package cli;

import models.Code;

import models.Currency;
import service.CurrencyExchangeProvider;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CLIHandler extends CLIUi {

    private final CurrencyExchangeProvider provider;
    public CLIHandler(){
         provider = new CurrencyExchangeProvider();
    }

    private void availableCurrencyBord(){
        loading();
        List<Code> codes = provider.getCurrencyCodes();
        for (Code code : codes) {
            System.out.println(code.toString());
        }
        mainMenu();
    }

    private void loop() {
        Scanner scan = new Scanner(System.in);

        int opt = 0;

        do {
            System.out.print("Ingresa una opción: ");
          try {
              opt = scan.nextInt();
          } catch (InputMismatchException e){
              System.out.println("ingresa una opción valida !");
          }


            switch (opt){
                case 1 -> availableCurrencyBord();
                case 2 -> convertMenu();
                default -> System.out.println("Ingresa una opción valida");
            }
        }

        while (opt != 3);
    }

    private void convertMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Ingresa el monto a convertir:");
        Double amount = scan.nextDouble();
        System.out.print("Ingresa la moneda que deseas convertir:  ");
        String from = scan.next();
        System.out.print("A que moneda quieres convertir:  ");
        String to = scan.next();

        loading();
        Currency c = provider.pairConvert(from,to);
        var baseCode = provider.getCurrencyName(c.getBaseCode());
        var targetCode = provider.getCurrencyName(c.getTargetCode());
        var targetAmount = provider.quantityConverter(c,amount);

        System.out.println( currencyMessageParse(baseCode,targetCode,c,amount,targetAmount) );
        mainMenu();
    }

    public void bootstrap() {
        mainMenu();
        loop();
    }

}
