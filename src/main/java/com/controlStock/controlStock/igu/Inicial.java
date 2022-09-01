package com.controlStock.controlStock.igu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.controlStock.controlStock.principal.Coordinador;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

public class Inicial extends javax.swing.JFrame {

	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JLabel lblLogo;
	private javax.swing.JMenu mnEstadisticas;
	private javax.swing.JMenu mnImpresoras;
	private javax.swing.JMenu mnInsumosImpresoras;
	private javax.swing.JMenu mnInsumosVarios;
	private javax.swing.JMenu mnProveedores;
	private javax.swing.JMenu mnServicios;
	private javax.swing.JMenuItem mntmActualizarSerie;
	private javax.swing.JMenuItem mntmAgregarNuevaImpresora;
	private javax.swing.JMenuItem mntmAgregarProveedor;
	private javax.swing.JMenuItem mntmAgregarServicio;
	private javax.swing.JMenuItem mntmBajaImpresora;
	private javax.swing.JMenuItem mntmConsumidoPeriodo;
	private javax.swing.JMenuItem mntmEliminarProveedor;
	private javax.swing.JMenuItem mntmEntregaImpresoraNueva;
	private javax.swing.JMenuItem mntmEntregarImpresoraUsada;
	private javax.swing.JMenuItem mntmIngresoInsumosImp;
	private javax.swing.JMenuItem mntmIngresoInsumosVarios;
	private javax.swing.JMenuItem mntmModificarProveedor;
	private javax.swing.JMenuItem mntmModificarServicio;
	private javax.swing.JMenuItem mntmNuevoInsumoVarios;
	private javax.swing.JMenuItem mntmQuitarImpresoraDelServicio;
	private javax.swing.JMenuItem mntmSalidaInsumosImp;
	private javax.swing.JMenuItem mntmSalidaInsumosVarios;
	private javax.swing.JMenuItem mntmSalidasPorInsumo;
	private javax.swing.JMenuItem mntmSalidasPorServicio;
	private javax.swing.JMenuItem mntmStock;
	private javax.swing.JMenuItem mntmingresoPorInsumo;
	private javax.swing.JMenuItem mntmingresoPorProveedor;
	private javax.swing.JMenu mntmmovimientoXInsumo;
	private javax.swing.JMenu mntmmovimientoXProveedor;
	private javax.swing.JMenuItem mntmnuevoInsumoImpresora;
	private static final long serialVersionUID = 1L;
	private Coordinador miCoordinador;

	public Inicial() {
		setTitle("ControlStock");
		setResizable(false);				
		initComponents();
	}

	private void initComponents() {

		lblLogo = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		mnServicios = new javax.swing.JMenu();
		mntmAgregarServicio = new javax.swing.JMenuItem();
		mntmModificarServicio = new javax.swing.JMenuItem();
		mnProveedores = new javax.swing.JMenu();
		mntmAgregarProveedor = new javax.swing.JMenuItem();
		mntmModificarProveedor = new javax.swing.JMenuItem();
		mntmEliminarProveedor = new javax.swing.JMenuItem();
		mnImpresoras = new javax.swing.JMenu();
		mntmAgregarNuevaImpresora = new javax.swing.JMenuItem();
		mntmEntregaImpresoraNueva = new javax.swing.JMenuItem();
		mntmEntregarImpresoraUsada = new javax.swing.JMenuItem();
		mntmQuitarImpresoraDelServicio = new javax.swing.JMenuItem();
		mntmActualizarSerie = new javax.swing.JMenuItem();
		mntmBajaImpresora = new javax.swing.JMenuItem();
		mnInsumosImpresoras = new javax.swing.JMenu();
		mntmnuevoInsumoImpresora = new javax.swing.JMenuItem();
		mntmIngresoInsumosImp = new javax.swing.JMenuItem();
		mntmSalidaInsumosImp = new javax.swing.JMenuItem();
		mnInsumosVarios = new javax.swing.JMenu();
		mntmNuevoInsumoVarios = new javax.swing.JMenuItem();
		mntmIngresoInsumosVarios = new javax.swing.JMenuItem();
		mntmSalidaInsumosVarios = new javax.swing.JMenuItem();
		mnEstadisticas = new javax.swing.JMenu();
		mntmStock = new javax.swing.JMenuItem();
		mntmmovimientoXProveedor = new javax.swing.JMenu();
		mntmingresoPorInsumo = new javax.swing.JMenuItem();
		mntmingresoPorProveedor = new javax.swing.JMenuItem();
		mntmmovimientoXInsumo = new javax.swing.JMenu();
		mntmSalidasPorInsumo = new javax.swing.JMenuItem();
		mntmSalidasPorServicio = new javax.swing.JMenuItem();
		mntmConsumidoPeriodo = new javax.swing.JMenuItem();
		
		

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		getContentPane();

		lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblLogo.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/com/controlStock/controlstock/imagenes/Logo Soporte.jpg")));
		lblLogo.setMaximumSize(new java.awt.Dimension(450, 450));
		lblLogo.setMinimumSize(new java.awt.Dimension(450, 450));
		lblLogo.setPreferredSize(new java.awt.Dimension(450, 450));
		

		setJMenuBar(jMenuBar1);

		jMenuBar1.add(mnServicios);
		mnServicios.setText("Servicios");
		mntmAgregarServicio.setText("Agregar");
		mnServicios.add(mntmAgregarServicio);
		mntmAgregarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaNuevoServicio();
			}
		});

		mntmModificarServicio.setText("Modificar");
		mnServicios.add(mntmModificarServicio);
		mntmModificarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaModificarServicio();
			}
		});

		jMenuBar1.add(mnProveedores);
		mnProveedores.setText("Proveedores");

		mntmAgregarProveedor.setText("Agregar");
		mnProveedores.add(mntmAgregarProveedor);
		mntmAgregarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaNuevoProveedor();
			}
		});

		mntmModificarProveedor.setText("Modificar");
		mnProveedores.add(mntmModificarProveedor);
		mntmModificarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaModificarProveedor();
			}
		});

		mntmEliminarProveedor.setForeground(java.awt.Color.red);
		mntmEliminarProveedor.setText("Eliminar");
		mnProveedores.add(mntmEliminarProveedor);
		mntmEliminarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaBajaProveedor();
			}
		});

		jMenuBar1.add(mnImpresoras);
		mnImpresoras.setText("Impresoras");

		mntmAgregarNuevaImpresora.setText("Agregar Nueva Impresora");
		mnImpresoras.add(mntmAgregarNuevaImpresora);
		mntmAgregarNuevaImpresora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaNuevaImpresora();
			}
		});

		mntmEntregaImpresoraNueva.setText("Entregar Impresora Nueva");
		mnImpresoras.add(mntmEntregaImpresoraNueva);
		mntmEntregaImpresoraNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaEntregarImpresoraNuevaServicio();
			}
		});

		mntmEntregarImpresoraUsada.setText("Entregar Impresora Usada");
		mnImpresoras.add(mntmEntregarImpresoraUsada);
		mntmEntregarImpresoraUsada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaEntregarImpresoraUsadaServicio();
			}
		});

		mntmQuitarImpresoraDelServicio.setText("Quitar Impresora del Servicio");
		mnImpresoras.add(mntmQuitarImpresoraDelServicio);
		mntmQuitarImpresoraDelServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaQuitarImpresoraDelServicio();
			}
		});

		mntmActualizarSerie.setText("Actualizar Serie Impresora");
		mnImpresoras.add(mntmActualizarSerie);
		mntmActualizarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaActualizarSerieImpresora();
			}
		});

		mntmBajaImpresora.setForeground(java.awt.Color.red);
		mntmBajaImpresora.setText("Dar de Baja Impresora");
		mnImpresoras.add(mntmBajaImpresora);
		mntmBajaImpresora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaBajaImpresora();
			}
		});

		jMenuBar1.add(mnInsumosImpresoras);
		mnInsumosImpresoras.setText("Insumos Impresora");

		mntmnuevoInsumoImpresora.setText("Nuevos Insumos");
		mnInsumosImpresoras.add(mntmnuevoInsumoImpresora);
		mntmnuevoInsumoImpresora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaNuevoInsumos();
			}
		});

		mntmIngresoInsumosImp.setText("Ingresar Insumos");
		mnInsumosImpresoras.add(mntmIngresoInsumosImp);
		mntmIngresoInsumosImp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaIngresoInsumosImp();
			}
		});
		mntmSalidaInsumosImp.setText("Salida Insumos");
		mnInsumosImpresoras.add(mntmSalidaInsumosImp);
		mntmSalidaInsumosImp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaSalidaInsumosImp();
			}
		});

		jMenuBar1.add(mnInsumosVarios);
		mnInsumosVarios.setText("Insumos Varios");

		mntmNuevoInsumoVarios.setText("Nuevos Insumos");
		mnInsumosVarios.add(mntmNuevoInsumoVarios);
		mntmNuevoInsumoVarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaNuevoInsumosVarios();
			}
		});

		mntmIngresoInsumosVarios.setText("Ingresar Insumos");
		mnInsumosVarios.add(mntmIngresoInsumosVarios);
		mntmIngresoInsumosVarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaIngresosInsumosVarios();
			}
		});
		mntmSalidaInsumosVarios.setText("Salida Insumos");
		mnInsumosVarios.add(mntmSalidaInsumosVarios);
		mntmSalidaInsumosVarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaSalidaInsumosVarios();
			}
		});

		jMenuBar1.add(mnEstadisticas);
		mnEstadisticas.setText("Estadisticas");

		mntmStock.setText("Stock");
		mnEstadisticas.add(mntmStock);
		mntmStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.stock();
			}
		});

		mnEstadisticas.add(mntmmovimientoXProveedor);
		mntmmovimientoXProveedor.setText("Ingresos de Insumos");

		mntmingresoPorInsumo.setText("Ingresos por Insumo");
		mntmmovimientoXProveedor.add(mntmingresoPorInsumo);
		mntmingresoPorInsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaIngresoPorInsumo();
			}
		});

		mntmingresoPorProveedor.setText("Ingresos por Proveedor");
		mntmmovimientoXProveedor.add(mntmingresoPorProveedor);
		mntmingresoPorProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaIngresoPorProveedor();
			}
		});

		mntmmovimientoXInsumo.setText("Salida de Insumos");
		mnEstadisticas.add(mntmmovimientoXInsumo);

		mntmSalidasPorInsumo.setText("Salidas por Insumo");
		mntmmovimientoXInsumo.add(mntmSalidasPorInsumo);
		mntmSalidasPorInsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaSalidaPorInsumo();
			}
		});

		mntmSalidasPorServicio.setText("Salidas por Servicio");
		mntmmovimientoXInsumo.add(mntmSalidasPorServicio);
		mntmSalidasPorServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaSalidasPorServicio();
			}
		});

		mntmConsumidoPeriodo.setText("Consumido en el periodo");
		mnEstadisticas.add(mntmConsumidoPeriodo);
		mntmConsumidoPeriodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCoordinador.iniciarPantallaConsumidoPeriodo();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(86)
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 440, Short.MAX_VALUE)
					.addGap(96))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 440, Short.MAX_VALUE)
					.addGap(25))
		);
		getContentPane().setLayout(groupLayout);

		pack();
	}

	public void setCoodinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
}
