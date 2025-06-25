package com.eazybytes.customer.query.projection;

import com.eazybytes.common.event.CusMobNumRollbackedEvent;
import com.eazybytes.common.event.CusMobNumUpdatedEvent;
import com.eazybytes.customer.command.event.CustomerCreatedEvent;
import com.eazybytes.customer.command.event.CustomerDeletedEvent;
import com.eazybytes.customer.command.event.CustomerUpdatedEvent;
import com.eazybytes.customer.entity.Customer;
import com.eazybytes.customer.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ProcessingGroup("customer-group")
public class CustomerProjection {

    private final ICustomerService iCustomerService;
    //Method will be executed whenever customerCreatedEvent is consumed by the Projection class
    @EventHandler
    public void on(CustomerCreatedEvent customerCreatedEvent) {
        //To store into H2 DB, we already have JPA entity class named Customer.
        Customer customerEntity = new Customer();
        BeanUtils.copyProperties(customerCreatedEvent,customerEntity);
        //Under ICustomerService instead of accepting CustomerDto, use Customer Object itself.
        //Also do the changes in CustomerServiceImpl as well.
        iCustomerService.createCustomer(customerEntity); //Will store data into Customer table.
    }

    @EventHandler
    public void on(CustomerUpdatedEvent customerUpdatedEvent) {
        //throw new RuntimeException("It is a bad day!!");
        /* Under ICustomerService instead of accepting CustomerDto, use customerUpdatedEvent itself.
           Also do the changes in CustomerServiceImpl as well.
           Do the changes of CustomerServiceImpl in CustomerMapper */
        iCustomerService.updateCustomer(customerUpdatedEvent);
    }

    @EventHandler
    public void on(CustomerDeletedEvent customerDeletedEvent) {
        iCustomerService.deleteCustomer(customerDeletedEvent.getCustomerId());
    }

    @EventHandler
    public void on(CusMobNumUpdatedEvent cusMobNumUpdatedEvent) {
        iCustomerService.updateMobileNumber(cusMobNumUpdatedEvent.getMobileNumber(), cusMobNumUpdatedEvent.getNewMobileNumber());
    }

    @EventHandler
    public void on(CusMobNumRollbackedEvent cusMobNumRollbackedEvent) {
        iCustomerService.updateMobileNumber(cusMobNumRollbackedEvent.getNewMobileNumber(), cusMobNumRollbackedEvent.getMobileNumber());
    }

}
