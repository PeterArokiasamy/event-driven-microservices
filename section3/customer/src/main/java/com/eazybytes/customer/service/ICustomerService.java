package com.eazybytes.customer.service;

import com.eazybytes.customer.command.event.CustomerUpdatedEvent;
import com.eazybytes.customer.dto.CustomerDto;
import com.eazybytes.customer.entity.Customer;

public interface ICustomerService {

    /**
     * @param customer - Customer Object
     */
    //void createCustomer(CustomerDto customerDto);
    void createCustomer(Customer customer);

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    CustomerDto fetchCustomer(String mobileNumber);

    /**
     * @param customerUpdatedEvent - CustomerUpdatedEvent Object
     * @return boolean indicating if the update of Account details is successful or not
     */
    //boolean updateCustomer(CustomerDto customerDto);
    boolean updateCustomer(CustomerUpdatedEvent customerUpdatedEvent);

    /**
     * @param customerId - Input Customer ID
     * @return boolean indicating if the delete of Customer details is successful or not
     */
    boolean deleteCustomer(String customerId);
}
