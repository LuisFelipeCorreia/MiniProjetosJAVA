package models;

public class TemperatureConverter {

    // Constantes do zero absoluto
    private static final double ZERO_ABSOLUTO_CELSIUS = -273.15;
    private static final double ZERO_ABSOLUTO_FAHRENHEIT = -459.67;
    private static final double ZERO_ABSOLUTO_KELVIN = 0.0;

    // Construtor privado para evitar instanciação (Classe Utilitária)
    private TemperatureConverter() {
        throw new UnsupportedOperationException("Esta é uma classe utilitária e não pode ser instanciada.");
    }

    // Conversões a partir de Celsius
    public static double celsiusToFahrenheit(double celsius) {
        validarTemperatura(celsius, ZERO_ABSOLUTO_CELSIUS, "Celsius");
        return (celsius * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        validarTemperatura(celsius, ZERO_ABSOLUTO_CELSIUS, "Celsius");
        return celsius + 273.15;
    }

    // Conversões a partir de Fahrenheit
    public static double fahrenheitToCelsius(double fahrenheit) {
        validarTemperatura(fahrenheit, ZERO_ABSOLUTO_FAHRENHEIT, "Fahrenheit");
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        validarTemperatura(fahrenheit, ZERO_ABSOLUTO_FAHRENHEIT, "Fahrenheit");
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }

    // Conversões a partir de Kelvin
    public static double kelvinToCelsius(double kelvin) {
        validarTemperatura(kelvin, ZERO_ABSOLUTO_KELVIN, "Kelvin");
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        validarTemperatura(kelvin, ZERO_ABSOLUTO_KELVIN, "Kelvin");
        return (kelvin - 273.15) * 9 / 5 + 32;
    }

    // Método utilitário privado para validação
    private static void validarTemperatura(double valor, double limite, String escala) {
        if (valor < limite) {
            throw new IllegalArgumentException(String.format(
                "Valor abaixo do zero absoluto! O limite em %s é %.2f.", escala, limite));
        }
    }
}