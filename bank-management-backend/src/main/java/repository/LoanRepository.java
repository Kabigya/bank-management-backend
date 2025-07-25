package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Loan;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUserId(Long userId);
}
