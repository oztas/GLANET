//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.25 at 09:13:08 AM EET 
//


package gov.nih.nlm.ncbi.snp.docsum;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{http://www.ncbi.nlm.nih.gov/SNP/docsum}FxnSet" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="asnFrom" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="asnTo" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="locType" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="insertion"/>
 *             &lt;enumeration value="exact"/>
 *             &lt;enumeration value="deletion"/>
 *             &lt;enumeration value="range-ins"/>
 *             &lt;enumeration value="range-exact"/>
 *             &lt;enumeration value="range-del"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="alnQuality" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="orient">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="forward"/>
 *             &lt;enumeration value="reverse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="physMapInt" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="leftFlankNeighborPos" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="rightFlankNeighborPos" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="leftContigNeighborPos" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="rightContigNeighborPos" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="numberOfMismatches" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="numberOfDeletions" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="numberOfInsertions" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fxnSet"
})
@XmlRootElement(name = "MapLoc")
public class MapLoc {

    @XmlElement(name = "FxnSet")
    protected List<FxnSet> fxnSet;
    @XmlAttribute(name = "asnFrom", required = true)
    protected BigInteger asnFrom;
    @XmlAttribute(name = "asnTo", required = true)
    protected BigInteger asnTo;
    @XmlAttribute(name = "locType", required = true)
    protected String locType;
    @XmlAttribute(name = "alnQuality")
    protected Double alnQuality;
    @XmlAttribute(name = "orient")
    protected String orient;
    @XmlAttribute(name = "physMapInt")
    protected Integer physMapInt;
    @XmlAttribute(name = "leftFlankNeighborPos")
    protected Integer leftFlankNeighborPos;
    @XmlAttribute(name = "rightFlankNeighborPos")
    protected Integer rightFlankNeighborPos;
    @XmlAttribute(name = "leftContigNeighborPos")
    protected Integer leftContigNeighborPos;
    @XmlAttribute(name = "rightContigNeighborPos")
    protected Integer rightContigNeighborPos;
    @XmlAttribute(name = "numberOfMismatches")
    protected Integer numberOfMismatches;
    @XmlAttribute(name = "numberOfDeletions")
    protected Integer numberOfDeletions;
    @XmlAttribute(name = "numberOfInsertions")
    protected Integer numberOfInsertions;

    /**
     * Gets the value of the fxnSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fxnSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFxnSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FxnSet }
     * 
     * 
     */
    public List<FxnSet> getFxnSet() {
        if (fxnSet == null) {
            fxnSet = new ArrayList<FxnSet>();
        }
        return this.fxnSet;
    }

    /**
     * Gets the value of the asnFrom property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAsnFrom() {
        return asnFrom;
    }

    /**
     * Sets the value of the asnFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAsnFrom(BigInteger value) {
        this.asnFrom = value;
    }

    /**
     * Gets the value of the asnTo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAsnTo() {
        return asnTo;
    }

    /**
     * Sets the value of the asnTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAsnTo(BigInteger value) {
        this.asnTo = value;
    }

    /**
     * Gets the value of the locType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocType() {
        return locType;
    }

    /**
     * Sets the value of the locType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocType(String value) {
        this.locType = value;
    }

    /**
     * Gets the value of the alnQuality property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAlnQuality() {
        return alnQuality;
    }

    /**
     * Sets the value of the alnQuality property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAlnQuality(Double value) {
        this.alnQuality = value;
    }

    /**
     * Gets the value of the orient property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrient() {
        return orient;
    }

    /**
     * Sets the value of the orient property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrient(String value) {
        this.orient = value;
    }

    /**
     * Gets the value of the physMapInt property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPhysMapInt() {
        return physMapInt;
    }

    /**
     * Sets the value of the physMapInt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPhysMapInt(Integer value) {
        this.physMapInt = value;
    }

    /**
     * Gets the value of the leftFlankNeighborPos property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLeftFlankNeighborPos() {
        return leftFlankNeighborPos;
    }

    /**
     * Sets the value of the leftFlankNeighborPos property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLeftFlankNeighborPos(Integer value) {
        this.leftFlankNeighborPos = value;
    }

    /**
     * Gets the value of the rightFlankNeighborPos property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRightFlankNeighborPos() {
        return rightFlankNeighborPos;
    }

    /**
     * Sets the value of the rightFlankNeighborPos property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRightFlankNeighborPos(Integer value) {
        this.rightFlankNeighborPos = value;
    }

    /**
     * Gets the value of the leftContigNeighborPos property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLeftContigNeighborPos() {
        return leftContigNeighborPos;
    }

    /**
     * Sets the value of the leftContigNeighborPos property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLeftContigNeighborPos(Integer value) {
        this.leftContigNeighborPos = value;
    }

    /**
     * Gets the value of the rightContigNeighborPos property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRightContigNeighborPos() {
        return rightContigNeighborPos;
    }

    /**
     * Sets the value of the rightContigNeighborPos property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRightContigNeighborPos(Integer value) {
        this.rightContigNeighborPos = value;
    }

    /**
     * Gets the value of the numberOfMismatches property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfMismatches() {
        return numberOfMismatches;
    }

    /**
     * Sets the value of the numberOfMismatches property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfMismatches(Integer value) {
        this.numberOfMismatches = value;
    }

    /**
     * Gets the value of the numberOfDeletions property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfDeletions() {
        return numberOfDeletions;
    }

    /**
     * Sets the value of the numberOfDeletions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfDeletions(Integer value) {
        this.numberOfDeletions = value;
    }

    /**
     * Gets the value of the numberOfInsertions property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfInsertions() {
        return numberOfInsertions;
    }

    /**
     * Sets the value of the numberOfInsertions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfInsertions(Integer value) {
        this.numberOfInsertions = value;
    }

}
