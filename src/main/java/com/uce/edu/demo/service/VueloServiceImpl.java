package com.uce.edu.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVueloRepository;
import com.uce.edu.demo.repository.modelo.Vuelo;

@Service
public class VueloServiceImpl implements IVueloService {

	@Autowired
	private IVueloRepository iVueloRepository;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vuelo> buscarVuelos(String origen, String destino, String fechaVuelo) {
		// TODO Auto-generated method stub
		List<Vuelo> listaVuelos = this.iVueloRepository.buscarVuelos(origen, destino, fechaVuelo);

		List<Vuelo> vuelosDisponibles = listaVuelos.stream().filter(v -> v.getEstado().equals("DIS")).toList();

		return vuelosDisponibles;
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)

	public Vuelo buscarVuelo(String numero) {
		// TODO Auto-generated method stub
		return this.iVueloRepository.buscarVuelo(numero);
	}
	
	
	
	




}
