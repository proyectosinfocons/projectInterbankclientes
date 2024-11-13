package com.example.projectInterbankclientes.controller;

import com.example.projectInterbankclientes.dto.ProductoFinancieroDTO;
import com.example.projectInterbankclientes.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/producto-financiero")
public class ProductoFinancieroController {


    @Autowired
    private ProductoService productoService;

    // Endpoint para guardar un producto financiero
    @PostMapping("/cliente/{clienteId}")
    public ProductoFinancieroDTO saveProducto(@PathVariable Long clienteId, @RequestBody ProductoFinancieroDTO productoDTO) {
        return productoService.saveProducto(clienteId, productoDTO);
    }

    // Endpoint para obtener los productos de un cliente
    @GetMapping("/cliente/{clienteId}")
    public List<ProductoFinancieroDTO> obtenerProductos(@PathVariable Long clienteId) {
        return productoService.obtenerProductosPorCliente(clienteId);
    }


}
