package com.controlStock.controlStock.principal;

import com.controlStock.controlStock.igu.Inicial;


public class Coordinador {   
    
    private Inicial miPantallaInicial;        

    public void setInicial(Inicial miPantallaInicial) {
       this.miPantallaInicial = miPantallaInicial; 
    } 

    public void iniciarPantallaPricipal() {
    miPantallaInicial.setVisible(true);
    }
	
	
}
