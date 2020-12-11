package com.desarrollo.web.app.models.dao;



import org.springframework.data.repository.CrudRepository;

import com.desarrollo.web.app.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{

}
