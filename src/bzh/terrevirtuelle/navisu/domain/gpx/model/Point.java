//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.03 at 09:49:42 AM CET 
//


package bzh.terrevirtuelle.navisu.domain.gpx.model;

import java.util.GregorianCalendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;



/**
 * 
 * 	 A geographic point with optional elevation and time.  Available for use by other schemas.
 *     
 * 
 * <p>Java class for ptType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ptType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ele" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="lat" use="required" type="{http://www.topografix.com/GPX/1/1}latitudeType" />
 *       &lt;attribute name="lon" use="required" type="{http://www.topografix.com/GPX/1/1}longitudeType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pt", propOrder = {
    "ele",
    "time"
})
public class Point {

    protected double ele;
    @XmlSchemaType(name = "dateTime")
    protected GregorianCalendar time;
    @XmlAttribute(name = "lat", required = true)
    protected double latitude;
    @XmlAttribute(name = "lon", required = true)
    protected double longitude;

    public Point() {
    }

    public Point(double ele, GregorianCalendar time, double lat, double lon) {
        this.ele = ele;
        this.time = time;
        this.latitude = lat;
        this.longitude = lon;
    }

    public Point(GregorianCalendar time, double lat, double lon) {
        this.time = time;
        this.latitude = lat;
        this.longitude = lon;
    }

    public Point(double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;
    }

    /**
     * Gets the value of the ele property.
     * 
     * @return
     *     possible object is
     *     {@link double }
     *     
     */
    public double getEle() {
        return ele;
    }

    /**
     * Sets the value of the ele property.
     * 
     * @param value
     *     allowed object is
     *     {@link double }
     *     
     */
    public void setEle(double value) {
        this.ele = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link GregorianCalendar }
     *     
     */
    public GregorianCalendar getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link GregorianCalendar }
     *     
     */
    public void setTime(GregorianCalendar value) {
        this.time = value;
    }

    /**
     * Gets the value of the lat property.
     * 
     * @return
     *     possible object is
     *     {@link double }
     *     
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the lat property.
     * 
     * @param value
     *     allowed object is
     *     {@link double }
     *     
     */
    public void setLatitude(double value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the lon property.
     * 
     * @return
     *     possible object is
     *     {@link double }
     *     
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the lon property.
     * 
     * @param value
     *     allowed object is
     *     {@link double }
     *     
     */
    public void setLongitude(double value) {
        this.longitude = value;
    }

}
