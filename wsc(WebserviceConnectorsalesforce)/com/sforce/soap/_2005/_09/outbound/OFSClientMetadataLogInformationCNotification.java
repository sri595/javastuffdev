
package com.sforce.soap._2005._09.outbound;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sforce.soap.enterprise.sobject.OFSClientMetadataLogInformationC;


/**
 * <p>Java class for OFSClient__MetadataLogInformation__cNotification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OFSClient__MetadataLogInformation__cNotification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:enterprise.soap.sforce.com}ID"/>
 *         &lt;element name="sObject" type="{urn:sobject.enterprise.soap.sforce.com}OFSClient__MetadataLogInformation__c"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OFSClient__MetadataLogInformation__cNotification", propOrder = {
    "id",
    "sObject"
})
public class OFSClientMetadataLogInformationCNotification {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(required = true)
    protected OFSClientMetadataLogInformationC sObject;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the sObject property.
     * 
     * @return
     *     possible object is
     *     {@link OFSClientMetadataLogInformationC }
     *     
     */
    public OFSClientMetadataLogInformationC getSObject() {
        return sObject;
    }

    /**
     * Sets the value of the sObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link OFSClientMetadataLogInformationC }
     *     
     */
    public void setSObject(OFSClientMetadataLogInformationC value) {
        this.sObject = value;
    }

}
