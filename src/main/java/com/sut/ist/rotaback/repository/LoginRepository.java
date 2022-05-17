package com.sut.ist.rotaback.repository;

import java.util.*;

import com.sut.ist.rotaback.entity.ProfileLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<ProfileLogin, Long> {
    @Query(value = "SELECT * FROM profile_login WHERE profile_id=?1 limit 1", nativeQuery = true)
    ProfileLogin getByProfileId(String id);

    @Query(value = "SELECT IF(count(*) > 0, true, false) FROM profile_login WHERE login=?1", nativeQuery = true)
    Boolean existsByLogin(String login);

    @Query(value = "SELECT * FROM profile_login WHERE login=?1 limit 1", nativeQuery = true)
    Optional<ProfileLogin> findByLogin(final String login);

    @Query(value = "SELECT * FROM profile_login WHERE login=?1 AND password=?2 limit 1", nativeQuery = true)
    Optional<ProfileLogin> getByLoginAndPassword(final String login, final String password);
}