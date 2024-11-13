package com.example.projectInterbankclientes.dto;

import java.math.BigDecimal;

public class ProductoFinancieroDTO {
    private String tipoProducto;
    private String nombre;
    private BigDecimal saldo;
    private Long clienteId;

    // Constructor, Getters y Setters

    public ProductoFinancieroDTO(String tipoProducto, String nombre, BigDecimal saldo, Long clienteId) {
        this.tipoProducto = tipoProducto;
        this.nombre = nombre;
        this.saldo = saldo;
        this.clienteId = clienteId;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
