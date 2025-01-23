package com.karatekin.accounts.service;

import com.karatekin.accounts.dto.CustomerDto;

public interface IAccountsService {
    /**
     * *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

}
