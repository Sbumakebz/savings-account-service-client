package com.sibusiso.banking.savings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/savings")
public class SavingsAccountServiceController {
    @Autowired
    AccountService service;

    @RequestMapping(value = "/create/{account}/{amount}", method = RequestMethod.PUT)
    public String create(@PathVariable("account") String account, @PathVariable("amount") Double amount)
            throws ResponseStatusException {
        return service.createAccount(account, amount);
    }

    @RequestMapping(value = "/deposit/{account}/{amount}", method = RequestMethod.PUT)
    public String deposit(@PathVariable("account") String account, @PathVariable("amount") Double amount)
            throws BankingException, ResponseStatusException {
        return service.depositAccount(account, amount);
    }

    @RequestMapping(value = "/draw/{account}/{amount}", method = RequestMethod.PUT)
    public String draw(@PathVariable("account") String account, @PathVariable("amount") Double amount)
            throws BankingException, ResponseStatusException {
        return service.drawAccount(account, amount);
    }

    @RequestMapping(value = "/transfer/{fromAccountNumber}/{amount}/{toAccountNumber}", method = RequestMethod.PUT)
    public String transfer(@PathVariable("fromAccountNumber") String fromAccountNumber, @PathVariable("amount") Double amount,
                           @PathVariable("toAccountNumber") String toAccountNumber)
            throws BankingException, ResponseStatusException {
        return service.transferFromAccount(fromAccountNumber, amount, toAccountNumber);
    }
}
