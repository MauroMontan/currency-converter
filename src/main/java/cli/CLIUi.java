package cli;

import models.Currency;

import java.util.List;

public class CLIUi {

    final protected String reset = "\u001B[0m";
    final  protected String red = "\u001B[31m";
    final protected String green = "\u001B[32m";
    public List<String> displayOptions() {
        List<String> options = List.of(
                "1._ Show currency codes",
                "2.- Pair convert",
                "3.- exit"
        );
        return options;
    }

    protected void mainMenu() {
        String banner = """
                  ______  __    __  .______      .______       _______ .__   __.   ______ ____    ____      ______   ______   .__   __. ____    ____  _______ .______     .___________. _______ .______     \s
                 /      ||  |  |  | |   _  \\     |   _  \\     |   ____||  \\ |  |  /      |\\   \\  /   /     /      | /  __  \\  |  \\ |  | \\   \\  /   / |   ____||   _  \\    |           ||   ____||   _  \\    \s
                |  ,----'|  |  |  | |  |_)  |    |  |_)  |    |  |__   |   \\|  | |  ,----' \\   \\/   /     |  ,----'|  |  |  | |   \\|  |  \\   \\/   /  |  |__   |  |_)  |   `---|  |----`|  |__   |  |_)  |   \s
                |  |     |  |  |  | |      /     |      /     |   __|  |  . `  | |  |       \\_    _/      |  |     |  |  |  | |  . `  |   \\      /   |   __|  |      /        |  |     |   __|  |      /    \s
                |  `----.|  `--'  | |  |\\  \\----.|  |\\  \\----.|  |____ |  |\\   | |  `----.    |  |        |  `----.|  `--'  | |  |\\   |    \\    /    |  |____ |  |\\  \\----.   |  |     |  |____ |  |\\  \\----.
                 \\______| \\______/  | _| `._____|| _| `._____||_______||__| \\__|  \\______|    |__|         \\______| \\______/  |__| \\__|     \\__/     |_______|| _| `._____|   |__|     |_______|| _| `._____|                                                                                                                                                                                     \s
                """;

        System.out.println(banner);
        for (String op: displayOptions()) {
            System.out.println(op);
        }

    }

    protected void loading(){
        System.out.println("loading...");
    }

    protected String currencyMessageParse(String from, String to, Currency currency,Double amount,  Double targeAmount ) {
        return green +amount +  " " + from + " equivale a " + targeAmount + " " + to + reset;
    }
}
