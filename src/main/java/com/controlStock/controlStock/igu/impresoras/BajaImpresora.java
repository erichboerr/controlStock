package com.controlStock.controlStock.igu.impresoras;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import com.controlStock.controlStock.logicaSistema.CargaComboBox;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import com.controlStock.controlStock.principal.Coordinador;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BajaImpresora extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblModelo;
	private JLabel lblMarca;
	private JLabel lblServicio;
	private JComboBox<String> cmbSerie;
	private JComboBox<String> cmbModelo;
	private JComboBox<String> cmbMarca;
	private JComboBox<String> cmbServicio;
	private Coordinador miCoordinador;
	private JLabel lblSerie;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	CargaComboBox cmb = new CargaComboBox();

	public BajaImpresora() {
		setPreferredSize(new Dimension(490, 280));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setMinimumSize(new Dimension(490, 280));
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblTitulo = new JLabel("Baja Impresora");
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setBounds(0, 11, 474, 25);
		getContentPane().add(lblTitulo);

		lblServicio = new JLabel("Servicio:");
		lblServicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblServicio.setBounds(10, 47, 75, 23);
		getContentPane().add(lblServicio);

		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarca.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMarca.setBounds(10, 81, 75, 23);
		getContentPane().add(lblMarca);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModelo.setBounds(10, 118, 75, 23);
		getContentPane().add(lblModelo);

		btnAceptar = new JButton("");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setIcon(new ImageIcon(BajaImpresora.class.getResource("/com/controlStock/controlStock/icons/aceptar-48px.png")));
		btnAceptar.setFocusable(false);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setAlignmentX(0.5f);
		btnAceptar.setBounds(350, 185, 48, 48);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(BajaImpresora.class.getResource("/com/controlStock/controlStock/icons/cerrar-ventana-48px.png")));
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
		btnCancelar.setBounds(416, 185, 48, 48);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);

		cmbServicio = new JComboBox<String>();
		cmbServicio.setFocusable(false);
		cmbServicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbServicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbServicio.setBounds(92, 47, 372, 23);
		getContentPane().add(cmbServicio);
		cmbServicio.insertItemAt("Seleccione un Servicio", 0);
		cmbServicio.setSelectedIndex(0);
		cmbServicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent ev) {
				cmb.cargarCmbServicio(cmbServicio);
				cmbServicio.insertItemAt("Seleccione un Servicio", 0);
				cmbServicio.setSelectedIndex(0);
				cmbMarca.removeAllItems();
				cmbMarca.insertItemAt("Seleccione una Marca", 0);
				cmbMarca.setSelectedIndex(0);
				cmbModelo.removeAllItems();
				cmbModelo.insertItemAt("Seleccione un Modelo", 0);
				cmbModelo.setSelectedIndex(0);
				cmbSerie.removeAllItems();
				cmbSerie.insertItemAt("Seleccione una Serie", 0);
				cmbSerie.setSelectedIndex(0);
			}
		});

		cmbMarca = new JComboBox<String>();
		cmbMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbMarca.setFocusable(false);
		cmbMarca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbMarca.setBounds(92, 81, 372, 23);
		getContentPane().add(cmbMarca);
		cmbMarca.insertItemAt("Seleccione una Marca", 0);
		cmbMarca.setSelectedIndex(0);
		cmbMarca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent ev) {
				if (cmbServicio.getSelectedIndex() > 0) {
					if (cmbMarca.getSelectedIndex() == 0) {
						cmb.cargarCmbMarcaParaDesasignar(cmbMarca, cmbServicio);
						cmbMarca.insertItemAt("Seleccione una Marca", 0);
						cmbMarca.setSelectedIndex(0);
						cmbModelo.removeAllItems();
						cmbModelo.insertItemAt("Seleccione un Modelo", 0);
						cmbModelo.setSelectedIndex(0);
						cmbSerie.removeAllItems();
						cmbSerie.insertItemAt("Seleccione una Serie", 0);
						cmbSerie.setSelectedIndex(0);
					}
				} else {
					cmbMarca.removeAllItems();
					cmbMarca.insertItemAt("Seleccione una Marca", 0);
					cmbMarca.setSelectedIndex(0);
					cmbModelo.removeAllItems();
					cmbModelo.insertItemAt("Seleccione un Modelo", 0);
					cmbModelo.setSelectedIndex(0);
					cmbSerie.removeAllItems();
					cmbSerie.insertItemAt("Seleccione una Serie", 0);
					cmbSerie.setSelectedIndex(0);
				}

			}
		});

		cmbModelo = new JComboBox<String>();
		cmbModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbModelo.setFocusable(false);
		cmbModelo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbModelo.setBounds(92, 118, 372, 23);
		getContentPane().add(cmbModelo);
		cmbModelo.insertItemAt("Seleccione un Modelo", 0);
		cmbModelo.setSelectedIndex(0);
		cmbModelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (cmbMarca.getSelectedIndex() > 0) {
					if (cmbModelo.getSelectedIndex() == 0) {
						cmb.cargarCmbModeloParaDesasignar(cmbMarca, cmbModelo, cmbServicio);
						cmbModelo.insertItemAt("Seleccione un Modelo", 0);
						cmbModelo.setSelectedIndex(0);
						cmbSerie.removeAllItems();
						cmbSerie.insertItemAt("Seleccione una Serie", 0);
						cmbSerie.setSelectedIndex(0);
					}

				} else {
					cmbModelo.removeAllItems();
					cmbModelo.insertItemAt("Seleccione un Modelo", 0);
					cmbModelo.setSelectedIndex(0);
					cmbSerie.removeAllItems();
					cmbSerie.insertItemAt("Seleccione una Serie", 0);
					cmbSerie.setSelectedIndex(0);
				}

			}
		});

		lblSerie = new JLabel("Serie:");
		lblSerie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSerie.setBounds(10, 151, 46, 23);
		getContentPane().add(lblSerie);

		cmbSerie = new JComboBox<String>();
		cmbSerie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbSerie.setFocusable(false);
		cmbSerie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbSerie.setBounds(92, 151, 372, 23);
		getContentPane().add(cmbSerie);
		cmbSerie.insertItemAt("Seleccione una Serie", 0);
		cmbSerie.setSelectedIndex(0);
		cmbSerie.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent ev) {
				if (cmbModelo.getSelectedIndex() > 0) {
					if (cmbSerie.getSelectedIndex() == 0) {
						cmb.cargarCmbSerieParaDesasignar(cmbModelo, cmbSerie, cmbServicio);
						cmbSerie.insertItemAt("Seleccione una Serie", 0);
						cmbSerie.setSelectedIndex(0);
					}
				} else {
					cmbSerie.removeAllItems();
					cmbSerie.insertItemAt("Seleccione una Serie", 0);
					cmbSerie.setSelectedIndex(0);
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/*if (e.getSource() == btnAceptar) {
			if (cmbServicio.getSelectedIndex() > 0) {
				if (cmbMarca.getSelectedIndex() > 0) {
					if (cmbModelo.getSelectedIndex() > 0) {
						if (cmbSerie.getSelectedIndex() > 0) {
							String nl = System.getProperty("line.separator");
							int resp = JOptionPane.showConfirmDialog(null, "Esta seguro de dar de baja la impresora. "
									+ nl + "Es irreversibe la acción de dar de baja");
							if (JOptionPane.OK_OPTION == resp) {
								if (miCoordinador.darDeBajaImpresora(cmbServicio, cmbMarca, cmbModelo, cmbSerie)) {
									limpiar();
									dispose();
									JOptionPane.showMessageDialog(null, "Impresora dada de baja");
								} else {
									JOptionPane.showMessageDialog(null, "No se pudo dar de baja la impresora ",
											"Advertencia", JOptionPane.ERROR_MESSAGE);
								}
							} else {
								limpiar();
								dispose();
								JOptionPane.showMessageDialog(null, "No se dio de baja la impresora ", "Advertencia",
										JOptionPane.ERROR_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(null, "Debe seleccionar un numero de serie de impresora ",
									"Advertencia", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Debe seleccionar un Modelo de Impresora ", "Advertencia",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una Marca de Impresora ", "Advertencia",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un Servicio ", "Advertencia",
						JOptionPane.ERROR_MESSAGE);
			}
		}*/

		if (e.getSource() == btnCancelar) {
			limpiar();
			dispose();
		}
	}

	private void limpiar() {
		cmbServicio.setSelectedIndex(0);
		cmbMarca.removeAllItems();
		cmbModelo.removeAllItems();
		cmbSerie.removeAllItems();
		cmbMarca.insertItemAt("Seleccione una Marca", 0);
		cmbMarca.setSelectedIndex(0);
		cmbModelo.insertItemAt("Seleccione un Modelo", 0);
		cmbModelo.setSelectedIndex(0);
		cmbSerie.insertItemAt("Seleccione una Serie", 0);
		cmbSerie.setSelectedIndex(0);
	}

}
