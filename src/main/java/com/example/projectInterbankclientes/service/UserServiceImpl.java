package com.example.projectInterbankclientes.service;


import com.example.projectInterbankclientes.model.User;
import com.example.projectInterbankclientes.repository.IGenericRepo;
import com.example.projectInterbankclientes.repository.IUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, Integer> implements IUserService {

    //@Autowired
    private final IUserRepo repo;// = new UserRepo();


    @Override
    protected IGenericRepo<User, Integer> getRepo() {
        return repo;
    }
}
