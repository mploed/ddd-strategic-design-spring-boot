package com.innoq.mploed.ddd.application.controller;

import com.innoq.mploed.ddd.application.domain.CreditApplicationForm;
import com.innoq.mploed.ddd.application.domain.Customer;
import com.innoq.mploed.ddd.application.domainevents.CreditApplicationApprovedEvent;
import com.innoq.mploed.ddd.application.integration.customer.CustomerClient;
import com.innoq.mploed.ddd.application.repository.CreditApplicationFormRespository;
import com.innoq.mploed.ddd.scoring.shared.ScoringColor;
import com.innoq.mploed.ddd.scoring.shared.ScoringInput;
import com.innoq.mploed.ddd.scoring.shared.ScoringResult;
import com.innoq.mploed.ddd.scoring.shared.ScoringService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    private ScoringService scoringService;

    private RedisTemplate<String, String> redisTemplate;

    private static final Logger log = LoggerFactory.getLogger(CreditApplicationController.class);

    @Autowired
    public CreditApplicationController(CreditApplicationFormRespository creditApplicationFormRespository,
                                       CustomerClient customerClient,
                                       ScoringService scoringService,
                                       RedisTemplate redisTemplate) {
        this.creditApplicationFormRespository = creditApplicationFormRespository;
        this.customerClient = customerClient;
        this.scoringService = scoringService;
        this.redisTemplate = redisTemplate;
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

        Customer customer = customerClient.saveCustomer(processContainer.getCustomer());
        CreditApplicationForm creditApplicationForm = creditApplicationFormRespository.findOne(processContainer.getCreditApplicationForm().getId());

        processContainer.setCustomer(customer);
        processContainer.setCreditApplicationForm(creditApplicationForm);
        creditApplicationForm.setCustomerId(customer.getId());
        model.addAttribute("processContainer", processContainer);

        return "applicationSummary";
    }

    @RequestMapping(method = RequestMethod.POST, path = "performScoring")
    public String performScoring(@ModelAttribute ProcessContainer processContainer, Model model) {

        CreditApplicationForm creditApplicationForm = creditApplicationFormRespository.findOne(processContainer.getCreditApplicationForm().getId());


        ScoringInput scoringInput = new ScoringInput();
        scoringInput.setIncome(creditApplicationForm.getSelfDisclosure().getEarnings().sum());
        scoringInput.setSpendings(creditApplicationForm.getSelfDisclosure().getOutgoings().sum());
        scoringInput.setReason(creditApplicationForm.getPurpose());
        scoringInput.setMonthlyPayment(creditApplicationForm.getMonthlyPayment().longValue());
        scoringInput.setFirstName(processContainer.getCustomer().getFirstName());
        scoringInput.setLastName(processContainer.getCustomer().getLastName());
        scoringInput.setStreet(processContainer.getCustomer().getStreet());
        scoringInput.setPostCode(processContainer.getCustomer().getPostCode());

        log.info("calling ScoringService");
        ScoringResult scoringResult = scoringService.performScoring(scoringInput);


        redisTemplate.convertAndSend("credit-application-approved-events", new CreditApplicationApprovedEvent(creditApplicationForm.getTerm(), creditApplicationForm.getAmount(), creditApplicationForm.getPercentage(), creditApplicationForm.getCustomerId().toString(), creditApplicationForm.getId().toString()));
        model.addAttribute("scoringResult", scoringResult);

        return "scoringResult";
    }
}
