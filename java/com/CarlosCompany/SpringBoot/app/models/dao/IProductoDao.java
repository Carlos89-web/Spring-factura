package com.CarlosCompany.SpringBoot.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.CarlosCompany.SpringBoot.app.models.entity.Producto;

// Video 167

public interface IProductoDao extends CrudRepository<Producto, Long>{

	// ..like %?1% -> hacemos referencia al id
	
	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findByNombre(String term);
	
	public List<Producto> findByNombreLikeIgnoreCase(String term);
	
}
