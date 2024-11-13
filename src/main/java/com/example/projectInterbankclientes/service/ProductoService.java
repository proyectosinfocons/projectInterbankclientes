package com.example.projectInterbankclientes.service;

import com.example.projectInterbankclientes.dto.ProductoFinancieroDTO;
import com.example.projectInterbankclientes.model.Cliente;
import com.example.projectInterbankclientes.model.ProductoFinanciero;
import com.example.projectInterbankclientes.repository.ClienteRepository;
import com.example.projectInterbankclientes.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para guardar un producto financiero
    public ProductoFinancieroDTO saveProducto(Long clienteId, ProductoFinancieroDTO productoDTO) {
        // Buscar el cliente
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Crear el objeto ProductoFinanciero
        ProductoFinanciero producto = new ProductoFinanciero();
        producto.setTipoProducto(productoDTO.getTipoProducto());
        producto.setNombre(productoDTO.getNombre());
        producto.setSaldo(productoDTO.getSaldo());
        producto.setCliente(cliente);

        // Guardar el producto en la base de datos
        ProductoFinanciero productoGuardado = productoRepository.save(producto);

        // Convertirlo a DTO y devolver
        return new ProductoFinancieroDTO(
                productoGuardado.getTipoProducto(),
                productoGuardado.getNombre(),
                productoGuardado.getSaldo(),
                productoGuardado.getCliente().getId()
        );
    }

    // Método para obtener todos los productos de un cliente
    public List<ProductoFinancieroDTO> obtenerProductosPorCliente(Long clienteId) {
        // Obtener todos los productos financieros del cliente
        List<ProductoFinanciero> productos = productoRepository.findByClienteId(clienteId);

        // Convertir los productos a DTOs
        return productos.stream().map(producto -> new ProductoFinancieroDTO(
                producto.getTipoProducto(),
                producto.getNombre(),
                producto.getSaldo(),
                producto.getCliente().getId()
        )).collect(Collectors.toList());
    }
}
