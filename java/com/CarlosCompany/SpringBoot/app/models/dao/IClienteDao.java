package com.CarlosCompany.SpringBoot.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.CarlosCompany.SpringBoot.app.models.entity.Cliente;

// Heredamos de PagingAndSortingRepository, obtenemos todas las ventajas del CrudRepository
// más las del PagingAndSortingRepository.

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{

	@Query("select c from Cliente c left join fetch c.facturas f where c.id=?1")
	public Cliente fetchByIdWithFacturas(Long id);

}

