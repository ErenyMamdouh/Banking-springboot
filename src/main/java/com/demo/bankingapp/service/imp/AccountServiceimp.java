package com.demo.bankingapp.service.imp;

import com.demo.bankingapp.dto.AccountDto;
import com.demo.bankingapp.mapper.AccountMapper;
import com.demo.bankingapp.model.Account;
import com.demo.bankingapp.repository.AccountRepository;
import com.demo.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceimp implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceimp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountdto) {
        Account account= AccountMapper.mapToAccount(accountdto);

        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
       Account account= accountRepository
               .findById(id)
               .orElseThrow(()-> new RuntimeException(" Account doesn't Exist "));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposite(Long id, double amount) {
        Account account= accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException(" Account doesn't Exist "));
        double total = account.getBalance()+ amount;
        account.setBalance(total);
        Account savedAccount =accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account= accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException(" Account doesn't Exist "));

        if(account.getBalance()<amount){
            throw new RuntimeException("Insufficient ammount");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account saveAccount =accountRepository.save(account);

        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts= accountRepository.findAll();
        return accounts.stream().map((account -> AccountMapper.mapToAccountDto(account)))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account= accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException(" Account doesn't Exist "));


        accountRepository.deleteById(id);
    }
}
