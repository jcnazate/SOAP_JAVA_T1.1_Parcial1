package ec.edu.monster.ws;

import ec.edu.monster.servicio.ConversionUnidades;
import ec.edu.monster.servicio.SumaService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 * Servicio SOAP que expone operaciones matemáticas y de conversión de unidades.
 */
@WebService(serviceName = "WSConUni")
public class WSConUni {

    private final ConversionUnidades conversionUnidades = new ConversionUnidades();

    /**
     * Suma dos números enteros.
     */
    @WebMethod(operationName = "sumar")
    public int sumar(@WebParam(name = "n1") int n1, @WebParam(name = "n2") int n2) {
        SumaService service = new SumaService();
        return service.suma(n1, n2);
    }

    /**
     * Convierte unidades de longitud utilizando el servicio de conversiones.
     */
    @WebMethod(operationName = "convertirLongitud")
    public double convertirLongitud(@WebParam(name = "valor") double valor,
            @WebParam(name = "unidadOrigen") String unidadOrigen,
            @WebParam(name = "unidadDestino") String unidadDestino) {
        return conversionUnidades.convertirLongitud(valor, unidadOrigen, unidadDestino);
    }

    /**
     * Convierte unidades de masa utilizando el servicio de conversiones.
     */
    @WebMethod(operationName = "convertirMasa")
    public double convertirMasa(@WebParam(name = "valor") double valor,
            @WebParam(name = "unidadOrigen") String unidadOrigen,
            @WebParam(name = "unidadDestino") String unidadDestino) {
        return conversionUnidades.convertirMasa(valor, unidadOrigen, unidadDestino);
    }

    /**
     * Convierte temperaturas entre Celsius, Fahrenheit y Kelvin.
     */
    @WebMethod(operationName = "convertirTemperatura")
    public double convertirTemperatura(@WebParam(name = "valor") double valor,
            @WebParam(name = "unidadOrigen") String unidadOrigen,
            @WebParam(name = "unidadDestino") String unidadDestino) {
        return conversionUnidades.convertirTemperatura(valor, unidadOrigen, unidadDestino);
    }
}
