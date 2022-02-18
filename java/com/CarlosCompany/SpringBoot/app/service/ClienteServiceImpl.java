package com.CarlosCompany.SpringBoot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CarlosCompany.SpringBoot.app.models.dao.IClienteDao;
import com.CarlosCompany.SpringBoot.app.models.dao.IFacturaDao;
import com.CarlosCompany.SpringBoot.app.models.dao.IProductoDao;
import com.CarlosCompany.SpringBoot.app.models.entity.Cliente;
import com.CarlosCompany.SpringBoot.app.models.entity.Factura;
import com.CarlosCompany.SpringBoot.app.models.entity.Producto;

// Video 130, 167, 174, 178, 182, 185, 186

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
		
	}
	
	// Video 139

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {
		// TODO Auto-generated method stub
		return productoDao.findByNombreLikeIgnoreCase("%"+term+"%");
	}
	
	// Video 174

	@Override
	@Transactional
	public void saveFactura(Factura factura) {
		// TODO Auto-generated method stub
		facturaDao.save(factura);
	}
	
	// Video 175

	@Override
	@Transactional(readOnly = true)
	public Producto findProductoById(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id).orElse(null);
	}

	// Video 178
	
	@Override
	@Transactional(readOnly = true)
	public Factura findFacturaById(Long id) {
		// TODO Auto-generated method stub
		return facturaDao.findById(id).orElse(null);
	}
	
	// Video 182

	@Override
	@Transactional
	public void deleteFactura(Long id) {
		// TODO Auto-generated method stub
		facturaDao.deleteById(id);
	}
	
	// Video 185

	@Override
	@Transactional(readOnly = true)
	public Factura fetchFacturaByIdWithClienteWithItemFacturaWithProducto(Long id) {
		// TODO Auto-generated method stub
		return facturaDao.fetchByIdWithClienteWithItemFacturaWithProducto(id);
	}
	
	// Video 186

	@Override
	@Transactional(readOnly = true)
	public Cliente fetchByIdWithFacturas(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.fetchByIdWithFacturas(id);
	}
}