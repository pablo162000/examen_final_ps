package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Vuelo;
@Repository
@Transactional
public class VueloRepositoryImpl  implements IVueloRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vuelo> buscarVuelos(String origen, String destino, String fechaVuelo) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo> myQuery = this.entityManager.createQuery(
				"SELECT v FROM Vuelo v JOIN v.avion a WHERE v.origen= :datoOrigen AND v.destino= :datoDestino AND v.fechaVuelo= :datoFecha",			Vuelo.class);
		myQuery.setParameter("datoDestino", destino);
		myQuery.setParameter("datoOrigen", origen);
		myQuery.setParameter("datoFecha", fechaVuelo);
		return myQuery.getResultList();	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)

	public Vuelo buscarVuelo(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo> myQuery = this.entityManager.createQuery("SELECT v FROM Vuelo v WHERE v.numero= :datoNumero AND v.estado= :datoEstado", Vuelo.class);
		myQuery.setParameter("datoNumero", numero);
		myQuery.setParameter("datoEstado", "DIS");
		return myQuery.getSingleResult();	
	}

}
