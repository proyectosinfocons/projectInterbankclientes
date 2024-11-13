package com.example.projectInterbankclientes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "ProductoFinanciero")
public class ProductoFinanciero {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoProducto;
    private String nombre;
    private BigDecimal saldo;

    @ManyToOne
    @JsonBackReference  // Evita la serialización recursiva
    private Cliente cliente;
}
