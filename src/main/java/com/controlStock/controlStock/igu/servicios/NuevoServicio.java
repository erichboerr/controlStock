package com.controlStock.controlStock.igu.servicios;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

public class NuevoServicio extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNuevoCliente;
	private JTextField txtServicio;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblServicio;
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public NuevoServicio() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(540, 190));
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblNuevoCliente = new JLabel("Nuevo Servico");
		lblNuevoCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNuevoCliente.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNuevoCliente.setBounds(0, 11, 534, 25);
		getContentPane().add(lblNuevoCliente);

		lblServicio = new JLabel("Servicio: ");
		lblServicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblServicio.setBounds(10, 50, 59, 23);
		getContentPane().add(lblServicio);

		txtServicio = new JTextField();
		txtServicio.setToolTipText("Ingrese la Razon Social del Proveedor");
		txtServicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtServicio.setBounds(70, 49, 444, 25);
		getContentPane().add(txtServicio);
		txtServicio.setColumns(10);

		btnAceptar = new JButton("");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setIcon(new ImageIcon(NuevoServicio.class.getResource("/com/controlStock/controlStock/icons/aceptar-48px.png")));
		btnAceptar.setFocusable(false);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setAlignmentX(0.5f);
		btnAceptar.setBounds(411, 93, 48, 48);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(NuevoServicio.class.getResource("/com/controlStock/controlStock/icons/cerrar-ventana-48px.png")));
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
		btnCancelar.setBounds(466, 93, 48, 48);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			/*if (!txtServicio.getText().equals("")) {// verifico que no este vacio el campo del nombre
				if (!miCoordinador.existeCliente(txtServicio)) {// verifico que no exista ya cargado en BD
					if (miCoordinador.nuevoCliente(txtServicio)) {// cargo en la BD el nuevo Servicio
						JOptionPane.showMessageDialog(null, "Servicio agregado con exito");
						txtServicio.setText("");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "El servicio no se pudo agregar", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"El servicio ' " + txtServicio.getText() + "'  ya se encuentra cargado");
					txtServicio.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe agregar un Nombre al servicio", "Advertencia",
						JOptionPane.ERROR_MESSAGE);
			}*/

		}

		if (e.getSource() == btnCancelar) {
			txtServicio.setText("");
			dispose();

		}

	}

}
