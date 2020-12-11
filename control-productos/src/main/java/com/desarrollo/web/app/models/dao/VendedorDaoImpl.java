package com.desarrollo.web.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.desarrollo.web.app.models.entity.Vendedor;

@Repository
public class VendedorDaoImpl implements IVendedorDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Vendedor> findAll() {

		return em.createQuery("from Vendedor").getResultList();
	}

	@Override
	@Transactional
	public void save(Vendedor vendedor) {
	em.persist(vendedor); 
	}

}
