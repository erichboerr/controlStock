package com.controlStock.controlStock.principal;

import com.controlStock.controlStock.igu.Inicial;


public class Principal {
    
     public void iniciarAplicacion() {
         
        Coordinador miCoordinador = new Coordinador();
        
        Inicial miPantallaInicial = new Inicial();        
	miPantallaInicial.setCoodinador(miCoordinador);
	miCoordinador.setInicial(miPantallaInicial);
        
        
        
        
        
        /****************************************************************/
        miCoordinador.iniciarPantallaPricipal();
        
        
    }
    
}
