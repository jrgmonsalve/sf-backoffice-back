package com.softcaribbean.demo.repositories;

import com.softcaribbean.demo.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract Optional<ArrayList<UserModel>> findByName(String name);
}
