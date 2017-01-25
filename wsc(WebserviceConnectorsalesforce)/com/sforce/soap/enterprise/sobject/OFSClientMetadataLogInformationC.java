
package com.sforce.soap.enterprise.sobject;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OFSClient__MetadataLogInformation__c complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OFSClient__MetadataLogInformation__c">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:sobject.enterprise.soap.sforce.com}sObject">
 *       &lt;sequence>
 *         &lt;element name="OFSClient__Action__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__BaseOrgId__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__BaseOrgRefreshToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__BaseOrgToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__BaseOrgUrl__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__BitBucket_AccessToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__BitBucket_RefreshTOken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__BitBucket_URL__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__BitBucket_User_Name__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__Error_Message__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__GIT_Access_Token__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__GIT_URL__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__GIT_User_Name__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__ID__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__Name__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__OrganizationId__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__Override__c" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OFSClient__RecordId__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__RepositoryId__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__SourceOrgRefreshToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__SourceOrgToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__SourceOrganizationURL__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__Status__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__TargetOrgRefreshToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__TargetOrgTokenNonEncrypted__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFSClient__TargetOrgToken__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OFSClient__MetadataLogInformation__c", propOrder = {
    "ofsClientActionC",
    "ofsClientBaseOrgIdC",
    "ofsClientBaseOrgRefreshTokenC",
    "ofsClientBaseOrgTokenC",
    "ofsClientBaseOrgUrlC",
    "ofsClientBitBucketAccessTokenC",
    "ofsClientBitBucketRefreshTOkenC",
    "ofsClientBitBucketURLC",
    "ofsClientBitBucketUserNameC",
    "ofsClientErrorMessageC",
    "ofsClientGITAccessTokenC",
    "ofsClientGITURLC",
    "ofsClientGITUserNameC",
    "ofsClientIDC",
    "ofsClientNameC",
    "ofsClientOrganizationIdC",
    "ofsClientOverrideC",
    "ofsClientRecordIdC",
    "ofsClientRepositoryIdC",
    "ofsClientSourceOrgRefreshTokenC",
    "ofsClientSourceOrgTokenC",
    "ofsClientSourceOrganizationURLC",
    "ofsClientStatusC",
    "ofsClientTargetOrgRefreshTokenC",
    "ofsClientTargetOrgTokenNonEncryptedC",
    "ofsClientTargetOrgTokenC"
})
public class OFSClientMetadataLogInformationC
    extends SObject
{

    @XmlElementRef(name = "OFSClient__Action__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientActionC;
    @XmlElementRef(name = "OFSClient__BaseOrgId__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientBaseOrgIdC;
    @XmlElementRef(name = "OFSClient__BaseOrgRefreshToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientBaseOrgRefreshTokenC;
    @XmlElementRef(name = "OFSClient__BaseOrgToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientBaseOrgTokenC;
    @XmlElementRef(name = "OFSClient__BaseOrgUrl__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientBaseOrgUrlC;
    @XmlElementRef(name = "OFSClient__BitBucket_AccessToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientBitBucketAccessTokenC;
    @XmlElementRef(name = "OFSClient__BitBucket_RefreshTOken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientBitBucketRefreshTOkenC;
    @XmlElementRef(name = "OFSClient__BitBucket_URL__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientBitBucketURLC;
    @XmlElementRef(name = "OFSClient__BitBucket_User_Name__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientBitBucketUserNameC;
    @XmlElementRef(name = "OFSClient__Error_Message__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientErrorMessageC;
    @XmlElementRef(name = "OFSClient__GIT_Access_Token__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientGITAccessTokenC;
    @XmlElementRef(name = "OFSClient__GIT_URL__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientGITURLC;
    @XmlElementRef(name = "OFSClient__GIT_User_Name__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientGITUserNameC;
    @XmlElementRef(name = "OFSClient__ID__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientIDC;
    @XmlElementRef(name = "OFSClient__Name__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientNameC;
    @XmlElementRef(name = "OFSClient__OrganizationId__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientOrganizationIdC;
    @XmlElementRef(name = "OFSClient__Override__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> ofsClientOverrideC;
    @XmlElementRef(name = "OFSClient__RecordId__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientRecordIdC;
    @XmlElementRef(name = "OFSClient__RepositoryId__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientRepositoryIdC;
    @XmlElementRef(name = "OFSClient__SourceOrgRefreshToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientSourceOrgRefreshTokenC;
    @XmlElementRef(name = "OFSClient__SourceOrgToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientSourceOrgTokenC;
    @XmlElementRef(name = "OFSClient__SourceOrganizationURL__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientSourceOrganizationURLC;
    @XmlElementRef(name = "OFSClient__Status__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientStatusC;
    @XmlElementRef(name = "OFSClient__TargetOrgRefreshToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientTargetOrgRefreshTokenC;
    @XmlElementRef(name = "OFSClient__TargetOrgTokenNonEncrypted__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientTargetOrgTokenNonEncryptedC;
    @XmlElementRef(name = "OFSClient__TargetOrgToken__c", namespace = "urn:sobject.enterprise.soap.sforce.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofsClientTargetOrgTokenC;

    /**
     * Gets the value of the ofsClientActionC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientActionC() {
        return ofsClientActionC;
    }

    /**
     * Sets the value of the ofsClientActionC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientActionC(JAXBElement<String> value) {
        this.ofsClientActionC = value;
    }

    /**
     * Gets the value of the ofsClientBaseOrgIdC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientBaseOrgIdC() {
        return ofsClientBaseOrgIdC;
    }

    /**
     * Sets the value of the ofsClientBaseOrgIdC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientBaseOrgIdC(JAXBElement<String> value) {
        this.ofsClientBaseOrgIdC = value;
    }

    /**
     * Gets the value of the ofsClientBaseOrgRefreshTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientBaseOrgRefreshTokenC() {
        return ofsClientBaseOrgRefreshTokenC;
    }

    /**
     * Sets the value of the ofsClientBaseOrgRefreshTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientBaseOrgRefreshTokenC(JAXBElement<String> value) {
        this.ofsClientBaseOrgRefreshTokenC = value;
    }

    /**
     * Gets the value of the ofsClientBaseOrgTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientBaseOrgTokenC() {
        return ofsClientBaseOrgTokenC;
    }

    /**
     * Sets the value of the ofsClientBaseOrgTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientBaseOrgTokenC(JAXBElement<String> value) {
        this.ofsClientBaseOrgTokenC = value;
    }

    /**
     * Gets the value of the ofsClientBaseOrgUrlC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientBaseOrgUrlC() {
        return ofsClientBaseOrgUrlC;
    }

    /**
     * Sets the value of the ofsClientBaseOrgUrlC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientBaseOrgUrlC(JAXBElement<String> value) {
        this.ofsClientBaseOrgUrlC = value;
    }

    /**
     * Gets the value of the ofsClientBitBucketAccessTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientBitBucketAccessTokenC() {
        return ofsClientBitBucketAccessTokenC;
    }

    /**
     * Sets the value of the ofsClientBitBucketAccessTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientBitBucketAccessTokenC(JAXBElement<String> value) {
        this.ofsClientBitBucketAccessTokenC = value;
    }

    /**
     * Gets the value of the ofsClientBitBucketRefreshTOkenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientBitBucketRefreshTOkenC() {
        return ofsClientBitBucketRefreshTOkenC;
    }

    /**
     * Sets the value of the ofsClientBitBucketRefreshTOkenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientBitBucketRefreshTOkenC(JAXBElement<String> value) {
        this.ofsClientBitBucketRefreshTOkenC = value;
    }

    /**
     * Gets the value of the ofsClientBitBucketURLC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientBitBucketURLC() {
        return ofsClientBitBucketURLC;
    }

    /**
     * Sets the value of the ofsClientBitBucketURLC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientBitBucketURLC(JAXBElement<String> value) {
        this.ofsClientBitBucketURLC = value;
    }

    /**
     * Gets the value of the ofsClientBitBucketUserNameC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientBitBucketUserNameC() {
        return ofsClientBitBucketUserNameC;
    }

    /**
     * Sets the value of the ofsClientBitBucketUserNameC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientBitBucketUserNameC(JAXBElement<String> value) {
        this.ofsClientBitBucketUserNameC = value;
    }

    /**
     * Gets the value of the ofsClientErrorMessageC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientErrorMessageC() {
        return ofsClientErrorMessageC;
    }

    /**
     * Sets the value of the ofsClientErrorMessageC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientErrorMessageC(JAXBElement<String> value) {
        this.ofsClientErrorMessageC = value;
    }

    /**
     * Gets the value of the ofsClientGITAccessTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientGITAccessTokenC() {
        return ofsClientGITAccessTokenC;
    }

    /**
     * Sets the value of the ofsClientGITAccessTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientGITAccessTokenC(JAXBElement<String> value) {
        this.ofsClientGITAccessTokenC = value;
    }

    /**
     * Gets the value of the ofsClientGITURLC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientGITURLC() {
        return ofsClientGITURLC;
    }

    /**
     * Sets the value of the ofsClientGITURLC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientGITURLC(JAXBElement<String> value) {
        this.ofsClientGITURLC = value;
    }

    /**
     * Gets the value of the ofsClientGITUserNameC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientGITUserNameC() {
        return ofsClientGITUserNameC;
    }

    /**
     * Sets the value of the ofsClientGITUserNameC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientGITUserNameC(JAXBElement<String> value) {
        this.ofsClientGITUserNameC = value;
    }

    /**
     * Gets the value of the ofsClientIDC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientIDC() {
        return ofsClientIDC;
    }

    /**
     * Sets the value of the ofsClientIDC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientIDC(JAXBElement<String> value) {
        this.ofsClientIDC = value;
    }

    /**
     * Gets the value of the ofsClientNameC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientNameC() {
        return ofsClientNameC;
    }

    /**
     * Sets the value of the ofsClientNameC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientNameC(JAXBElement<String> value) {
        this.ofsClientNameC = value;
    }

    /**
     * Gets the value of the ofsClientOrganizationIdC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientOrganizationIdC() {
        return ofsClientOrganizationIdC;
    }

    /**
     * Sets the value of the ofsClientOrganizationIdC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientOrganizationIdC(JAXBElement<String> value) {
        this.ofsClientOrganizationIdC = value;
    }

    /**
     * Gets the value of the ofsClientOverrideC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getOFSClientOverrideC() {
        return ofsClientOverrideC;
    }

    /**
     * Sets the value of the ofsClientOverrideC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setOFSClientOverrideC(JAXBElement<Boolean> value) {
        this.ofsClientOverrideC = value;
    }

    /**
     * Gets the value of the ofsClientRecordIdC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientRecordIdC() {
        return ofsClientRecordIdC;
    }

    /**
     * Sets the value of the ofsClientRecordIdC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientRecordIdC(JAXBElement<String> value) {
        this.ofsClientRecordIdC = value;
    }

    /**
     * Gets the value of the ofsClientRepositoryIdC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientRepositoryIdC() {
        return ofsClientRepositoryIdC;
    }

    /**
     * Sets the value of the ofsClientRepositoryIdC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientRepositoryIdC(JAXBElement<String> value) {
        this.ofsClientRepositoryIdC = value;
    }

    /**
     * Gets the value of the ofsClientSourceOrgRefreshTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientSourceOrgRefreshTokenC() {
        return ofsClientSourceOrgRefreshTokenC;
    }

    /**
     * Sets the value of the ofsClientSourceOrgRefreshTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientSourceOrgRefreshTokenC(JAXBElement<String> value) {
        this.ofsClientSourceOrgRefreshTokenC = value;
    }

    /**
     * Gets the value of the ofsClientSourceOrgTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientSourceOrgTokenC() {
        return ofsClientSourceOrgTokenC;
    }

    /**
     * Sets the value of the ofsClientSourceOrgTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientSourceOrgTokenC(JAXBElement<String> value) {
        this.ofsClientSourceOrgTokenC = value;
    }

    /**
     * Gets the value of the ofsClientSourceOrganizationURLC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientSourceOrganizationURLC() {
        return ofsClientSourceOrganizationURLC;
    }

    /**
     * Sets the value of the ofsClientSourceOrganizationURLC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientSourceOrganizationURLC(JAXBElement<String> value) {
        this.ofsClientSourceOrganizationURLC = value;
    }

    /**
     * Gets the value of the ofsClientStatusC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientStatusC() {
        return ofsClientStatusC;
    }

    /**
     * Sets the value of the ofsClientStatusC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientStatusC(JAXBElement<String> value) {
        this.ofsClientStatusC = value;
    }

    /**
     * Gets the value of the ofsClientTargetOrgRefreshTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientTargetOrgRefreshTokenC() {
        return ofsClientTargetOrgRefreshTokenC;
    }

    /**
     * Sets the value of the ofsClientTargetOrgRefreshTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientTargetOrgRefreshTokenC(JAXBElement<String> value) {
        this.ofsClientTargetOrgRefreshTokenC = value;
    }

    /**
     * Gets the value of the ofsClientTargetOrgTokenNonEncryptedC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientTargetOrgTokenNonEncryptedC() {
        return ofsClientTargetOrgTokenNonEncryptedC;
    }

    /**
     * Sets the value of the ofsClientTargetOrgTokenNonEncryptedC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientTargetOrgTokenNonEncryptedC(JAXBElement<String> value) {
        this.ofsClientTargetOrgTokenNonEncryptedC = value;
    }

    /**
     * Gets the value of the ofsClientTargetOrgTokenC property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFSClientTargetOrgTokenC() {
        return ofsClientTargetOrgTokenC;
    }

    /**
     * Sets the value of the ofsClientTargetOrgTokenC property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFSClientTargetOrgTokenC(JAXBElement<String> value) {
        this.ofsClientTargetOrgTokenC = value;
    }

}
