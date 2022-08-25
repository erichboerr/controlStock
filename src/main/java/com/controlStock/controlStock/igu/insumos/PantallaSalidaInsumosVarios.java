package com.controlStock.controlStock.igu.insumos;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.border.BevelBorder;

import com.controlStock.controlStock.connection.ConnectionDB;
import com.controlStock.controlStock.loggers.Logs;
//import logicaSistema.CargaComboBox;
//import logicaSistema.DTO.InsumosDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import com.controlStock.controlStock.principal.Coordinador;
//import reports.SalidaInsumosDatasource;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PantallaSalidaInsumosVarios extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	private JComboBox<String> cmbServicio;
	private JComboBox<String> cmbInsumo2;
	private JLabel lblInsumo;
	private JLabel lblInsumo2;
	private JLabel lblInsumo3;
	private JLabel lblInsumo5;
	private JComboBox<String> cmbInsumo;
	private JComboBox<String> cmbInsumo4;
	private JComboBox<String> cmbInsumo3;
	private JComboBox<String> cmbInsumo6;
	private JComboBox<String> cmbInsumo5;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblInsumo6;
	private JLabel lblServicio;
	private Coordinador miCoordinador;
	private JLabel lblInsumo4;
	//public InsumosDTO miInsumo;
	private Statement st;
	private ResultSet rs;
	private Connection conn;
	private List<List<Integer>> listaInsumos;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	//CargaComboBox cmb = new CargaComboBox();
	int i = 0;
	int j = 0;
	int k = 0;
	int tempServicio = 0;

	private JTextField txtCantidad;
	private JTextField txtCantidad2;
	private JTextField txtCantidad3;
	private JTextField txtCantidad4;
	private JTextField txtCantidad5;
	private JTextField txtCantidad6;
	private String insumo;
	private String insumo2;
	private String insumo3;
	private String insumo4;
	private String insumo5;

	public PantallaSalidaInsumosVarios() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(500, 410));
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblTitulo = new JLabel("Entrega de Insumos Varios");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setBounds(0, 11, 482, 25);
		getContentPane().add(lblTitulo);

		lblServicio = new JLabel("Servicio:");
		lblServicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblServicio.setBounds(10, 59, 55, 23);
		getContentPane().add(lblServicio);

		cmbServicio = new JComboBox<String>();
		cmbServicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbServicio.setFocusable(false);
		cmbServicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbServicio.setBounds(72, 57, 352, 23);
		getContentPane().add(cmbServicio);
		cmbServicio.insertItemAt("Seleccione un Servicio", 0);
		cmbServicio.setSelectedIndex(0);

		cmbServicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				if (j == 0) {
					//cmb.cargarCmbServicio(cmbServicio);
					cmbServicio.insertItemAt("Seleccione un Servicio", 0);
					cmbServicio.setSelectedIndex(0);
					j = 1;
				}
			}
		});

		lblInsumo = new JLabel("Insumo:");
		lblInsumo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsumo.setBounds(10, 95, 55, 23);
		getContentPane().add(lblInsumo);

		cmbInsumo = new JComboBox<String>();
		cmbInsumo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbInsumo.setFocusable(false);
		cmbInsumo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbInsumo.setBounds(72, 93, 352, 23);
		getContentPane().add(cmbInsumo);
		cmbInsumo.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo.setSelectedIndex(0);
		cmbInsumo.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
					//cmb.cargarInsumosVarios(cmbInsumo);
						cmbInsumo.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo.setSelectedIndex(0);
						txtCantidad.setEditable(true);
						txtCantidad.requestFocus(true);
						i = cmbInsumo.getItemCount();				 
			}	
		});

		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(434, 93, 40, 23);
		getContentPane().add(txtCantidad);
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

		lblInsumo2 = new JLabel("Insumo:");
		lblInsumo2.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblInsumo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsumo2.setBounds(10, 131, 55, 23);
		getContentPane().add(lblInsumo2);

		cmbInsumo2 = new JComboBox<String>();
		cmbInsumo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbInsumo2.setFocusable(false);
		cmbInsumo2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbInsumo2.setBounds(72, 129, 352, 23);
		getContentPane().add(cmbInsumo2);
		cmbInsumo2.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo2.setSelectedIndex(0);
		cmbInsumo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (cmbInsumo.getSelectedIndex() > 0) {
					//cmb.cargarInsumosVarios(cmbInsumo2);
					insumo = cmbInsumo.getSelectedItem().toString();
					cmbInsumo2.removeItem(insumo);
					cmbInsumo2.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo2.setSelectedIndex(0);
					txtCantidad2.requestFocus();
					txtCantidad2.setEditable(true);

					if (i >= 3) {// precargo el 3
						//cmb.cargarInsumosVarios(cmbInsumo3);
						cmbInsumo3.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo3.setSelectedIndex(0);
						cmbInsumo4.removeAllItems();
						cmbInsumo4.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo4.setSelectedIndex(0);
						cmbInsumo5.removeAllItems();
						cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo5.setSelectedIndex(0);
						cmbInsumo6.removeAllItems();
						cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo6.setSelectedIndex(0);
						txtCantidad3.setEditable(false);
						txtCantidad4.setEditable(false);
						txtCantidad5.setEditable(false);
						txtCantidad6.setEditable(false);

					} else {
						cmbInsumo3.removeAllItems();
						cmbInsumo3.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo3.setSelectedIndex(0);
						cmbInsumo4.removeAllItems();
						cmbInsumo4.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo4.setSelectedIndex(0);
						cmbInsumo5.removeAllItems();
						cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo5.setSelectedIndex(0);
						cmbInsumo6.removeAllItems();
						cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo6.setSelectedIndex(0);
						txtCantidad3.setEditable(false);
						txtCantidad4.setEditable(false);
						txtCantidad5.setEditable(false);
						txtCantidad6.setEditable(false);
					}

				} else {										
					cmbInsumo3.removeAllItems();
					cmbInsumo3.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo3.setSelectedIndex(0);
					cmbInsumo4.removeAllItems();
					cmbInsumo4.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo4.setSelectedIndex(0);
					cmbInsumo5.removeAllItems();
					cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo5.setSelectedIndex(0);
					cmbInsumo6.removeAllItems();
					cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo6.setSelectedIndex(0);
					txtCantidad3.setEditable(false);
					txtCantidad4.setEditable(false);
					txtCantidad5.setEditable(false);
					txtCantidad6.setEditable(false);
				}
			}
		});

		txtCantidad2 = new JTextField();
		txtCantidad2.setEditable(false);
		txtCantidad2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad2.setColumns(10);
		txtCantidad2.setBounds(434, 129, 40, 23);
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

		lblInsumo3 = new JLabel("Insumo:");
		lblInsumo3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsumo3.setBounds(10, 167, 55, 23);
		getContentPane().add(lblInsumo3);

		cmbInsumo3 = new JComboBox<String>();
		cmbInsumo3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbInsumo3.setFocusable(false);
		cmbInsumo3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbInsumo3.setBounds(72, 165, 352, 23);
		getContentPane().add(cmbInsumo3);
		cmbInsumo3.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo3.setSelectedIndex(0);
		cmbInsumo3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (cmbInsumo2.getSelectedIndex() > 0) {
					//cmb.cargarInsumosVarios(cmbInsumo3);
					insumo2 = cmbInsumo2.getSelectedItem().toString();
					cmbInsumo3.removeItem(insumo);
					cmbInsumo3.removeItem(insumo2);
					cmbInsumo3.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo3.setSelectedIndex(0);
					txtCantidad3.requestFocus();
					txtCantidad3.setEditable(true);
					if (i >= 5) {
						//cmb.cargarInsumosVarios(cmbInsumo4);
						cmbInsumo4.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo4.setSelectedIndex(0);
						cmbInsumo5.removeAllItems();
						cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo5.setSelectedIndex(0);
						cmbInsumo6.removeAllItems();
						cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo6.setSelectedIndex(0);
						txtCantidad4.setEditable(false);
						txtCantidad5.setEditable(false);
						txtCantidad6.setEditable(false);
					} else {
						cmbInsumo4.removeAllItems();
						cmbInsumo4.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo4.setSelectedIndex(0);
						cmbInsumo5.removeAllItems();
						cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo5.setSelectedIndex(0);
						cmbInsumo6.removeAllItems();
						cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo6.setSelectedIndex(0);
						txtCantidad4.setEditable(false);
						txtCantidad5.setEditable(false);
						txtCantidad6.setEditable(false);
					}
				} else {
					cmbInsumo4.removeAllItems();
					cmbInsumo4.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo4.setSelectedIndex(0);
					cmbInsumo5.removeAllItems();
					cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo5.setSelectedIndex(0);
					cmbInsumo6.removeAllItems();
					cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo6.setSelectedIndex(0);
					txtCantidad4.setEditable(false);
					txtCantidad5.setEditable(false);
					txtCantidad6.setEditable(false);
				}
			}
		});

		txtCantidad3 = new JTextField();
		txtCantidad3.setEditable(false);
		txtCantidad3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad3.setColumns(10);
		txtCantidad3.setBounds(434, 165, 40, 23);
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

		lblInsumo4 = new JLabel("Insumo:");
		lblInsumo4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsumo4.setBounds(10, 203, 55, 23);
		getContentPane().add(lblInsumo4);

		cmbInsumo4 = new JComboBox<String>();
		cmbInsumo4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbInsumo4.setFocusable(false);
		cmbInsumo4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbInsumo4.setBounds(72, 201, 352, 23);
		getContentPane().add(cmbInsumo4);
		cmbInsumo4.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo4.setSelectedIndex(0);
		cmbInsumo4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (cmbInsumo3.getSelectedIndex() > 0) {
					//cmb.cargarInsumosVarios(cmbInsumo4);
					insumo3 = cmbInsumo3.getSelectedItem().toString();
					cmbInsumo4.removeItem(insumo);
					cmbInsumo4.removeItem(insumo2);
					cmbInsumo4.removeItem(insumo3);
					cmbInsumo4.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo4.setSelectedIndex(0);
					txtCantidad4.requestFocus();
					txtCantidad4.setEditable(true);
					if (i >= 6) {
						//cmb.cargarInsumosVarios(cmbInsumo5);
						cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo5.setSelectedIndex(0);
						cmbInsumo6.removeAllItems();
						cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo6.setSelectedIndex(0);
						txtCantidad5.setEditable(false);
						txtCantidad6.setEditable(false);
					} else {
						cmbInsumo5.removeAllItems();
						cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo5.setSelectedIndex(0);
						cmbInsumo6.removeAllItems();
						cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo6.setSelectedIndex(0);
						txtCantidad5.setEditable(false);
						txtCantidad6.setEditable(false);
					}
				} else {
					cmbInsumo5.removeAllItems();
					cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo5.setSelectedIndex(0);
					cmbInsumo6.removeAllItems();
					cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo6.setSelectedIndex(0);
					txtCantidad5.setEditable(false);
					txtCantidad6.setEditable(false);
				}
			}
		});

		txtCantidad4 = new JTextField();
		txtCantidad4.setEditable(false);
		txtCantidad4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad4.setColumns(10);
		txtCantidad4.setBounds(434, 201, 40, 23);
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

		lblInsumo5 = new JLabel("Insumo:");
		lblInsumo5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsumo5.setBounds(10, 239, 55, 23);
		getContentPane().add(lblInsumo5);

		cmbInsumo5 = new JComboBox<String>();
		cmbInsumo5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbInsumo5.setFocusable(false);
		cmbInsumo5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbInsumo5.setBounds(72, 237, 352, 23);
		getContentPane().add(cmbInsumo5);
		cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo5.setSelectedIndex(0);
		cmbInsumo5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (cmbInsumo4.getSelectedIndex() > 0) {
					//cmb.cargarInsumosVarios(cmbInsumo5);
					insumo4 = cmbInsumo4.getSelectedItem().toString();
					cmbInsumo5.removeItem(insumo);
					cmbInsumo5.removeItem(insumo2);
					cmbInsumo5.removeItem(insumo3);
					cmbInsumo5.removeItem(insumo4);
					cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo5.setSelectedIndex(0);
					txtCantidad5.requestFocus();
					txtCantidad5.setEditable(true);
					if (i >= 7) {
						//cmb.cargarInsumosVarios(cmbInsumo6);
						cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo6.setSelectedIndex(0);
						txtCantidad6.setEditable(false);
					} else {
						cmbInsumo6.removeAllItems();
						cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo6.setSelectedIndex(0);
						txtCantidad6.setEditable(false);
					}
				} else {
					cmbInsumo6.removeAllItems();
					cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo6.setSelectedIndex(0);
					txtCantidad6.setEditable(false);
				}
			}
		});

		txtCantidad5 = new JTextField();
		txtCantidad5.setEditable(false);
		txtCantidad5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad5.setColumns(10);
		txtCantidad5.setBounds(434, 239, 40, 23);
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

		lblInsumo6 = new JLabel("Insumo:");
		lblInsumo6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsumo6.setBounds(10, 275, 55, 23);
		getContentPane().add(lblInsumo6);

		cmbInsumo6 = new JComboBox<String>();
		cmbInsumo6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbInsumo6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbInsumo6.setFocusable(false);
		cmbInsumo6.setBounds(72, 273, 352, 23);
		getContentPane().add(cmbInsumo6);
		cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo6.setSelectedIndex(0);

		cmbInsumo6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (cmbInsumo5.getSelectedIndex() > 1) {
					//cmb.cargarInsumosVarios(cmbInsumo6);
					insumo5 = cmbInsumo5.getSelectedItem().toString();
					cmbInsumo6.removeItem(insumo);
					cmbInsumo6.removeItem(insumo2);
					cmbInsumo6.removeItem(insumo3);
					cmbInsumo6.removeItem(insumo4);
					cmbInsumo6.removeItem(insumo5);
					cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo6.setSelectedIndex(0);
					txtCantidad6.requestFocus();
					txtCantidad6.setEditable(true);
				} else {
					cmbInsumo6.removeAllItems();
					cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo6.setSelectedIndex(0);
					txtCantidad6.setEditable(false);
				}
			}
		});

		txtCantidad6 = new JTextField();
		txtCantidad6.setEditable(false);
		txtCantidad6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCantidad6.setColumns(10);
		txtCantidad6.setBounds(434, 273, 40, 23);
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

		btnAceptar = new JButton("");
		btnAceptar.setIcon(new ImageIcon(PantallaSalidaInsumosVarios.class.getResource("/com/controlStock/controlStock/icons/aceptar-48px.png")));
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setFocusable(false);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setAlignmentX(0.5f);
		btnAceptar.setBounds(376, 310, 48, 48);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(PantallaSalidaInsumosVarios.class.getResource("/com/controlStock/controlStock/icons/cerrar-ventana-48px.png")));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		btnCancelar.setBounds(427, 310, 48, 48);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	/*	if (e.getSource() == btnAceptar) {
			if (cmbServicio.getSelectedIndex() > 0) {
				
						if (cmbInsumo.getSelectedIndex() > 0) {
							if (!txtCantidad.getText().equals("")) {
								if (miCoordinador.salidaInsumo(miInsumoDTO())) {
									dispose();
									cargaReporte();
									limpiar();									
								}
							} else {
								JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad que se entregar�",
										"Advertencia", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Debe seleccionar el insumo entregado", "Advertencia",
									JOptionPane.ERROR_MESSAGE);
						}				
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un Servicio", "Advertencia",
						JOptionPane.ERROR_MESSAGE);
			}
		}*/
		if (e.getSource() == btnCancelar) {
			limpiar();
			dispose();
		}
	}

	/*private void cargaReporte() {

		SalidaInsumosDatasource datasource = new SalidaInsumosDatasource();

		InsumosDTO insumo = new InsumosDTO();
		insumo.setServicio(cmbServicio.getSelectedItem().toString());
		insumo.setInsumo(cmbInsumo.getSelectedItem().toString());
		insumo.setCantidad(txtCantidad.getText());
		datasource.addinsumos(insumo);
		if (cmbInsumo2.getSelectedIndex() > 0) {
			InsumosDTO insumo2 = new InsumosDTO();
			insumo2.setInsumo(cmbInsumo2.getSelectedItem().toString());
			insumo2.setCantidad(txtCantidad2.getText());
			datasource.addinsumos(insumo2);
		}
		if (cmbInsumo3.getSelectedIndex() > 0) {
			InsumosDTO insumo3 = new InsumosDTO();
			insumo3.setInsumo(cmbInsumo3.getSelectedItem().toString());
			insumo3.setCantidad(txtCantidad3.getText());
			datasource.addinsumos(insumo3);
		}
		if (cmbInsumo4.getSelectedIndex() > 0) {
			InsumosDTO insumo4 = new InsumosDTO();
			insumo4.setInsumo(cmbInsumo4.getSelectedItem().toString());
			insumo4.setCantidad(txtCantidad4.getText());
			datasource.addinsumos(insumo4);
		}
		if (cmbInsumo5.getSelectedIndex() > 0) {
			InsumosDTO insumo5 = new InsumosDTO();
			insumo5.setInsumo(cmbInsumo5.getSelectedItem().toString());
			insumo5.setCantidad(txtCantidad5.getText());
			datasource.addinsumos(insumo5);
		}
		if (cmbInsumo6.getSelectedIndex() > 0) {
			InsumosDTO insumo6 = new InsumosDTO();
			insumo6.setInsumo(cmbInsumo6.getSelectedItem().toString());
			insumo6.setCantidad(txtCantidad6.getText());
			datasource.addinsumos(insumo6);
		}

		try {
			JasperReport reporte = (JasperReport) JRLoader
					.loadObject(getClass().getResource("/jrReportes/salidaInsumosVarios.jasper"));
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, datasource);
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"C:\\reportes\\SalidaInsumos-(" + getFecha() + ")-" + numeroAleatorio() + ".pdf");
			JasperViewer viewer = new JasperViewer(jasperPrint, false);		
			viewer.setVisible(true);

		} catch (JRException e) {
			String error = e.getMessage();
			Logs miLogs = new Logs();
			miLogs.cargarArchivo(error);
			System.out.println("error al generar el reporte " + e.getMessage());
		}
	}

	private int numeroAleatorio() {
		int valorEntero = (int) Math.floor(Math.random() * (999 - 1 + 1) + 1);
		return valorEntero;
	}

	private InsumosDTO miInsumoDTO() {
		String fecha = getFechaActual();

		miInsumo = new InsumosDTO();
		miInsumo.setIdServicio(miCoordinador.idServicio(cmbServicio));
		miInsumo.setFechaEgreso(fecha);
		listaInsumos();
		miInsumo.setListaInsumos(listaInsumos);

		return miInsumo;
	}*/

	/*private List<List<Integer>> listaInsumos() {
		try {
			int idInsumo = cmb.idInsumo(cmbInsumo);
			if (stockSuperiorCero(idInsumo)) {
				listaInsumos = new ArrayList<List<Integer>>();
				listaInsumos.add(new ArrayList<Integer>());// indice 0 guarda lista de insumos
				listaInsumos.add(new ArrayList<Integer>());// indice 1 guarda lista de cantidades
				listaInsumos.get(0).add(0, idInsumo);
				listaInsumos.get(1).add(0, Integer.parseInt(txtCantidad.getText()));
				
				if (cmbInsumo2.getSelectedIndex() > 0) {
					if (!txtCantidad2.getText().equals("")) {
						int idInsumo2 = cmb.idInsumo(cmbInsumo2);
						if (stockSuperiorCero(idInsumo2)) {
							listaInsumos.get(0).add(1, idInsumo2);
							listaInsumos.get(1).add(1, Integer.parseInt(txtCantidad2.getText()));
						} else {
							limpiar();
							JOptionPane.showMessageDialog(null, "No hay Stock: " + cmbInsumo2.getSelectedItem().toString(),
									"Advertencia", JOptionPane.ERROR_MESSAGE);
						}

						if (cmbInsumo3.getSelectedIndex() > 0) {
							if (!txtCantidad3.getText().equals("")) {
								int idInsumo3 = cmb.idInsumo(cmbInsumo3);
								if (stockSuperiorCero(idInsumo3)) {
									listaInsumos.get(0).add(2, idInsumo3);
									listaInsumos.get(1).add(2, Integer.parseInt(txtCantidad3.getText()));
								} else {
									JOptionPane.showMessageDialog(null,
											"No hay Stock: " + cmbInsumo3.getSelectedItem().toString(), "Advertencia",
											JOptionPane.ERROR_MESSAGE);
								}

								if (cmbInsumo4.getSelectedIndex() > 0) {
									if (!txtCantidad4.getText().equals("")) {
										int idInsumo4 = cmb.idInsumo(cmbInsumo4);
										if (stockSuperiorCero(idInsumo4)) {
											listaInsumos.get(0).add(3, idInsumo4);
											listaInsumos.get(1).add(3, Integer.parseInt(txtCantidad4.getText()));
										} else {
											JOptionPane.showMessageDialog(null,
													"No hay Stock: " + cmbInsumo4.getSelectedItem().toString(),
													"Advertencia", JOptionPane.ERROR_MESSAGE);
										}

										if (cmbInsumo5.getSelectedIndex() > 0) {
											if (!txtCantidad5.getText().equals("")) {
												int idInsumo5 = cmb.idInsumo(cmbInsumo5);
												if (stockSuperiorCero(idInsumo5)) {
													listaInsumos.get(0).add(4, idInsumo5);
													listaInsumos.get(1).add(4, Integer.parseInt(txtCantidad5.getText()));
												} else {
													JOptionPane.showMessageDialog(null,
															"No hay Stock: " + cmbInsumo5.getSelectedItem().toString(),
															"Advertencia", JOptionPane.ERROR_MESSAGE);
												}

												if (cmbInsumo6.getSelectedIndex() > 0) {
													if (!txtCantidad6.getText().equals("")) {
														int idInsumo6 = cmb.idInsumo(cmbInsumo6);
														if (stockSuperiorCero(idInsumo6)) {
															listaInsumos.get(0).add(5, idInsumo6);
															listaInsumos.get(1).add(5,
																	Integer.parseInt(txtCantidad6.getText()));
														}
													} else {
														JOptionPane.showMessageDialog(null,
																"No hay Stock: " + cmbInsumo6.getSelectedItem().toString(),
																"Advertencia", JOptionPane.ERROR_MESSAGE);
													}
												}
											} else {
												JOptionPane.showMessageDialog(null,
														"Debe ingresar una cantidad para el insumo: "
																+ cmbInsumo5.getSelectedItem().toString(),
														"Advertencia", JOptionPane.ERROR_MESSAGE);
											}
										}
									} else {
										JOptionPane.showMessageDialog(null,
												"Debe ingresar una cantidad para el insumo: "
														+ cmbInsumo4.getSelectedItem().toString(),
												"Advertencia", JOptionPane.ERROR_MESSAGE);
									}
								}
							} else {
								JOptionPane.showMessageDialog(null,
										"Debe ingresar una cantidad para el insumo: "
												+ cmbInsumo3.getSelectedItem().toString(),
										"Advertencia", JOptionPane.ERROR_MESSAGE);
							}
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe ingresar una cantidad para el insumo: " + cmbInsumo2.getSelectedItem().toString(),
								"Advertencia", JOptionPane.ERROR_MESSAGE);
					}
				}

			} else {
				JOptionPane.showMessageDialog(null, "No hay Stock: " + cmbInsumo.getSelectedItem().toString(),
						"Advertencia", JOptionPane.ERROR_MESSAGE);
			}			

		} catch (Exception e) {
			String error = "error al generar lista de insumos " + e.getMessage();
			Logs miLogs = new Logs();
			miLogs.cargarArchivo(error);
		}
		return listaInsumos;
	}*/

	private boolean stockSuperiorCero(int idInsumo) {
		boolean existe = false;
		int id = 0;
		conn = ConnectionDB.getConnection();
		String sql = "SELECT IFNULL(E.total_entradas, 0) - IFNULL(S.total_salidas, 0) Stock " + "FROM t_insumo ins "
				+ "JOIN (SELECT t_Insumo_id , SUM(ingreso) total_entradas FROM t_stockinsumo GROUP BY t_Insumo_id) E "
				+ "ON ins.id = E.t_Insumo_id and ins.id = '" + idInsumo
				+ "' JOIN (SELECT t_Insumo_id, SUM(egreso) total_salidas FROM t_stockinsumo GROUP BY t_Insumo_id) S "
				+ "ON ins.id = S.t_Insumo_id and ins.id = '" + idInsumo + "';";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = new Integer(rs.getString(1));
			}
			if (id > 0) {
				existe = true;
			} else {
				existe = false;
			}
		} catch (SQLException e) {
			String error = "(PantallaSalidaInsumosVarios = 817)Error al Buscar stock superior a cero: " + e.getMessage();
			//miCoordinador.cargaErrores(error);
		}

		return existe;

	}

	private static String getFechaActual() {
		Date fechaActual = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
		return formateador.format(fechaActual);
	}

	private static String getFecha() {
		Date fechaActual = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yy");
		return formateador.format(fechaActual);
	}

	private void limpiar() {
		i = 0;
		j = 0;
		cmbServicio.setSelectedIndex(0);
		cmbInsumo.removeAllItems();
		cmbInsumo2.removeAllItems();
		cmbInsumo3.removeAllItems();
		cmbInsumo4.removeAllItems();
		cmbInsumo5.removeAllItems();
		cmbInsumo6.removeAllItems();
		cmbInsumo.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo.setSelectedIndex(0);
		cmbInsumo2.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo2.setSelectedIndex(0);
		cmbInsumo3.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo3.setSelectedIndex(0);
		cmbInsumo4.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo4.setSelectedIndex(0);
		cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo5.setSelectedIndex(0);
		cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo6.setSelectedIndex(0);
		txtCantidad.setText("");
		txtCantidad2.setText("");
		txtCantidad3.setText("");
		txtCantidad4.setText("");
		txtCantidad5.setText("");
		txtCantidad6.setText("");
		txtCantidad.setEditable(false);
		txtCantidad2.setEditable(false);
		txtCantidad3.setEditable(false);
		txtCantidad4.setEditable(false);
		txtCantidad5.setEditable(false);
		txtCantidad6.setEditable(false);
	}
}
