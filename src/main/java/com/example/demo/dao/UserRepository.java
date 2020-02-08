package com.example.demo.dao;

import com.example.demo.model.*;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}