package com.controlStock.controlStock.loggers;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.controlStock.controlStock.principal.Coordinador;
public class Logs {
	
	private Coordinador miCoordinador;
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.setMiCoordinador(miCoordinador);
		
	}
	
	private String fecha = getFechaActual();
	
	public void cargarArchivo(String error) {
		
		File archivo;
		FileWriter escribirArchivo;
		PrintWriter linea;
		try {
		fecha = getFechaActual();					
		archivo = new File("C:\\controlStock\\logs\\"+fecha+".txt");
		if(!archivo.exists()) {
			archivo.createNewFile();
			escribirArchivo = new FileWriter(archivo, true);
			linea = new PrintWriter(escribirArchivo);
			linea.println(fecha + " {"+error+"}");
			linea.close();
			escribirArchivo.close();
			
		}else {
			escribirArchivo = new FileWriter(archivo, true);
			linea = new PrintWriter(escribirArchivo);
			linea.println(fecha + " {"+error+"}");
			linea.close();
			escribirArchivo.close();
		}
			
		} catch(IOException ex) {
			System.out.println(ex.toString());
		}		
	}
	public static String getFechaActual() {
	    Date fechaActual = new Date();
	    SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yy");
	    return formateador.format(fechaActual);
	}
	public Coordinador getMiCoordinador() {
		return miCoordinador;
	}
	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
	
}
