package com.CarlosCompany.SpringBoot.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.CarlosCompany.SpringBoot.app.models.entity.Cliente;
import com.CarlosCompany.SpringBoot.app.models.entity.Factura;
import com.CarlosCompany.SpringBoot.app.models.entity.Producto;

//Video 130, 139, 167, 174, 175, 178, 182, 185, 186

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);

	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
	
	public List<Producto> findByNombre(String term);
	
	public void saveFactura(Factura factura);
	
	public Producto findProductoById(Long id);
	
	public Factura findFacturaById(Long id);
	
	public void deleteFactura(Long id);
	
	public Factura fetchFacturaByIdWithClienteWithItemFacturaWithProducto(Long id);
	
	public Cliente fetchByIdWithFacturas(Long id);
	
}

