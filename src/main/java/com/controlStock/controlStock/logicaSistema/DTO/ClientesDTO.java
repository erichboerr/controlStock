package com.controlStock.controlStock.logicaSistema.DTO;

public class ClientesDTO {

	private String servicio;
	private int idServicio;
	private int idMarca;
	private int idModelo;
	private int idSerie;
	private int flagHabilitado;

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public int getFlagHabilitado() {
		return flagHabilitado;
	}

	public void setFlagHabilitado(int flagHabilitado) {
		this.flagHabilitado = flagHabilitado;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public int getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}

	public int getIdSerie() {
		return idSerie;
	}

	public void setIdSerie(int idSerie) {
		this.idSerie = idSerie;
	}

}
