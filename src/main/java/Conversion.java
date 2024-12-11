public class Conversion {
    // Método que convierte de una moneda a otra
    public static double convertir(String monedaBase, String monedaDestino, double cantidad) {
        double tasaDeCambio = APIClient.obtenerTasaDeCambio(monedaBase, monedaDestino);

        if (tasaDeCambio != 0) {
            return cantidad * tasaDeCambio;
        } else {
            return 0;
        }
    }
}
