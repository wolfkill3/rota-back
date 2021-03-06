package com.sut.ist.rotaback.mapper;

public interface EntityMapper<T, E> {
    T toDto(E e);

    E toEntity(T t);
}
