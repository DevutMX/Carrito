package com.solucionesdigitales.carrito.servicio;

import java.util.List;

import com.solucionesdigitales.carrito.modelo.entidad.Producto;

public interface ProductoServicio {
	
	public String insertarProducto(Producto producto);
	public String actualizarProducto(Producto producto);
	public String eliminarProducto(Long id);
	public Producto recuperarProducto(Long id);
	public List<Producto> listarProductos();
	
}
