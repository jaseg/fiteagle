//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.03 at 03:55:56 PM CEST 
//


package org.fiteagle.interactors.sfa.getSelfCredential.jaxbClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}property_name"/>
 *         &lt;element ref="{}property_value"/>
 *         &lt;element ref="{}property_penalty"/>
 *         &lt;element ref="{}violatable" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="global_operator">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="OnceOnly"/>
 *             &lt;enumeration value="FirstFree"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="local_operator">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="+"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "propertyName",
    "propertyValue",
    "propertyPenalty",
    "violatable"
})
@XmlRootElement(name = "property")
public class Property {

    @XmlElement(name = "property_name", required = true)
    protected String propertyName;
    @XmlElement(name = "property_value", required = true)
    protected String propertyValue;
    @XmlElement(name = "property_penalty")
    protected float propertyPenalty;
    protected Violatable violatable;
    @XmlAttribute(name = "global_operator")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String globalOperator;
    @XmlAttribute(name = "local_operator")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String localOperator;

    /**
     * Gets the value of the propertyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Sets the value of the propertyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyName(String value) {
        this.propertyName = value;
    }

    /**
     * Gets the value of the propertyValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyValue() {
        return propertyValue;
    }

    /**
     * Sets the value of the propertyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyValue(String value) {
        this.propertyValue = value;
    }

    /**
     * Gets the value of the propertyPenalty property.
     * 
     */
    public float getPropertyPenalty() {
        return propertyPenalty;
    }

    /**
     * Sets the value of the propertyPenalty property.
     * 
     */
    public void setPropertyPenalty(float value) {
        this.propertyPenalty = value;
    }

    /**
     * Gets the value of the violatable property.
     * 
     * @return
     *     possible object is
     *     {@link Violatable }
     *     
     */
    public Violatable getViolatable() {
        return violatable;
    }

    /**
     * Sets the value of the violatable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Violatable }
     *     
     */
    public void setViolatable(Violatable value) {
        this.violatable = value;
    }

    /**
     * Gets the value of the globalOperator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlobalOperator() {
        return globalOperator;
    }

    /**
     * Sets the value of the globalOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlobalOperator(String value) {
        this.globalOperator = value;
    }

    /**
     * Gets the value of the localOperator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalOperator() {
        return localOperator;
    }

    /**
     * Sets the value of the localOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalOperator(String value) {
        this.localOperator = value;
    }

}
