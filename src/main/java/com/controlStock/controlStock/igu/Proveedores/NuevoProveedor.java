package com.controlStock.controlStock.igu.Proveedores;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import com.controlStock.controlStock.principal.Coordinador;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class NuevoProveedor extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNuevoProveedor;
	private JTextField txtRazonsocial;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblEmail;
	private JLabel lblTelefono;
	private JLabel lblRaznSocial;
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public NuevoProveedor() {
		getContentPane().setPreferredSize(new Dimension(540, 250));
		getContentPane().setMinimumSize(new Dimension(540, 250));
		setPreferredSize(new Dimension(540, 250));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(540, 250));
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblNuevoProveedor = new JLabel("Nuevo Proveedor");
		lblNuevoProveedor.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNuevoProveedor.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNuevoProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoProveedor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNuevoProveedor.setBounds(0, 11, 524, 25);
		getContentPane().add(lblNuevoProveedor);

		lblRaznSocial = new JLabel("Raz\u00F3n Social: ");
		lblRaznSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRaznSocial.setBounds(10, 50, 75, 23);
		getContentPane().add(lblRaznSocial);

		txtRazonsocial = new JTextField();
		txtRazonsocial.setToolTipText("Ingrese la Razon Social del Proveedor");
		txtRazonsocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRazonsocial.setBounds(90, 50, 424, 25);
		getContentPane().add(txtRazonsocial);
		txtRazonsocial.setColumns(10);

		lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefono.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTelefono.setBounds(10, 84, 75, 23);
		getContentPane().add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTelefono.setBounds(90, 84, 424, 25);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);

		lblEmail = new JLabel("E-Mail: ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(20, 118, 75, 23);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setToolTipText("Ingrese el Email del Proveedor");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setBounds(90, 119, 424, 25);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		btnAceptar = new JButton("");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setIcon(new ImageIcon(NuevoProveedor.class.getResource("/com/controlStock/controlStock/icons/aceptar-48px.png")));
		btnAceptar.setFocusable(false);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setAlignmentX(0.5f);
		btnAceptar.setBounds(395, 155, 48, 48);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(NuevoProveedor.class.getResource("/com/controlStock/controlStock/icons/cerrar-ventana-48px.png")));
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
		btnCancelar.setBounds(466, 155, 48, 48);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*if (e.getSource() == btnAceptar) {
			if (!txtRazonsocial.getText().equals("")) {// verifico que no este vacio el campo del nombre
				if (!miCoordinador.existeProveedor(txtRazonsocial)) {// verifico que no exista ya cargado en BD
					if (miCoordinador.nuevoProveedor(txtRazonsocial, txtTelefono, txtEmail)) {// cargo en la BD el nuevo
						dispose();																		// Servicio
						JOptionPane.showMessageDialog(null, "Proveedor agregado con exito");
						limpiar();
						
					} else {
						JOptionPane.showMessageDialog(null, "El Proveedor no se pudo agregar", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"El Proveedor:'" + txtRazonsocial.getText() + "'  ya se encuentra cargado", "Advertencia",
							JOptionPane.ERROR_MESSAGE);
					txtRazonsocial.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe agregar un Nombre al Proveedor", "Advertencia",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == btnCancelar) {
			limpiar();
			dispose();
		}*/
	}

	private void limpiar() {
		txtEmail.setText("");
		txtRazonsocial.setText("");
		txtTelefono.setText("");
	}
}
