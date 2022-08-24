package com.controlStock.controlStock.principal;

import com.controlStock.controlStock.igu.Inicial;
import com.controlStock.controlStock.igu.Proveedores.ModificarProveedor;
import com.controlStock.controlStock.igu.Proveedores.NuevoProveedor;
import com.controlStock.controlStock.igu.servicios.ModificarServicio;
import com.controlStock.controlStock.igu.servicios.NuevoServicio;


public class Coordinador {   
    
    private Inicial miPantallaInicial;
	private NuevoServicio miPpantallaNuevoServicio;
	private ModificarServicio miPantallaModificarServicio;
	private NuevoProveedor miPantallaNuevoProveedor;
	private ModificarProveedor miPantallaModificarProveedor;
	private ModificarProveedor miPantallaEliminarProveedor;        

    public void setInicial(Inicial miPantallaInicial) {
       this.miPantallaInicial = miPantallaInicial; 
    } 
    
    public void setmiPantallaNuevoServicio(NuevoServicio miPantallaNuevoServicio) {
		this.miPpantallaNuevoServicio = miPantallaNuevoServicio;
			
	}
    
    public void setmiPantallaModificarServicio(ModificarServicio miPantallaModificarServicio) {
		this.miPantallaModificarServicio = miPantallaModificarServicio;
			
	}
    

	public void setmiPantallaNuevoProveedor(NuevoProveedor miPantallaNuevoProveedor) {
		this.miPantallaNuevoProveedor = miPantallaNuevoProveedor;
		
	}
	
	public void setmiPantallaModificarProveedor(ModificarProveedor miPantallaModificarProveedor) {
		this.miPantallaModificarProveedor = miPantallaModificarProveedor;
		
	}
	
	public void setmiPantallaEliminarProveedor(ModificarProveedor miPantallaEliminarProveedor) {
		this.miPantallaEliminarProveedor = miPantallaEliminarProveedor;
		
	}
    
    /*************************************************************************/
    public void iniciarPantallaPricipal() {
    miPantallaInicial.setVisible(true);
    }

    public void iniciarPantallaNuevoServicio() {
    	miPpantallaNuevoServicio.setVisible(true);;
    }

	public void iniciarPantallaModificarServicio() {
		miPantallaModificarServicio.setVisible(true);
		
	}

	public void iniciarPantallaNuevoProveedor() {
		miPantallaNuevoProveedor.setVisible(true);
		
	}

	public void iniciarPantallaModificarProveedor() {
		miPantallaModificarProveedor.setVisible(true);
		
	}

	public void iniciarPantallaEliminarProveedor() {
		miPantallaEliminarProveedor.setVisible(true);
		
	}


	
	
	
}
