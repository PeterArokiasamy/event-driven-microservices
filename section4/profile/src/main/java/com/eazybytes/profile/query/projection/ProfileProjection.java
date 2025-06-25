package com.eazybytes.profile.query.projection;

import com.eazybytes.common.event.AccountDataChangedEvent;
import com.eazybytes.common.event.CardDataChangedEvent;
import com.eazybytes.common.event.CustomerDataChangedEvent;
import com.eazybytes.common.event.LoanDataChangedEvent;
import com.eazybytes.profile.service.IProfileService;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfileProjection {

    private final IProfileService iProfileService;

    //Method will be executed whenever customerCreatedEvent is consumed by the Projection class
    @EventHandler
    public void on(CustomerDataChangedEvent customerDataChangedEvent) {
        iProfileService.handleCustomerDataChangedEvent(customerDataChangedEvent);
    }

    @EventHandler
    public void on(AccountDataChangedEvent accountDataChangedEvent) {
        iProfileService.handleAccountDataChangedEvent(accountDataChangedEvent);
    }

    @EventHandler
    public void on(LoanDataChangedEvent loanDataChangedEvent) {
        iProfileService.handleLoanDataChangedEvent(loanDataChangedEvent);
    }

    @EventHandler
    public void on(CardDataChangedEvent customerDataChangedEvent) {
        iProfileService.handleCardDataChangedEvent(customerDataChangedEvent);
    }

}
