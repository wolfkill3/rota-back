package com.sut.ist.rotaback.mapper;

public interface IEntityMapper<T, E> {
    T toDto(E e);

    E toEntity(T t);
}
