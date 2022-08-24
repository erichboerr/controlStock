package com.controlStock.controlStock.principal;

import com.controlStock.controlStock.igu.Inicial;
import com.controlStock.controlStock.igu.Proveedores.ModificarProveedor;
import com.controlStock.controlStock.igu.Proveedores.NuevoProveedor;
import com.controlStock.controlStock.igu.servicios.ModificarServicio;
import com.controlStock.controlStock.igu.servicios.NuevoServicio;

public class Aplicacion {

	 
	 
	 public void iniciarAplicacion() {
		 Coordinador miCoordinador = new Coordinador();
		 
		 Inicial miPantallaInicial = new Inicial();
		 miPantallaInicial.setCoodinador(miCoordinador);
		 miCoordinador.setInicial(miPantallaInicial);
		 
		 NuevoServicio miPantallaNuevoServicio = new NuevoServicio();
		 miPantallaNuevoServicio.setCoordinador(miCoordinador);
		 miCoordinador.setmiPantallaNuevoServicio(miPantallaNuevoServicio);
		 
		 ModificarServicio miPantalaModificarServicio = new ModificarServicio();
		 miPantalaModificarServicio.setCoodinador(miCoordinador);
		 miCoordinador.setmiPantallaModificarServicio(miPantalaModificarServicio);
		 
		 NuevoProveedor miPantallaNuevoProveedor = new NuevoProveedor();
		 miPantallaNuevoProveedor.setCoordinador(miCoordinador);
		 miCoordinador.setmiPantallaNuevoProveedor(miPantallaNuevoProveedor);
		 
		 ModificarProveedor miPantallaModificarProveedor = new ModificarProveedor();
		 miPantallaModificarProveedor.setCoordinador(miCoordinador);
		 miCoordinador.setmiPantallaModificarProveedor(miPantallaModificarProveedor);
		 
		/********************************************************************/
		 miCoordinador.iniciarPantallaPricipal();
	 }
     
    	
}
