package com.CarlosCompany.SpringBoot.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.CarlosCompany.SpringBoot.app.models.entity.Factura;

// Video 174, 185

public interface IFacturaDao extends CrudRepository<Factura, Long>{
	
	// Video 185
	
	@Query("select f from Factura f join fetch f.cliente c join fetch f.items l join fetch l.producto where f.id=?1")
	public Factura fetchByIdWithClienteWithItemFacturaWithProducto(Long id);

}
