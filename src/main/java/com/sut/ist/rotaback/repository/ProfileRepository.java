package com.sut.ist.rotaback.repository;

import java.util.*;

import com.sut.ist.rotaback.entity.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {

}