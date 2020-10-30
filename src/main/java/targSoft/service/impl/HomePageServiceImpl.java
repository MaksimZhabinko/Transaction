package targSoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import targSoft.repository.HomePageRepository;
import targSoft.dto.TransactionDto;
import targSoft.entities.TransactionEntity;
import targSoft.service.EntityBeanConverter;
import targSoft.service.HomePageService;

import java.util.List;

@Service
public class HomePageServiceImpl implements HomePageService {

    private HomePageRepository homePageRepository;

    private EntityBeanConverter entityBeanConverter;

    @Autowired
    public HomePageServiceImpl(HomePageRepository homePageRepository, EntityBeanConverter entityBeanConverter) {
        this.homePageRepository = homePageRepository;
        this.entityBeanConverter = entityBeanConverter;
    }

    @Override
    public List<TransactionDto> getAllTransaction() {
        List<TransactionEntity> transactionEntities = homePageRepository.findAll();
        return entityBeanConverter.converterToDtoList(transactionEntities,
                TransactionDto.class);
    }
}
