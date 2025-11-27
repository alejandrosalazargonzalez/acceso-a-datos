package com.docencia.rest.repository.interfaces;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.docencia.rest.model.DetalleProductoDocument;
@Repository
public interface DetalleProductoRepository extends MongoRepository<DetalleProductoDocument,String> {
    //Optional<DetalleProductoDocument> findByProductoId(int productoId);
    //DetalleProductoDocument save(int productoId, DetalleProductoDocument detalle);
    //void deleteByProductoId(int productoId);
}
