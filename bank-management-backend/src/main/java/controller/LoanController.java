package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Loan;
import com.example.demo.model.User;

import repository.LoanRepository;
import repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/apply/{userId}")
    public Loan applyLoan(@PathVariable Long userId, @RequestBody Loan loan) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        loan.setUser(user.get());
        loan.setStatus("PENDING");
        return loanRepository.save(loan);
    }
}
