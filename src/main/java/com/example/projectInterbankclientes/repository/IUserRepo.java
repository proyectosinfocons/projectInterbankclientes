package com.example.projectInterbankclientes.repository;


import com.example.projectInterbankclientes.model.User;

//@Repository
public interface IUserRepo extends IGenericRepo<User, Integer> {

    User findOneByUsername(String username);
}