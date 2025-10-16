
package ec.edu.monster.ws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para kelvinACelsius complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="kelvinACelsius"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="kelvin" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "kelvinACelsius", propOrder = {
    "kelvin"
})
public class KelvinACelsius {

    protected double kelvin;

    /**
     * Obtiene el valor de la propiedad kelvin.
     * 
     */
    public double getKelvin() {
        return kelvin;
    }

    /**
     * Define el valor de la propiedad kelvin.
     * 
     */
    public void setKelvin(double value) {
        this.kelvin = value;
    }

}
