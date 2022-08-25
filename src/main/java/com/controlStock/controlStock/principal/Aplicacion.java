package com.controlStock.controlStock.principal;

import com.controlStock.controlStock.igu.*;
import com.controlStock.controlStock.igu.servicios.*;
import com.controlStock.controlStock.igu.proveedores.*;
import com.controlStock.controlStock.igu.insumos.*;

public class Aplicacion {

	public void iniciarAplicacion() {
		Coordinador miCoordinador = new Coordinador();

		Inicial miPantallaInicial = new Inicial();
		miPantallaInicial.setCoodinador(miCoordinador);
		miCoordinador.setInicial(miPantallaInicial);

		/********************************************************************/
		// Servicios
		NuevoServicio miPantallaNuevoServicio = new NuevoServicio();
		miPantallaNuevoServicio.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaNuevoServicio(miPantallaNuevoServicio);

		ModificarServicio miPantalaModificarServicio = new ModificarServicio();
		miPantalaModificarServicio.setCoodinador(miCoordinador);
		miCoordinador.setmiPantallaModificarServicio(miPantalaModificarServicio);

		/********************************************************************/
		// Proveedores
		NuevoProveedor miPantallaNuevoProveedor = new NuevoProveedor();
		miPantallaNuevoProveedor.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaNuevoProveedor(miPantallaNuevoProveedor);

		ModificarProveedor miPantallaModificarProveedor = new ModificarProveedor();
		miPantallaModificarProveedor.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaModificarProveedor(miPantallaModificarProveedor);

		BajaProveedor miPantallaBajaProveedor = new BajaProveedor();
		miPantallaBajaProveedor.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaBajaProveedor(miPantallaBajaProveedor);

		/********************************************************************/
		// Impresoras

		/********************************************************************/
		// Insumos impresoras
		NuevoInsumosImpresora miPantallaNuevoInsumosImpresora = new NuevoInsumosImpresora();
		miPantallaNuevoInsumosImpresora.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaNuevoInsumoImpresora(miPantallaNuevoInsumosImpresora);

		IngresoInsumosImp miPantallaIngresoInsumosImp = new IngresoInsumosImp();
		miPantallaIngresoInsumosImp.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaIngresoInsumosImp(miPantallaIngresoInsumosImp);

		/********************************************************************/
		//Insumos Varios
		
		/********************************************************************/
		miCoordinador.iniciarPantallaPricipal();
	}

}
