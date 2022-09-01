package com.controlStock.controlStock.principal;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.controlStock.controlStock.loggers.*;
import com.controlStock.controlStock.logicaSistema.DAO.*;
import com.controlStock.controlStock.logicaSistema.DTO.*;
import com.controlStock.controlStock.igu.Inicial;
import com.controlStock.controlStock.igu.Estadisticas.*;
import com.controlStock.controlStock.igu.impresoras.*;
import com.controlStock.controlStock.igu.insumosImpresoras.*;
import com.controlStock.controlStock.igu.insumosVarios.*;
import com.controlStock.controlStock.igu.proveedores.*;
import com.controlStock.controlStock.igu.servicios.*;

public class Coordinador {

	 	private Inicial miPantallaInicial;
		private NuevoServicio miPpantallaNuevoServicio;
		private ModificarServicio miPantallaModificarServicio;
		private NuevoProveedor miPantallaNuevoProveedor;
		private ModificarProveedor miPantallaModificarProveedor;
		private BajaProveedor miPantallaBajaProveedor;
		private Logs miLogs; 
		private IngresoInsumosImp miPantallaIngresoInsumosImp;
		private SalidaInsumosImp miPantallaSalidaInsumosImp;
		private NuevosInsumosVarios miPantallaNuevosInsumosVarios;
		private IngresoInsumosVarios miPantallaIngresoInsumosVarios;
		private SalidaInsumosVarios miPantallaSalidaInsumosVarios;
		private NuevaImpresora miPantallaNuevaImpresora;
		private EntregarImpresoraNuevaServicio miPantallaEntregarImpresoraNuevaServicio;
		private EntregarImpresoraUsadaServicio miPantallaEntregarImpresoraUsadaServicio;
		private QuitarImpresoraServicio miPantallaQuitarImpresoraServicio;
		private ActualizarSerieImpresora miPantallaActualizarSerieImpresora;
		private BajaImpresora miPantallaBajaImpresora;
		private IngresosPorInsumo miPantallaIngresosPorInsumo;
		private IngresosPorProveedor miPantallaIngresosPorProveedor;
		private SalidaPorInsumos miPantallaSalidaPorInsumo;
		private SalidaPorServicio miPantallaSalidaPorServicio;
		private ConsumidoPeriodo miPantallaConsumidoPeriodo;
		private ClientesDAO miClientesDAO;
		private ProveedoresDAO miProveedoresDAO;
		private InsumosDAO miInsumosDAO;
		private MarcaImpresora miPantallaMarcaImpresora;
		private ModeloImpresora miPantallaModeloImpresora;
		private NuevoInsumos miPantallaNuevoInsumos;

	    /*************************************************************************/
		//Visibilidad de Pantallas
		
		//inicio
		 public void setInicial(Inicial miPantallaInicial) {
		       this.miPantallaInicial = miPantallaInicial; 
		    } 
		 
	    public void iniciarPantallaPricipal() {
	    miPantallaInicial.setVisible(true);
	    }

	    /*************************************************************************/
	    //servicios
	    public void setmiPantallaNuevoServicio(NuevoServicio miPantallaNuevoServicio) {
			this.miPpantallaNuevoServicio = miPantallaNuevoServicio;				
		}
	    public void iniciarPantallaNuevoServicio() {
	    	miPpantallaNuevoServicio.setVisible(true);
	    }
	    
	    public void setmiPantallaModificarServicio(ModificarServicio miPantallaModificarServicio) {
			this.miPantallaModificarServicio = miPantallaModificarServicio;				
		}

		public void iniciarPantallaModificarServicio() {
			miPantallaModificarServicio.setVisible(true);			
		}
		
	    /*************************************************************************/
		//Proveedores
		public void setmiPantallaNuevoProveedor(NuevoProveedor miPantallaNuevoProveedor) {
			this.miPantallaNuevoProveedor = miPantallaNuevoProveedor;			
		}
		
		public void iniciarPantallaNuevoProveedor() {
			miPantallaNuevoProveedor.setVisible(true);			
		}

		public void setmiPantallaModificarProveedor(ModificarProveedor miPantallaModificarProveedor) {
			this.miPantallaModificarProveedor = miPantallaModificarProveedor;			
		}
		
		public void iniciarPantallaModificarProveedor() {
			miPantallaModificarProveedor.setVisible(true);			
		}

		public void setmiPantallaBajaProveedor(BajaProveedor miPantallaBajaProveedor) {
			this.miPantallaBajaProveedor = miPantallaBajaProveedor;			
		}
		
		public void iniciarPantallaBajaProveedor() {
			miPantallaBajaProveedor.setVisible(true);			
		}
		
	    /*************************************************************************/
		//Impresoras
		public void setmiPantallaNuevaImpresora(NuevaImpresora miPantallaNuevaImpresora) {
			this.miPantallaNuevaImpresora = miPantallaNuevaImpresora;			
		}
		public void iniciarPantallaNuevaImpresora() {
			miPantallaNuevaImpresora.setVisible(true);			
		}
		
		public void setmiPantallaEntregarImpresoraNuevaServicio(
				EntregarImpresoraNuevaServicio miPantallaEntregarImpresoraNuevaServicio) {
			this.miPantallaEntregarImpresoraNuevaServicio = miPantallaEntregarImpresoraNuevaServicio;			
		}
		
		public void iniciarPantallaEntregarImpresoraNuevaServicio() {
			miPantallaEntregarImpresoraNuevaServicio.setVisible(true);			
		}
		
		public void setmiPantallaEntregarImpresoraUsadaServicio(
				EntregarImpresoraUsadaServicio miPantallaEntregarImpresoraUsadaServicio) {
			this.miPantallaEntregarImpresoraUsadaServicio = miPantallaEntregarImpresoraUsadaServicio;			
		}
		
		public void iniciarPantallaEntregarImpresoraUsadaServicio() {
			miPantallaEntregarImpresoraUsadaServicio.setVisible(true);			
		}
		
		public void setmiPantallaQuitarImpresoraServicio(
				QuitarImpresoraServicio miPantallaQuitarImpresoraServicio) {
			this.miPantallaQuitarImpresoraServicio = miPantallaQuitarImpresoraServicio;			
		}
		
		public void iniciarPantallaQuitarImpresoraDelServicio() {
			miPantallaQuitarImpresoraServicio.setVisible(true);
			
		}
		
		public void setmiPantallaActualizarSerieImpresora(ActualizarSerieImpresora miPantallaActualizarSerieImpresora) {
			this.miPantallaActualizarSerieImpresora = miPantallaActualizarSerieImpresora;			
		}
		
		public void iniciarPantallaActualizarSerieImpresora() {
			miPantallaActualizarSerieImpresora.setVisible(true);
			
		}
		
		public void setmiPantallaBajaImpresora(BajaImpresora miPantallaBajaImpresora) {
			this.miPantallaBajaImpresora = miPantallaBajaImpresora;			
		}
		
		public void iniciarPantallaBajaImpresora() {
			miPantallaBajaImpresora.setVisible(true);			
		}
		
		public void setmiPantallaMarcaInpresora(MarcaImpresora miPantallaMarcaImpresora) {
		this.miPantallaMarcaImpresora = miPantallaMarcaImpresora;			
		}
		
		public void iniciarPantallaMarcaImpresora() {
			miPantallaMarcaImpresora.setVisible(true);			
		}
		
		public void setmiPantallaModeloInpresora(ModeloImpresora miPantallaModeloImpresora) {
			this.miPantallaModeloImpresora = miPantallaModeloImpresora;			
			}
		
		public void iniciarPantallaModeloImpresora() {
			miPantallaModeloImpresora.setVisible(true);			
		}
		
	    /*************************************************************************/
		//Insumos Impresoras
		public void setmiPantallaNuevoInsumos(NuevoInsumos miPantallaNuevoInsumos) {
			this.miPantallaNuevoInsumos = miPantallaNuevoInsumos;			
		}
		
		public void iniciarPantallaNuevoInsumos() {
			miPantallaNuevoInsumos.setVisible(true);			
		}	
		
		public void setmiPantallaIngresoInsumosImp(IngresoInsumosImp miPantallaIngresoInsumosImp) {
			this.miPantallaIngresoInsumosImp = miPantallaIngresoInsumosImp;			
		}
		public void iniciarPantallaIngresoInsumosImp() {
			miPantallaIngresoInsumosImp.setVisible(true);			
		}
		
		public void setmiPantallaSalidaInsumosImp(SalidaInsumosImp miPantallaSalidaInsumosImp) {
			this.miPantallaSalidaInsumosImp = miPantallaSalidaInsumosImp;			
		}
		
		public void iniciarPantallaSalidaInsumosImp() {
			miPantallaSalidaInsumosImp.setVisible(true);			
		}			
		
	    /*************************************************************************/
		//Insumos Varios
		
		public void setmiPantallaNuevosInsumosVarios(NuevosInsumosVarios miPantallaNuevosInsumosVarios) {
			this.miPantallaNuevosInsumosVarios = miPantallaNuevosInsumosVarios;			
		}
		
		public void iniciarPantallaNuevoInsumosVarios() {
			miPantallaNuevosInsumosVarios.setVisible(true);
			
		}
		
		public void setmiPantallaIngresoInsumosVarios(IngresoInsumosVarios miPantallaIngresoInsumosVarios) {
			this.miPantallaIngresoInsumosVarios = miPantallaIngresoInsumosVarios;			
		}
		
		public void iniciarPantallaIngresosInsumosVarios() {
			miPantallaIngresoInsumosVarios.setVisible(true);
			
		}
		
		public void setmiPantallaSalidaInsumosVarios(SalidaInsumosVarios miPantallaSalidaInsumosVarios) {
			this.miPantallaSalidaInsumosVarios = miPantallaSalidaInsumosVarios;			
		}
		
		public void iniciarPantallaSalidaInsumosVarios() {
			miPantallaSalidaInsumosVarios.setVisible(true);
			
		}
		
	    /*************************************************************************/
		//Estadisticas
		
		public void stock() {
			miInsumosDAO.stock();			
		}
		
		public void setmiPantallaIngresosPorInsumo(IngresosPorInsumo miPantallaIngresosPorInsumo) {
			this.miPantallaIngresosPorInsumo = miPantallaIngresosPorInsumo;			
		}
		public void iniciarPantallaIngresoPorInsumo() {
			miPantallaIngresosPorInsumo.setVisible(true);
		}
		
		public void setmiPantallaIngresosPorProveedor(IngresosPorProveedor miPantallaIngresosPorProveedor) {
			this.miPantallaIngresosPorProveedor = miPantallaIngresosPorProveedor;			
		}
		
		public void iniciarPantallaIngresoPorProveedor() {
			miPantallaIngresosPorProveedor.setVisible(true);
			
		}
		
		public void setmiPantallaSalidaPorInsumo(SalidaPorInsumos miPantallaSalidaPorInsumo) {
			this.miPantallaSalidaPorInsumo = miPantallaSalidaPorInsumo;			
		}
		
		public void iniciarPantallaSalidaPorInsumo() {
			miPantallaSalidaPorInsumo.setVisible(true);
		}
		
		public void setmiPantallaSalidasPorServicio(SalidaPorServicio miPantallaSalidaPorServicio) {
			this.miPantallaSalidaPorServicio = miPantallaSalidaPorServicio;			
		}
		
		public void iniciarPantallaSalidasPorServicio() {
			miPantallaSalidaPorServicio.setVisible(true);			
		}
		
		public void setmiPantallaConsumidoPeriodo(ConsumidoPeriodo miPantallaConsumidoPeriodo) {
			this.miPantallaConsumidoPeriodo = miPantallaConsumidoPeriodo;			
		}
		
		public void iniciarPantallaConsumidoPeriodo() {
			miPantallaConsumidoPeriodo.setVisible(true);			
		}
		
		/*************************************************************************/	
		//logs		
		public void setmiLogs(Logs miLogs) {
			this.miLogs = miLogs;
		}
				
		public void cargaErrores(String error) {
			miLogs.cargarArchivo(error);
		}
		
		/*************************************************************************/	
		// ClientesDAO
		
		public void setmiClientesDAO(ClientesDAO miClientesDAO) {
			this.miClientesDAO = miClientesDAO;			
		}
		
		public boolean nuevoCliente(JTextField txtServicio) {
			return miClientesDAO.nuevoCliente(txtServicio);
		}

		public boolean existeCliente(JTextField txtServicio) {
			return miClientesDAO.existeCliente(txtServicio);
		}

		public boolean actualizarCliente(JTextField txtServicio, JComboBox<String> cmbServicio) {
			return miClientesDAO.actualizarCliente(txtServicio, cmbServicio);
		}

		public int idServicio(JComboBox<String> cmbServicio) {
			return miClientesDAO.idServicio(cmbServicio);
		}

		/********************************************************************************/
		// ProveedoresDAO
		
		public void setmiProveedoresDAO(ProveedoresDAO miProveedoresDAO) {
			this.miProveedoresDAO = miProveedoresDAO;			
		}
		
		public boolean nuevoProveedor(JTextField txtProveedor, JTextField txtTelefono, JTextField txtEmail) {
			return miProveedoresDAO.nuevoProveedor(txtProveedor, txtTelefono, txtEmail);
		}

		public boolean actualizarProveedor(JTextField txtTelefono, JTextField txtEmail, JComboBox<String> cmbProveedor ) {
			return miProveedoresDAO.actualizarProveedor(txtTelefono, txtEmail, cmbProveedor);
		}

		public boolean existeProveedor(JTextField txtProveedor) {
			return miProveedoresDAO.existeProveedor(txtProveedor);
		}

		public int idProveedor(JComboBox<String> cmbProveedor) {
			return miProveedoresDAO.idProveedor(cmbProveedor);
		}

		public boolean bajaProveedor(JComboBox<String> cmbProveedor, JCheckBox chckbxHabilitado  ) {
			return miProveedoresDAO.bajaProveedor(cmbProveedor,chckbxHabilitado);
		}

		public ProveedoresDTO BuscarProveedor(int idProveedor) {
			return miProveedoresDAO.BuscarProveedor(idProveedor);
		}

		/********************************************************************************/
		// InsumosDAO
		
		public void setmiInsumosDAO(InsumosDAO miInsumosDAO) {
			this.miInsumosDAO = miInsumosDAO;			
		}
		
		public int idMarca(JComboBox<String> cmbMarca) {
			return miInsumosDAO.idMarca(cmbMarca);
		}

		public int idModeloCMB(JComboBox<String> cmbModelo) {
			return miInsumosDAO.idModeloCMB(cmbModelo);
		}

		public int nuevaImpresoraId(String nroSerie) {
			return miInsumosDAO.nuevaImpresoraId(nroSerie);
		}

		public boolean existeMarca(JTextField txtMarca) {
			return miInsumosDAO.existeMarca(txtMarca);
		}

		public boolean existeModelo(JTextField txtModelo) {
			return miInsumosDAO.existeModelo(txtModelo);
		}

		public boolean nuevoModelo(JTextField txtModelo, JComboBox<String> cmbMarca) {
			return miInsumosDAO.nuevoModelo(txtModelo, cmbMarca);
		}

		public boolean existeInsumo(JTextField txtInsumos) {
			return miInsumosDAO.existeInsumo(txtInsumos);
		}

		public boolean nuevaMarca(JTextField txtMarca) {
			return miInsumosDAO.nuevaMarca(txtMarca);
		}

		public boolean nuevoInsumo(JComboBox<String> cmbModelo, JTextField txtInsumos) {
			return miInsumosDAO.nuevoInsumo(cmbModelo, txtInsumos);
		}
		
		public boolean nuevoInsumosVarios(JTextField txtInsumos) {
			return miInsumosDAO.nuevoInsumoVaros(txtInsumos);
		}

		public boolean agregarNuevaImpresora(InsumosDTO miInsumo) {
			return miInsumosDAO.agregarNuevaImpresora(miInsumo);
		}

		public boolean ingresoDeInsumos(InsumosDTO miInsumoDTO) {
			return miInsumosDAO.ingresoDeInsumos(miInsumoDTO);
		}

		public boolean salidaInsumo(InsumosDTO miInsumo) {
			return miInsumosDAO.egresoDeInsumos(miInsumo);

		}

		public int insumoId(JComboBox<String> cmbInsumo) {
		return miInsumosDAO.idInsumoCMB(cmbInsumo);
		}

		
					
	    /*************************************************************************/

}