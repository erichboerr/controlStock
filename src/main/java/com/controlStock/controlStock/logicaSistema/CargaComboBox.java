package com.controlStock.controlStock.logicaSistema;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import com.controlStock.controlStock.connection.ConnectionDB;
import com.controlStock.controlStock.loggers.Logs;
import com.controlStock.controlStock.principal.Coordinador;

public class CargaComboBox {
	private String sql;
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private String modelo;
	private int id;
	private String marca;
	private String error;
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public int idMarca(JComboBox<String> cmbMarca) {
		id = 0;
		marca = cmbMarca.getSelectedItem().toString();
		conn = ConnectionDB.getConnection();
		sql = "SELECT id FROM t_marca WHERE marca = '" + marca + "' and flagHabilitado = 1";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = new Integer(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(CargaComboBox = 31)Error al Buscar el Id de la marca: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return id; // Retorna el id de la marca
	}

	public int idInsumo(JComboBox<String> cmbInsumo) {
		id = 0;
		String insumo = cmbInsumo.getSelectedItem().toString();
		conn = ConnectionDB.getConnection();
		sql = "SELECT id FROM t_insumo WHERE insumo = '" + insumo + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = new Integer(rs.getString(1));

				System.out.println("el id de la marca es: " + id);
			}
		} catch (SQLException e) {
			error = "(CargaComboBox = 58)Error al Buscar el Id de insumo: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return id; // Retorna el id de la marca
	}

	public int idModeloCMB(JComboBox<String> cmbModelo) {
		id = 0;
		modelo = cmbModelo.getSelectedItem().toString();
		conn = ConnectionDB.getConnection();
		sql = "SELECT id FROM t_modelo WHERE modelo = '" + modelo + "' and flagHabilitado = 1";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = new Integer(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(CargaComboBox = 76)Error al Buscar el Id del modeloCMB: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return id; // Retorna el id de la marca
	}

	public int idServicio(JComboBox<String> cmbServicio) {
		id = 0;
		modelo = cmbServicio.getSelectedItem().toString();
		conn = ConnectionDB.getConnection();
		sql = "SELECT id FROM t_servicio WHERE servicio = '" + modelo + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = new Integer(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(CargaComboBox = 94)Error al Buscar el Id del servicio: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
		return id; // Retorna el id de la marca
	}

	public void cargarCmbServicio(JComboBox<String> cmbServicio) {

		sql = "SELECT servicio FROM t_servicio ORDER BY servicio ASC;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbServicio.removeAllItems();
			while (rs.next()) {
				cmbServicio.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(CargaComboBox = 112) Error al cargar el ComboBox servicio: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarCmbMarca(JComboBox<String> cmbMarca) {
		
		sql = "SELECT marca FROM t_marca where flagHabilitado = 1 ORDER BY marca ASC;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbMarca.removeAllItems();

			while (rs.next()) {
				cmbMarca.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 131) Error al cargar el ComboBox marca: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarCmbMarcaSegunServicio(JComboBox<String> cmbMarca, JComboBox<String> cmbServicio) {
		int servicio = 0;
		servicio = idServicio(cmbServicio);
		
		sql = "SELECT distinct mar.marca " + "FROM t_marca mar, t_impresora imp,t_impresora_t_servicio serImp "
				+ "where mar.id = imp.t_marca_id and imp.id = serImp.t_impresora_id and serImp.t_servicio_id ="
				+ servicio + " and serImp.flagHabilitado = 1 order by marca asc;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbMarca.removeAllItems();
			while (rs.next()) {
				cmbMarca.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 153) Error al cargar el ComboBox cargarCmbMarcaSegunServicio: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarCmbModelo(JComboBox<String> cmbModelo) {

		sql = "SELECT marca FROM t_marca where flagHabilitado = 1 order by marca ASC;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbModelo.removeAllItems();
			while (rs.next()) {
				cmbModelo.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(CargaComboBox = 153) Error al cargar el ComboBox modelo: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarCmbModelo(JComboBox<String> cmbModelo, JComboBox<String> cmbMarca) {

		int idMarca = idMarca(cmbMarca);
		sql = "SELECT mo.modelo " + "FROM t_modelo mo , t_marca_t_modelo tm_tm "
				+ "WHERE tm_tm.t_modelo_id = mo.id and tm_tm.t_marca_id  =" + idMarca + " and mo.flagHabilitado = 1 order by mo.modelo ASC";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbModelo.removeAllItems();

			while (rs.next()) {
				cmbModelo.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 191) Error al cargar el ComboBox modelo: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarCmbModeloSegunServicio(JComboBox<String> cmbModelo, JComboBox<String> cmbServicio,
			JComboBox<String> cmbMarca) {

		int servicio = 0;
		servicio = idServicio(cmbServicio);
		int idMarca = idMarca(cmbMarca);

		sql = "SELECT distinct mo.modelo " + "FROM t_modelo mo, t_impresora imp, t_impresora_t_servicio serImp "
				+ "WHERE mo.id = imp.t_modelo_id " + "AND imp.id = serImp.t_impresora_Id "
				+ "AND serImp.t_Servicio_id = " + servicio + " AND imp.t_marca_id = " + idMarca
				+ " and serImp.flagHabilitado = 1  order by modelo ASC";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbModelo.removeAllItems();
			while (rs.next()) {
				cmbModelo.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 217) Error al cargar el ComboBox cargarCmbModeloSegunServicio: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarCmbSerie(JComboBox<String> cmbSerie) {

		sql = "SELECT distinct numeroSerie FROM t_impresora ORDER BY numeroSerie ASC;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbSerie.removeAllItems();
			while (rs.next()) {
				cmbSerie.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			error = "(CargaComboBox = 234) Error al cargar el ComboBox cargarCmbSerie: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarCmbProveedor(JComboBox<String> cmbProveedor) {

		sql = "SELECT nombre FROM t_proveedor ORDER BY nombre ASC;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbProveedor.removeAllItems();
			while (rs.next()) {
				cmbProveedor.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 252) Error al cargar el ComboBox cargarCmbProveedor: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarInsumo(JComboBox<String> cmbInsumos, JComboBox<String> cmbModelo) {
		int idModelo = idModeloCMB(cmbModelo);
		sql = "select distinct ins.insumo " + "from t_insumo ins, t_modelo_t_insumo tM_tI "
				+ "where tM_TI.t_insumo_id = ins.id AND tM_tI.t_modelo_id =" + idModelo + " order by ins.insumo ASC ";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbInsumos.removeAllItems();
			while (rs.next()) {
				cmbInsumos.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 271) Error al cargar el ComboBox cargarInsumo: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarInsum(JComboBox<String> cmbInsumos) {
		sql = "select insumo from t_insumo order by insumo ASC;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbInsumos.removeAllItems();
			while (rs.next()) {
				cmbInsumos.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 288) Error al cargar el ComboBox cargarInsum: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}
	
	public void cargarInsumosVarios(JComboBox<String> cmbInsumos) {
		sql = "select insumo from t_insumo where flaghabilitado = 2 order by insumo ASC;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbInsumos.removeAllItems();
			while (rs.next()) {
				cmbInsumos.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 288) Error al cargar el ComboBox cargarInsum: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarCmbMarcaParaAsignar(JComboBox<String> cmbMarca) {

		sql = "SELECT distinct mar.marca FROM t_marca mar, t_impresora imp WHERE imp.t_marca_id = mar.id and imp.flagHabilitado = 0 order by marca ASC;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbMarca.removeAllItems();
			while (rs.next()) {
				cmbMarca.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 306) Error al cargar el ComboBox cargarCmbMarcaParaAsignar: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarCmbModeloParaAsignar(JComboBox<String> cmbMarca, JComboBox<String> cmbModelo) {

		int idMarca = idMarca(cmbMarca);
		sql = "SELECT distinct mo.modelo FROM t_modelo mo, t_impresora imp WHERE imp.t_modelo_id = mo.id and imp.t_marca_id = "
				+ idMarca + " and imp.flagHabilitado = 0 order by modelo ASC;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbModelo.removeAllItems();
			while (rs.next()) {
				cmbModelo.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 326) Error al cargar el ComboBox cargarCmbModeloParaAsignar: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarCmbSerieParaAsignar(JComboBox<String> cmbSerie) {

		sql = "SELECT serieImpresora from t_impresora WHERE flagHabilitado = 0 order by serieImpresora ASC;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbSerie.removeAllItems();
			while (rs.next()) {
				cmbSerie.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 344) Error al cargar el ComboBox cargarCmbSerieParaAsignar: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarCmbSerieParaAsignar(JComboBox<String> cmbModelo, JComboBox<String> cmbSerie) {
		int idModelo = idModeloCMB(cmbModelo);
		sql = "SELECT serieImpresora from t_impresora WHERE flagHabilitado = 0 and t_modelo_id = " + idModelo
				+ " order by serieImpresora ASC;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbSerie.removeAllItems();
			while (rs.next()) {
				cmbSerie.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 363) Error al cargar el ComboBox cargarCmbSerieParaAsignar: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarCmbMarcaParaDesasignar(JComboBox<String> cmbMarca, JComboBox<String> cmbServicio) {
		int servicio = idServicio(cmbServicio);

		sql = "SELECT distinct mar.marca " + "FROM t_marca mar, t_impresora imp, t_impresora_t_servicio serImp "
				+ "WHERE mar.id = imp.t_marca_id " + "AND imp.id = serImp.t_impresora_Id " + "and serImp.t_servicio_id="
				+ servicio + " and serImp.flagHabilitado = 1 order by marca ASC;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbMarca.removeAllItems();
			while (rs.next()) {
				cmbMarca.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 384) Error al cargar el ComboBox cargarCmbMarcaParaDesasignar: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarCmbModeloParaDesasignar(JComboBox<String> cmbMarca, JComboBox<String> cmbModelo,
			JComboBox<String> cmbServicio) {
		int idMarca = idMarca(cmbMarca);
		int idServicio = idServicio(cmbServicio);
		sql = "SELECT distinct mo.modelo " + "FROM t_modelo mo, t_impresora imp, t_impresora_t_servicio serImp"
				+ " WHERE mo.id = imp.t_modelo_id " + "AND imp.id = serImp.t_impresora_Id "
				+ "and serImp.t_Servicio_id = " + idServicio + " and imp.t_marca_id = " + idMarca
				+ " and serImp.flagHabilitado = 1 order by modelo ASC;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbModelo.removeAllItems();
			while (rs.next()) {
				cmbModelo.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 407) Error al cargar el ComboBox cargarCmbModeloParaDesasignar: " + e.getMessage();
			miCoordinador.cargaErrores(error);
		}
	}

	public void cargarCmbSerieParaDesasignar(JComboBox<String> cmbModelo, JComboBox<String> cmbSerie, JComboBox<String> cmbServicio) {

		int idModelo = idModeloCMB(cmbModelo);
		System.out.println(idModelo);
		int idServicio = idServicio(cmbServicio);
		System.out.println(idServicio);
		sql = "SELECT serieImpresora "
				+ "from t_impresora IMP, t_impresora_t_servicio SERV "
				+ "WHERE IMP.flagHabilitado = 1 "
				+ "AND IMP.t_modelo_id = '"+idModelo
				+ "' AND IMP.id = serv.t_impresora_id "
				+ "AND serv.t_Servicio_id = '"+idServicio+"' order by serieImpresora ASC;";
		conn = ConnectionDB.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			cmbSerie.removeAllItems();
			while (rs.next()) {
				cmbSerie.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			error = "(CargaComboBox = 427) Error al cargar el ComboBox cargarCmbSerieParaDesasignar: " + e.getMessage();
			Logs miLogs = new Logs();
			miLogs.cargarArchivo(error);
		}
	}

}
