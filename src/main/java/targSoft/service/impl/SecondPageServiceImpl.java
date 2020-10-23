package targSoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import targSoft.dto.TransactionAvgDto;
import targSoft.dto.TransactionDto;
import targSoft.entities.TransactionEntity;
import targSoft.repository.SecondPageRepository;
import targSoft.service.EntityBeanConverter;
import targSoft.service.SecondPageService;

import java.sql.Date;
import java.util.List;

@Service
public class SecondPageServiceImpl implements SecondPageService {

    private SecondPageRepository secondPageRepository;
    private EntityBeanConverter entityBeanConverter;

    @Autowired
    public SecondPageServiceImpl(SecondPageRepository secondPageRepository, EntityBeanConverter entityBeanConverter) {
        this.secondPageRepository = secondPageRepository;
        this.entityBeanConverter = entityBeanConverter;
    }

    @Override
    public TransactionAvgDto getTransactionForSpecificMerchant(String dateString, String merchant) {
        TransactionAvgDto transactionAvgDto = new TransactionAvgDto();
        Date date =Date.valueOf(dateString);
        List<TransactionEntity> transactionEntities = secondPageRepository.
                findAllByDateAndTypeAndMerchant(date, merchant);

        if (transactionEntities.size() == 0) {
            return transactionAvgDto;
        }

        List<TransactionDto> transactionDtos = entityBeanConverter.converterToDtoList(transactionEntities,
                TransactionDto.class);
        Double sum = 0.0;
        int count = 0;
        for (TransactionDto transactionDto : transactionDtos) {
            if (transactionDto.getType().equals("PAYMENT")) {
                sum += transactionDto.getAmount();
                count++;
            }
        }
        Double avg = sum/count;

        transactionAvgDto.setTransactionDtos(transactionDtos);
        transactionAvgDto.setAvg(avg);

        return transactionAvgDto;
    }

}
