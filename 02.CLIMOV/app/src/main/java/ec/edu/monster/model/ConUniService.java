package ec.edu.monster.model;

import ec.edu.monster.utils.SoapConstants;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class ConUniService {

    public boolean login(String usuario, String contraseña) throws Exception {
        return attemptLogin("http://10.0.2.2:8080/WS_ConUni_SOAPJAVA_GR08/Login", usuario, contraseña);
    }
    
    private boolean attemptLogin(String url, String usuario, String contraseña) throws Exception {
        SoapObject request = new SoapObject(SoapConstants.LOGIN_NAMESPACE, SoapConstants.LOGIN_METHOD);
        request.addProperty("user", usuario);
        request.addProperty("password", contraseña);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        HttpTransportSE transport = new HttpTransportSE(url);
        transport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

        try {
            transport.call(SoapConstants.SOAP_ACTION_PREFIX + SoapConstants.LOGIN_METHOD, envelope);
            
            Object responseObj = envelope.getResponse();
            if (responseObj == null) {
                throw new Exception("El servidor no devolvió una respuesta válida");
            }
            
            String responseString;
            if (responseObj instanceof SoapObject) {
                SoapObject soapResponse = (SoapObject) responseObj;
                if (soapResponse.hasProperty("return")) {
                    Object returnValue = soapResponse.getProperty("return");
                    responseString = returnValue.toString();
                } else {
                    throw new Exception("Respuesta del servidor no tiene el formato esperado");
                }
            } else if (responseObj instanceof SoapPrimitive) {
                responseString = ((SoapPrimitive) responseObj).toString();
            } else {
                responseString = responseObj.toString();
            }
            
            return Boolean.parseBoolean(responseString);
        } catch (Exception e) {
            throw new Exception("Error al conectar con el servidor de login: " + e.getMessage(), e);
        }
    }

    public double pulgadasACentimetros(double pulgadas) throws Exception {
        return performConversion(SoapConstants.PULGADAS_A_CENTIMETROS_METHOD, "pulgadas", pulgadas);
    }

    public double centimetrosAPulgadas(double centimetros) throws Exception {
        return performConversion(SoapConstants.CENTIMETROS_A_PULGADAS_METHOD, "centimetros", centimetros);
    }

    public double kelvinACelsius(double kelvin) throws Exception {
        return performConversion(SoapConstants.KELVIN_A_CELSIUS_METHOD, "kelvin", kelvin);
    }

    public double celsiusAKelvin(double celsius) throws Exception {
        return performConversion(SoapConstants.CELSIUS_A_KELVIN_METHOD, "celsius", celsius);
    }
    
    private double performConversion(String method, String paramName, double value) throws Exception {
        SoapObject request = new SoapObject(SoapConstants.CONVERSION_NAMESPACE, method);
        request.addProperty(paramName, String.valueOf(value));

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        envelope.dotNet = false;
        envelope.implicitTypes = true;

        HttpTransportSE transport = new HttpTransportSE(SoapConstants.CONVERSION_URL);
        transport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

        try {
            transport.call(SoapConstants.SOAP_ACTION_PREFIX + method, envelope);
            
            Object responseObj = envelope.getResponse();
            if (responseObj == null) {
                throw new Exception("El servidor no devolvió una respuesta válida");
            }
            
            String responseString;
            if (responseObj instanceof SoapObject) {
                SoapObject soapResponse = (SoapObject) responseObj;
                if (soapResponse.hasProperty("return")) {
                    Object returnValue = soapResponse.getProperty("return");
                    responseString = returnValue.toString();
                } else {
                    throw new Exception("Respuesta del servidor no tiene el formato esperado");
                }
            } else if (responseObj instanceof SoapPrimitive) {
                responseString = ((SoapPrimitive) responseObj).toString();
            } else {
                responseString = responseObj.toString();
            }
            
            return Double.parseDouble(responseString);
        } catch (Exception e) {
            throw new Exception("Error al conectar con el servidor de conversión: " + e.getMessage(), e);
        }
    }

    public double gramosAKilogramos(double gramos) throws Exception {
        return performConversion(SoapConstants.GRAMOS_A_KILOGRAMOS_METHOD, "gramos", gramos);
    }

    public double kilogramosAGramos(double kilogramos) throws Exception {
        return performConversion(SoapConstants.KILOGRAMOS_A_GRAMOS_METHOD, "kilogramos", kilogramos);
    }
}