package com.maveric.bank.Service;
import com.maveric.bank.model.Account;
import com.maveric.bank.Repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public int createAccountData(Account account) {
        Account createdAccount = repository.save(account);
        return createdAccount.getId();
    }
}
