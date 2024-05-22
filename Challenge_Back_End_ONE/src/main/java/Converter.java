import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class Converter {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private static final String BASE_CURRENCY = "BRL";

    public static double convertCurrency(String toCurrency, double amount, String apiKey) {
        try {
            String urlStr = API_URL + "c04268bca506dccfd2a9c580/latest/" + BASE_CURRENCY;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = input.readLine()) != null) {
                response.append(line);
            }

            input.close();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
            double exchangeRate = rates.get(toCurrency).getAsDouble();

            return amount * exchangeRate;
        } catch (IOException e) {
            e.printStackTrace();
            return -1; // Retorna -1 em caso de erro
        }
    }
}



