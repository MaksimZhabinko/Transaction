package targSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import targSoft.entities.TransactionEntity;

@Repository
public interface HomePageRepository extends JpaRepository<TransactionEntity, String> {

}
