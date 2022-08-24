package com.controlStock.controlStock.igu.Proveedores;

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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Cursor;

public class BajaProveedor extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblBajaProveedor;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblEmail;
	private JLabel lblTelefono;
	private JLabel lblRaznSocial;
	private JCheckBox chckbxHabilitado;
	private Coordinador miCoordinador;
	private JComboBox<String> cmbProveedor;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	//CargaComboBox cmb = new CargaComboBox();

	public BajaProveedor() {
		getContentPane().setMinimumSize(new Dimension(540, 270));
		getContentPane().setPreferredSize(new Dimension(540, 270));
		setPreferredSize(new Dimension(540, 270));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(540, 270));
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblBajaProveedor = new JLabel("Baja Proveedor");
		lblBajaProveedor.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblBajaProveedor.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblBajaProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblBajaProveedor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBajaProveedor.setBounds(0, 11, 524, 25);
		getContentPane().add(lblBajaProveedor);

		lblRaznSocial = new JLabel("Raz\u00F3n social: ");
		lblRaznSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRaznSocial.setBounds(10, 50, 75, 23);
		getContentPane().add(lblRaznSocial);

		lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefono.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTelefono.setBounds(10, 94, 75, 23);
		getContentPane().add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setFocusable(false);
		txtTelefono.setEditable(false);
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTelefono.setBounds(90, 94, 425, 25);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);

		lblEmail = new JLabel("E-Mail: ");
		lblEmail.setBounds(20, 138, 75, 23);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFocusable(false);
		txtEmail.setEditable(false);
		txtEmail.setToolTipText("Ingrese el Email del Proveedor");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setBounds(90, 139, 425, 25);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		btnAceptar = new JButton("");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setIcon(new ImageIcon(BajaProveedor.class.getResource("/com/controlStock/controlStock/icons/aceptar-48px.png")));
		btnAceptar.setFocusable(false);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setAlignmentX(0.5f);
		btnAceptar.setBounds(396, 175, 48, 48);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(BajaProveedor.class.getResource("/com/controlStock/controlStock/icons/cerrar-ventana-48px.png")));
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
		btnCancelar.setBounds(467, 175, 48, 48);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);

		chckbxHabilitado = new JCheckBox("Habilitado");
		chckbxHabilitado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chckbxHabilitado.setEnabled(false);
		chckbxHabilitado.setFocusable(false);
		chckbxHabilitado.setAlignmentX(Component.CENTER_ALIGNMENT);
		chckbxHabilitado
				.setToolTipText("Para dar de alta debe ir a \"Actualizar Proveedor\" y tildar esta opci\u00F3n.");
		chckbxHabilitado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxHabilitado.setBounds(10, 186, 97, 23);
		getContentPane().add(chckbxHabilitado);

		cmbProveedor = new JComboBox<String>();
		cmbProveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbProveedor.setBounds(90, 50, 425, 23);
		getContentPane().add(cmbProveedor);
		//cmb.cargarCmbProveedor(cmbProveedor);
		cmbProveedor.insertItemAt("Seleccione un Proveedor", 0);
		cmbProveedor.setSelectedIndex(0);
		cmbProveedor.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*if (e.getSource() == cmbProveedor) {
			if (cmbProveedor.getSelectedIndex() > 0) {
				int id = miCoordinador.idProveedor(cmbProveedor);
				ProveedoresDTO miProveedor = new ProveedoresDTO();
				miProveedor = miCoordinador.BuscarProveedor(id);
				txtEmail.setText(miProveedor.getEmail());
				txtTelefono.setText(miProveedor.getTelefono());
				btnAceptar.setEnabled(true);
				if (miProveedor.getFlagHabilitado() == 1) {
					chckbxHabilitado.setSelected(true);
					chckbxHabilitado.setEnabled(true);
				} else {
					chckbxHabilitado.setSelected(false);
					chckbxHabilitado.setEnabled(false);
				}
			} else {
				limpiar();
			}
		}

		// logica de guardar
		if (e.getSource() == btnAceptar) {
			// logica de guardar
			if (!chckbxHabilitado.isEnabled()) {
				if (cmbProveedor.getSelectedIndex() > 0) {// verifico que no este vacio el campo del nombre
					if (miCoordinador.bajaProveedor(cmbProveedor, chckbxHabilitado)) {
						dispose();
						JOptionPane.showMessageDialog(null, "Proveedor dado de baja");
						limpiar();
						
					} else {
						JOptionPane.showMessageDialog(null, "El Proveedor no se pudo dar de baja", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un proveedor para actualizarlo",
							"Advertencia", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe destildar la opci�n 'HABILITADO' para darlo de baja",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource() == btnCancelar) {
			limpiar();
			dispose();
		}*/
	}

	private void limpiar() {
		//cmb.cargarCmbProveedor(cmbProveedor);
		cmbProveedor.insertItemAt("Seleccione un Proveedor", 0);
		cmbProveedor.setSelectedIndex(0);
		txtEmail.setText("");
		txtTelefono.setText("");
		chckbxHabilitado.setSelected(false);
		chckbxHabilitado.setEnabled(false);
		btnAceptar.setEnabled(false);
	}
}
