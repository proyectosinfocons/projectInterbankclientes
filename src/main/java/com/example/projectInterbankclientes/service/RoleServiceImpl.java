package com.example.projectInterbankclientes.service;

import com.example.projectInterbankclientes.model.Role;
import com.example.projectInterbankclientes.repository.IGenericRepo;
import com.example.projectInterbankclientes.repository.IRoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends CRUDImpl<Role, Integer> implements IRoleService {

    //@Autowired
    private final IRoleRepo repo;// = new RoleRepo();


    @Override
    protected IGenericRepo<Role, Integer> getRepo() {
        return repo;
    }
}
