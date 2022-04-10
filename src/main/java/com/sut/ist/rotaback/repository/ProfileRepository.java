package com.sut.ist.rotaback.repository;

import com.sut.ist.rotaback.entity.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
    @Query(value = "select * from profile pp where pp.id=?1", nativeQuery = true)
    Profile getByProfileId(String id);
}