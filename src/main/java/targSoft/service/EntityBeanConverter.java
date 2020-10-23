package targSoft.service;

import java.util.List;

public interface EntityBeanConverter {
    /**
     * This method is used for convert to Dto.
     * @param entity information about entity.
     * @param dtoClass information about dtoClass.
     * @return dto.
     */
    <E, D> D converterToDto (E entity, Class<D> dtoClass);

    /**
     * This method is used for convert to Entity.
     * @param dto information about dto.
     * @param entityClass information about entityClass.
     * @return entity.
     */
    <E, D> E converterToEntity (D dto, Class<E> entityClass);

    /**
     * This method is used for convert to List Dto.
     * @param entities information about entities.
     * @param dtoClass information about dtoClass.
     * @return list dto.
     */
    <E, D>List<D> converterToDtoList (List<E> entities, Class<D> dtoClass);
}
