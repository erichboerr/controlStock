package com.controlStock.controlStock.logicaSistema.DAO;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.controlStock.controlStock.principal.Coordinador;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.controlStock.controlStock.connection.ConnectionDB;

public class ClientesDAO {

	private Coordinador miCoordinador;
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement st;
	private boolean exito;
	private boolean existe;
	private String sql;
	private String servicio;
	private int idServicio;
	private int idMarca;
	private int idModelo;
	private int idImpresora;
	private String error;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public static String getFechaActual() {
		Date fechaActual = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
		return formateador.format(fechaActual);
	}

	// Obtener el id del servicio
	public int idServicio(JComboBox<String> cmbServicio) {
		int idServicio = 0;
		String servicio = cmbServicio.getSelectedItem().toString();
		conn = ConnectionDB.getConnection();
		sql = "SELECT id FROM T_servicio WHERE servicio = '" + servicio + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				idServicio = new Integer(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(ClientesDAO 56) Error al Buscar el Id del Cliente/Servicio: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return idServicio; // Retorna el id del servicio
	}

	// Ver que no exista el cliente
	public boolean existeCliente(JTextField txtServicio) {
		existe = false;
		servicio = txtServicio.getText();
		try {
			conn = ConnectionDB.getConnection();
			sql = "select * from  t_servicio where servicio = '" + servicio + "';";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				existe = true;

			} else {
				existe = false;
			}

		} catch (SQLException ex) {
			error = "(ClientesDAO 79) Error al Buscar si existe el Cliente: " + ex.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return existe;
	}
	
	public boolean existeSerie(String txtSerie) {
		existe = false;
		
		try {
			conn = ConnectionDB.getConnection();
			sql = "select serieImpresora from  t_impresora where serieImpresora = '" + txtSerie + "';";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				existe = true;

			} else {
				existe = false;
			}

		} catch (SQLException ex) {
			error = "(ClientesDAO 84) Error al Buscar si existe la serie de una impresora: " + ex.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return existe;
	}
	

	// Alta nuevo cliente
	public boolean nuevoCliente(JTextField txtServicio) {
		exito = false;
		servicio = txtServicio.getText().toUpperCase();
		try {
			conn = ConnectionDB.getConnection();
			sql = "insert into t_servicio(servicio, flagHabilitado) values(?,?);";
			pst = conn.prepareStatement(sql);

			pst.setString(1, servicio);
			pst.setInt(2, 1);
			pst.executeUpdate();
			exito = true;

		} catch (SQLException ex) {
			error = "(ClientesDAO 100) Error al agregar nuevo Cliente: " + ex.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return exito;
	}

	// Actualizo los datos del cliente
	public boolean actualizarCliente(JTextField txtServicio, JComboBox<String> cmbServicio) {

		exito = false;
		int servicioId = idServicio(cmbServicio);

		servicio = txtServicio.getText().toUpperCase();
		sql = "UPDATE t_servicio set servicio = ? Where id = " + servicioId;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, servicio);
			int reg = pst.executeUpdate();
			if (reg == 1) {
				exito = true;
			} else {
				exito = false;
			}

		} catch (SQLException ex) {
			error = "(ClientesDAO 126) Error al actualizar Cliente: " + ex.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return exito;
	}

	public boolean asignarImpresoraAServicio(JComboBox<String> cmbServicio, JComboBox<String> cmbMarca,
			JComboBox<String> cmbModelo, JComboBox<String> cmbSerie) {
		exito = false;

		idServicio = idServicio(cmbServicio);
		idMarca = miCoordinador.idMarca(cmbMarca);
		idModelo = miCoordinador.idModeloCMB(cmbModelo);
		String nroSerie = cmbSerie.getSelectedItem().toString();
		idImpresora = miCoordinador.nuevaImpresoraId(nroSerie);
		String fecha = getFechaActual();
		
		try {
			conn = ConnectionDB.getConnection();
			sql = "insert into t_impresora_t_servicio(t_impresora_id, t_Servicio_id, fechaIngreso, flagHabilitado) values(?,?,?,?);";
			pst = conn.prepareStatement(sql);

			pst.setInt(1, idImpresora);
			pst.setInt(2, idServicio);
			pst.setString(3, fecha);
			pst.setInt(4, 1);

			int i = pst.executeUpdate();
			if (i == 1) {
				sql = "UPDATE t_impresora set flaghabilitado = ? Where id = " + idImpresora + ";";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, 1);
				pst.executeUpdate();
				exito = true;
			}

		} catch (SQLException ex) {
			try {
				sql = "UPDATE t_impresora_t_servicio set fechaEgreso = ?, fechaIngreso = ?  Where t_impresora_id = "
						+ idImpresora + " and t_Servicio_id = " + idServicio + ";";
				pst = conn.prepareStatement(sql);
				pst.setString(1, null);
				pst.setString(2, fecha);
				pst.executeUpdate();

				sql = "UPDATE t_impresora set flaghabilitado = ? Where id = " + idImpresora + ";";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, 1);

				pst.executeUpdate();

				exito = true;
			} catch (SQLException e) {
				error = "(ClientesDAO 178) Error al asignar impresora al servicio: " + e.getMessage();
				miCoordinador.cargaErrores(error);
			}
		}
		return exito;
	}

	public boolean desasignarImpresoraAServicio(JComboBox<String> cmbServicio, JComboBox<String> cmbMarca,
			JComboBox<String> cmbModelo, JComboBox<String> cmbSerie) {

		exito = false;

		idServicio = idServicio(cmbServicio);
		idMarca = miCoordinador.idMarca(cmbMarca);
		idModelo = miCoordinador.idModeloCMB(cmbModelo);
		String nroSerie = cmbSerie.getSelectedItem().toString();
		idImpresora = miCoordinador.nuevaImpresoraId(nroSerie);
		String fecha = getFechaActual();

		try {
			sql = "UPDATE t_impresora set flaghabilitado = ?  Where id = " + idImpresora + ";";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, 0);
			int reg = pst.executeUpdate();

			sql = "UPDATE t_impresora_t_servicio set fechaEgreso = ?  Where t_impresora_id = " + idImpresora
					+ " and t_Servicio_id = " + idServicio + ";";
			pst = conn.prepareStatement(sql);
			pst.setString(1, fecha);
			pst.executeUpdate();

			if (reg == 1) {
				exito = true;
			} else {
				exito = false;
			}

		} catch (Exception e) {
			error = "(ClientesDAO 216) Error al designar impresora al servicio: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return exito;
	}

	public boolean darDeBajaImpresora(JComboBox<String> cmbServicio, JComboBox<String> cmbMarca,
			JComboBox<String> cmbModelo, JComboBox<String> cmbSerie) {
		exito = false;

		idServicio = idServicio(cmbServicio);
		idMarca = miCoordinador.idMarca(cmbMarca);
		idModelo = miCoordinador.idModeloCMB(cmbModelo);
		String nroSerie = cmbSerie.getSelectedItem().toString();
		idImpresora = miCoordinador.nuevaImpresoraId(nroSerie);
		String fecha = getFechaActual();

		try {
			sql = "UPDATE t_impresora set flaghabilitado = ?  Where id = " + idImpresora + ";";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, 2);
			int reg = pst.executeUpdate();

			sql = "UPDATE t_impresora_t_servicio set fechaEgreso = ? Where t_impresora_id = " + idImpresora
					+ " and t_Servicio_id = " + idServicio + ";";
			pst = conn.prepareStatement(sql);
			pst.setString(1, fecha);
			pst.executeUpdate();
			
			sql = "UPDATE t_impresora_t_servicio set flagHabilitado = ? Where t_impresora_id = " + idImpresora
					+ " and t_Servicio_id = " + idServicio + ";";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, 2);
			pst.executeUpdate();

			if (reg == 1) {
				exito = true;
			} else {
				exito = false;
			}
			idModelo=0;
			idMarca=0;

		} catch (Exception e) {
			error = "(ClientesDAO 259) Error al dar de baja la impresora: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		
		return exito;
	}

	public boolean actualizarSerieImpresora(JComboBox<String> cmbSerie, JTextField txtNuevaSerie) {
		exito = false;
		conn = ConnectionDB.getConnection();
		String nroSerie = cmbSerie.getSelectedItem().toString();
		idImpresora = miCoordinador.nuevaImpresoraId(nroSerie);
		
		try {
			sql = "UPDATE t_impresora set serieImpresora = ?  Where id = " + idImpresora + ";";
			pst = conn.prepareStatement(sql);
			pst.setString(1, txtNuevaSerie.getText().toUpperCase());
			int reg = pst.executeUpdate();
			
			if (reg == 1) {
				exito = true;
			} else {
				exito = false;
			}
			
		} catch (Exception e) {
			error = "(ClientesDAO 285) Error al actualizar la serie de la impresora: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		
		return exito;
	}
}
