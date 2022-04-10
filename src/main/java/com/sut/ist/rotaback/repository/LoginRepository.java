package com.sut.ist.rotaback.repository;

import com.sut.ist.rotaback.entity.ProfileLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<ProfileLogin, Long> {
    @Query(value = "SELECT * FROM profile_login pp WHERE pp.profile_id=?1", nativeQuery = true)
    ProfileLogin getByProfileId(String id);

    @Query(value = "SELECT IF(count(*) > 0, 1, 0) FROM profile_login pp WHERE pp.login=?1", nativeQuery = true)
    Boolean existsByLogin(String login);
}