package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import threads.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
