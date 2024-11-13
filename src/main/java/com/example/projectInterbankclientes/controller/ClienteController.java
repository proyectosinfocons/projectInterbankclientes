package com.example.projectInterbankclientes.controller;

import com.example.projectInterbankclientes.model.Cliente;
import com.example.projectInterbankclientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    private final PasswordEncoder passwordEncoder;

    // Endpoint para guardar un cliente
    @PostMapping
    public Cliente saveCliente(@RequestBody Cliente cliente) {

        String codigoUnicoEncriptado =passwordEncoder.encode(cliente.getCodigoUnico());
        cliente.setCodigoUnico(codigoUnicoEncriptado);
        return clienteService.saveCliente(cliente);
    }

    // Endpoint para obtener un cliente por su número de documento
    @GetMapping("/numeroDocumento/{numeroDocumento}")
    public Cliente getClienteByNumeroDocumento(@PathVariable String numeroDocumento) {
        return clienteService.getClienteByNumeroDocumento(numeroDocumento);
    }
}
