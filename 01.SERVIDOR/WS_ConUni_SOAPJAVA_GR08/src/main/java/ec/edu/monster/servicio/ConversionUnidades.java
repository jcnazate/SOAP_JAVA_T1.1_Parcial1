package ec.edu.monster.servicio;

import java.util.Locale;
import java.util.Map;

/**
 * Servicio utilitario para conversiones de unidades en distintas magnitudes.
 */
public class ConversionUnidades {

    private static final Map<String, Double> FACTORES_LONGITUD = Map.of(
            "MM", 0.001,
            "CM", 0.01,
            "M", 1.0,
            "KM", 1000.0,
            "IN", 0.0254,
            "FT", 0.3048,
            "YD", 0.9144,
            "MI", 1609.344
    );

    private static final Map<String, Double> FACTORES_MASA = Map.of(
            "MG", 0.000001,
            "G", 0.001,
            "KG", 1.0,
            "T", 1000.0,
            "LB", 0.45359237,
            "OZ", 0.0283495231
    );

    /**
     * Convierte una magnitud de longitud entre unidades soportadas.
     *
     * @param valor         cantidad a convertir
     * @param unidadOrigen  unidad de entrada (por ejemplo, "m" o "km")
     * @param unidadDestino unidad deseada (por ejemplo, "cm" o "mi")
     * @return valor convertido a la unidad solicitada
     */
    public double convertirLongitud(double valor, String unidadOrigen, String unidadDestino) {
        String origen = normalizarUnidad(unidadOrigen);
        String destino = normalizarUnidad(unidadDestino);
        double metros = valor * obtenerFactor(FACTORES_LONGITUD, origen, "longitud");
        return metros / obtenerFactor(FACTORES_LONGITUD, destino, "longitud");
    }

    /**
     * Convierte una magnitud de masa entre unidades soportadas.
     *
     * @param valor         cantidad a convertir
     * @param unidadOrigen  unidad de entrada (por ejemplo, "kg" o "lb")
     * @param unidadDestino unidad deseada (por ejemplo, "g" o "oz")
     * @return valor convertido a la unidad solicitada
     */
    public double convertirMasa(double valor, String unidadOrigen, String unidadDestino) {
        String origen = normalizarUnidad(unidadOrigen);
        String destino = normalizarUnidad(unidadDestino);
        double kilogramos = valor * obtenerFactor(FACTORES_MASA, origen, "masa");
        return kilogramos / obtenerFactor(FACTORES_MASA, destino, "masa");
    }

    /**
     * Convierte una temperatura entre unidades soportadas.
     *
     * @param valor         temperatura a convertir
     * @param unidadOrigen  unidad de entrada ("C", "F" o "K")
     * @param unidadDestino unidad deseada ("C", "F" o "K")
     * @return valor convertido a la unidad solicitada
     */
    public double convertirTemperatura(double valor, String unidadOrigen, String unidadDestino) {
        String origen = normalizarUnidad(unidadOrigen);
        String destino = normalizarUnidad(unidadDestino);
        double celsius = convertirACelsius(valor, origen);
        return convertirDesdeCelsius(celsius, destino);
    }

    private static double obtenerFactor(Map<String, Double> factores, String unidad, String tipo) {
        Double factor = factores.get(unidad);
        if (factor == null) {
            throw new IllegalArgumentException("Unidad de " + tipo + " no soportada: " + unidad);
        }
        return factor;
    }

    private static double convertirACelsius(double valor, String unidadOrigen) {
        switch (unidadOrigen) {
            case "C":
                return valor;
            case "F":
                return (valor - 32.0) * 5.0 / 9.0;
            case "K":
                return valor - 273.15;
            default:
                throw new IllegalArgumentException("Unidad de temperatura no soportada: " + unidadOrigen);
        }
    }

    private static double convertirDesdeCelsius(double celsius, String unidadDestino) {
        switch (unidadDestino) {
            case "C":
                return celsius;
            case "F":
                return (celsius * 9.0 / 5.0) + 32.0;
            case "K":
                return celsius + 273.15;
            default:
                throw new IllegalArgumentException("Unidad de temperatura no soportada: " + unidadDestino);
        }
    }

    private static String normalizarUnidad(String unidad) {
        if (unidad == null) {
            throw new IllegalArgumentException("La unidad no puede ser nula");
        }
        String normalizada = unidad.trim()
                .toUpperCase(Locale.ROOT)
                .replace("°", "")
                .replace("º", "");

        switch (normalizada) {
            case "METRO":
            case "METROS":
                return "M";
            case "KILOMETRO":
            case "KILOMETROS":
                return "KM";
            case "CENTIMETRO":
            case "CENTIMETROS":
                return "CM";
            case "MILIMETRO":
            case "MILIMETROS":
                return "MM";
            case "PULGADA":
            case "PULGADAS":
                return "IN";
            case "PIE":
            case "PIES":
                return "FT";
            case "YARDA":
            case "YARDAS":
                return "YD";
            case "MILLA":
            case "MILLAS":
                return "MI";
            case "GRAMO":
            case "GRAMOS":
                return "G";
            case "MIGRAMO":
            case "MIGRAMOS":
            case "MILLIGRAMO":
            case "MILLIGRAMOS":
                return "MG";
            case "KILOGRAMO":
            case "KILOGRAMOS":
                return "KG";
            case "TONELADA":
            case "TONELADAS":
                return "T";
            case "LIBRA":
            case "LIBRAS":
                return "LB";
            case "ONZA":
            case "ONZAS":
                return "OZ";
            case "CELSIUS":
            case "CENTIGRADO":
            case "CENTIGRADOS":
                return "C";
            case "FAHRENHEIT":
                return "F";
            case "KELVIN":
                return "K";
            default:
                return normalizada;
        }
    }
}
