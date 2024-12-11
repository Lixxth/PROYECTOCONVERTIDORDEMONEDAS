import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIClient {
    private static final String API_URL = "https://app.exchangerate-api.com/activate/c69c6feecfaa716895145002a4";

    // Método para obtener la tasa de cambio entre dos monedas
    public static double obtenerTasaDeCambio(String monedaBase, String monedaDestino) {
        try {
            // Construir la URL de la API
            URL url = new URL(API_URL + monedaBase);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Leer la respuesta
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            ExchangeRateResponse response = new Gson().fromJson(reader, ExchangeRateResponse.class);

            // Obtener la tasa de cambio específica
            if (response != null && response.conversionRates.containsKey(monedaDestino)) {
                return response.conversionRates.get(monedaDestino);
            } else {
                System.out.println("No se pudo obtener la tasa de cambio.");
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Error al hacer la solicitud a la API: " + e.getMessage());
            return 0;
        }
    }
}
