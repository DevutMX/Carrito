package com.solucionesdigitales.carrito.data;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import com.solucionesdigitales.carrito.modelo.entidad.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Serializable> {

}
