package com.sut.ist.rotaback.repository;

import java.util.*;

import com.sut.ist.rotaback.entity.ProfileRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<ProfileRating, Long> {
    @Query(value = "select * from profile_rating where profile_id=?1", nativeQuery = true)
    Optional<ProfileRating> findByProfileId(Long id);

    @Query(value = "select * from profile_rating where rating<=?1 order by rating desc limit ?2", nativeQuery = true)
    List<ProfileRating> findUsersWithLowerRating(Integer rating, Integer count);

    @Query(value = "select COUNT(pr1.rating) from profile_rating pr1", nativeQuery = true)
    Integer getCount();

    @Query(value = "select COUNT(pr1.rating) from profile_rating pr1 where pr1.rating < ?1", nativeQuery = true)
    Integer getCountLower(Integer rating);

    @Query(value = "select COUNT(pr1.rating) from profile_rating pr1 where pr1.rating > ?1", nativeQuery = true)
    Integer getCountHigher(Integer rating);

    @Query(value = "select COUNT(pr1.rating) from profile_rating pr1 where pr1.rating = ?1", nativeQuery = true)
    Integer getCountEquals(Integer rating);
}