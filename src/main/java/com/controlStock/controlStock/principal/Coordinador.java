package com.controlStock.controlStock.principal;

import com.controlStock.controlStock.loggers.*;
import com.controlStock.controlStock.igu.servicios.*;
import com.controlStock.controlStock.igu.Inicial;
import com.controlStock.controlStock.igu.proveedores.*;
import com.controlStock.controlStock.igu.insumos.*;

public class Coordinador {

	 	private Inicial miPantallaInicial;
		private NuevoServicio miPpantallaNuevoServicio;
		private ModificarServicio miPantallaModificarServicio;
		private NuevoProveedor miPantallaNuevoProveedor;
		private ModificarProveedor miPantallaModificarProveedor;
		private BajaProveedor miPantallaBajaProveedor;
		private Logs miLogs;
		private NuevoInsumosImpresora miPantallaNuevoInsumoImpresora;     
		private IngresoInsumosImp miPantallaIngresoInsumosImp;

	    /*************************************************************************/
		//Visibilidad de Pantallas
		
		//inicio
		 public void setInicial(Inicial miPantallaInicial) {
		       this.miPantallaInicial = miPantallaInicial; 
		    } 
		 
	    public void iniciarPantallaPricipal() {
	    miPantallaInicial.setVisible(true);
	    }

	    /*************************************************************************/
	    //servicios
	    public void setmiPantallaNuevoServicio(NuevoServicio miPantallaNuevoServicio) {
			this.miPpantallaNuevoServicio = miPantallaNuevoServicio;				
		}
	    public void iniciarPantallaNuevoServicio() {
	    	miPpantallaNuevoServicio.setVisible(true);
	    }
	    
	    public void setmiPantallaModificarServicio(ModificarServicio miPantallaModificarServicio) {
			this.miPantallaModificarServicio = miPantallaModificarServicio;				
		}

		public void iniciarPantallaModificarServicio() {
			miPantallaModificarServicio.setVisible(true);			
		}
		
	    /*************************************************************************/
		//Proveedores
		public void setmiPantallaNuevoProveedor(NuevoProveedor miPantallaNuevoProveedor) {
			this.miPantallaNuevoProveedor = miPantallaNuevoProveedor;			
		}
		
		public void iniciarPantallaNuevoProveedor() {
			miPantallaNuevoProveedor.setVisible(true);			
		}

		public void setmiPantallaModificarProveedor(ModificarProveedor miPantallaModificarProveedor) {
			this.miPantallaModificarProveedor = miPantallaModificarProveedor;			
		}
		
		public void iniciarPantallaModificarProveedor() {
			miPantallaModificarProveedor.setVisible(true);			
		}

		public void setmiPantallaBajaProveedor(BajaProveedor miPantallaBajaProveedor) {
			this.miPantallaBajaProveedor = miPantallaBajaProveedor;			
		}
		
		public void iniciarPantallaBajaProveedor() {
			miPantallaBajaProveedor.setVisible(true);			
		}
		
	    /*************************************************************************/
		//Impresoras
		
	    /*************************************************************************/
		//Insumos Impresoras
		public void setmiPantallaNuevoInsumoImpresora(NuevoInsumosImpresora miPantallaNuevoInsumoImpresora) {
			this.miPantallaNuevoInsumoImpresora = miPantallaNuevoInsumoImpresora;			
		}
		public void iniciarPantallaNuevoInsumoImpresora() {
			miPantallaNuevoInsumoImpresora.setVisible(true);			
		}
		
		public void setmiPantallaIngresoInsumosImp(IngresoInsumosImp miPantallaIngresoInsumosImp) {
			this.miPantallaIngresoInsumosImp = miPantallaIngresoInsumosImp;			
		}
		public void iniciarPantallaIngresoInsumosImp() {
			miPantallaIngresoInsumosImp.setVisible(true);			
		}
		
	    /*************************************************************************/
		//Insumos Varios
		
	    /*************************************************************************/
		//logs		
		public void setmiLogs(Logs miLogs) {
			this.miLogs = miLogs;
		}
		
		public void cargaErrores(String error) {
			miLogs.cargarArchivo(error);
		}

		

		
		
	    /*************************************************************************/
		//DAO
		
	    /*************************************************************************/
		//DTO
		
	    /*************************************************************************/

}