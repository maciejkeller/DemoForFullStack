package virtualbookshelf.springboot.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import virtualbookshelf.springboot.DAO.Accounts.Entity.Account;
import virtualbookshelf.springboot.Managers.AccountManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class AccountApi {

    private AccountManager usersList;

    @Autowired
    public AccountApi(AccountManager accountManager){
        this.usersList = accountManager;
    }

    @GetMapping("/all")
    public Iterable<Account> showAllUsers() {
        return usersList.findAllAccounts();
    }

    @GetMapping
    public Optional<Account> getById(@RequestParam Long index) {
        return usersList.findById(index);
    }

    @PostMapping
    public Account addUser(@RequestBody Account account) {
        return usersList.addAccount(account);
    }

    @PutMapping
    public Account updateAccount(@RequestBody Account account) {
        return usersList.addAccount(account);
    }

    @DeleteMapping
    public void deleteAccount(@RequestParam Long index) {
        usersList.deleteById(index);
    }


}
