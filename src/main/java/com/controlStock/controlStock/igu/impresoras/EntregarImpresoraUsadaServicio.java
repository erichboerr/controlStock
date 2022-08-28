package com.controlStock.controlStock.igu.impresoras;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
//import logicaSistema.CargaComboBox;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import com.controlStock.controlStock.principal.Coordinador;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EntregarImpresoraUsadaServicio extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblModelo;
	private JLabel lblMarca;
	private JLabel lblServicio;
	private JComboBox<String> cmbModelo;
	private JComboBox<String> cmbMarca;
	private JComboBox<String> cmbServicio;
	private com.controlStock.controlStock.principal.Coordinador miCoordinador;
	private JLabel lblSerie;
	private JComboBox<String> cmbSerie;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	//CargaComboBox cmb = new CargaComboBox();

	public EntregarImpresoraUsadaServicio() {
		setPreferredSize(new Dimension(490, 290));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setMinimumSize(new Dimension(490, 290));
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblTitulo = new JLabel("Asignar Impresora usada al Servicio");
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setBounds(0, 11, 484, 25);
		getContentPane().add(lblTitulo);

		lblServicio = new JLabel("Servicio:");
		lblServicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblServicio.setBounds(10, 48, 75, 23);
		getContentPane().add(lblServicio);

		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarca.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMarca.setBounds(10, 82, 75, 23);
		getContentPane().add(lblMarca);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModelo.setBounds(10, 119, 75, 23);
		getContentPane().add(lblModelo);
		
		cmbServicio = new JComboBox<String>();
		cmbServicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbServicio.setFocusable(false);
		cmbServicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbServicio.setBounds(92, 48, 372, 23);
		getContentPane().add(cmbServicio);
		cmbServicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent ev) {
				//cmb.cargarCmbServicio(cmbServicio);
				cmbServicio.insertItemAt("Seleccione un Servicio", 0);
				cmbServicio.setSelectedIndex(0);
				
			}
		});		
		cmbServicio.insertItemAt("Seleccione un Servicio", 0);
		cmbServicio.setSelectedIndex(0);
		

		cmbMarca = new JComboBox<String>();
		cmbMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbMarca.setFocusable(false);
		cmbMarca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbMarca.setBounds(92, 82, 372, 23);
		getContentPane().add(cmbMarca);
		cmbMarca.insertItemAt("Seleccione una Marca", 0);
		cmbMarca.setSelectedIndex(0);
		cmbMarca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent ev) {
				if(cmbServicio.getSelectedIndex()>0) {
					//cmb.cargarCmbMarcaParaAsignarUsada(cmbMarca);
					cmbMarca.insertItemAt("Seleccione una Marca", 0);
					cmbMarca.setSelectedIndex(0);
					cmbModelo.removeAllItems();
					cmbModelo.insertItemAt("Seleccione un Modelo", 0);
					cmbModelo.setSelectedIndex(0);
					cmbSerie.insertItemAt("Seleccione una Serie", 0);  
					cmbSerie.setSelectedIndex(0);
				}else {
					cmbMarca.removeAllItems();
					cmbMarca.insertItemAt("Seleccione una Marca", 0);
					cmbMarca.setSelectedIndex(0);
				}
				
			}
		});

		cmbModelo = new JComboBox<String>();
		cmbModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbModelo.setFocusable(false);
		cmbModelo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbModelo.setBounds(92, 119, 372, 23);
		getContentPane().add(cmbModelo);
		cmbModelo.insertItemAt("Seleccione un Modelo", 0);
		cmbModelo.setSelectedIndex(0);
		cmbModelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent ev) {
				//cmb.cargarCmbModeloParaAsignarUsada(cmbMarca, cmbModelo);				
				cmbModelo.insertItemAt("Seleccione un Modelo", 0);  
				cmbModelo.setSelectedIndex(0);
			}
		});

		lblSerie = new JLabel("Serie:");
		lblSerie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSerie.setBounds(10, 152, 46, 23);
		getContentPane().add(lblSerie);

		cmbSerie = new JComboBox<String>();
		cmbSerie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbSerie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbSerie.setBounds(92, 153, 372, 22);
		cmbSerie.setFocusable(false);
		getContentPane().add(cmbSerie);
		cmbSerie.insertItemAt("Seleccione una Serie", 0);  
		cmbSerie.setSelectedIndex(0);
		cmbSerie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent ev) {
				//cmb.cargarCmbSerieParaAsignarUsada(cmbModelo, cmbSerie);	
				cmbSerie.insertItemAt("Seleccione una Serie", 0);  
				cmbSerie.setSelectedIndex(0);
				
			}
		});
		
		btnAceptar = new JButton("");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setIcon(
				new ImageIcon(EntregarImpresoraUsadaServicio.class.getResource("/com/controlStock/controlStock/icons/aceptar-48px.png")));
		btnAceptar.setFocusable(false);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setAlignmentX(0.5f);
		btnAceptar.setBounds(350, 190, 48, 48);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(EntregarImpresoraUsadaServicio.class.getResource("/com/controlStock/controlStock/icons/cerrar-ventana-48px.png")));
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
		btnCancelar.setBounds(416, 190, 48, 48);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/*if (e.getSource() == btnAceptar) {			
					if (cmbServicio.getSelectedIndex() > 0) {
						if (cmbMarca.getSelectedIndex() > 0) {
							if (cmbModelo.getSelectedIndex() > 0) {
								if (cmbSerie.getSelectedIndex() > 0) {									
									if (miCoordinador.asignarImpresoraUsadaAlServicio(cmbServicio, cmbMarca, cmbModelo,
											cmbSerie)) {
										dispose();
										JOptionPane.showMessageDialog(null, "Impresora asignada al servicio: "
												+ cmbServicio.getSelectedItem().toString());
										limpiar();

									} else {
										JOptionPane.showMessageDialog(null, "No se pudo asignar la impresora ",
												"Advertencia", JOptionPane.ERROR_MESSAGE);
									}
								} else {
									JOptionPane.showMessageDialog(null,
											"Debe seleccionar un numero de serie de impresora ", "Advertencia",
											JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Debe seleccionar un Modelo de Impresora ",
										"Advertencia", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Debe seleccionar una Marca de Impresora ",
									"Advertencia", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Debe seleccionar un Servicio ", "Advertencia",
								JOptionPane.ERROR_MESSAGE);
					}	
			}*/
		
	if(e.getSource()==btnCancelar){
		limpiar();
		dispose();
	}

	}

	private void limpiar() {
		cmbServicio.setSelectedIndex(0);
		cmbMarca.removeAllItems();
		cmbModelo.removeAllItems();
		cmbMarca.insertItemAt("Seleccione una Marca", 0);
		cmbMarca.setSelectedIndex(0);
		cmbModelo.insertItemAt("Seleccione un Modelo", 0);
		cmbModelo.setSelectedIndex(0);
	}
}
