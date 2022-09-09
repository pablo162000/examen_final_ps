package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.service.IVueloService;





@Controller
@RequestMapping("/vuelos")
public class VueloController {

	@Autowired
	private IVueloService iVueloService;

	@GetMapping("/busqueda")
	public String buscarVuelos(Vuelo vuelo) {
		return "vistaNuevaBusqueda";
	}

	@GetMapping("/vuelosDisponibles")
	public String buscarVuelosDisponibles(Vuelo vuelo, Model modelo) {
		System.out.println(vuelo);
		List<Vuelo> lista = this.iVueloService.buscarVuelos(vuelo.getOrigen(), vuelo.getDestino(),
				vuelo.getFechaVuelo());
		modelo.addAttribute("vuelos", lista);
		return "vistaVuelosDisponibles";
	}




}
