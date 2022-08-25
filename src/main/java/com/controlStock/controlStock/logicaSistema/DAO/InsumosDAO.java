package com.controlStock.controlStock.logicaSistema.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.controlStock.controlStock.connection.*;
import com.controlStock.controlStock.loggers.*;
import com.controlStock.controlStock.logicaSistema.DTO.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import com.controlStock.controlStock.principal.Coordinador;

public class InsumosDAO {

	private String marca;
	private String modelo;
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement st;
	private int id;
	private boolean exito;
	private boolean existe;
	private String sql;
	private String error;
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	// Marca
	public int idMarca(JComboBox<String> cmbMarca) {
		id = 0;
		marca = cmbMarca.getSelectedItem().toString();
		conn = ConnectionDB.getConnection();
		sql = "SELECT id FROM t_marca WHERE marca = '" + marca + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = new Integer(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(InsumosDAO = 55) Error al Buscar el Id de la marca: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return id; // Retorna el id de la marca
	}

	public int idModeloCMB(JComboBox<String> cmbModelo) {
		id = 0;
		modelo = cmbModelo.getSelectedItem().toString();
		conn = ConnectionDB.getConnection();
		sql = "SELECT id FROM t_modelo WHERE modelo = '" + modelo + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = new Integer(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(InsumosDAO = 73) Error al Buscar el Id de la Modelo: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return id; // Retorna el id de la marca
	}

	public int idModeloTXT(JTextField txtModelo) {
		id = 0;
		modelo = txtModelo.getText();
		conn = ConnectionDB.getConnection();
		sql = "SELECT id FROM t_modelo WHERE modelo = '" + modelo + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = new Integer(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(InsumosDAO = 91) Error al Buscar el IdModeloTXT: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return id; // Retorna el id de la marca
	}

	public int nuevaImpresoraId(String nroSerie) {
		id = 0;
		conn = ConnectionDB.getConnection();
		sql = "SELECT id FROM t_impresora WHERE serieImpresora = '" + nroSerie + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = new Integer(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(InsumosDAO = 108) Error al Buscar el IdnuevaImpresora: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return id;
	}

	public int idModeloString(String txtModelo) {
		id = 0;
		conn = ConnectionDB.getConnection();
		sql = "SELECT id FROM t_modelo WHERE modelo = '" + txtModelo + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = new Integer(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(InsumosDAO = 125) Error al Buscar el IdmodeloString: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return id; // Retorna el id del modelo String
	}

	public int idInsumo(JTextField txtInsumos) {
		id = 0;
		String insumos = txtInsumos.getText();
		conn = ConnectionDB.getConnection();
		sql = "SELECT id FROM t_insumo WHERE insumo = '" + insumos + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = new Integer(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(InsumosDAO =149) Error al Buscar el Id del insumo: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return id; // Retorna el id del insumo
	}

	public int idInsumoTXT(String insumos) {
		id = 0;
		conn = ConnectionDB.getConnection();
		sql = "SELECT id FROM t_insumo WHERE insumo = '" + insumos + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = new Integer(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(InsumosDAO = 160) Error al Buscar el Id del insumoTXT: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return id; // Retorna el id del insumo txt
	}
	
	public int idInsumoCMB(JComboBox<String> cmbInsumo) {
		String insumo = (String) cmbInsumo.getSelectedItem();
		id = 0;
		conn = ConnectionDB.getConnection();
		sql = "SELECT id FROM t_insumo WHERE insumo = '" + insumo + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = new Integer(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(InsumosDAO = 160) Error al Buscar el Id del insumoTXT: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return id; // Retorna el id del insumo txt
	}

	public boolean verificarExistenciaEnt_modelo_t_insumo(int idModelo, String insumos) {
		existe = false;

		int idInsumo = idInsumoTXT(insumos);
		conn = ConnectionDB.getConnection();
		sql = "SELECT * FROM sch_controlstock.t_modelo_t_insumo where t_modelo_id = " + idModelo + " and t_insumo_id = "
				+ idInsumo + ";";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				existe = true;
			}
		} catch (SQLException e) {
			error = "(InsumosDAO = 185) Error al verificarExistenciaEnt_modelo_t_insumo: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return existe;
	}

	public boolean existeMarca(JTextField txtMarca) {
		existe = false;
		marca = txtMarca.getText();
		try {
			conn = ConnectionDB.getConnection();
			sql = "select marca from  t_marca where marca = '" + marca + "';";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				existe = true;
			} else {
				existe = false;
			}

		} catch (SQLException e) {
			error = "(InsumosDAO = 201) Error al saber si existe la marca: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return existe;
	}

	public boolean existeModelo(JTextField txtModelo) {
		existe = false;
		modelo = txtModelo.getText();
		try {
			conn = ConnectionDB.getConnection();
			sql = "select modelo from  t_modelo where modelo = '" + modelo + "';";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				existe = true;
			} else {
				existe = false;
			}

		} catch (SQLException e) {
			error = "(InsumosDAO = 222) Error al saber si existe el modelo: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return existe;
	}

	public boolean existeInsumo(JTextField txtInsumos) {
		existe = false;
		modelo = txtInsumos.getText();
		try {
			conn = ConnectionDB.getConnection();
			sql = "select insumo from  t_insumo where insumo = '" + modelo + "';";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				existe = true;
			} else {
				existe = false;
			}

		} catch (SQLException e) {
			error = "(InsumosDAO = 243) Error al saber si existe el insumo: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return existe;
	}

	public boolean existeInsumoTXT(String insumos) {
		existe = false;
		try {
			conn = ConnectionDB.getConnection();
			sql = "select insumo from  t_insumo where insumo = '" + insumos + "';";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				existe = true;
			} else {
				existe = false;
			}
		} catch (SQLException e) {
			error = "(InsumosDAO = 262) Error al saber si existe el insumoTXT: " + e.getMessage();
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
	
	public boolean nuevaMarca(JTextField txtMarca) {
		exito = false;
		marca = txtMarca.getText().toUpperCase();
		try {
			conn = ConnectionDB.getConnection();
			sql = "insert into t_marca(marca, flagHabilitado) values(?,?);";
			pst = conn.prepareStatement(sql);

			pst.setString(1, marca);
			pst.setInt(2, 1);
			pst.executeUpdate();
			exito = true;

		} catch (SQLException e) {
			error = "(InsumosDAO = 282) Error al agregar la nueva marca: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return exito;
	}

	public boolean nuevoModelo(JTextField txtModelo, JComboBox<String> cmbMarca) {
		exito = false;
		modelo = txtModelo.getText().toUpperCase();
		int marcaId = idMarca(cmbMarca);

		try {
			conn = ConnectionDB.getConnection();
			sql = "insert into t_modelo(modelo, flagHabilitado) values(?,?);";
			pst = conn.prepareStatement(sql);

			pst.setString(1, modelo);
			pst.setInt(2, 1);
			pst.executeUpdate();

			int idModelo = idModeloTXT(txtModelo);

			sql = "insert into t_marca_t_modelo(t_marca_id, t_modelo_id) values(?,?);";
			pst = conn.prepareStatement(sql);

			pst.setInt(1, marcaId);
			pst.setInt(2, idModelo);
			pst.executeUpdate();
			exito = true;

		} catch (SQLException e) {
			error = "(InsumosDAO = 313) Error al agregar la nueva modelo " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return exito;
	}

	public boolean nuevoInsumo(JComboBox<String> cmbModelo, JTextField txtInsumos) {

		int idModelo = idModeloCMB(cmbModelo);
		String insumo = txtInsumos.getText().toUpperCase();
		int idInsumo = 0;
		exito = false;
		try {
			conn = ConnectionDB.getConnection();
			sql = "insert into t_insumo(insumo, flagHabilitado) values(?,?);";
			pst = conn.prepareStatement(sql);

			pst.setString(1, insumo);
			pst.setInt(2, 1);
			pst.executeUpdate();

			idInsumo = idInsumo(txtInsumos);
			sql = "insert into t_modelo_t_insumo(t_modelo_id, t_insumo_id) values(?,?);";
			pst = conn.prepareStatement(sql);

			pst.setInt(1, idModelo);
			pst.setInt(2, idInsumo);
			pst.executeUpdate();

			exito = true;
		} catch (SQLException e) {
			error = "(InsumosDAO = 344) Error al agregar la nueva insumo:  " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return exito;
	}

	public boolean nuevoInsumoID(String insumo, int modeloId) {

		exito = false;
		try {
			conn = ConnectionDB.getConnection();
			sql = "insert into t_insumo(insumo, flagHabilitado) values(?,?);";
			pst = conn.prepareStatement(sql);

			pst.setString(1, insumo);
			pst.setInt(2, 1);
			pst.executeUpdate();

			int idInsumo = idInsumoTXT(insumo);
			sql = "insert into t_modelo_t_insumo(t_modelo_id, t_insumo_id) values(?,?);";
			pst = conn.prepareStatement(sql);

			pst.setInt(1, modeloId);
			pst.setInt(2, idInsumo);
			pst.executeUpdate();

			exito = true;
		} catch (SQLException e) {
			error = "(InsumosDAO = 372) Error al agregar la nuevo nuevoInsumoID " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return exito;
	}

	public boolean nuevoInsumoExistente(String insumo, int modeloId) {

		exito = false;
		try {
			int idInsumo = idInsumoTXT(insumo);
			sql = "insert into t_modelo_t_insumo(t_modelo_id, t_insumo_id) values(?,?);";
			pst = conn.prepareStatement(sql);

			pst.setInt(1, modeloId);
			pst.setInt(2, idInsumo);
			pst.executeUpdate();

			exito = true;
		} catch (SQLException e) {
			error = "(InsumosDAO = 392) Error al verificar nuevoInsumoExistente " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return exito;
	}
	


	public boolean agregarNuevaImpresora(InsumosDTO miInsumo) {
		exito = false;

		try {
						
			// Agrego la impresora a la tabla de impresora
			conn = ConnectionDB.getConnection();
			sql = "insert into t_impresora(serieImpresora, fechaIngreso, flagHabilitado, t_proveedor_id, t_marca_id, t_modelo_id) values(?,?,?,?,?,?);";
			pst = conn.prepareStatement(sql);

			pst.setString(1, miInsumo.getNroSerie());
			pst.setString(2, miInsumo.getFechaIngreso());
			pst.setInt(3, 0);
			pst.setInt(4, miInsumo.getIdProveedor());
			pst.setInt(5, miInsumo.getMarca());
			pst.setInt(6, miInsumo.getModelo());

			pst.executeUpdate();
			exito = true;

		} catch (Exception e) {
			error = "(InsumosDAO = 418) Error al agregar la nueva impresora:" + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return exito;
	}

	public boolean ingresoDeInsumos(InsumosDTO miInsumoDTO) {
		exito = false;
		int idProveedor = 0;
		String fechaIngreso = "";
		int idInsumo = 0;
		int cantidad = 0;
		int idInsumo2 = 0;
		int cantidad2 = 0;
		int idInsumo3 = 0;
		int cantidad3 = 0;
		int idInsumo4 = 0;
		int cantidad4 = 0;
		int idInsumo5 = 0;
		int cantidad5 = 0;
		int idInsumo6 = 0;
		int cantidad6 = 0;
		int idInsumo7 = 0;
		int cantidad7 = 0;
		int idInsumo8 = 0;
		int cantidad8 = 0;
		int idInsumo9 = 0;
		int cantidad9 = 0;
		String ordenCompra  ="";
		int i = 0;

		try {
			i = miInsumoDTO.getListaInsumos().get(0).size();
			System.out.println("Cantidad de insumos: " + i);

			if (i > 1) {
				if (i > 2) {
					if (i > 3) {
						if (i > 4) {
							if (i > 5) {
								if (i > 6) {
									if (i > 7) {
										if (i >= 8) {
											// cargo nueve iteraciones de ingreso de producto

											idProveedor = miInsumoDTO.getIdProveedor();
											fechaIngreso = miInsumoDTO.getFechaIngreso();
											ordenCompra = miInsumoDTO.getOrdenCompra();
											idInsumo = miInsumoDTO.getListaInsumos().get(0).get(8);
											cantidad = miInsumoDTO.getListaInsumos().get(1).get(8);
											idInsumo2 = miInsumoDTO.getListaInsumos().get(0).get(7);
											cantidad2 = miInsumoDTO.getListaInsumos().get(1).get(7);
											idInsumo3 = miInsumoDTO.getListaInsumos().get(0).get(6);
											cantidad3 = miInsumoDTO.getListaInsumos().get(1).get(6);
											idInsumo4 = miInsumoDTO.getListaInsumos().get(0).get(5);
											cantidad4 = miInsumoDTO.getListaInsumos().get(1).get(5);
											idInsumo5 = miInsumoDTO.getListaInsumos().get(0).get(4);
											cantidad5 = miInsumoDTO.getListaInsumos().get(1).get(4);
											idInsumo6 = miInsumoDTO.getListaInsumos().get(0).get(3);
											cantidad6 = miInsumoDTO.getListaInsumos().get(1).get(3);
											idInsumo7 = miInsumoDTO.getListaInsumos().get(0).get(2);
											cantidad7 = miInsumoDTO.getListaInsumos().get(1).get(2);
											idInsumo8 = miInsumoDTO.getListaInsumos().get(0).get(1);
											cantidad8 = miInsumoDTO.getListaInsumos().get(1).get(1);
											idInsumo9 = miInsumoDTO.getListaInsumos().get(0).get(0);
											cantidad9 = miInsumoDTO.getListaInsumos().get(1).get(0);

											conn = ConnectionDB.getConnection();
											sql = "insert into t_stockInsumo(ingreso, fechaIngreso, t_proveedor_id, t_insumo_id, anotaciones) values(?,?,?,?,?);";
											pst = conn.prepareStatement(sql);

											pst.setInt(1, cantidad);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad2);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo2);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad3);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo3);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad4);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo4);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad5);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo5);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad6);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo6);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad7);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo7);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad8);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo8);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad9);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo9);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											exito = true;
										} else {
											// cargo ocho iteraciones de ingreso de producto
											idProveedor = miInsumoDTO.getIdProveedor();
											fechaIngreso = miInsumoDTO.getFechaIngreso();
											ordenCompra = miInsumoDTO.getOrdenCompra();
											idInsumo = miInsumoDTO.getListaInsumos().get(0).get(0);
											cantidad = miInsumoDTO.getListaInsumos().get(1).get(0);
											idInsumo2 = miInsumoDTO.getListaInsumos().get(0).get(1);
											cantidad2 = miInsumoDTO.getListaInsumos().get(1).get(1);
											idInsumo3 = miInsumoDTO.getListaInsumos().get(0).get(2);
											cantidad3 = miInsumoDTO.getListaInsumos().get(1).get(2);
											idInsumo4 = miInsumoDTO.getListaInsumos().get(0).get(3);
											cantidad4 = miInsumoDTO.getListaInsumos().get(1).get(3);
											idInsumo5 = miInsumoDTO.getListaInsumos().get(0).get(4);
											cantidad5 = miInsumoDTO.getListaInsumos().get(1).get(4);
											idInsumo6 = miInsumoDTO.getListaInsumos().get(0).get(5);
											cantidad6 = miInsumoDTO.getListaInsumos().get(1).get(5);
											idInsumo7 = miInsumoDTO.getListaInsumos().get(0).get(6);
											cantidad7 = miInsumoDTO.getListaInsumos().get(1).get(6);
											idInsumo8 = miInsumoDTO.getListaInsumos().get(0).get(7);
											cantidad8 = miInsumoDTO.getListaInsumos().get(1).get(7);

											conn = ConnectionDB.getConnection();
											sql = "insert into t_stockInsumo(ingreso, fechaIngreso, t_proveedor_id, t_insumo_id, anotaciones) values(?,?,?,?,?);";
											pst = conn.prepareStatement(sql);

											pst.setInt(1, cantidad);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad2);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo2);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad3);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo3);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad4);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo4);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad5);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo5);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad6);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo6);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad7);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo7);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											pst.setInt(1, cantidad8);
											pst.setString(2, fechaIngreso);
											pst.setInt(3, idProveedor);
											pst.setInt(4, idInsumo8);
											pst.setString(5, ordenCompra);
											pst.executeUpdate();

											exito = true;
										}
									} else {
										// cargo siete iteraciones de ingreso de producto
										idProveedor = miInsumoDTO.getIdProveedor();
										fechaIngreso = miInsumoDTO.getFechaIngreso();
										ordenCompra  =miInsumoDTO.getOrdenCompra();
										idInsumo = miInsumoDTO.getListaInsumos().get(0).get(0);
										cantidad = miInsumoDTO.getListaInsumos().get(1).get(0);
										idInsumo2 = miInsumoDTO.getListaInsumos().get(0).get(1);
										cantidad2 = miInsumoDTO.getListaInsumos().get(1).get(1);
										idInsumo3 = miInsumoDTO.getListaInsumos().get(0).get(2);
										cantidad3 = miInsumoDTO.getListaInsumos().get(1).get(2);
										idInsumo4 = miInsumoDTO.getListaInsumos().get(0).get(3);
										cantidad4 = miInsumoDTO.getListaInsumos().get(1).get(3);
										idInsumo5 = miInsumoDTO.getListaInsumos().get(0).get(4);
										cantidad5 = miInsumoDTO.getListaInsumos().get(1).get(4);
										idInsumo6 = miInsumoDTO.getListaInsumos().get(0).get(5);
										cantidad6 = miInsumoDTO.getListaInsumos().get(1).get(5);
										idInsumo7 = miInsumoDTO.getListaInsumos().get(0).get(6);
										cantidad7 = miInsumoDTO.getListaInsumos().get(1).get(6);

										conn = ConnectionDB.getConnection();
										sql = "insert into t_stockInsumo(ingreso, fechaIngreso, t_proveedor_id, t_insumo_id, anotaciones) values(?,?,?,?,?);";
										pst = conn.prepareStatement(sql);

										pst.setInt(1, cantidad);
										pst.setString(2, fechaIngreso);
										pst.setInt(3, idProveedor);
										pst.setInt(4, idInsumo);
										pst.setString(5, ordenCompra);
										pst.executeUpdate();

										pst.setInt(1, cantidad2);
										pst.setString(2, fechaIngreso);
										pst.setInt(3, idProveedor);
										pst.setInt(4, idInsumo2);
										pst.setString(5, ordenCompra);
										pst.executeUpdate();

										pst.setInt(1, cantidad3);
										pst.setString(2, fechaIngreso);
										pst.setInt(3, idProveedor);
										pst.setInt(4, idInsumo3);
										pst.setString(5, ordenCompra);
										pst.executeUpdate();

										pst.setInt(1, cantidad4);
										pst.setString(2, fechaIngreso);
										pst.setInt(3, idProveedor);
										pst.setInt(4, idInsumo4);
										pst.setString(5, ordenCompra);
										pst.executeUpdate();

										pst.setInt(1, cantidad5);
										pst.setString(2, fechaIngreso);
										pst.setInt(3, idProveedor);
										pst.setInt(4, idInsumo5);
										pst.setString(5, ordenCompra);
										pst.executeUpdate();

										pst.setInt(1, cantidad6);
										pst.setString(2, fechaIngreso);
										pst.setInt(3, idProveedor);
										pst.setInt(4, idInsumo6);
										pst.setString(5, ordenCompra);
										pst.executeUpdate();

										pst.setInt(1, cantidad7);
										pst.setString(2, fechaIngreso);
										pst.setInt(3, idProveedor);
										pst.setInt(4, idInsumo7);
										pst.setString(5, ordenCompra);
										pst.executeUpdate();

										exito = true;
									}
								} else {
									// cargo seis iteraciones de ingreso de producto
									idProveedor = miInsumoDTO.getIdProveedor();
									fechaIngreso = miInsumoDTO.getFechaIngreso();
									ordenCompra = miInsumoDTO.getOrdenCompra();
									idInsumo = miInsumoDTO.getListaInsumos().get(0).get(0);
									cantidad = miInsumoDTO.getListaInsumos().get(1).get(0);
									idInsumo2 = miInsumoDTO.getListaInsumos().get(0).get(1);
									cantidad2 = miInsumoDTO.getListaInsumos().get(1).get(1);
									idInsumo3 = miInsumoDTO.getListaInsumos().get(0).get(2);
									cantidad3 = miInsumoDTO.getListaInsumos().get(1).get(2);
									idInsumo4 = miInsumoDTO.getListaInsumos().get(0).get(3);
									cantidad4 = miInsumoDTO.getListaInsumos().get(1).get(3);
									idInsumo5 = miInsumoDTO.getListaInsumos().get(0).get(4);
									cantidad5 = miInsumoDTO.getListaInsumos().get(1).get(4);
									idInsumo6 = miInsumoDTO.getListaInsumos().get(0).get(5);
									cantidad6 = miInsumoDTO.getListaInsumos().get(1).get(5);

									conn = ConnectionDB.getConnection();
									sql = "insert into t_stockInsumo(ingreso, fechaIngreso, t_proveedor_id, t_insumo_id, anotaciones) values(?,?,?,?,?);";
									pst = conn.prepareStatement(sql);

									pst.setInt(1, cantidad);
									pst.setString(2, fechaIngreso);
									pst.setInt(3, idProveedor);
									pst.setInt(4, idInsumo);
									pst.setString(5, ordenCompra);
									pst.executeUpdate();

									pst.setInt(1, cantidad2);
									pst.setString(2, fechaIngreso);
									pst.setInt(3, idProveedor);
									pst.setInt(4, idInsumo2);
									pst.setString(5, ordenCompra);
									pst.executeUpdate();

									pst.setInt(1, cantidad3);
									pst.setString(2, fechaIngreso);
									pst.setInt(3, idProveedor);
									pst.setInt(4, idInsumo3);
									pst.setString(5, ordenCompra);
									pst.executeUpdate();

									pst.setInt(1, cantidad4);
									pst.setString(2, fechaIngreso);
									pst.setInt(3, idProveedor);
									pst.setInt(4, idInsumo4);
									pst.setString(5, ordenCompra);
									pst.executeUpdate();

									pst.setInt(1, cantidad5);
									pst.setString(2, fechaIngreso);
									pst.setInt(3, idProveedor);
									pst.setInt(4, idInsumo5);
									pst.setString(5, ordenCompra);
									pst.executeUpdate();

									pst.setInt(1, cantidad6);
									pst.setString(2, fechaIngreso);
									pst.setInt(3, idProveedor);
									pst.setInt(4, idInsumo6);
									pst.setString(5, ordenCompra);
									pst.executeUpdate();

									exito = true;
								}
							} else {
								// cargo cinco iteraciones de ingreso de producto
								idProveedor = miInsumoDTO.getIdProveedor();
								fechaIngreso = miInsumoDTO.getFechaIngreso();
								ordenCompra  =miInsumoDTO.getOrdenCompra();
								idInsumo = miInsumoDTO.getListaInsumos().get(0).get(0);
								cantidad = miInsumoDTO.getListaInsumos().get(1).get(0);
								idInsumo2 = miInsumoDTO.getListaInsumos().get(0).get(1);
								cantidad2 = miInsumoDTO.getListaInsumos().get(1).get(1);
								idInsumo3 = miInsumoDTO.getListaInsumos().get(0).get(2);
								cantidad3 = miInsumoDTO.getListaInsumos().get(1).get(2);
								idInsumo4 = miInsumoDTO.getListaInsumos().get(0).get(3);
								cantidad4 = miInsumoDTO.getListaInsumos().get(1).get(3);
								idInsumo5 = miInsumoDTO.getListaInsumos().get(0).get(4);
								cantidad5 = miInsumoDTO.getListaInsumos().get(1).get(4);

								conn = ConnectionDB.getConnection();
								sql = "insert into t_stockInsumo(ingreso, fechaIngreso, t_proveedor_id, t_insumo_id, anotaciones) values(?,?,?,?,?);";
								pst = conn.prepareStatement(sql);

								pst.setInt(1, cantidad);
								pst.setString(2, fechaIngreso);
								pst.setInt(3, idProveedor);
								pst.setInt(4, idInsumo);
								pst.setString(5, ordenCompra);
								pst.executeUpdate();

								pst.setInt(1, cantidad2);
								pst.setString(2, fechaIngreso);
								pst.setInt(3, idProveedor);
								pst.setInt(4, idInsumo2);
								pst.setString(5, ordenCompra);
								pst.executeUpdate();

								pst.setInt(1, cantidad3);
								pst.setString(2, fechaIngreso);
								pst.setInt(3, idProveedor);
								pst.setInt(4, idInsumo3);
								pst.setString(5, ordenCompra);
								pst.executeUpdate();

								pst.setInt(1, cantidad4);
								pst.setString(2, fechaIngreso);
								pst.setInt(3, idProveedor);
								pst.setInt(4, idInsumo4);
								pst.setString(5, ordenCompra);
								pst.executeUpdate();

								pst.setInt(1, cantidad5);
								pst.setString(2, fechaIngreso);
								pst.setInt(3, idProveedor);
								pst.setInt(4, idInsumo5);
								pst.setString(5, ordenCompra);
								pst.executeUpdate();

								exito = true;
							}
						} else {
							// cargo cuatro iteraciones de ingreso de producto
							idProveedor = miInsumoDTO.getIdProveedor();
							fechaIngreso = miInsumoDTO.getFechaIngreso();
							ordenCompra = miInsumoDTO.getOrdenCompra();
							idInsumo = miInsumoDTO.getListaInsumos().get(0).get(0);
							cantidad = miInsumoDTO.getListaInsumos().get(1).get(0);
							idInsumo2 = miInsumoDTO.getListaInsumos().get(0).get(1);
							cantidad2 = miInsumoDTO.getListaInsumos().get(1).get(1);
							idInsumo3 = miInsumoDTO.getListaInsumos().get(0).get(2);
							cantidad3 = miInsumoDTO.getListaInsumos().get(1).get(2);
							idInsumo4 = miInsumoDTO.getListaInsumos().get(0).get(3);
							cantidad4 = miInsumoDTO.getListaInsumos().get(1).get(3);

							conn = ConnectionDB.getConnection();
							sql = "insert into t_stockInsumo(ingreso, fechaIngreso, t_proveedor_id, t_insumo_id, anotaciones) values(?,?,?,?,?);";
							pst = conn.prepareStatement(sql);

							pst.setInt(1, cantidad);
							pst.setString(2, fechaIngreso);
							pst.setInt(3, idProveedor);
							pst.setInt(4, idInsumo);
							pst.setString(5, ordenCompra);
							pst.executeUpdate();

							pst.setInt(1, cantidad2);
							pst.setString(2, fechaIngreso);
							pst.setInt(3, idProveedor);
							pst.setInt(4, idInsumo2);
							pst.setString(5, ordenCompra);
							pst.executeUpdate();

							pst.setInt(1, cantidad3);
							pst.setString(2, fechaIngreso);
							pst.setInt(3, idProveedor);
							pst.setInt(4, idInsumo3);
							pst.setString(5, ordenCompra);
							pst.executeUpdate();

							pst.setInt(1, cantidad4);
							pst.setString(2, fechaIngreso);
							pst.setInt(3, idProveedor);
							pst.setInt(4, idInsumo4);
							pst.setString(5, ordenCompra);
							pst.executeUpdate();

							exito = true;
						}
					} else {
						// cargo tres iteraciones de ingreso de producto
						idProveedor = miInsumoDTO.getIdProveedor();
						fechaIngreso = miInsumoDTO.getFechaIngreso();
						ordenCompra = miInsumoDTO.getOrdenCompra();
						idInsumo = miInsumoDTO.getListaInsumos().get(0).get(0);
						cantidad = miInsumoDTO.getListaInsumos().get(1).get(0);
						idInsumo2 = miInsumoDTO.getListaInsumos().get(0).get(1);
						cantidad2 = miInsumoDTO.getListaInsumos().get(1).get(1);
						idInsumo3 = miInsumoDTO.getListaInsumos().get(0).get(2);
						cantidad3 = miInsumoDTO.getListaInsumos().get(1).get(2);

						conn = ConnectionDB.getConnection();
						sql = "insert into t_stockInsumo(ingreso, fechaIngreso, t_proveedor_id, t_insumo_id, anotaciones) values(?,?,?,?,?);";
						pst = conn.prepareStatement(sql);

						pst.setInt(1, cantidad);
						pst.setString(2, fechaIngreso);
						pst.setInt(3, idProveedor);
						pst.setInt(4, idInsumo);
						pst.setString(5, ordenCompra);
						pst.executeUpdate();

						pst.setInt(1, cantidad2);
						pst.setString(2, fechaIngreso);
						pst.setInt(3, idProveedor);
						pst.setInt(4, idInsumo2);
						pst.setString(5, ordenCompra);
						pst.executeUpdate();

						pst.setInt(1, cantidad3);
						pst.setString(2, fechaIngreso);
						pst.setInt(3, idProveedor);
						pst.setInt(4, idInsumo3);
						pst.setString(5, ordenCompra);
						pst.executeUpdate();

						exito = true;
					}
				} else {
					// cargo dos iteraciones de ingreso de producto
					idProveedor = miInsumoDTO.getIdProveedor();
					fechaIngreso = miInsumoDTO.getFechaIngreso();
					ordenCompra = miInsumoDTO.getOrdenCompra();
					idInsumo = miInsumoDTO.getListaInsumos().get(0).get(0);
					cantidad = miInsumoDTO.getListaInsumos().get(1).get(0);
					idInsumo2 = miInsumoDTO.getListaInsumos().get(0).get(1);
					cantidad2 = miInsumoDTO.getListaInsumos().get(1).get(1);

					conn = ConnectionDB.getConnection();
					sql = "insert into t_stockInsumo(ingreso, fechaIngreso, t_proveedor_id, t_insumo_id, anotaciones) values(?,?,?,?,?);";
					pst = conn.prepareStatement(sql);

					pst.setInt(1, cantidad);
					pst.setString(2, fechaIngreso);
					pst.setInt(3, idProveedor);
					pst.setInt(4, idInsumo);
					pst.setString(5, ordenCompra);
					pst.executeUpdate();

					pst.setInt(1, cantidad2);
					pst.setString(2, fechaIngreso);
					pst.setInt(3, idProveedor);
					pst.setInt(4, idInsumo2);
					pst.setString(5, ordenCompra);
					pst.executeUpdate();

					exito = true;
				}
			} else {
				// cargo solo una iteracion de ingreso de producto
				idProveedor = miInsumoDTO.getIdProveedor();
				fechaIngreso = miInsumoDTO.getFechaIngreso();
				ordenCompra = miInsumoDTO.getOrdenCompra();
				idInsumo = miInsumoDTO.getListaInsumos().get(0).get(0);
				cantidad = miInsumoDTO.getListaInsumos().get(1).get(0);

				conn = ConnectionDB.getConnection();
				sql = "insert into t_stockInsumo(ingreso, fechaIngreso, t_proveedor_id, t_insumo_id, anotaciones) values(?,?,?,?,?);";
				pst = conn.prepareStatement(sql);

				pst.setInt(1, cantidad);
				pst.setString(2, fechaIngreso);
				pst.setInt(3, idProveedor);
				pst.setInt(4, idInsumo);
				pst.setString(5, ordenCompra);				
				pst.executeUpdate();
				exito = true;
			}

		} catch (Exception e) {
			error = "(InsumosDAO = 920) Error al ingresoDeInsumos:" + e.getMessage();
			miCoordinador.cargaErrores(error);
		}

		return exito;
	}
	
	

	public boolean egresoDeInsumos(InsumosDTO miInsumo) {
		exito = false;
		int idServicio = 0;
		String fechaEgreso = "";
		int idInsumo;
		int cantidad = 0;
		int idInsumo2;
		int cantidad2 = 0;
		int idInsumo3;
		int cantidad3 = 0;
		int idInsumo4;
		int cantidad4 = 0;
		int idInsumo5;
		int cantidad5 = 0;
		int idInsumo6;
		int cantidad6 = 0;
		int i = 0;

		try {
			i = miInsumo.getListaInsumos().get(0).size();
			System.out.println("Valor de lista de insumos para egreso: "+ i);

			if (i > 1) {
				if (i > 2) {
					if (i > 3) {
						if (i > 4) {
							if (i > 5) {
								if (i == 6) {// cargo seis iteraciones de ingreso de producto
									idServicio = miInsumo.getIdServicio();
									fechaEgreso = miInsumo.getFechaEgreso();
									idInsumo = miInsumo.getListaInsumos().get(0).get(0);
									cantidad = miInsumo.getListaInsumos().get(1).get(0);
									idInsumo2 = miInsumo.getListaInsumos().get(0).get(1);
									cantidad2 = miInsumo.getListaInsumos().get(1).get(1);
									idInsumo3 = miInsumo.getListaInsumos().get(0).get(2);
									cantidad3 = miInsumo.getListaInsumos().get(1).get(2);
									idInsumo4 = miInsumo.getListaInsumos().get(0).get(3);
									cantidad4 = miInsumo.getListaInsumos().get(1).get(3);
									idInsumo5 = miInsumo.getListaInsumos().get(0).get(4);
									cantidad5 = miInsumo.getListaInsumos().get(1).get(4);
									idInsumo6 = miInsumo.getListaInsumos().get(0).get(5);
									cantidad6 = miInsumo.getListaInsumos().get(1).get(5);

									conn = ConnectionDB.getConnection();
									sql = "insert into t_stockInsumo(egreso, fechaEgreso, t_servicio_id, t_insumo_id) values(?,?,?,?);";
									pst = conn.prepareStatement(sql);

									pst.setInt(1, cantidad);
									pst.setString(2, fechaEgreso);
									pst.setInt(3, idServicio);
									pst.setInt(4, idInsumo);
									pst.executeUpdate();

									pst.setInt(1, cantidad2);
									pst.setString(2, fechaEgreso);
									pst.setInt(3, idServicio);
									pst.setInt(4, idInsumo2);
									pst.executeUpdate();

									pst.setInt(1, cantidad3);
									pst.setString(2, fechaEgreso);
									pst.setInt(3, idServicio);
									pst.setInt(4, idInsumo3);
									pst.executeUpdate();

									pst.setInt(1, cantidad4);
									pst.setString(2, fechaEgreso);
									pst.setInt(3, idServicio);
									pst.setInt(4, idInsumo4);
									pst.executeUpdate();

									pst.setInt(1, cantidad5);
									pst.setString(2, fechaEgreso);
									pst.setInt(3, idServicio);
									pst.setInt(4, idInsumo5);
									pst.executeUpdate();

									pst.setInt(1, cantidad6);
									pst.setString(2, fechaEgreso);
									pst.setInt(3, idServicio);
									pst.setInt(4, idInsumo6);
									pst.executeUpdate();

									exito = true;
								}
							} else {// cargo cinco iteraciones de ingreso de producto

								idServicio = miInsumo.getIdServicio();
								fechaEgreso = miInsumo.getFechaEgreso();
								idInsumo = miInsumo.getListaInsumos().get(0).get(0);
								cantidad = miInsumo.getListaInsumos().get(1).get(0);
								idInsumo2 = miInsumo.getListaInsumos().get(0).get(1);
								cantidad2 = miInsumo.getListaInsumos().get(1).get(1);
								idInsumo3 = miInsumo.getListaInsumos().get(0).get(2);
								cantidad3 = miInsumo.getListaInsumos().get(1).get(2);
								idInsumo4 = miInsumo.getListaInsumos().get(0).get(3);
								cantidad4 = miInsumo.getListaInsumos().get(1).get(3);
								idInsumo5 = miInsumo.getListaInsumos().get(0).get(4);
								cantidad5 = miInsumo.getListaInsumos().get(1).get(4);

								conn = ConnectionDB.getConnection();
								sql = "insert into t_stockInsumo(egreso, fechaEgreso, t_Servicio_id, t_insumo_id) values(?,?,?,?);";
								pst = conn.prepareStatement(sql);

								pst.setInt(1, cantidad);
								pst.setString(2, fechaEgreso);
								pst.setInt(3, idServicio);
								pst.setInt(4, idInsumo);
								pst.executeUpdate();

								pst.setInt(1, cantidad2);
								pst.setString(2, fechaEgreso);
								pst.setInt(3, idServicio);
								pst.setInt(4, idInsumo2);
								pst.executeUpdate();

								pst.setInt(1, cantidad3);
								pst.setString(2, fechaEgreso);
								pst.setInt(3, idServicio);
								pst.setInt(4, idInsumo3);
								pst.executeUpdate();

								pst.setInt(1, cantidad4);
								pst.setString(2, fechaEgreso);
								pst.setInt(3, idServicio);
								pst.setInt(4, idInsumo4);
								pst.executeUpdate();

								pst.setInt(1, cantidad5);
								pst.setString(2, fechaEgreso);
								pst.setInt(3, idServicio);
								pst.setInt(4, idInsumo5);
								pst.executeUpdate();

								exito = true;
							}
						} else {
							// cargo cuatro iteraciones de ingreso de producto
							idServicio = miInsumo.getIdServicio();
							fechaEgreso = miInsumo.getFechaEgreso();
							idInsumo = miInsumo.getListaInsumos().get(0).get(0);
							cantidad = miInsumo.getListaInsumos().get(1).get(0);
							idInsumo2 = miInsumo.getListaInsumos().get(0).get(1);
							cantidad2 = miInsumo.getListaInsumos().get(1).get(1);
							idInsumo3 = miInsumo.getListaInsumos().get(0).get(2);
							cantidad3 = miInsumo.getListaInsumos().get(1).get(2);
							idInsumo4 = miInsumo.getListaInsumos().get(0).get(3);
							cantidad4 = miInsumo.getListaInsumos().get(1).get(3);

							conn = ConnectionDB.getConnection();
							sql = "insert into t_stockInsumo(egreso, fechaEgreso, t_Servicio_id, t_insumo_id) values(?,?,?,?);";
							pst = conn.prepareStatement(sql);

							pst.setInt(1, cantidad);
							pst.setString(2, fechaEgreso);
							pst.setInt(3, idServicio);
							pst.setInt(4, idInsumo);
							pst.executeUpdate();

							pst.setInt(1, cantidad2);
							pst.setString(2, fechaEgreso);
							pst.setInt(3, idServicio);
							pst.setInt(4, idInsumo2);
							pst.executeUpdate();

							pst.setInt(1, cantidad3);
							pst.setString(2, fechaEgreso);
							pst.setInt(3, idServicio);
							pst.setInt(4, idInsumo3);
							pst.executeUpdate();

							pst.setInt(1, cantidad4);
							pst.setString(2, fechaEgreso);
							pst.setInt(3, idServicio);
							pst.setInt(4, idInsumo4);
							pst.executeUpdate();

							exito = true;
						}
					} else {
						// cargo tres iteraciones de ingreso de producto
						idServicio = miInsumo.getIdServicio();
						fechaEgreso = miInsumo.getFechaEgreso();
						idInsumo = miInsumo.getListaInsumos().get(0).get(0);
						cantidad = miInsumo.getListaInsumos().get(1).get(0);
						idInsumo2 = miInsumo.getListaInsumos().get(0).get(1);
						cantidad2 = miInsumo.getListaInsumos().get(1).get(1);
						idInsumo3 = miInsumo.getListaInsumos().get(0).get(2);
						cantidad3 = miInsumo.getListaInsumos().get(1).get(2);

						conn = ConnectionDB.getConnection();
						sql = "insert into t_stockInsumo(egreso, fechaEgreso, t_Servicio_id, t_insumo_id) values(?,?,?,?);";
						pst = conn.prepareStatement(sql);

						pst.setInt(1, cantidad);
						pst.setString(2, fechaEgreso);
						pst.setInt(3, idServicio);
						pst.setInt(4, idInsumo);
						pst.executeUpdate();

						pst.setInt(1, cantidad2);
						pst.setString(2, fechaEgreso);
						pst.setInt(3, idServicio);
						pst.setInt(4, idInsumo2);
						pst.executeUpdate();

						pst.setInt(1, cantidad3);
						pst.setString(2, fechaEgreso);
						pst.setInt(3, idServicio);
						pst.setInt(4, idInsumo3);
						pst.executeUpdate();

						exito = true;
					}
				} else {
					// cargo dos iteraciones de ingreso de producto
					idServicio = miInsumo.getIdServicio();
					fechaEgreso = miInsumo.getFechaEgreso();
					idInsumo = miInsumo.getListaInsumos().get(0).get(0);
					cantidad = miInsumo.getListaInsumos().get(1).get(0);
					idInsumo2 = miInsumo.getListaInsumos().get(0).get(1);
					cantidad2 = miInsumo.getListaInsumos().get(1).get(1);

					conn = ConnectionDB.getConnection();
					sql = "insert into t_stockInsumo(egreso, fechaEgreso, t_Servicio_id, t_insumo_id) values(?,?,?,?);";
					pst = conn.prepareStatement(sql);

					pst.setInt(1, cantidad);
					pst.setString(2, fechaEgreso);
					pst.setInt(3, idServicio);
					pst.setInt(4, idInsumo);
					pst.executeUpdate();

					pst.setInt(1, cantidad2);
					pst.setString(2, fechaEgreso);
					pst.setInt(3, idServicio);
					pst.setInt(4, idInsumo2);
					pst.executeUpdate();

					exito = true;
				}
			} else {
				// cargo uno iteraciones de ingreso de producto
				idServicio = miInsumo.getIdServicio();
				fechaEgreso = miInsumo.getFechaEgreso();
				idInsumo = miInsumo.getListaInsumos().get(0).get(0);
				cantidad = miInsumo.getListaInsumos().get(1).get(0);

				conn = ConnectionDB.getConnection();
				sql = "insert into t_stockInsumo(egreso, fechaEgreso, t_Servicio_id, t_insumo_id) values(?,?,?,?);";
				pst = conn.prepareStatement(sql);

				pst.setInt(1, cantidad);
				pst.setString(2, fechaEgreso);
				pst.setInt(3, idServicio);
				pst.setInt(4, idInsumo);
				pst.executeUpdate();

				exito = true;
			}

		} catch (Exception e) {
			String error = e.getMessage();
			Logs miLogs = new Logs();
			miLogs.cargarArchivo(error);
		}
		return exito;
	}

	public void stock() {
		try {
			conn = ConnectionDB.getConnection();
			JasperReport reporte = (JasperReport) JRLoader
					.loadObject(getClass().getResource("/jrReportes/listadoStock.jasper"));
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conn);
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"C:\\reportes\\ReporteStock-al-(" + getFecha() + ")-" + numeroAleatorio() + ".pdf");
			JasperViewer viewer = new JasperViewer(jasperPrint, false);
			viewer.setVisible(true);

		} catch (JRException e) {
			String error = e.getMessage()+"Linea 1271";
			Logs miLogs = new Logs();
			miLogs.cargarArchivo(error);
		}
	}

	private int numeroAleatorio() {
		int valorEntero = (int) Math.floor(Math.random() * (999 - 1 + 1) + 1);
		return valorEntero;
	}

	private static String getFecha() {
		Date fechaActual = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yy");
		return formateador.format(fechaActual);
	}

	public boolean nuevoInsumoVaros(JTextField txtInsumos) {
		String insumo = txtInsumos.getText().toUpperCase();
		exito = false;
		try {
			conn = ConnectionDB.getConnection();
			sql = "insert into t_insumo(insumo, flagHabilitado) values(?,?);";
			pst = conn.prepareStatement(sql);

			pst.setString(1, insumo);
			pst.setInt(2, 2);
			pst.executeUpdate();
			
			int idInsumo = idInsumoTXT(insumo);
			sql = "insert into t_modelo_t_insumo(t_modelo_id, t_insumo_id) values(?,?);";
			pst = conn.prepareStatement(sql);

			pst.setInt(1, 28);
			pst.setInt(2, idInsumo);
			pst.executeUpdate();
			
			exito = true;
			
		} catch (SQLException e) {
			error = "(InsumosDAO = 1300) Error al agregar la nueva insumo:  " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return exito;
	}

}
