package targSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import targSoft.entities.TransactionEntity;

import java.sql.Date;
import java.util.List;

@Repository
public interface SecondPageRepository extends JpaRepository<TransactionEntity, String> {
    @Query(value = "SELECT * FROM info WHERE DATE (date) = ?1 AND merchant = ?2", nativeQuery = true)
    List<TransactionEntity> findAllByDateAndTypeAndMerchant (Date date, String merchant);

}
