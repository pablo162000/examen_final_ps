package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;

public interface IVueloService {
	
	
	
	
	public List<Vuelo> buscarVuelos(String origen, String destino, String fechaVuelo) ;

	public Vuelo buscarVuelo(String numero) ;

}
