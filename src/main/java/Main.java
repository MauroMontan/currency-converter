import http.HttpService;

public class Main {
    public static void main(String[] args) {
        String url = "https://dont-starve-together-api.xyz/api/crockpot-recipes?page=1";

        HttpService.fetchData(url);

    }
}
