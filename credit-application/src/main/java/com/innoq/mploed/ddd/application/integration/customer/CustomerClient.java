package com.innoq.mploed.ddd.application.integration.customer;

import com.innoq.mploed.ddd.application.domain.Customer;
import com.innoq.mploed.ddd.application.integration.customer.wsdl.SaveCustomerRequest;
import com.innoq.mploed.ddd.application.integration.customer.wsdl.SaveCustomerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CustomerClient  extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(CustomerClient.class);

    public void saveCustomer(Customer customer) {
        SaveCustomerRequest request = new SaveCustomerRequest();
        com.innoq.mploed.ddd.application.integration.customer.wsdl.Customer webServiceCustomer = new com.innoq.mploed.ddd.application.integration.customer.wsdl.Customer();
        webServiceCustomer.setCity(customer.getCity());
        webServiceCustomer.setFirstName(customer.getFirstName());
        webServiceCustomer.setLastName(customer.getLastName());
        webServiceCustomer.setStreet(customer.getStreet());
        webServiceCustomer.setPostCode(customer.getPostCode());
        request.setCustomer(webServiceCustomer);

        log.info("Saving Customer in the CRM System");

        SaveCustomerResponse response = (SaveCustomerResponse)getWebServiceTemplate().marshalSendAndReceive("http://localhost:9091/ws", request);

        log.info("Saved Customer with Id: " + response.getCustomer().getId());
    }

}
