package com.solucionesdigitales.carrito.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solucionesdigitales.carrito.data.ProductoRepository;
import com.solucionesdigitales.carrito.modelo.entidad.Producto;

@Service("productoServicio")
public class ProductoServicioImpl implements ProductoServicio {
	
	@Autowired
	private ProductoRepository repositorio;

	@Override
	public String insertarProducto(Producto producto)
	{
		if(producto.getIdProducto() != null)
		{
			producto.setIdProducto(null);
		}
		
		repositorio.save(producto);
		return "EXITO";
	}

	@Override
	public String actualizarProducto(Producto producto)
	{
		repositorio.save(producto);
		return "EXITO";
	}

	@Override
	public Producto recuperarProducto(Long id) {
		
		return repositorio.findOne(id);
	}

	@Override
	public List<Producto> listarProductos() {
		return (List<Producto>) repositorio.findAll();
	}

	@Override
	public String eliminarProducto(Long id) {
		repositorio.delete(id);
		return "EXITO";
	}

}
