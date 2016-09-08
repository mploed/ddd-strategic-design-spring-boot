package com.innoq.mploed.ddd.application.controller;

import com.innoq.mploed.ddd.application.domain.CreditApplicationForm;
import com.innoq.mploed.ddd.application.domain.Customer;
import com.innoq.mploed.ddd.application.integration.customer.CustomerClient;
import com.innoq.mploed.ddd.application.repository.CreditApplicationFormRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(path = "/")
public class CreditApplicationController {
    private CreditApplicationFormRespository creditApplicationFormRespository;

    private CustomerClient customerClient;

    @Autowired
    public CreditApplicationController(CreditApplicationFormRespository creditApplicationFormRespository,
                                       CustomerClient customerClient) {
        this.creditApplicationFormRespository = creditApplicationFormRespository;
        this.customerClient = customerClient;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("processContainer", new ProcessContainer());
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, path = "saveStepOne")
    public String saveStepOne(@ModelAttribute ProcessContainer processContainer, Model model) {
        CreditApplicationForm savedCreditApplication = creditApplicationFormRespository.saveAndFlush(processContainer.getCreditApplicationForm());
        processContainer.setCreditApplicationForm(savedCreditApplication);
        model.addAttribute("processContainer", processContainer);
        return "stepTwo";
    }

    @RequestMapping(method = RequestMethod.POST, path = "saveStepTwo")
    public String saveStepTwo(@ModelAttribute ProcessContainer processContainer, Model model) {

        System.out.println(processContainer.getCustomer());
        System.out.println(processContainer.getCreditApplicationForm());

        customerClient.saveCustomer(processContainer.getCustomer());
        return "index";
    }
}
