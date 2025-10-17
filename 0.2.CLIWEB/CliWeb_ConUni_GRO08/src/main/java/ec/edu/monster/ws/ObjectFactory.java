
package ec.edu.monster.ws;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.edu.monster.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CelsiusAKelvin_QNAME = new QName("http://ws.monster.edu.ec/", "celsiusAKelvin");
    private final static QName _CelsiusAKelvinResponse_QNAME = new QName("http://ws.monster.edu.ec/", "celsiusAKelvinResponse");
    private final static QName _CentimetrosAPulgadas_QNAME = new QName("http://ws.monster.edu.ec/", "centimetrosAPulgadas");
    private final static QName _CentimetrosAPulgadasResponse_QNAME = new QName("http://ws.monster.edu.ec/", "centimetrosAPulgadasResponse");
    private final static QName _GramosAKilogramos_QNAME = new QName("http://ws.monster.edu.ec/", "gramosAKilogramos");
    private final static QName _GramosAKilogramosResponse_QNAME = new QName("http://ws.monster.edu.ec/", "gramosAKilogramosResponse");
    private final static QName _KelvinACelsius_QNAME = new QName("http://ws.monster.edu.ec/", "kelvinACelsius");
    private final static QName _KelvinACelsiusResponse_QNAME = new QName("http://ws.monster.edu.ec/", "kelvinACelsiusResponse");
    private final static QName _KilogramosAGramos_QNAME = new QName("http://ws.monster.edu.ec/", "kilogramosAGramos");
    private final static QName _KilogramosAGramosResponse_QNAME = new QName("http://ws.monster.edu.ec/", "kilogramosAGramosResponse");
    private final static QName _PulgadasACentimetros_QNAME = new QName("http://ws.monster.edu.ec/", "pulgadasACentimetros");
    private final static QName _PulgadasACentimetrosResponse_QNAME = new QName("http://ws.monster.edu.ec/", "pulgadasACentimetrosResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.edu.monster.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CelsiusAKelvin }
     * 
     */
    public CelsiusAKelvin createCelsiusAKelvin() {
        return new CelsiusAKelvin();
    }

    /**
     * Create an instance of {@link CelsiusAKelvinResponse }
     * 
     */
    public CelsiusAKelvinResponse createCelsiusAKelvinResponse() {
        return new CelsiusAKelvinResponse();
    }

    /**
     * Create an instance of {@link CentimetrosAPulgadas }
     * 
     */
    public CentimetrosAPulgadas createCentimetrosAPulgadas() {
        return new CentimetrosAPulgadas();
    }

    /**
     * Create an instance of {@link CentimetrosAPulgadasResponse }
     * 
     */
    public CentimetrosAPulgadasResponse createCentimetrosAPulgadasResponse() {
        return new CentimetrosAPulgadasResponse();
    }

    /**
     * Create an instance of {@link GramosAKilogramos }
     * 
     */
    public GramosAKilogramos createGramosAKilogramos() {
        return new GramosAKilogramos();
    }

    /**
     * Create an instance of {@link GramosAKilogramosResponse }
     * 
     */
    public GramosAKilogramosResponse createGramosAKilogramosResponse() {
        return new GramosAKilogramosResponse();
    }

    /**
     * Create an instance of {@link KelvinACelsius }
     * 
     */
    public KelvinACelsius createKelvinACelsius() {
        return new KelvinACelsius();
    }

    /**
     * Create an instance of {@link KelvinACelsiusResponse }
     * 
     */
    public KelvinACelsiusResponse createKelvinACelsiusResponse() {
        return new KelvinACelsiusResponse();
    }

    /**
     * Create an instance of {@link KilogramosAGramos }
     * 
     */
    public KilogramosAGramos createKilogramosAGramos() {
        return new KilogramosAGramos();
    }

    /**
     * Create an instance of {@link KilogramosAGramosResponse }
     * 
     */
    public KilogramosAGramosResponse createKilogramosAGramosResponse() {
        return new KilogramosAGramosResponse();
    }

    /**
     * Create an instance of {@link PulgadasACentimetros }
     * 
     */
    public PulgadasACentimetros createPulgadasACentimetros() {
        return new PulgadasACentimetros();
    }

    /**
     * Create an instance of {@link PulgadasACentimetrosResponse }
     * 
     */
    public PulgadasACentimetrosResponse createPulgadasACentimetrosResponse() {
        return new PulgadasACentimetrosResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CelsiusAKelvin }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CelsiusAKelvin }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "celsiusAKelvin")
    public JAXBElement<CelsiusAKelvin> createCelsiusAKelvin(CelsiusAKelvin value) {
        return new JAXBElement<CelsiusAKelvin>(_CelsiusAKelvin_QNAME, CelsiusAKelvin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CelsiusAKelvinResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CelsiusAKelvinResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "celsiusAKelvinResponse")
    public JAXBElement<CelsiusAKelvinResponse> createCelsiusAKelvinResponse(CelsiusAKelvinResponse value) {
        return new JAXBElement<CelsiusAKelvinResponse>(_CelsiusAKelvinResponse_QNAME, CelsiusAKelvinResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CentimetrosAPulgadas }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CentimetrosAPulgadas }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "centimetrosAPulgadas")
    public JAXBElement<CentimetrosAPulgadas> createCentimetrosAPulgadas(CentimetrosAPulgadas value) {
        return new JAXBElement<CentimetrosAPulgadas>(_CentimetrosAPulgadas_QNAME, CentimetrosAPulgadas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CentimetrosAPulgadasResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CentimetrosAPulgadasResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "centimetrosAPulgadasResponse")
    public JAXBElement<CentimetrosAPulgadasResponse> createCentimetrosAPulgadasResponse(CentimetrosAPulgadasResponse value) {
        return new JAXBElement<CentimetrosAPulgadasResponse>(_CentimetrosAPulgadasResponse_QNAME, CentimetrosAPulgadasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GramosAKilogramos }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GramosAKilogramos }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "gramosAKilogramos")
    public JAXBElement<GramosAKilogramos> createGramosAKilogramos(GramosAKilogramos value) {
        return new JAXBElement<GramosAKilogramos>(_GramosAKilogramos_QNAME, GramosAKilogramos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GramosAKilogramosResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GramosAKilogramosResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "gramosAKilogramosResponse")
    public JAXBElement<GramosAKilogramosResponse> createGramosAKilogramosResponse(GramosAKilogramosResponse value) {
        return new JAXBElement<GramosAKilogramosResponse>(_GramosAKilogramosResponse_QNAME, GramosAKilogramosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KelvinACelsius }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link KelvinACelsius }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "kelvinACelsius")
    public JAXBElement<KelvinACelsius> createKelvinACelsius(KelvinACelsius value) {
        return new JAXBElement<KelvinACelsius>(_KelvinACelsius_QNAME, KelvinACelsius.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KelvinACelsiusResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link KelvinACelsiusResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "kelvinACelsiusResponse")
    public JAXBElement<KelvinACelsiusResponse> createKelvinACelsiusResponse(KelvinACelsiusResponse value) {
        return new JAXBElement<KelvinACelsiusResponse>(_KelvinACelsiusResponse_QNAME, KelvinACelsiusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KilogramosAGramos }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link KilogramosAGramos }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "kilogramosAGramos")
    public JAXBElement<KilogramosAGramos> createKilogramosAGramos(KilogramosAGramos value) {
        return new JAXBElement<KilogramosAGramos>(_KilogramosAGramos_QNAME, KilogramosAGramos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KilogramosAGramosResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link KilogramosAGramosResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "kilogramosAGramosResponse")
    public JAXBElement<KilogramosAGramosResponse> createKilogramosAGramosResponse(KilogramosAGramosResponse value) {
        return new JAXBElement<KilogramosAGramosResponse>(_KilogramosAGramosResponse_QNAME, KilogramosAGramosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PulgadasACentimetros }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PulgadasACentimetros }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "pulgadasACentimetros")
    public JAXBElement<PulgadasACentimetros> createPulgadasACentimetros(PulgadasACentimetros value) {
        return new JAXBElement<PulgadasACentimetros>(_PulgadasACentimetros_QNAME, PulgadasACentimetros.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PulgadasACentimetrosResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PulgadasACentimetrosResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "pulgadasACentimetrosResponse")
    public JAXBElement<PulgadasACentimetrosResponse> createPulgadasACentimetrosResponse(PulgadasACentimetrosResponse value) {
        return new JAXBElement<PulgadasACentimetrosResponse>(_PulgadasACentimetrosResponse_QNAME, PulgadasACentimetrosResponse.class, null, value);
    }

}
