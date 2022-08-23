package com.controlStock.controlStock.igu;

import com.controlStock.controlStock.principal.Coordinador;

public class Inicial extends javax.swing.JFrame {

    
	private static final long serialVersionUID = 1L;
	private Coordinador miCoordinador;

    public Inicial() {
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

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/controlStock/controlstock/imagenes/Logo Soporte.jpg"))); // NOI18N
        lblLogo.setMaximumSize(new java.awt.Dimension(450, 450));
        lblLogo.setMinimumSize(new java.awt.Dimension(450, 450));
        lblLogo.setPreferredSize(new java.awt.Dimension(450, 450));

        mnServicios.setText("Servicios");

        mntmAgregarServicio.setText("Agregar");
        mnServicios.add(mntmAgregarServicio);

        mntmModificarServicio.setText("Modificar");
        mnServicios.add(mntmModificarServicio);

        jMenuBar1.add(mnServicios);

        mnProveedores.setText("Proveedores");

        mntmAgregarProveedor.setText("Agregar");
        mnProveedores.add(mntmAgregarProveedor);

        mntmModificarProveedor.setText("Modificar");
        mnProveedores.add(mntmModificarProveedor);

        mntmEliminarProveedor.setForeground(java.awt.Color.red);
        mntmEliminarProveedor.setText("Eliminar");
        mnProveedores.add(mntmEliminarProveedor);

        jMenuBar1.add(mnProveedores);

        mnImpresoras.setText("Impresoras");

        mntmAgregarNuevaImpresora.setText("Agregar Nueva Impresora");
        mnImpresoras.add(mntmAgregarNuevaImpresora);

        mntmEntregaImpresoraNueva.setText("Entregar Impresora Nueva");
        mnImpresoras.add(mntmEntregaImpresoraNueva);

        mntmEntregarImpresoraUsada.setText("Entregar Impresora Usada");
        mnImpresoras.add(mntmEntregarImpresoraUsada);

        mntmQuitarImpresoraDelServicio.setText("Quitar Impresora del Servicio");
        mnImpresoras.add(mntmQuitarImpresoraDelServicio);

        mntmActualizarSerie.setText("Actualizar Serie Impresora");
        mnImpresoras.add(mntmActualizarSerie);

        mntmBajaImpresora.setForeground(java.awt.Color.red);
        mntmBajaImpresora.setText("Dar de Baja Impresora");
        mnImpresoras.add(mntmBajaImpresora);

        jMenuBar1.add(mnImpresoras);

        mnInsumosImpresoras.setText("Insumos Impresora ");

        mntmnuevoInsumoImpresora.setText("Nuevos Insumos");
        mnInsumosImpresoras.add(mntmnuevoInsumoImpresora);

        mntmIngresoInsumosImp.setText("Ingresar Insumos");
        mnInsumosImpresoras.add(mntmIngresoInsumosImp);

        mntmSalidaInsumosImp.setText("Salida Insumos");
        mnInsumosImpresoras.add(mntmSalidaInsumosImp);

        jMenuBar1.add(mnInsumosImpresoras);

        mnInsumosVarios.setText("Insumos Varios");

        mntmNuevoInsumoVarios.setText("Nuevos Insumos");
        mnInsumosVarios.add(mntmNuevoInsumoVarios);

        mntmIngresoInsumosVarios.setText("Ingresar Insumos");
        mnInsumosVarios.add(mntmIngresoInsumosVarios);

        mntmSalidaInsumosVarios.setText("Salida Insumos");
        mnInsumosVarios.add(mntmSalidaInsumosVarios);

        jMenuBar1.add(mnInsumosVarios);

        mnEstadisticas.setText("Estadisticas");

        mntmStock.setText("Stock");
        mnEstadisticas.add(mntmStock);

        mntmmovimientoXProveedor.setText("Ingresos de Insumos");

        mntmingresoPorInsumo.setText("Ingresos por Insumo");
        mntmmovimientoXProveedor.add(mntmingresoPorInsumo);

        mntmingresoPorProveedor.setText("Ingresos por Proveedor");
        mntmmovimientoXProveedor.add(mntmingresoPorProveedor);

        mnEstadisticas.add(mntmmovimientoXProveedor);

        mntmmovimientoXInsumo.setText("Salida de Insumos");

        mntmSalidasPorInsumo.setText("Salidas por Insumo");
        mntmmovimientoXInsumo.add(mntmSalidasPorInsumo);

        mntmSalidasPorServicio.setText("Salidas por Servicio");
        mntmmovimientoXInsumo.add(mntmSalidasPorServicio);

        mnEstadisticas.add(mntmmovimientoXInsumo);

        mntmConsumidoPeriodo.setText("Consumido en el periodo");
        mnEstadisticas.add(mntmConsumidoPeriodo);

        jMenuBar1.add(mnEstadisticas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        pack();
    }
    
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
    // End of variables declaration//GEN-END:variables

    public void setCoodinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }
}
