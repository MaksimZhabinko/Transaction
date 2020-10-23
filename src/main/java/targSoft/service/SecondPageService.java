package targSoft.service;

import targSoft.dto.TransactionAvgDto;

public interface SecondPageService {

    /**
     * This method is used for get transaction for specific merchant from the database.
     * @return list transaction and avg.
     */
    TransactionAvgDto getTransactionForSpecificMerchant(String dateString, String merchant);

}
