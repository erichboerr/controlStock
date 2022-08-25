package com.controlStock.controlStock.logicaSistema.DTO;

public class ProveedoresDTO {

	private String razonSocial;
	private String email;
	private String telefono;
	private int flagHabilitado;

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getFlagHabilitado() {
		return flagHabilitado;
	}

	public void setFlagHabilitado(int flagHabilitado) {
		this.flagHabilitado = flagHabilitado;
	}

}
