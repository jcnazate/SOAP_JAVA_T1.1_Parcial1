
package ec.edu.monster.ws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para celsiusAKelvin complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="celsiusAKelvin"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="celsius" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "celsiusAKelvin", propOrder = {
    "celsius"
})
public class CelsiusAKelvin {

    protected double celsius;

    /**
     * Obtiene el valor de la propiedad celsius.
     * 
     */
    public double getCelsius() {
        return celsius;
    }

    /**
     * Define el valor de la propiedad celsius.
     * 
     */
    public void setCelsius(double value) {
        this.celsius = value;
    }

}
