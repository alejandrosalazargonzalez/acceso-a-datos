package com.docencia.rest.controller;

import com.docencia.rest.domain.Producto;
import com.docencia.rest.exeption.ResourceNotFoundException;
import com.docencia.rest.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/producto")
@Tag(name = "Productos", description = "Operaciones sobre productos")
public class ProductoController {
    ProductoService productoService;

    @Autowired
    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Operation(summary = "Get all products")
    @GetMapping("/")
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @Operation(summary = "Get a product by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable(value = "id") int productoId)
            throws ResourceNotFoundException {
        Producto producto = productoService.findById(productoId).orElse(null);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(producto);
    }

    @Operation(summary = "Delete producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Producto not found")
    })
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProductById(@PathVariable(value = "id") int productoId)
            throws ResourceNotFoundException {
        boolean respuesta = productoService.deleteById(productoId);
        Map<String, Boolean> response = new HashMap<>();
        if (!respuesta) {
            response.put("deleted", Boolean.FALSE);
            return response;
        }
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @Operation(summary = "Insertar producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto added successfully"),
            @ApiResponse(responseCode = "404", description = "Producto not found")
    })
    @PostMapping("/add/")
    public Producto createProducto(@Valid @RequestBody Producto producto) {
        return productoService.save(producto);
    }

}