package com.example.projectInterbankclientes.repository;

import com.example.projectInterbankclientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Cliente findByNumeroDocumento(String numeroDocumento);
}
