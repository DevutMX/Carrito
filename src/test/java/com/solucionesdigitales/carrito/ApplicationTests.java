package com.solucionesdigitales.carrito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.solucionesdigitales.carrito.Application;
import com.solucionesdigitales.carrito.modelo.entidad.Producto;
import com.solucionesdigitales.carrito.servicio.ProductoServicio;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = Application.class, loader = AnnotationConfigContextLoader.class)
public class ApplicationTests {
	
	private static final Logger LOG = LoggerFactory.getLogger(ApplicationTests.class);
	
	@Autowired
	@Qualifier("productoServicio")
	private ProductoServicio servicio;
	
	@Before
	public void setup() 
	{
       LOG.info("-----------------------------");
       LOG.info("Inicializando componentes ...");
       LOG.info("-----------------------------");
	}
	
//	Long id = (long) 0;
	
//	@Test
//	public void agregarProducto() {
//		String respuestaEsperada = "EXITO";
//		Producto producto = new Producto("Rufles",15.5);
//		LOG.info("PRODUCTO A INSERTAR: " + producto);
//		String respuesta = servicio.insertarProducto(producto);
//		LOG.info("Se  el producto: " + producto);
//		id = producto.getagregoIdProducto();
//		Assert.assertEquals(respuestaEsperada, respuesta);
//	}
	
	@Test
	public void borrarProducto()
	{
		String respuestaEsperada = "EXITO";
		Producto producto = new Producto("Ruffles",15.5);
		servicio.insertarProducto(producto);
		LOG.info("Se agrego el producto: " + producto);
		producto.setNombre("Papitas");
		producto.setIdProducto(1L);
		servicio.actualizarProducto(producto);
		LOG.info("Se actualizo el producto a: " + producto);
		LOG.info("Eliminando el producto con ID: " + producto.getIdProducto().toString());
		String respuesta = servicio.eliminarProducto(producto.getIdProducto());
		LOG.info("Se elimino el producto con ID: " + producto.getIdProducto().toString());
		Assert.assertEquals(respuestaEsperada, respuesta);
		
	}
}

