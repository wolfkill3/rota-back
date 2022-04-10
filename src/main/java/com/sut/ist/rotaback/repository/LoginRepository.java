package com.sut.ist.rotaback.repository;

import com.sut.ist.rotaback.entity.ProfileLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<ProfileLogin, Long> {
    @Query(value = "select * from profile_login pp where pp.profile_id=?1", nativeQuery = true)
    ProfileLogin getByProfileId(String id);
}