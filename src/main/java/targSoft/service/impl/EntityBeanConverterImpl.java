package targSoft.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import targSoft.service.EntityBeanConverter;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntityBeanConverterImpl implements EntityBeanConverter {

    private Mapper mapper;

    @Autowired
    public EntityBeanConverterImpl(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public <E, D> D converterToDto(E entity, Class<D> dtoClass) {
        return mapper.map(entity, dtoClass);
    }

    @Override
    public <E, D> E converterToEntity(D dto, Class<E> entityClass) {
        return mapper.map(dto, entityClass);
    }

    @Override
    public <E, D> List<D> converterToDtoList(List<E> entities, Class<D> dtoClass) {
        List<D> dtos = new ArrayList<>();

        for (E entity : entities) {
            D dto = converterToDto(entity, dtoClass);
            dtos.add(dto);
        }
        return dtos;
    }
}
