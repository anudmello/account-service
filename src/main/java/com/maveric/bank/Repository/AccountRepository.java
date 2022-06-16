package com.maveric.bank.Repository;

import com.maveric.bank.model.Account;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer>, JpaSpecificationExecutor<Account> {
    Account save(Account account);
}
