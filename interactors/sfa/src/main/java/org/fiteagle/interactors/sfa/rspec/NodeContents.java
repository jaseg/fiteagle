//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.28 at 02:10:13 PM CET 
//


package org.fiteagle.interactors.sfa.rspec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>Java class for NodeContents complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NodeContents">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;choice>
 *           &lt;group ref="{http://www.geni.net/resources/rspec/3}AnyExtension"/>
 *           &lt;element ref="{http://www.geni.net/resources/rspec/3}relation"/>
 *           &lt;element ref="{http://www.geni.net/resources/rspec/3}location"/>
 *           &lt;element ref="{http://www.geni.net/resources/rspec/3}services"/>
 *           &lt;element ref="{http://www.geni.net/resources/rspec/3}interface"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element ref="{http://www.geni.net/resources/rspec/3}available"/>
 *           &lt;element ref="{http://www.geni.net/resources/rspec/3}cloud"/>
 *           &lt;element ref="{http://www.geni.net/resources/rspec/3}hardware_type"/>
 *           &lt;element name="sliver_type">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                     &lt;group ref="{http://www.geni.net/resources/rspec/3}SliverTypeContents"/>
 *                     &lt;element name="disk_image">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://www.geni.net/resources/rspec/3}DiskImageContents">
 *                             &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                             &lt;anyAttribute processContents='lax' namespace='##other'/>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/choice>
 *                   &lt;attGroup ref="{http://www.geni.net/resources/rspec/3}SliverTypeContents"/>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *       &lt;/choice>
 *       &lt;attGroup ref="{http://www.geni.net/resources/rspec/3}AnyExtension"/>
 *       &lt;attribute name="component_id" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="component_manager_id" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="component_name" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="exclusive" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NodeContents", propOrder = {
    "anyOrRelationOrLocation"
})
public class NodeContents {

    @XmlElementRefs({
        @XmlElementRef(name = "hardware_type", namespace = "http://www.geni.net/resources/rspec/3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "location", namespace = "http://www.geni.net/resources/rspec/3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "interface", namespace = "http://www.geni.net/resources/rspec/3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "services", namespace = "http://www.geni.net/resources/rspec/3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sliver_type", namespace = "http://www.geni.net/resources/rspec/3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "relation", namespace = "http://www.geni.net/resources/rspec/3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cloud", namespace = "http://www.geni.net/resources/rspec/3", type = Cloud.class, required = false),
        @XmlElementRef(name = "available", namespace = "http://www.geni.net/resources/rspec/3", type = JAXBElement.class, required = false)
    })
    @XmlAnyElement(lax = true)
    protected List<Object> anyOrRelationOrLocation;
    @XmlAttribute(name = "component_id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String componentId;
    @XmlAttribute(name = "component_manager_id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String componentManagerId;
    @XmlAttribute(name = "component_name")
    @XmlSchemaType(name = "anySimpleType")
    protected String componentName;
    @XmlAttribute(name = "exclusive", required = true)
    protected boolean exclusive;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the anyOrRelationOrLocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anyOrRelationOrLocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnyOrRelationOrLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     * {@link JAXBElement }{@code <}{@link RelationContents }{@code >}
     * {@link JAXBElement }{@code <}{@link NodeContents.SliverType }{@code >}
     * {@link JAXBElement }{@code <}{@link LocationContents }{@code >}
     * {@link JAXBElement }{@code <}{@link HardwareTypeContents }{@code >}
     * {@link Cloud }
     * {@link JAXBElement }{@code <}{@link InterfaceContents }{@code >}
     * {@link JAXBElement }{@code <}{@link AvailableContents }{@code >}
     * {@link JAXBElement }{@code <}{@link ServiceContents }{@code >}
     * 
     * 
     */
    public List<Object> getAnyOrRelationOrLocation() {
        if (anyOrRelationOrLocation == null) {
            anyOrRelationOrLocation = new ArrayList<Object>();
        }
        return this.anyOrRelationOrLocation;
    }

    /**
     * Gets the value of the componentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComponentId() {
        return componentId;
    }

    /**
     * Sets the value of the componentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComponentId(String value) {
        this.componentId = value;
    }

    /**
     * Gets the value of the componentManagerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComponentManagerId() {
        return componentManagerId;
    }

    /**
     * Sets the value of the componentManagerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComponentManagerId(String value) {
        this.componentManagerId = value;
    }

    /**
     * Gets the value of the componentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComponentName() {
        return componentName;
    }

    /**
     * Sets the value of the componentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComponentName(String value) {
        this.componentName = value;
    }

    /**
     * Gets the value of the exclusive property.
     * 
     */
    public boolean isExclusive() {
        return exclusive;
    }

    /**
     * Sets the value of the exclusive property.
     * 
     */
    public void setExclusive(boolean value) {
        this.exclusive = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice maxOccurs="unbounded" minOccurs="0">
     *         &lt;group ref="{http://www.geni.net/resources/rspec/3}SliverTypeContents"/>
     *         &lt;element name="disk_image">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.geni.net/resources/rspec/3}DiskImageContents">
     *                 &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *                 &lt;anyAttribute processContents='lax' namespace='##other'/>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/choice>
     *       &lt;attGroup ref="{http://www.geni.net/resources/rspec/3}SliverTypeContents"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "anyOrDiskImage"
    })
    public static class SliverType {

        @XmlElementRef(name = "disk_image", namespace = "http://www.geni.net/resources/rspec/3", type = JAXBElement.class, required = false)
        @XmlAnyElement(lax = true)
        protected List<Object> anyOrDiskImage;
        @XmlAttribute(name = "name", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String name;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the anyOrDiskImage property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the anyOrDiskImage property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAnyOrDiskImage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * {@link Element }
         * {@link JAXBElement }{@code <}{@link NodeContents.SliverType.DiskImage }{@code >}
         * 
         * 
         */
        public List<Object> getAnyOrDiskImage() {
            if (anyOrDiskImage == null) {
                anyOrDiskImage = new ArrayList<Object>();
            }
            return this.anyOrDiskImage;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         * 
         * <p>
         * the map is keyed by the name of the attribute and 
         * the value is the string value of the attribute.
         * 
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         * 
         * 
         * @return
         *     always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://www.geni.net/resources/rspec/3}DiskImageContents">
         *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
         *       &lt;anyAttribute processContents='lax' namespace='##other'/>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class DiskImage
            extends DiskImageContents
        {

            @XmlAttribute(name = "default")
            @XmlSchemaType(name = "anySimpleType")
            protected String _default;

            /**
             * Gets the value of the default property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDefault() {
                return _default;
            }

            /**
             * Sets the value of the default property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDefault(String value) {
                this._default = value;
            }

        }

    }

}
