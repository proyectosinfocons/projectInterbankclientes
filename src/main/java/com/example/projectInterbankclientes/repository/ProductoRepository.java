package com.example.projectInterbankclientes.repository;

import com.example.projectInterbankclientes.model.ProductoFinanciero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoFinanciero, Long> {

    List<ProductoFinanciero> findByClienteId(Long clienteId);
}