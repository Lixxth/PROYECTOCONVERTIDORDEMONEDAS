import java.util.Scanner;

public class ConvertidorMonedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mostrar menú de opciones
        System.out.println("Bienvenido al Convertidor de Monedas");
        System.out.println("Selecciona una opción:");
        System.out.println("1. USD a EUR");
        System.out.println("2. EUR a USD");
        System.out.println("3. Salir");

        int opcion = scanner.nextInt();

        while (opcion != 3) {
            System.out.print("Introduce la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();

            switch (opcion) {
                case 1:
                    double resultadoUSD2EUR = Conversion.convertir("USD", "EUR", cantidad);
                    System.out.println(cantidad + " USD = " + resultadoUSD2EUR + " EUR");
                    break;
                case 2:
                    double resultadoEUR2USD = Conversion.convertir("EUR", "USD", cantidad);
                    System.out.println(cantidad + " EUR = " + resultadoEUR2USD + " USD");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

            // Volver a mostrar el menú
            System.out.println("Selecciona una opción:");
            System.out.println("1. USD a EUR");
            System.out.println("2. EUR a USD");
            System.out.println("3. Salir");
            opcion = scanner.nextInt();
        }

        System.out.println("Gracias por usar el Convertidor de Monedas. ¡Adiós!");
        scanner.close();
    }
}
