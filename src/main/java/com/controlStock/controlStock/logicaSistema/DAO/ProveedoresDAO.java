package com.controlStock.controlStock.logicaSistema.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.controlStock.controlStock.connection.*;
import com.controlStock.controlStock.logicaSistema.DTO.*;
import com.controlStock.controlStock.principal.*;

public class ProveedoresDAO {

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement st;
	private ProveedoresDTO miProveedorDTO;
	private boolean exito;
	private boolean existe;
	private String sql;
	private String proveedor;
	private String email;
	private String telefono;
	private int idProveedor;
	private Coordinador miCoordinador;
	private String error;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	// Obtener el id del Proveedor
	public int idProveedor(JComboBox<String> cmbProveedor) {
		idProveedor = 0;
		proveedor = cmbProveedor.getSelectedItem().toString();
		conn = ConnectionDB.getConnection();
		sql = "SELECT id FROM t_proveedor WHERE nombre = '" + proveedor + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				idProveedor = new Integer(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(ProveedorDAO 51) Error al Buscar el IdProveedor: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return idProveedor; // Retorna el id del Proveedor
	}

	// Ver que no exista el proveedor
	public boolean existeProveedor(JTextField txtProveedor) {
		existe = false;
		proveedor = txtProveedor.getText();
		try {
			conn = ConnectionDB.getConnection();
			sql = "select * from  t_proveedor where nombre = '" + proveedor + "';";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				existe = true;

			} else {
				existe = false;
			}
		} catch (SQLException e) {
			error = "(ProveedorDAO 73) Error al Buscar si existe el proveedor: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return existe; // Devielve true/false luego de comprobarlo
	}

	// Alta nuevo Proveedor
	public boolean nuevoProveedor(JTextField txtProveedor, JTextField txtTelefono, JTextField txtEmail) {
		exito = false;
		proveedor = txtProveedor.getText().toUpperCase();
		telefono = txtTelefono.getText();
		email = txtEmail.getText();

		try {
			conn = ConnectionDB.getConnection();
			sql = "insert into t_proveedor(nombre, telefono, mail, flagHabilitado) values(?,?,?,?);";
			pst = conn.prepareStatement(sql);

			pst.setString(1, proveedor);
			pst.setString(2, telefono);
			pst.setString(3, email);
			pst.setInt(4, 1);
			pst.executeUpdate();
			exito = true;

		} catch (SQLException e) {
			error = "(ProveedorDAO 99) Error al ingresar nuevo proveedor: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return exito;
	}

	// Actauliza los datos del proveedor
	public boolean actualizarProveedor(JTextField txtTelefono, JTextField txtEmail, JComboBox<String> cmbProveedor) {
		int reg = 0;
		exito = false;
		idProveedor = idProveedor(cmbProveedor);

		telefono = txtTelefono.getText();
		email = txtEmail.getText();

		sql = "UPDATE t_proveedor set telefono = ? Where id = " + idProveedor;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, telefono);
			reg = pst.executeUpdate();
		} catch (SQLException e) {
			error = "(ProveedorDAO 122) EError al actualizar el telefono: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}

		sql = "UPDATE t_proveedor set mail = ? Where id = " + idProveedor;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			reg = pst.executeUpdate();
		} catch (SQLException e) {
			error = "(ProveedorDAO 133) Error al actualizar el email: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}

		if (reg == 1) {
			exito = true;
		} else {
			exito = false;
		}		
		
		return exito;
	}

	public boolean bajaProveedor(JComboBox<String> cmbProveedor, JCheckBox chckbxHabilitado) {
		int reg = 0;
		exito = false;
		idProveedor = idProveedor(cmbProveedor);

		if (chckbxHabilitado.isSelected()) {
			sql = "UPDATE t_proveedor set flagHabilitado = ? Where id = " + idProveedor;
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, 1);
				reg = pst.executeUpdate();
			} catch (SQLException e) {
				error = "(ProveedorDAO 183) Error al actualizar el flagHabilitado 'Habilitado': " + e.getMessage();
				miCoordinador.cargaErrores(error);
			}
		}
		if (reg == 1) {
			exito = true;
		} else {
			exito = false;
		}
		return exito;
	}

	public ProveedoresDTO BuscarProveedor(int idProveedor) {

		conn = ConnectionDB.getConnection();
		sql = "SELECT * FROM t_Proveedor Where id = ?;";

		miProveedorDTO = new ProveedoresDTO();

		try {
			int id = idProveedor;
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
				miProveedorDTO.setRazonSocial(rs.getString(2));
				miProveedorDTO.setTelefono(rs.getString(3));
				miProveedorDTO.setEmail(rs.getString(4));
				miProveedorDTO.setFlagHabilitado(rs.getInt(5));
			}

		} catch (SQLException e) {
			error = "(ProveedorDAO 216) Error al buscar proveedorDAO': " + e.getMessage();
			miCoordinador.cargaErrores(error);
			System.out.println("error en la consulta miProveedorDTO:  " + e.getMessage());
		}
		return miProveedorDTO;
	}
}
