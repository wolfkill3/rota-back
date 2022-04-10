package com.sut.ist.rotaback.repository;

import com.sut.ist.rotaback.entity.ProfileRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<ProfileRating, Long> {
    @Query(value = "select * from profile_rating pp where pp.profile_id=?1", nativeQuery = true)
    ProfileRating getByProfileId(String id);
}