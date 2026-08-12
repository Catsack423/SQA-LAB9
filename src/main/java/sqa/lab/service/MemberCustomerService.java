package sqa.lab.service;

import sqa.lab.repository.CustomerRepository;
import sqa.lab.service.exception.InvalidMemberException;

public class MemberCustomerService {
    private CustomerRepository customerRepo;

    public  MemberCustomerService(CustomerRepository CustomerRepository) {
        this.customerRepo = CustomerRepository;
    }


    public boolean isMember(int customerId){
        boolean valid = customerRepo.isCustomerValidByCustomerId(customerId);
        return valid; 
    }

    public void addPointToMember(int customerId) throws InvalidMemberException {
        if (!isMember(customerId)) {
            throw new InvalidMemberException("This Customer not valid");
        }

        customerRepo.AddCustomerPointByCustomerId(customerId);
        return;
    }
}
