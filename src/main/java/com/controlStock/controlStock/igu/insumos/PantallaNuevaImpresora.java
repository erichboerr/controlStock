package com.controlStock.controlStock.igu.insumos;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.controlStock.controlStock.connection.ConnectionDB;

import javax.swing.JComboBox;

//import logicaSistema.CargaComboBox;
//import logicaSistema.DTO.InsumosDTO;
import com.controlStock.controlStock.principal.Coordinador;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaNuevaImpresora extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblTxttitulo;
	private JComboBox<String> cmbMarca;
	private JComboBox<String> cmbModelo;
	private JLabel lblMarca;
	private JLabel lblProveedor;
	private JComboBox<String> cmbProveedor;
	private JButton btnAgregarMarca;
	private JLabel lblInsumo;
	private JLabel lblModelo;
	private JButton btnagregarModelo;
	private JTextField txtSerie;
	private JLabel lblInsumo3;
	private JLabel lblInsumo4;
	private JLabel lblInsumo5;
	private JLabel lblInsumo6;
	private Coordinador miCoordinador;
	private JLabel lblInsumo2;
	private JLabel lblNroSerie;
	private JButton btnAceptar;
	private JButton btnCancelar;
	//public InsumosDTO miInsumo;
	private JComboBox<String> cmbInsumo6;
	private JComboBox<String> cmbInsumo5;
	private JComboBox<String> cmbInsumo4;
	private JComboBox<String> cmbInsumo3;
	private JComboBox<String> cmbInsumo2;
	private JComboBox<String> cmbInsumo;
	private JButton btnAddIsumo6;
	private JButton btnAddIsumo5;
	private JButton btnAddIsumo3;
	private JButton btnAddIsumo2;
	private JButton btnAddIsumo;
	private JButton btnAddIsumo4;

	private String insumo;
	private String insumo2;
	private String insumo3;
	private String insumo4;
	private String insumo5;

	private int i = 0;
	private int j = 0;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	//CargaComboBox cmb = new CargaComboBox();

	public PantallaNuevaImpresora() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		getContentPane().setFocusable(false);
		setMinimumSize(new Dimension(390, 490));
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblTxttitulo = new JLabel("Nueva Impresora");
		lblTxttitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblTxttitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxttitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTxttitulo.setBounds(0, 11, 384, 24);
		getContentPane().add(lblTxttitulo);

		lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProveedor.setBounds(10, 45, 70, 24);
		getContentPane().add(lblProveedor);

		cmbProveedor = new JComboBox<String>();
		cmbProveedor.setFocusable(false);
		cmbProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbProveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbProveedor.setBounds(82, 45, 249, 24);
		getContentPane().add(cmbProveedor);
		cmbProveedor.insertItemAt("Seleccione un Proveedor", 0);
		cmbProveedor.setSelectedIndex(0);
		cmbProveedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (cmbProveedor.getSelectedIndex() == 0) {
					//cmb.cargarCmbProveedor(cmbProveedor);
					cmbProveedor.insertItemAt("Seleccione un Proveedor", 0);
					cmbProveedor.setSelectedIndex(0);
				}
			}
		});

		lblMarca = new JLabel("Marca: ");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarca.setBounds(10, 80, 70, 24);
		getContentPane().add(lblMarca);

		cmbMarca = new JComboBox<String>();
		cmbMarca.setFocusable(false);
		cmbMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbMarca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbMarca.setBounds(82, 80, 249, 24);
		cmbMarca.insertItemAt("Seleccione una Marca", 0);
		cmbMarca.setSelectedIndex(0);
		getContentPane().add(cmbMarca);
		cmbMarca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (j == 0) {
					//cmb.cargarCmbMarca(cmbMarca);
					cmbMarca.insertItemAt("Seleccione una Marca", 0);
					cmbMarca.setSelectedIndex(0);
					j = 1;
				}
			}
		});

		btnAgregarMarca = new JButton("");
		btnAgregarMarca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarMarca.setFocusPainted(false);
		btnAgregarMarca.setFocusable(false);
		btnAgregarMarca.setMaximumSize(new Dimension(24, 24));
		btnAgregarMarca.setMinimumSize(new Dimension(24, 24));
		btnAgregarMarca.setPreferredSize(new Dimension(24, 24));
		btnAgregarMarca.setSize(new Dimension(24, 24));
		btnAgregarMarca.setToolTipText("Agregar nueva Marca de Impresora");
		btnAgregarMarca
				.setIcon(new ImageIcon(PantallaNuevaImpresora.class.getResource("/com/controlStock/controlStock/icons/añadir-48px.png")));
		btnAgregarMarca.setBounds(340, 80, 24, 24);
		getContentPane().add(btnAgregarMarca);
		btnAgregarMarca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//miCoordinador.miPantallaMarca();
				j = 0;
			}
		});

		lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModelo.setBounds(10, 115, 70, 24);
		getContentPane().add(lblModelo);

		cmbModelo = new JComboBox<String>();
		cmbModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbModelo.setFocusable(false);
		cmbModelo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbModelo.setBounds(82, 118, 249, 21);
		cmbModelo.insertItemAt("Seleccione un Modelo", 0);
		cmbModelo.setSelectedIndex(0);
		getContentPane().add(cmbModelo);
		cmbModelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				if (cmbMarca.getSelectedIndex() > 0) {
					//cmb.cargarCmbModelo(cmbModelo, cmbMarca);
					cmbModelo.insertItemAt("Seleccione un Modelo", 0);
					cmbModelo.setSelectedIndex(0);
					cmbInsumo.removeAllItems();
					cmbInsumo.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo.setSelectedIndex(0);
					cmbInsumo2.removeAllItems();
					cmbInsumo2.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo2.setSelectedIndex(0);
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
				} else {
					cmbModelo.insertItemAt("Seleccione un Modelo", 0);
					cmbModelo.setSelectedIndex(0);
					cmbInsumo.removeAllItems();
					cmbInsumo.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo.setSelectedIndex(0);
					cmbInsumo2.removeAllItems();
					cmbInsumo2.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo2.setSelectedIndex(0);
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
				}
			}
		});

		btnagregarModelo = new JButton("");
		btnagregarModelo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnagregarModelo
				.setIcon(new ImageIcon(PantallaNuevaImpresora.class.getResource("/com/controlStock/controlStock/icons/añadir-48px.png")));
		btnagregarModelo.setToolTipText("Agregar nuevo modelo de Impresora");
		btnagregarModelo.setSize(new Dimension(24, 24));
		btnagregarModelo.setPreferredSize(new Dimension(24, 24));
		btnagregarModelo.setMinimumSize(new Dimension(24, 24));
		btnagregarModelo.setMaximumSize(new Dimension(24, 24));
		btnagregarModelo.setFocusable(false);
		btnagregarModelo.setFocusPainted(false);
		btnagregarModelo.setBounds(340, 115, 24, 24);
		getContentPane().add(btnagregarModelo);
		btnagregarModelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//miCoordinador.miPantallaModelo();
			}
		});

		lblNroSerie = new JLabel("Nro. Serie:");
		lblNroSerie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNroSerie.setBounds(10, 150, 70, 23);
		getContentPane().add(lblNroSerie);

		txtSerie = new JTextField();
		txtSerie.setToolTipText("Agregue el nro de serie de la impresora");
		txtSerie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSerie.setBounds(82, 150, 249, 23);
		getContentPane().add(txtSerie);
		txtSerie.setColumns(10);

		lblInsumo = new JLabel("Insumo:");
		lblInsumo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsumo.setBounds(10, 184, 70, 24);
		getContentPane().add(lblInsumo);

		cmbInsumo = new JComboBox<String>();
		cmbInsumo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbInsumo.setBounds(82, 184, 249, 23);
		cmbInsumo.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo.setSelectedIndex(0);
		cmbInsumo.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo.setSelectedIndex(0);
		getContentPane().add(cmbInsumo);
		cmbInsumo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (cmbInsumo.getSelectedIndex() == 0) {
					if (cmbModelo.getSelectedIndex() > 0) {
						//cmb.cargarInsumo(cmbInsumo, cmbModelo);
						cmbInsumo.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo.setSelectedIndex(0);
						i = cmbInsumo.getItemCount();

						if (i >= 3) {// precargo el 3� combobox
							//cmb.cargarInsumo(cmbInsumo2, cmbModelo);
							cmbInsumo2.insertItemAt("Seleccione un Insumo", 0);
							cmbInsumo2.setSelectedIndex(0);
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

						} else {
							cmbInsumo2.removeAllItems();
							cmbInsumo2.insertItemAt("Seleccione un Insumo", 0);
							cmbInsumo2.setSelectedIndex(0);
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
						}
					} else {
						cmbInsumo.removeAllItems();
						cmbInsumo.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo.setSelectedIndex(0);
						cmbInsumo2.removeAllItems();
						cmbInsumo2.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo2.setSelectedIndex(0);
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
					}
				}
			}
		});

		btnAddIsumo = new JButton("");
		btnAddIsumo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddIsumo.setIcon(new ImageIcon(PantallaNuevaImpresora.class.getResource("/com/controlStock/controlStock/icons/añadir-48px.png")));
		btnAddIsumo.setToolTipText("Agregar nuevo insumo para el modelo de Impresora");
		btnAddIsumo.setSize(new Dimension(24, 24));
		btnAddIsumo.setPreferredSize(new Dimension(24, 24));
		btnAddIsumo.setMinimumSize(new Dimension(24, 24));
		btnAddIsumo.setMaximumSize(new Dimension(24, 24));
		btnAddIsumo.setFocusable(false);
		btnAddIsumo.setFocusPainted(false);
		btnAddIsumo.setBounds(340, 186, 24, 24);
		getContentPane().add(btnAddIsumo);
		btnAddIsumo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//miCoordinador.miPantallaInsumos();
			}
		});

		lblInsumo2 = new JLabel("Insumo:");
		lblInsumo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsumo2.setBounds(10, 219, 70, 24);
		getContentPane().add(lblInsumo2);

		cmbInsumo2 = new JComboBox<String>();
		cmbInsumo2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbInsumo2.setBounds(82, 219, 249, 23);
		getContentPane().add(cmbInsumo2);
		cmbInsumo2.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo2.setSelectedIndex(0);
		cmbInsumo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (cmbInsumo.getSelectedIndex() > 0) {
					//cmb.cargarInsumo(cmbInsumo2, cmbModelo);
					insumo = cmbInsumo.getSelectedItem().toString();
					cmbInsumo2.removeItem(insumo);
					cmbInsumo2.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo2.setSelectedIndex(0);
					if (i >= 4) {// precargo el 4
						//cmb.cargarInsumo(cmbInsumo3, cmbModelo);
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
				}
			}
		});

		btnAddIsumo2 = new JButton("");
		btnAddIsumo2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddIsumo2.setIcon(new ImageIcon(PantallaNuevaImpresora.class.getResource("/com/controlStock/controlStock/icons/añadir-48px.png")));
		btnAddIsumo2.setToolTipText("Agregar nuevo insumo para el modelo de Impresora");
		btnAddIsumo2.setSize(new Dimension(24, 24));
		btnAddIsumo2.setPreferredSize(new Dimension(24, 24));
		btnAddIsumo2.setMinimumSize(new Dimension(24, 24));
		btnAddIsumo2.setMaximumSize(new Dimension(24, 24));
		btnAddIsumo2.setFocusable(false);
		btnAddIsumo2.setFocusPainted(false);
		btnAddIsumo2.setBounds(340, 219, 24, 24);
		getContentPane().add(btnAddIsumo2);
		btnAddIsumo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//miCoordinador.miPantallaInsumos();

			}
		});

		lblInsumo3 = new JLabel("Insumo:");
		lblInsumo3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsumo3.setBounds(10, 254, 70, 24);
		getContentPane().add(lblInsumo3);

		cmbInsumo3 = new JComboBox<String>();
		cmbInsumo3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbInsumo3.setBounds(82, 254, 249, 23);
		cmbInsumo3.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo3.setSelectedIndex(0);
		getContentPane().add(cmbInsumo3);
		cmbInsumo3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (cmbInsumo2.getSelectedIndex() > 0) {
					//cmb.cargarInsumo(cmbInsumo3, cmbModelo);
					insumo2 = cmbInsumo2.getSelectedItem().toString();
					cmbInsumo3.removeItem(insumo);
					cmbInsumo3.removeItem(insumo2);
					cmbInsumo3.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo3.setSelectedIndex(0);
					if (i >= 5) {
						//cmb.cargarInsumo(cmbInsumo4, cmbModelo);
						cmbInsumo4.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo4.setSelectedIndex(0);
						cmbInsumo5.removeAllItems();
						cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo5.setSelectedIndex(0);
						cmbInsumo6.removeAllItems();
						cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo6.setSelectedIndex(0);
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
				}
			}
		});

		btnAddIsumo3 = new JButton("");
		btnAddIsumo3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddIsumo3.setIcon(new ImageIcon(PantallaNuevaImpresora.class.getResource("/com/controlStock/controlStock/icons/añadir-48px.png")));
		btnAddIsumo3.setToolTipText("Agregar nuevo insumo para el modelo de Impresora");
		btnAddIsumo3.setSize(new Dimension(24, 24));
		btnAddIsumo3.setPreferredSize(new Dimension(24, 24));
		btnAddIsumo3.setMinimumSize(new Dimension(24, 24));
		btnAddIsumo3.setMaximumSize(new Dimension(24, 24));
		btnAddIsumo3.setFocusable(false);
		btnAddIsumo3.setFocusPainted(false);
		btnAddIsumo3.setBounds(340, 254, 24, 24);
		getContentPane().add(btnAddIsumo3);
		btnAddIsumo3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//miCoordinador.miPantallaInsumos();
			}
		});

		lblInsumo4 = new JLabel("Insumo:");
		lblInsumo4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsumo4.setBounds(10, 289, 70, 24);
		getContentPane().add(lblInsumo4);

		cmbInsumo4 = new JComboBox<String>();
		cmbInsumo4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbInsumo4.setBounds(82, 289, 249, 23);
		cmbInsumo4.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo4.setSelectedIndex(0);
		getContentPane().add(cmbInsumo4);
		cmbInsumo4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (cmbInsumo3.getSelectedIndex() > 0) {
					//cmb.cargarInsumo(cmbInsumo4, cmbModelo);
					insumo3 = cmbInsumo3.getSelectedItem().toString();
					cmbInsumo4.removeItem(insumo);
					cmbInsumo4.removeItem(insumo2);
					cmbInsumo4.removeItem(insumo3);
					cmbInsumo4.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo4.setSelectedIndex(0);
					if (i >= 6) {
						//cmb.cargarInsumo(cmbInsumo5, cmbModelo);
						cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo5.setSelectedIndex(0);
						cmbInsumo6.removeAllItems();
						cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo6.setSelectedIndex(0);
					} else {
						cmbInsumo5.removeAllItems();
						cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo5.setSelectedIndex(0);
						cmbInsumo6.removeAllItems();
						cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo6.setSelectedIndex(0);
					}
				} else {
					cmbInsumo5.removeAllItems();
					cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo5.setSelectedIndex(0);
					cmbInsumo6.removeAllItems();
					cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo6.setSelectedIndex(0);
				}
			}
		});

		btnAddIsumo4 = new JButton("");
		btnAddIsumo4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddIsumo4.setIcon(new ImageIcon(PantallaNuevaImpresora.class.getResource("/com/controlStock/controlStock/icons/añadir-48px.png")));
		btnAddIsumo4.setToolTipText("Agregar nuevo insumo para el modelo de Impresora");
		btnAddIsumo4.setSize(new Dimension(24, 24));
		btnAddIsumo4.setPreferredSize(new Dimension(24, 24));
		btnAddIsumo4.setMinimumSize(new Dimension(24, 24));
		btnAddIsumo4.setMaximumSize(new Dimension(24, 24));
		btnAddIsumo4.setFocusable(false);
		btnAddIsumo4.setFocusPainted(false);
		btnAddIsumo4.setBounds(340, 289, 24, 24);
		getContentPane().add(btnAddIsumo4);
		btnAddIsumo4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//miCoordinador.miPantallaInsumos();
			}
		});

		lblInsumo5 = new JLabel("Insumo:");
		lblInsumo5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsumo5.setBounds(10, 324, 70, 24);
		getContentPane().add(lblInsumo5);

		cmbInsumo5 = new JComboBox<String>();
		cmbInsumo5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbInsumo5.setBounds(82, 324, 249, 23);
		cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo5.setSelectedIndex(0);
		getContentPane().add(cmbInsumo5);
		cmbInsumo5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (cmbInsumo4.getSelectedIndex() > 0) {
					//cmb.cargarInsumo(cmbInsumo5, cmbModelo);
					insumo4 = cmbInsumo4.getSelectedItem().toString();
					cmbInsumo5.removeItem(insumo);
					cmbInsumo5.removeItem(insumo2);
					cmbInsumo5.removeItem(insumo3);
					cmbInsumo5.removeItem(insumo4);
					cmbInsumo5.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo5.setSelectedIndex(0);
					if (i >= 7) {
						//cmb.cargarInsumo(cmbInsumo6, cmbModelo);
						cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo6.setSelectedIndex(0);
					} else {
						cmbInsumo6.removeAllItems();
						cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
						cmbInsumo6.setSelectedIndex(0);
					}

				} else {
					cmbInsumo6.removeAllItems();
					cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo6.setSelectedIndex(0);
				}
			}
		});

		btnAddIsumo5 = new JButton("");
		btnAddIsumo5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddIsumo5.setIcon(new ImageIcon(PantallaNuevaImpresora.class.getResource("/com/controlStock/controlStock/icons/añadir-48px.png")));
		btnAddIsumo5.setToolTipText("Agregar nuevo insumo para el modelo de Impresora");
		btnAddIsumo5.setSize(new Dimension(24, 24));
		btnAddIsumo5.setPreferredSize(new Dimension(24, 24));
		btnAddIsumo5.setMinimumSize(new Dimension(24, 24));
		btnAddIsumo5.setMaximumSize(new Dimension(24, 24));
		btnAddIsumo5.setFocusable(false);
		btnAddIsumo5.setFocusPainted(false);
		btnAddIsumo5.setBounds(340, 324, 24, 24);
		getContentPane().add(btnAddIsumo5);
		btnAddIsumo5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//miCoordinador.miPantallaInsumos();
			}
		});

		lblInsumo6 = new JLabel("Insumo:");
		lblInsumo6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsumo6.setBounds(10, 359, 70, 24);
		getContentPane().add(lblInsumo6);

		cmbInsumo6 = new JComboBox<String>();
		cmbInsumo6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbInsumo6.setBounds(82, 359, 249, 23);
		cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo6.setSelectedIndex(0);
		getContentPane().add(cmbInsumo6);
		cmbInsumo6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (cmbInsumo5.getSelectedIndex() > 0) {
					//cmb.cargarInsumo(cmbInsumo6, cmbModelo);
					insumo5 = cmbInsumo5.getSelectedItem().toString();
					cmbInsumo6.removeItem(insumo);
					cmbInsumo6.removeItem(insumo2);
					cmbInsumo6.removeItem(insumo3);
					cmbInsumo6.removeItem(insumo4);
					cmbInsumo6.removeItem(insumo5);
					cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo6.setSelectedIndex(0);
				} else {
					cmbInsumo6.removeAllItems();
					cmbInsumo6.insertItemAt("Seleccione un Insumo", 0);
					cmbInsumo6.setSelectedIndex(0);
				}
			}
		});

		btnAddIsumo6 = new JButton("");
		btnAddIsumo6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddIsumo6.setIcon(new ImageIcon(PantallaNuevaImpresora.class.getResource("/com/controlStock/controlStock/icons/añadir-48px.png")));
		btnAddIsumo6.setToolTipText("Agregar nuevo insumo para el modelo de Impresora");
		btnAddIsumo6.setSize(new Dimension(24, 24));
		btnAddIsumo6.setPreferredSize(new Dimension(24, 24));
		btnAddIsumo6.setMinimumSize(new Dimension(24, 24));
		btnAddIsumo6.setMaximumSize(new Dimension(24, 24));
		btnAddIsumo6.setFocusable(false);
		btnAddIsumo6.setFocusPainted(false);
		btnAddIsumo6.setBounds(340, 359, 24, 24);
		getContentPane().add(btnAddIsumo6);
		btnAddIsumo6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//miCoordinador.miPantallaInsumos();
			}
		});

		btnCancelar = new JButton("");
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCancelar.setBorder(null);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setFocusable(false);
		btnCancelar.setIcon(new ImageIcon(PantallaNuevaImpresora.class.getResource("/com/controlStock/controlStock/icons/cerrar-ventana-48px.png")));
		btnCancelar.setMaximumSize(new Dimension(48, 48));
		btnCancelar.setMinimumSize(new Dimension(48, 48));
		btnCancelar.setPreferredSize(new Dimension(48, 48));
		btnCancelar.setSize(new Dimension(48, 48));
		btnCancelar.setBounds(316, 393, 48, 48);
		getContentPane().add(btnCancelar);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limpiar();
				dispose();
			}
		});

		btnAceptar = new JButton("");
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAceptar.setIcon(new ImageIcon(PantallaNuevaImpresora.class.getResource("/com/controlStock/controlStock/icons/aceptar-48px.png")));
		btnAceptar.setFocusPainted(false);
		btnAceptar.setFocusable(false);
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setBounds(243, 393, 48, 48);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	/*	if (e.getSource() == btnAceptar) {
			if (cmbProveedor.getSelectedIndex() > 0) {
				if (cmbMarca.getSelectedIndex() > 0) {
					if (!txtSerie.getText().equals("")) {
						if (cmbModelo.getSelectedIndex() > 0) {
							if (cmbInsumo.getSelectedIndex() > 0) {
								String serie = txtSerie.getText();
								if(!miCoordinador.existeSerie(serie)) {
									miInsumoDTO();
									if (miCoordinador.agregarNuevaImpresora(miInsumo)) {
										JOptionPane.showMessageDialog(null, "Impresora agregada con exito");
										limpiar();
										dispose();
									}
								}else {
									JOptionPane.showMessageDialog(null, "El Numero de serie ingresado ya existe, Cambielo",
											"Advertencia", JOptionPane.ERROR_MESSAGE);
								}
								
							} else {
								JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un insumo",
										"Advertencia", JOptionPane.ERROR_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(null, "Debe seleccionar un modelo de impresora",
									"Advertencia", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Debe ingresar el numero de serie de la impresora",
								"Advertencia", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar la Marca de la impresora", "Advertencia",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar el Proveedor de la impresora", "Advertencia",
						JOptionPane.ERROR_MESSAGE);
			}
		}*/
	}

	/******************************************************************/

	private void limpiar() {
		cmbProveedor.setSelectedIndex(0);
		cmbMarca.setSelectedIndex(0);
		cmbModelo.removeAllItems();
		cmbInsumo.removeAllItems();
		cmbInsumo2.removeAllItems();
		cmbInsumo3.removeAllItems();
		cmbInsumo4.removeAllItems();
		cmbInsumo5.removeAllItems();
		cmbInsumo6.removeAllItems();
		cmbModelo.insertItemAt("Seleccione un Modelo", 0);
		cmbModelo.setSelectedIndex(0);
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
		txtSerie.setText("");
		i = 0;
	}

	/*public InsumosDTO miInsumoDTO() {

		String fecha = getFechaActual();

		miInsumo = new InsumosDTO();
		miInsumo.setIdProveedor(miCoordinador.idProveedor(cmbProveedor));
		miInsumo.setMarca(miCoordinador.idMarca(cmbMarca));
		miInsumo.setModelo(miCoordinador.idModeloCMB(cmbModelo));
		miInsumo.setNroSerie(txtSerie.getText().toUpperCase());
		miInsumo.setInsumo(cmbInsumo.getSelectedItem().toString());
		if (cmbInsumo2.getSelectedIndex() > 0) {
			miInsumo.setInsumo2(cmbInsumo2.getSelectedItem().toString());
		}
		if (cmbInsumo3.getSelectedIndex() > 0) {
			miInsumo.setInsumo2(cmbInsumo3.getSelectedItem().toString());
		}
		if (cmbInsumo4.getSelectedIndex() > 0) {
			miInsumo.setInsumo2(cmbInsumo4.getSelectedItem().toString());
		}
		if (cmbInsumo5.getSelectedIndex() > 0) {
			miInsumo.setInsumo2(cmbInsumo5.getSelectedItem().toString());
		}
		if (cmbInsumo6.getSelectedIndex() > 0) {
			miInsumo.setInsumo2(cmbInsumo6.getSelectedItem().toString());
		}
		miInsumo.setFechaIngreso(fecha);

		return miInsumo;
	}*/

	public static String getFechaActual() {
		Date fechaActual = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
		return formateador.format(fechaActual);
	}
	

}
