package AllesOnlineBank.com.repository;

import AllesOnlineBank.com.models.Konto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontoRepository extends JpaRepository<Konto, Long>{
}
