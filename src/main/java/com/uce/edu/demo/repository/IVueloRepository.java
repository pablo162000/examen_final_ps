package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;

public interface IVueloRepository {
	
	public List<Vuelo> buscarVuelos(String origen, String destino, String fechaVuelo) ;

	public Vuelo buscarVuelo(String numero) ;

}
