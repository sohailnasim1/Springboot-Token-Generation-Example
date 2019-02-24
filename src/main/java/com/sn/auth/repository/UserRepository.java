package com.sn.auth.repository;

import org.springframework.data.repository.CrudRepository;

import com.sn.auth.domain.User;

public interface UserRepository extends CrudRepository<User, String> {

}
