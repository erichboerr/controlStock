package com.controlStock.controlStock.igu.insumosVarios;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;
import javax.swing.border.BevelBorder;

import com.controlStock.controlStock.principal.Coordinador;

//import logicaSistema.CargaComboBox;
//import logicaSistema.DTO.InsumosDTO;
//import principal.Coordinador;

import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IngresoInsumosVarios extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField txtCantidad;
	private JComboBox<String> cmbTipo;
	private JTextField txtCantidad2;
	private JComboBox<String> cmbTipo2;
	private JTextField txtCantidad4;
	private JTextField txtCantidad3;
	private JComboBox<String> cmbTipo3;
	private JComboBox<String> cmbTipo4;
	private JTextField txtCantidad5;
	private JTextField txtCantidad6;
	private JTextField txtCantidad7;
	private JTextField txtCantidad8;
	private JComboBox<String> cmbTipo5;
	private JComboBox<String> cmbTipo6;
	private JComboBox<String> cmbTipo7;
	private JComboBox<String> cmbTipo8;
	private JComboBox<String> cmbProveedor;
	private JLabel lblProveedor;
	private JTextField txtCantidad9;
	private JComboBox<String> cmbTipo9;
	private JButton btnNuevoInsumo;
	private List<List<Integer>> listaInsumos;
	private com.controlStock.controlStock.principal.Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	//CargaComboBox cmb = new CargaComboBox();
	//private InsumosDTO miInsumo;
	private JLabel lblInsumos;
	private String insumo;
	private String insumo2;
	private String insumo3;
	private String insumo4;
	private String insumo5;
	private String insumo6;
	private String insumo7;
	private String insumo8;
	private JTextField txtoc;
	private JLabel lblOrdenDeCompra;

	public IngresoInsumosVarios() {
		setMinimumSize(new Dimension(380, 550));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Ingreso de Insumos");
		setPreferredSize(new Dimension(380, 550));
		setSize(new Dimension(360, 550));
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblTitulo = new JLabel("Ingreso de insumos Varios");
		lblTitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 11, 364, 25);
		getContentPane().add(lblTitulo);

		lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProveedor.setBounds(10, 47, 68, 23);
		getContentPane().add(lblProveedor);

		cmbProveedor = new JComboBox<String>();
		cmbProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbProveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbProveedor.setFocusable(false);
		cmbProveedor.setBounds(75, 47, 269, 23);
		getContentPane().add(cmbProveedor);
		cmbProveedor.addActionListener(this);
		//cmb.cargarCmbProveedor(cmbProveedor);
		cmbProveedor.insertItemAt("Seleccione un Proveedor", 0);
		cmbProveedor.setSelectedIndex(0);

		lblInsumos = new JLabel("Insumos: ");
		lblInsumos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInsumos.setBounds(10, 117, 77, 23);
		getContentPane().add(lblInsumos);

		cmbTipo = new JComboBox<String>();
		cmbTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbTipo.setFocusable(false);
		cmbTipo.setBounds(10, 142, 294, 23);
		getContentPane().add(cmbTipo);
		cmbTipo.insertItemAt("Seleccione un Insumo", 0);
		cmbTipo.setSelectedIndex(0);
		cmbTipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//cmb.cargarInsumosVarios(cmbTipo);
				cmbTipo.insertItemAt("Seleccione un Insumo", 0);
				cmbTipo.setSelectedIndex(0);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCantidad.requestFocus();
			}
		});

		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad.setBounds(314, 142, 30, 23);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		txtCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				char tecla = ev.getKeyChar();
				if (!Character.isDigit(tecla)) {
					getToolkit().beep();
					ev.consume();
				}
			}
		});

		cmbTipo2 = new JComboBox<String>();
		cmbTipo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTipo2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbTipo2.setFocusable(false);
		cmbTipo2.setBounds(10, 176, 294, 23);
		getContentPane().add(cmbTipo2);
		cmbTipo2.insertItemAt("Seleccione un Insumo", 0);
		cmbTipo2.setSelectedIndex(0);
		cmbTipo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (cmbTipo.getSelectedIndex() > 0) {
					//cmb.cargarInsumosVarios(cmbTipo2);
					insumo = cmbTipo.getSelectedItem().toString();
					cmbTipo2.removeItem(insumo);
					cmbTipo2.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo2.setSelectedIndex(0);
				} else {
					cmbTipo2.removeAllItems();
					cmbTipo2.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo2.setSelectedIndex(0);
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCantidad2.requestFocus();
			}
		});

		txtCantidad2 = new JTextField();
		txtCantidad2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad2.setColumns(10);
		txtCantidad2.setBounds(314, 176, 30, 23);
		getContentPane().add(txtCantidad2);
		txtCantidad2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				char tecla = ev.getKeyChar();
				if (!Character.isDigit(tecla)) {
					getToolkit().beep();
					ev.consume();
				}
			}
		});

		cmbTipo3 = new JComboBox<String>();
		cmbTipo3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTipo3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbTipo3.setFocusable(false);
		cmbTipo3.setBounds(10, 210, 294, 23);
		getContentPane().add(cmbTipo3);
		cmbTipo3.insertItemAt("Seleccione un Insumo", 0);
		cmbTipo3.setSelectedIndex(0);
		cmbTipo3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (cmbTipo2.getSelectedIndex() > 0) {
					//cmb.cargarInsumosVarios(cmbTipo3);
					insumo2 = cmbTipo2.getSelectedItem().toString();
					cmbTipo3.removeItem(insumo);
					cmbTipo3.removeItem(insumo2);
					cmbTipo3.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo3.setSelectedIndex(0);
				} else {
					cmbTipo3.removeAllItems();
					cmbTipo3.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo3.setSelectedIndex(0);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCantidad3.requestFocus();
			}
		});

		txtCantidad3 = new JTextField();
		txtCantidad3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad3.setColumns(10);
		txtCantidad3.setBounds(314, 210, 30, 23);
		getContentPane().add(txtCantidad3);
		txtCantidad3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				char tecla = ev.getKeyChar();
				if (!Character.isDigit(tecla)) {
					getToolkit().beep();
					ev.consume();
				}
			}
		});

		cmbTipo4 = new JComboBox<String>();
		cmbTipo4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTipo4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbTipo4.setFocusable(false);
		cmbTipo4.setBounds(10, 244, 294, 23);
		getContentPane().add(cmbTipo4);
		cmbTipo4.insertItemAt("Seleccione un Insumo", 0);
		cmbTipo4.setSelectedIndex(0);
		cmbTipo4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (cmbTipo3.getSelectedIndex() > 0) {
					//cmb.cargarInsumosVarios(cmbTipo4);
					insumo3 = cmbTipo3.getSelectedItem().toString();
					cmbTipo4.removeItem(insumo);
					cmbTipo4.removeItem(insumo2);
					cmbTipo4.removeItem(insumo3);
					cmbTipo4.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo4.setSelectedIndex(0);					
				} else {
					cmbTipo4.removeAllItems();
					cmbTipo4.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo4.setSelectedIndex(0);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCantidad4.requestFocus();
			}
		});

		txtCantidad4 = new JTextField();
		txtCantidad4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad4.setColumns(10);
		txtCantidad4.setBounds(314, 244, 30, 23);
		getContentPane().add(txtCantidad4);
		txtCantidad4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				char tecla = ev.getKeyChar();
				if (!Character.isDigit(tecla)) {
					getToolkit().beep();
					ev.consume();
				}
			}
		});

		cmbTipo5 = new JComboBox<String>();
		cmbTipo5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTipo5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbTipo5.setFocusable(false);
		cmbTipo5.setBounds(10, 278, 294, 23);
		getContentPane().add(cmbTipo5);
		cmbTipo5.insertItemAt("Seleccione un Insumo", 0);
		cmbTipo5.setSelectedIndex(0);
		cmbTipo5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (cmbTipo4.getSelectedIndex() > 0) {
					//cmb.cargarInsumosVarios(cmbTipo5);
					insumo4 = cmbTipo4.getSelectedItem().toString();
					cmbTipo5.removeItem(insumo);
					cmbTipo5.removeItem(insumo2);
					cmbTipo5.removeItem(insumo3);
					cmbTipo5.removeItem(insumo4);
					cmbTipo5.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo5.setSelectedIndex(0);
				} else {
					cmbTipo5.removeAllItems();
					cmbTipo5.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo5.setSelectedIndex(0);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCantidad5.requestFocus();
			}
		});

		txtCantidad5 = new JTextField();
		txtCantidad5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad5.setColumns(10);
		txtCantidad5.setBounds(314, 278, 30, 23);
		getContentPane().add(txtCantidad5);
		txtCantidad5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				char tecla = ev.getKeyChar();
				if (!Character.isDigit(tecla)) {
					getToolkit().beep();
					ev.consume();
				}
			}
		});

		cmbTipo6 = new JComboBox<String>();
		cmbTipo6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTipo6.setFocusable(false);
		cmbTipo6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbTipo6.setBounds(10, 312, 294, 23);
		getContentPane().add(cmbTipo6);
		cmbTipo6.insertItemAt("Seleccione un Insumo", 0);
		cmbTipo6.setSelectedIndex(0);
		cmbTipo6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (cmbTipo5.getSelectedIndex() > 0) {
					//cmb.cargarInsumosVarios(cmbTipo6);
					insumo5 = cmbTipo5.getSelectedItem().toString();
					cmbTipo6.removeItem(insumo);
					cmbTipo6.removeItem(insumo2);
					cmbTipo6.removeItem(insumo3);
					cmbTipo6.removeItem(insumo4);
					cmbTipo6.removeItem(insumo5);
					cmbTipo6.insertItemAt("Seleccione un Insumo", 0);					
					cmbTipo6.setSelectedIndex(0);
				} else {
					cmbTipo6.removeAllItems();
					cmbTipo6.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo6.setSelectedIndex(0);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCantidad6.requestFocus();
			}
		});

		txtCantidad6 = new JTextField();
		txtCantidad6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad6.setColumns(10);
		txtCantidad6.setBounds(314, 312, 30, 23);
		getContentPane().add(txtCantidad6);
		txtCantidad6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				char tecla = ev.getKeyChar();
				if (!Character.isDigit(tecla)) {
					getToolkit().beep();
					ev.consume();
				}
			}
		});

		cmbTipo7 = new JComboBox<String>();
		cmbTipo7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTipo7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbTipo7.setFocusable(false);
		cmbTipo7.setBounds(10, 346, 294, 23);
		getContentPane().add(cmbTipo7);
		cmbTipo7.insertItemAt("Seleccione un Insumo", 0);
		cmbTipo7.setSelectedIndex(0);
		cmbTipo7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (cmbTipo6.getSelectedIndex() > 0) {
					//cmb.cargarInsumosVarios(cmbTipo7);
					insumo6 = cmbTipo6.getSelectedItem().toString();
					cmbTipo7.removeItem(insumo);
					cmbTipo7.removeItem(insumo2);
					cmbTipo7.removeItem(insumo3);
					cmbTipo7.removeItem(insumo4);
					cmbTipo7.removeItem(insumo5);
					cmbTipo7.removeItem(insumo6);
					cmbTipo7.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo7.setSelectedIndex(0);
				} else {
					cmbTipo7.removeAllItems();
					cmbTipo7.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo7.setSelectedIndex(0);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCantidad7.requestFocus();
			}
		});

		txtCantidad7 = new JTextField();
		txtCantidad7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad7.setColumns(10);
		txtCantidad7.setBounds(314, 346, 30, 23);
		getContentPane().add(txtCantidad7);
		txtCantidad7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				char tecla = ev.getKeyChar();
				if (!Character.isDigit(tecla)) {
					getToolkit().beep();
					ev.consume();
				}
			}
		});

		cmbTipo8 = new JComboBox<String>();
		cmbTipo8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTipo8.setFocusable(false);
		cmbTipo8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbTipo8.setBounds(10, 380, 294, 23);
		getContentPane().add(cmbTipo8);
		cmbTipo8.insertItemAt("Seleccione un Insumo", 0);
		cmbTipo8.setSelectedIndex(0);
		cmbTipo8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (cmbTipo7.getSelectedIndex() > 0) {
					//cmb.cargarInsumosVarios(cmbTipo8);
					insumo7 = cmbTipo7.getSelectedItem().toString();
					cmbTipo8.removeItem(insumo);
					cmbTipo8.removeItem(insumo2);
					cmbTipo8.removeItem(insumo3);
					cmbTipo8.removeItem(insumo4);
					cmbTipo8.removeItem(insumo5);
					cmbTipo8.removeItem(insumo6);
					cmbTipo8.removeItem(insumo7);
					cmbTipo8.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo8.setSelectedIndex(0);
				} else {
					cmbTipo8.removeAllItems();
					cmbTipo8.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo8.setSelectedIndex(0);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCantidad8.requestFocus();
			}
		});

		txtCantidad8 = new JTextField();
		txtCantidad8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad8.setColumns(10);
		txtCantidad8.setBounds(314, 380, 30, 23);
		getContentPane().add(txtCantidad8);
		txtCantidad8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				char tecla = ev.getKeyChar();
				if (!Character.isDigit(tecla)) {
					getToolkit().beep();
					ev.consume();
				}
			}
		});

		cmbTipo9 = new JComboBox<String>();
		cmbTipo9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbTipo9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbTipo9.setFocusable(false);
		cmbTipo9.setBounds(10, 414, 294, 23);
		getContentPane().add(cmbTipo9);
		cmbTipo9.insertItemAt("Seleccione un Insumo", 0);
		cmbTipo9.setSelectedIndex(0);
		cmbTipo9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (cmbTipo8.getSelectedIndex() > 0) {
					//cmb.cargarInsumosVarios(cmbTipo9);
					insumo8 = cmbTipo8.getSelectedItem().toString();
					cmbTipo9.removeItem(insumo);
					cmbTipo9.removeItem(insumo2);
					cmbTipo9.removeItem(insumo3);
					cmbTipo9.removeItem(insumo4);
					cmbTipo9.removeItem(insumo5);
					cmbTipo9.removeItem(insumo6);
					cmbTipo9.removeItem(insumo7);
					cmbTipo9.removeItem(insumo8);
					cmbTipo9.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo9.setSelectedIndex(0);
				} else {
					cmbTipo9.removeAllItems();
					cmbTipo9.insertItemAt("Seleccione un Insumo", 0);
					cmbTipo9.setSelectedIndex(0);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCantidad9.requestFocus();
			}
		});

		txtCantidad9 = new JTextField();
		txtCantidad9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad9.setColumns(10);
		txtCantidad9.setBounds(314, 414, 30, 23);
		getContentPane().add(txtCantidad9);
		txtCantidad9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				char tecla = ev.getKeyChar();
				if (!Character.isDigit(tecla)) {
					getToolkit().beep();
					ev.consume();
				}
			}
		});

		btnAceptar = new JButton("");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setIcon(new ImageIcon(IngresoInsumosVarios.class.getResource("/com/controlStock/controlStock/icons/aceptar-48px.png")));
		btnAceptar.setFocusable(false);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setAlignmentX(0.5f);
		btnAceptar.setBounds(250, 460, 48, 48);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(IngresoInsumosVarios.class.getResource("/com/controlStock/controlStock/icons/cerrar-ventana-48px.png")));
		btnCancelar.setSize(new Dimension(48, 48));
		btnCancelar.setPreferredSize(new Dimension(48, 48));
		btnCancelar.setMinimumSize(new Dimension(48, 48));
		btnCancelar.setMaximumSize(new Dimension(48, 48));
		btnCancelar.setFocusable(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setAlignmentX(0.5f);
		btnCancelar.setBounds(303, 460, 48, 48);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);

		btnNuevoInsumo = new JButton("");
		btnNuevoInsumo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevoInsumo.setToolTipText("Agregar nuevo Insumo");
		btnNuevoInsumo.setIcon(new ImageIcon(IngresoInsumosVarios.class.getResource("/com/controlStock/controlStock/icons/añadir-48px.png")));
		btnNuevoInsumo.setFocusable(false);
		btnNuevoInsumo.setFocusPainted(false);
		btnNuevoInsumo.setContentAreaFilled(false);
		btnNuevoInsumo.setBorderPainted(false);
		btnNuevoInsumo.setBorder(null);
		btnNuevoInsumo.setAlignmentX(0.5f);
		btnNuevoInsumo.setBounds(10, 460, 48, 48);
		getContentPane().add(btnNuevoInsumo);
		
		lblOrdenDeCompra = new JLabel("Orden de Compra: ");
		lblOrdenDeCompra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOrdenDeCompra.setBounds(10, 88, 110, 23);
		getContentPane().add(lblOrdenDeCompra);
		
		txtoc = new JTextField();
		txtoc.setBounds(114, 88, 230, 22);
		getContentPane().add(txtoc);
		txtoc.setColumns(10);
		btnNuevoInsumo.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			limpiar();
			dispose();
		}
		/*if (e.getSource() == btnAceptar) {
			if (cmbProveedor.getSelectedIndex() > 0) {
				if (cmbTipo.getSelectedIndex() > 0) {
					if (!txtCantidad.getText().equals("")) {
						if (miCoordinador.ingresoDeInsumos(miInsumoDTO())) {
							dispose();
							JOptionPane.showMessageDialog(null, "Insumos Cargados con Exito");
							limpiar();
							
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe ingresar una cantidad para el producto " + cmbTipo.getSelectedItem(),
								"Advertencia", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un producto ", "Advertencia",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar unProveedor ", "Advertencia",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == btnNuevoInsumo) {
			miCoordinador.miPantallaInsumosVarios();
		}*/
	}

	private void limpiar() {
		cmbProveedor.setSelectedIndex(0);
		txtoc.setText("");
		txtCantidad.setText("");
		txtCantidad2.setText("");
		txtCantidad3.setText("");
		txtCantidad4.setText("");
		txtCantidad5.setText("");
		txtCantidad6.setText("");
		txtCantidad7.setText("");
		txtCantidad8.setText("");
		txtCantidad9.setText("");
		cmbTipo.setSelectedIndex(0);
		cmbTipo2.setSelectedIndex(0);
		cmbTipo3.setSelectedIndex(0);
		cmbTipo4.setSelectedIndex(0);
		cmbTipo5.setSelectedIndex(0);
		cmbTipo6.setSelectedIndex(0);
		cmbTipo7.setSelectedIndex(0);
		cmbTipo8.setSelectedIndex(0);
		cmbTipo9.setSelectedIndex(0);
	}

	/*public InsumosDTO miInsumoDTO() {

		String fecha = getFechaActual();

		miInsumo = new InsumosDTO();
		miInsumo.setIdProveedor(miCoordinador.idProveedor(cmbProveedor));
		miInsumo.setFechaIngreso(fecha);
		miInsumo.setOrdenCompra(txtoc.getText());
		listaInsumos();
		miInsumo.setListaInsumos(listaInsumos);
		return miInsumo;
	}*/

	public static String getFechaActual() {
		Date fechaActual = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
		return formateador.format(fechaActual);
	}

	/*public List<List<Integer>> listaInsumos() {

		listaInsumos = new ArrayList<List<Integer>>();
		listaInsumos.add(new ArrayList<Integer>());// indice 0 guarda listas de insumos
		listaInsumos.add(new ArrayList<Integer>());// indice 1 guarda lista de cantidades

		int idInsumo = cmb.idInsumo(cmbTipo);
		listaInsumos.get(0).add(0, idInsumo);
		listaInsumos.get(1).add(0, Integer.parseInt(txtCantidad.getText()));
		if (cmbTipo2.getSelectedIndex() > 0) {
			if (!txtCantidad2.getText().equals("")) {
				int idInsumo2 = cmb.idInsumo(cmbTipo2);
				listaInsumos.get(0).add(0, idInsumo2);
				listaInsumos.get(1).add(0, Integer.parseInt(txtCantidad2.getText()));
			}
		}
		if (cmbTipo3.getSelectedIndex() > 0) {
			if (!txtCantidad3.getText().equals("")) {
				int idInsumo3 = cmb.idInsumo(cmbTipo3);
				listaInsumos.get(0).add(0, idInsumo3);
				listaInsumos.get(1).add(0, Integer.parseInt(txtCantidad3.getText()));
			}
		}
		if (cmbTipo4.getSelectedIndex() > 0) {
			if (!txtCantidad4.getText().equals("")) {
				int idInsumo4 = cmb.idInsumo(cmbTipo4);
				listaInsumos.get(0).add(0, idInsumo4);
				listaInsumos.get(1).add(0, Integer.parseInt(txtCantidad4.getText()));
			}
		}
		if (cmbTipo5.getSelectedIndex() > 0) {
			if (!txtCantidad5.getText().equals("")) {
				int idInsumo5 = cmb.idInsumo(cmbTipo5);
				listaInsumos.get(0).add(0, idInsumo5);
				listaInsumos.get(1).add(0, Integer.parseInt(txtCantidad5.getText()));
			}
		}
		if (cmbTipo6.getSelectedIndex() > 0) {
			if (!txtCantidad6.getText().equals("")) {
				int idInsumo6 = cmb.idInsumo(cmbTipo6);
				listaInsumos.get(0).add(0, idInsumo6);
				listaInsumos.get(1).add(0, Integer.parseInt(txtCantidad6.getText()));
			}
		}
		if (cmbTipo7.getSelectedIndex() > 0) {
			if (!txtCantidad7.getText().equals("")) {
				int idInsumo7 = cmb.idInsumo(cmbTipo7);
				listaInsumos.get(0).add(0, idInsumo7);
				listaInsumos.get(1).add(0, Integer.parseInt(txtCantidad7.getText()));
			}
		}
		if (cmbTipo8.getSelectedIndex() > 0) {
			if (!txtCantidad8.getText().equals("")) {
				int idInsumo8 = cmb.idInsumo(cmbTipo8);
				listaInsumos.get(0).add(0, idInsumo8);
				listaInsumos.get(1).add(0, Integer.parseInt(txtCantidad8.getText()));

			}
			if (cmbTipo9.getSelectedIndex() > 0) {
				if (!txtCantidad9.getText().equals("")) {
					int idInsumo9 = cmb.idInsumo(cmbTipo9);
					listaInsumos.get(0).add(0, idInsumo9);
					listaInsumos.get(1).add(0, Integer.parseInt(txtCantidad9.getText()));
				}
			}
		}
		return listaInsumos;
	}*/
}
