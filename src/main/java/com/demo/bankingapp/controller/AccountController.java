package com.demo.bankingapp.controller;


import com.demo.bankingapp.dto.AccountDto;
import com.demo.bankingapp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }



    //http://localhost:8080/api/accounts/add
    @PostMapping("add")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){

        return  new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //http://localhost:8080/api/accounts/get/
    @GetMapping("get/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto= accountService.getAccountById(id);

        return  ResponseEntity.ok(accountDto);
    }

    //http://localhost:8080/api/accounts/deposit/1
    @PutMapping("deposit/{id}")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double> request){

        Double amount=request.get("amount");
        AccountDto accountDto= accountService.deposite(id,amount);

        return  ResponseEntity.ok(accountDto);
    }

    //http://localhost:8080/api/accounts/withdraw/1
    @PutMapping("withdraw/{id}")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request){

        Double amount=request.get("amount");
        AccountDto accountDto= accountService.withdraw(id,amount);

        return  ResponseEntity.ok(accountDto);
    }

    //http://localhost:8080/api/accounts/AllAcounts
    @GetMapping("AllAcounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts= accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }


    //http://localhost:8080/api/accounts/delete/1
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return  ResponseEntity.ok("Account is deleted successfully!");
    }
}
