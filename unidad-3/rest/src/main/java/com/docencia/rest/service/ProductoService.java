package com.docencia.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.rest.model.ProductoEntity;
import com.docencia.rest.repository.interfaces.DetalleProductoRepository;
import com.docencia.rest.repository.interfaces.ProductoRepository;
import com.docencia.rest.service.interfaces.ProductoServiceInterface;

@Service
public class ProductoService implements ProductoServiceInterface {

    private ProductoRepository productoRepository;

    private DetalleProductoRepository detalleProductoRepository;

    @Autowired
    public void setProductoRepository(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Autowired
    public void setDetalleProductoRepository(DetalleProductoRepository detalleProductoRepository) {
        this.detalleProductoRepository = detalleProductoRepository;
    }

    @Override
    public Optional<ProductoEntity> find(ProductoEntity producto) {
        return productoRepository.findById(producto.getId());
    }

    @Override
    public Optional<ProductoEntity> findById(int id) {
        ProductoEntity productoFind = new ProductoEntity(id);
        return find(productoFind);
    }

    @Override
    public List<ProductoEntity> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public ProductoEntity save(ProductoEntity producto) {
        if (producto != null) {
            return productoRepository.save(producto);
        }
        return producto;
    }

    @Override
    public boolean delete(ProductoEntity producto) {
        productoRepository.deleteById(producto.getId());
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        ProductoEntity productoDelete = new ProductoEntity(id);
        return delete(productoDelete);
    }

}
