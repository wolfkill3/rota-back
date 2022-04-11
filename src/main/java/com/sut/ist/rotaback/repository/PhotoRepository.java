package com.sut.ist.rotaback.repository;

import com.sut.ist.rotaback.entity.ProfilePhoto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<ProfilePhoto, Long> {
    @Query(value = "select * from profile_photo where profile_id=?1", nativeQuery = true)
    ProfilePhoto getByProfileId(String id);
}