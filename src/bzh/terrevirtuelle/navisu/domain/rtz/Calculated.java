//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.03 at 04:05:58 PM CET 
//
package bzh.terrevirtuelle.navisu.domain.rtz;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * Calculated schedule parameters.
 *
 *
 * <p>
 * Java class for Calculated complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="Calculated">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sheduleElement" type="{http://www.cirm.org/RTZ/1/0}ScheduleElement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="extensions" type="{http://www.cirm.org/RTZ/1/0}Extensions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Calculated", propOrder = {
    "sheduleElement",
    "extensions"
})
public class Calculated {

    protected List<ScheduleElement> sheduleElement;
    protected Extensions extensions;

    /**
     * Gets the value of the sheduleElement property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the sheduleElement property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSheduleElement().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScheduleElement }
     *
     *
     */
    public List<ScheduleElement> getSheduleElement() {
        if (sheduleElement == null) {
            sheduleElement = new ArrayList<ScheduleElement>();
        }
        return this.sheduleElement;
    }

    /**
     * Gets the value of the extensions property.
     *
     * @return possible object is {@link Extensions }
     *
     */
    public Extensions getExtensions() {
        return extensions;
    }

    /**
     * Sets the value of the extensions property.
     *
     * @param value allowed object is {@link Extensions }
     *
     */
    public void setExtensions(Extensions value) {
        this.extensions = value;
    }

    @Override
    public String toString() {
        return "Calculated{" + "sheduleElement=" + sheduleElement + ", extensions=" + extensions + '}';
    }

}