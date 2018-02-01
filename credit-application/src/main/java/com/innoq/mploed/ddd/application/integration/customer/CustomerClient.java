package com.innoq.mploed.ddd.application.integration.customer;

import com.innoq.mploed.ddd.application.domain.Customer;
import com.innoq.mploed.ddd.application.integration.customer.wsdl.SaveCustomerRequest;
import com.innoq.mploed.ddd.application.integration.customer.wsdl.SaveCustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CustomerClient  extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(CustomerClient.class);

    private String customerServer;


    public CustomerClient(String customerServer) {
        this.customerServer = customerServer;
    }

    public Customer saveCustomer(Customer customer) {
        SaveCustomerRequest request = new SaveCustomerRequest();
        com.innoq.mploed.ddd.application.integration.customer.wsdl.Customer webServiceCustomer = fromInternalToExternalModel(customer);
        request.setCustomer(webServiceCustomer);

        log.info("Saving Customer in the CRM System");

        SaveCustomerResponse response = (SaveCustomerResponse)getWebServiceTemplate().marshalSendAndReceive(customerServer + "ws", request);

        log.info("Saved Customer with Id: " + response.getCustomer().getId());
        Customer result = fromExternalToInternalModel(response);
        return result;
    }

    private Customer fromExternalToInternalModel(SaveCustomerResponse response) {
        Customer result = new Customer();
        result.setId(response.getCustomer().getId());
        result.setFirstName(response.getCustomer().getFirstName());
        result.setLastName(response.getCustomer().getLastName());
        result.setStreet(response.getCustomer().getStreet());
        result.setPostCode(response.getCustomer().getPostCode());
        result.setCity(response.getCustomer().getCity());
        return result;
    }

    private com.innoq.mploed.ddd.application.integration.customer.wsdl.Customer fromInternalToExternalModel(Customer customer) {
        com.innoq.mploed.ddd.application.integration.customer.wsdl.Customer webServiceCustomer = new com.innoq.mploed.ddd.application.integration.customer.wsdl.Customer();
        webServiceCustomer.setCity(customer.getCity());
        webServiceCustomer.setFirstName(customer.getFirstName());
        webServiceCustomer.setLastName(customer.getLastName());
        webServiceCustomer.setStreet(customer.getStreet());
        webServiceCustomer.setPostCode(customer.getPostCode());
        return webServiceCustomer;
    }

}
