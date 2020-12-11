package com.desarrollo.web.app.models.dao;

import java.util.List;

import com.desarrollo.web.app.models.entity.Vendedor;

public interface IVendedorDao {

	public List<Vendedor> findAll();
	
	public void save(Vendedor vendedor);
	
}
