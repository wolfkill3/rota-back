package com.sut.ist.rotaback.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractEntityMapper<T, E> implements EntityMapper<T, E> {
    @Autowired
    protected ModelMapper mapper;

    @Override
    public abstract T toDto(final E e);

    @Override
    public abstract E toEntity(final T t);
}
