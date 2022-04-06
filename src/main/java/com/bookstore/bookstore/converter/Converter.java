package com.bookstore.bookstore.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<E, D> {
    E toEntity(D currentDTO);

    D toDTO(E entity);

    default List<E> toEntityList(List<D> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<D> toDtoList(List<E> entityList) {
        return entityList.stream().map(this::toDTO).collect(Collectors.toList());
    }

}
