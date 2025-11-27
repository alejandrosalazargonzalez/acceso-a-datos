package com.docencia.rest.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.docencia.rest.model.ProductoEntity;

public interface ProductoServiceInterface {

    Optional<ProductoEntity> find(ProductoEntity producto);

    Optional<ProductoEntity> findById(int id);

    List<ProductoEntity> findAll();

    ProductoEntity save(ProductoEntity producto);

    boolean delete(ProductoEntity producto);

    boolean deleteById(int id);
}
