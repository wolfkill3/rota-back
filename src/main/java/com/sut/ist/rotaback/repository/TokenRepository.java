package com.sut.ist.rotaback.repository;

import com.sut.ist.rotaback.entity.Token;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends CrudRepository<Token, Long> {
    @Query(value = "select * from token where profile_id=?1", nativeQuery = true)
    Token getByProfileId(String id);
}