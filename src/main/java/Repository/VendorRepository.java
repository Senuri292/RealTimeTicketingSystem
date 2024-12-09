package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import threads.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
}
