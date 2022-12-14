package com.controlStock.controlStock.principal;

import com.controlStock.controlStock.igu.*;
import com.controlStock.controlStock.igu.Estadisticas.ConsumidoPeriodo;
import com.controlStock.controlStock.igu.Estadisticas.IngresosPorInsumo;
import com.controlStock.controlStock.igu.Estadisticas.IngresosPorProveedor;
import com.controlStock.controlStock.igu.Estadisticas.SalidaPorInsumos;
import com.controlStock.controlStock.igu.Estadisticas.SalidaPorServicio;
import com.controlStock.controlStock.igu.impresoras.ActualizarSerieImpresora;
import com.controlStock.controlStock.igu.impresoras.BajaImpresora;
import com.controlStock.controlStock.igu.impresoras.EntregarImpresoraNuevaServicio;
import com.controlStock.controlStock.igu.impresoras.EntregarImpresoraUsadaServicio;
import com.controlStock.controlStock.igu.impresoras.MarcaImpresora;
import com.controlStock.controlStock.igu.impresoras.ModeloImpresora;
import com.controlStock.controlStock.igu.impresoras.NuevaImpresora;
import com.controlStock.controlStock.igu.impresoras.QuitarImpresoraServicio;
import com.controlStock.controlStock.igu.insumosImpresoras.*;
import com.controlStock.controlStock.igu.insumosVarios.IngresoInsumosVarios;
import com.controlStock.controlStock.igu.insumosVarios.NuevosInsumosVarios;
import com.controlStock.controlStock.igu.insumosVarios.SalidaInsumosVarios;
import com.controlStock.controlStock.igu.servicios.*;
import com.controlStock.controlStock.loggers.Logs;
import com.controlStock.controlStock.logicaSistema.DAO.ClientesDAO;
import com.controlStock.controlStock.logicaSistema.DAO.InsumosDAO;
import com.controlStock.controlStock.logicaSistema.DAO.ProveedoresDAO;
import com.controlStock.controlStock.igu.proveedores.*;

public class Aplicacion {
	
	public void iniciarAplicacion() {
		Coordinador miCoordinador = new Coordinador();
		
		ClientesDAO miClientesDAO = new ClientesDAO();
		miClientesDAO.setCoordinador(miCoordinador);
		miCoordinador.setmiClientesDAO(miClientesDAO);

		ProveedoresDAO miProveedoresDAO = new ProveedoresDAO();
		miCoordinador.setmiProveedoresDAO(miProveedoresDAO);
		
		InsumosDAO miInsumosDAO = new InsumosDAO();
		miCoordinador.setmiInsumosDAO(miInsumosDAO);

		Inicial miPantallaInicial = new Inicial();
		miPantallaInicial.setCoodinador(miCoordinador);
		miCoordinador.setInicial(miPantallaInicial);
		
		Logs miLogs = new Logs();
		miLogs.setCoordinador(miCoordinador);
		miCoordinador.setmiLogs(miLogs);

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
		
		ActualizarSerieImpresora miPantallaActualizarSerieImpresora = new ActualizarSerieImpresora();
		miPantallaActualizarSerieImpresora.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaActualizarSerieImpresora(miPantallaActualizarSerieImpresora);
		
		BajaImpresora miPantallaBajaImpresora = new BajaImpresora();
		miPantallaBajaImpresora.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaBajaImpresora(miPantallaBajaImpresora);
		
		EntregarImpresoraNuevaServicio miPantallaEntregarImpresoraNuevaServicio = new EntregarImpresoraNuevaServicio();
		miPantallaEntregarImpresoraNuevaServicio.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaEntregarImpresoraNuevaServicio(miPantallaEntregarImpresoraNuevaServicio);
		
		EntregarImpresoraUsadaServicio miPantallaEntregarImpresoraUsadaServicio = new EntregarImpresoraUsadaServicio();
		miPantallaEntregarImpresoraUsadaServicio.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaEntregarImpresoraUsadaServicio(miPantallaEntregarImpresoraUsadaServicio);
		
		MarcaImpresora miPantallaMarcaImpresora = new MarcaImpresora();
		miPantallaMarcaImpresora.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaMarcaInpresora(miPantallaMarcaImpresora);
		
		ModeloImpresora miPantallaModeloImpresora = new ModeloImpresora();
		miPantallaModeloImpresora.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaModeloInpresora(miPantallaModeloImpresora);
				
		NuevaImpresora miPantallaNuevaImpresora = new NuevaImpresora();
		miPantallaNuevaImpresora.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaNuevaImpresora(miPantallaNuevaImpresora);
				
		QuitarImpresoraServicio miPantallaQuitarImpresoraServicio = new QuitarImpresoraServicio();
		miPantallaQuitarImpresoraServicio.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaQuitarImpresoraServicio(miPantallaQuitarImpresoraServicio);
		
		
		/********************************************************************/
		// Insumos impresoras
		
		NuevoInsumos miPantallaNuevoInsumos = new NuevoInsumos();
		miPantallaNuevoInsumos.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaNuevoInsumos(miPantallaNuevoInsumos);
		
		IngresoInsumosImp miPantallaIngresoInsumosImp = new IngresoInsumosImp();
		miPantallaIngresoInsumosImp.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaIngresoInsumosImp(miPantallaIngresoInsumosImp);
		
		SalidaInsumosImp miPantallaSalidaInsumosImp = new SalidaInsumosImp();
		miPantallaSalidaInsumosImp.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaSalidaInsumosImp(miPantallaSalidaInsumosImp);		

		/********************************************************************/
		//Insumos Varios
		
		NuevosInsumosVarios miPantallaNuevosInsumosVarios = new NuevosInsumosVarios();
		miPantallaNuevosInsumosVarios.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaNuevosInsumosVarios(miPantallaNuevosInsumosVarios);
		
		IngresoInsumosVarios miPantallaIngresoInsumosVarios = new IngresoInsumosVarios();
		miPantallaIngresoInsumosVarios.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaIngresoInsumosVarios(miPantallaIngresoInsumosVarios);
		
		SalidaInsumosVarios miPantallaSalidaInsumosVarios = new SalidaInsumosVarios();
		miPantallaSalidaInsumosVarios.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaSalidaInsumosVarios(miPantallaSalidaInsumosVarios);
		
		/********************************************************************/
		//Estadisticas
		IngresosPorInsumo miPantallaIngresosPorInsumo = new IngresosPorInsumo();
		miPantallaIngresosPorInsumo.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaIngresosPorInsumo(miPantallaIngresosPorInsumo);
		
		IngresosPorProveedor miPantallaIngresosPorProveedor = new IngresosPorProveedor();
		miPantallaIngresosPorProveedor.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaIngresosPorProveedor(miPantallaIngresosPorProveedor);
		
		SalidaPorInsumos miPantallaSalidaPorInsumos = new SalidaPorInsumos();
		miPantallaSalidaPorInsumos.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaSalidaPorInsumo(miPantallaSalidaPorInsumos);
		
		SalidaPorServicio miPantallaSalidaPorServicio = new SalidaPorServicio();
		miPantallaSalidaPorServicio.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaSalidasPorServicio(miPantallaSalidaPorServicio);
		
		ConsumidoPeriodo miPantallaConsumidoPeriodo = new ConsumidoPeriodo();
		miPantallaConsumidoPeriodo.setCoordinador(miCoordinador);
		miCoordinador.setmiPantallaConsumidoPeriodo(miPantallaConsumidoPeriodo);
		
		/********************************************************************/

		
		
		miCoordinador.iniciarPantallaPricipal();
	}

}
