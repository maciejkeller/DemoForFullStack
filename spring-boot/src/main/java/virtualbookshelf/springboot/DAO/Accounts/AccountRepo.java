package virtualbookshelf.springboot.DAO.Accounts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import virtualbookshelf.springboot.DAO.Accounts.Entity.Account;
import virtualbookshelf.springboot.DAO.Accounts.Entity.AccountType;

import java.util.List;

@Repository
public interface AccountRepo extends CrudRepository<Account, Long> {

    List<Account> findAllByAccountType(AccountType accountType);

    List<Account> findByUsername(String username);
}
