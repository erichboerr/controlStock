package com.controlStock.controlStock.reports;

import java.util.ArrayList;
import java.util.List;

import com.controlStock.controlStock.logicaSistema.DTO.*;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class SalidaInsumosDatasource implements JRDataSource {
	private List<InsumosDTO> listaInsumos = new ArrayList<InsumosDTO>();
	private int indicelistaInsumo = -1;

	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		
		Object valor = null;
		
		if("servicio".equals(jrField.getName())) 
	    { 
	        valor = listaInsumos.get(indicelistaInsumo).getServicio(); 
	    } 
	    else if("marca".equals(jrField.getName())) 
	    { 
	        valor = listaInsumos.get(indicelistaInsumo).getMarcas(); 
	    } 
	    else if("modelo".equals(jrField.getName())) 
	    { 
	        valor = listaInsumos.get(indicelistaInsumo).getModelos(); 
	    } 
	    else if("insumo".equals(jrField.getName())) 
	    { 
	        valor = listaInsumos.get(indicelistaInsumo).getInsumo(); 
	    }
	    else if("cantidad".equals(jrField.getName())) 
	    { 
	        valor = listaInsumos.get(indicelistaInsumo).getCantidad(); 
	    }
		
		return valor;
	}

	@Override
	public boolean next() throws JRException {
		
		return ++indicelistaInsumo < listaInsumos.size();
	}
	
	public void addinsumos(InsumosDTO insumo)
    {
        this.listaInsumos.add(insumo);
    }

}
