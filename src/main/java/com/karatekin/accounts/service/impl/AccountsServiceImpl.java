package com.karatekin.accounts.service.impl;

import com.karatekin.accounts.entity.Accounts;
import com.karatekin.accounts.entity.Customer;
import com.karatekin.accounts.constants.AccountsConstants;
import com.karatekin.accounts.dto.CustomerDto;
import com.karatekin.accounts.mapper.CustomerMapper;
import com.karatekin.accounts.repository.AccountsRepository;
import com.karatekin.accounts.repository.CustomerRepository;
import com.karatekin.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }
}
