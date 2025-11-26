package com.docencia.rest.repository.interfaces;

import java.util.Optional;

import com.docencia.rest.model.DetalleProducto;

public interface DetalleProductoRepository {
    Optional<DetalleProducto> findByProductoId(int productoId);
    DetalleProducto save(int productoId, DetalleProducto detalle);
    void deleteByProductoId(int productoId);
}
