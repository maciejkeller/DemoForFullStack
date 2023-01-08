package virtualbookshelf.springboot.Managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import virtualbookshelf.springboot.DAO.Accounts.AccountRepo;
import virtualbookshelf.springboot.DAO.Accounts.Entity.Account;
import virtualbookshelf.springboot.DAO.Accounts.Entity.AccountType;

import java.util.List;
import java.util.Optional;

@Service
public class AccountManager {

    private AccountRepo accountRepo;

    @Autowired
    public AccountManager(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Optional<Account>findById(Long id){
        return accountRepo.findById(id);
    }

    public Account addAccount(Account account) {
        return accountRepo.save(account);
    }

    public void deleteById(Long id) {
        accountRepo.deleteById(id);
    }

    public Iterable<Account> findAllAccounts() {
        return accountRepo.findAll();
    }

    public List<Account> findByName(String username) {
        return accountRepo.findByUsername(username);
    }

    public List<Account> findAllByAccountType(AccountType accountType) {
        return accountRepo.findAllByAccountType(accountType);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase(){
      addAccount(new Account(1L, AccountType.ADMIN, "Head_admin", "password"));
      addAccount(new Account(2L, AccountType.USER, "First_user", "password"));
    }

}