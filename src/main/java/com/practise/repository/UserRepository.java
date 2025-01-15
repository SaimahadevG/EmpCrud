package com.practise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practise.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>
{

}
