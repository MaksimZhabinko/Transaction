package targSoft.service;

import targSoft.dto.TransactionDto;

import java.util.List;


public interface HomePageService {
    /**
     * This method is used for get all transaction from the database.
     * @return list transaction.
     */
    List<TransactionDto> getAllTransaction();

}
