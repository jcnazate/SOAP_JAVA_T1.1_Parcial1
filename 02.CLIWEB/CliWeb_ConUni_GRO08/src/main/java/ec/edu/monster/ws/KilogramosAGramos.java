
package ec.edu.monster.ws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para kilogramosAGramos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="kilogramosAGramos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="kilogramos" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "kilogramosAGramos", propOrder = {
    "kilogramos"
})
public class KilogramosAGramos {

    protected double kilogramos;

    /**
     * Obtiene el valor de la propiedad kilogramos.
     * 
     */
    public double getKilogramos() {
        return kilogramos;
    }

    /**
     * Define el valor de la propiedad kilogramos.
     * 
     */
    public void setKilogramos(double value) {
        this.kilogramos = value;
    }

}
