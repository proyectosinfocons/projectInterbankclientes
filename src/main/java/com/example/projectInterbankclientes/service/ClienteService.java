package com.example.projectInterbankclientes.service;

import com.example.projectInterbankclientes.model.Cliente;
import com.example.projectInterbankclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;




    // Método para guardar un cliente
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Método para obtener un cliente por su número de documento
    public Cliente getClienteByNumeroDocumento(String numeroDocumento) {
        return clienteRepository.findByNumeroDocumento(numeroDocumento);
    }
}
