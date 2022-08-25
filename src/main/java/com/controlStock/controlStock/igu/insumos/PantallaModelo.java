package com.controlStock.controlStock.igu.insumos;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.border.BevelBorder;

//import logicaSistema.CargaComboBox;
import com.controlStock.controlStock.principal.Coordinador;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaModelo extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtModelo;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblModelo;
	private JLabel lblNuevoModelo;
	private Coordinador miCoordinador;
	private JComboBox<String> cmbMarca;
	private JLabel lblMarca;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	//CargaComboBox cmb = new CargaComboBox();

	public PantallaModelo() {
		setResizable(false);
		getContentPane().setMinimumSize(new Dimension(460, 200));
		setSize(new Dimension(460, 200));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(460, 200));
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblNuevoModelo = new JLabel("Nuevo Modelo");
		lblNuevoModelo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNuevoModelo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNuevoModelo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNuevoModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoModelo.setBounds(0, 11, 444, 25);
		getContentPane().add(lblNuevoModelo);

		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarca.setBounds(10, 47, 46, 23);
		getContentPane().add(lblMarca);

		cmbMarca = new JComboBox<String>();
		cmbMarca.setToolTipText("Seleccione una Marca");
		cmbMarca.setFocusable(false);
		cmbMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbMarca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbMarca.setBounds(59, 47, 375, 25);
		getContentPane().add(cmbMarca);
		cmbMarca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargarCombo();
			}
		});
		cargarCombo();

		lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModelo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblModelo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblModelo.setBounds(10, 80, 46, 23);
		getContentPane().add(lblModelo);

		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtModelo.setToolTipText("Agregue el modelo de la impresora");
		txtModelo.setBounds(59, 80, 375, 20);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);

		btnAceptar = new JButton("");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setIcon(new ImageIcon(PantallaModelo.class.getResource("/com/controlStock/controlStock/icons/aceptar-48px.png")));
		btnAceptar.setFocusable(false);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setAlignmentX(0.5f);
		btnAceptar.setBounds(315, 111, 48, 48);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(PantallaModelo.class.getResource("/com/controlStock/controlStock/icons/cerrar-ventana-48px.png")));
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
		btnCancelar.setBounds(386, 111, 48, 48);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*if (e.getSource() == btnAceptar) {
			if (!txtModelo.getText().equals("")) {// verifico que no este vacio el campo del nombre
				if (!miCoordinador.existeModelo(txtModelo)) {// verifico que no exista ya cargado en BD
					if (miCoordinador.nuevoModelo(txtModelo, cmbMarca)) {// cargo en la BD el nueva Marca
						dispose();
						JOptionPane.showMessageDialog(null, "Modelo agregado con exito");
						limpiar();
						
					} else {
						JOptionPane.showMessageDialog(null, "La marca no se pudo agregar", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"El Modelo '" + txtModelo.getText() + "'  ya se encuentra cargado");
					txtModelo.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe agregar un Nombre al Modelo", "Advertencia",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == btnCancelar) {
			limpiar();
			dispose();
		}*/
	}

	private void cargarCombo() {
		//cmb.cargarCmbMarca(cmbMarca);
	}

	private void limpiar() {
		txtModelo.setText("");
		//cmb.cargarCmbMarca(cmbMarca);
	}
}
