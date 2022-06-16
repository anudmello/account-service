package com.maveric.bank.contoller;

import com.maveric.bank.Service.AccountServiceImpl;
import com.maveric.bank.model.Account;
import com.maveric.bank.model.AccountDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    ModelMapper modelMapper;
    private final AccountServiceImpl AccountService;

    AccountController(AccountServiceImpl AccountService) {
        this.AccountService = AccountService;
    }

    @PostMapping(value = "/accounts")
    public ResponseEntity<Integer> createAccount(@Valid @RequestBody AccountDto accountdto){
        Account account = convertToEntity(accountdto);
        return new ResponseEntity<>(AccountService.createAccountData(account), HttpStatus.CREATED);
    }

    private Account convertToEntity(AccountDto accountDto) {
        return modelMapper.map(accountDto, Account.class);
    }
}