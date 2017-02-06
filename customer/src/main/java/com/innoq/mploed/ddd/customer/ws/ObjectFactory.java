//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.02.06 um 01:12:59 PM CET 
//


package com.innoq.mploed.ddd.customer.ws;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.innoq.mploed.ddd.customer.ws package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.innoq.mploed.ddd.customer.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SaveCustomerResponse }
     * 
     */
    public SaveCustomerResponse createSaveCustomerResponse() {
        return new SaveCustomerResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link SaveCustomerRequest }
     * 
     */
    public SaveCustomerRequest createSaveCustomerRequest() {
        return new SaveCustomerRequest();
    }

}
