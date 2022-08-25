package com.controlStock.controlStock.igu.proveedores;

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
import java.awt.Cursor;
import javax.swing.JComboBox;

public class ModificarProveedor extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblModProveedor;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblEmail;
	private JLabel lblTelefono;
	private JLabel lblRaznSocial;
	private Coordinador miCoordinador;
	private JCheckBox chckbxHabilitado;
	private JComboBox<String> cmbProveedor;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	//CargaComboBox cmb = new CargaComboBox();

	public ModificarProveedor() {
		getContentPane().setMinimumSize(new Dimension(540, 250));
		setPreferredSize(new Dimension(540, 250));
		getContentPane().setPreferredSize(new Dimension(540, 250));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(540, 250));
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblModProveedor = new JLabel("Actualizar datos Proveedor");
		lblModProveedor.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblModProveedor.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblModProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblModProveedor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModProveedor.setBounds(0, 11, 524, 25);
		getContentPane().add(lblModProveedor);

		lblRaznSocial = new JLabel("Raz\u00F3n social: ");
		lblRaznSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRaznSocial.setBounds(10, 50, 75, 23);
		getContentPane().add(lblRaznSocial);

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
		lblEmail.setBounds(20, 120, 75, 23);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setToolTipText("Ingrese el Email del Proveedor");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setBounds(90, 121, 424, 25);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		btnAceptar = new JButton("");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setEnabled(false);
		btnAceptar.setIcon(new ImageIcon(ModificarProveedor.class.getResource("/com/controlStock/controlStock/icons/aceptar-48px.png")));
		btnAceptar.setFocusable(false);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setAlignmentX(0.5f);
		btnAceptar.setBounds(395, 157, 48, 48);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(ModificarProveedor.class.getResource("/com/controlStock/controlStock/icons/cerrar-ventana-48px.png")));
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
		btnCancelar.setBounds(466, 157, 48, 48);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);

		chckbxHabilitado = new JCheckBox("Habilitado");
		chckbxHabilitado.setEnabled(false);
		chckbxHabilitado.setFocusable(false);
		chckbxHabilitado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chckbxHabilitado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxHabilitado.setBounds(10, 160, 97, 23);
		getContentPane().add(chckbxHabilitado);

		cmbProveedor = new JComboBox<String>();
		cmbProveedor.setFocusable(false);
		cmbProveedor.setToolTipText("Seleccione El Proveedor a editar");
		cmbProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbProveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbProveedor.setBounds(90, 50, 424, 23);
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
				txtEmail.setEditable(true);
				txtTelefono.setEditable(true);
				int id = miCoordinador.idProveedor(cmbProveedor);
				ProveedoresDTO miProveedor = new ProveedoresDTO();
				miProveedor = miCoordinador.BuscarProveedor(id);
				txtEmail.setText(miProveedor.getEmail());
				txtTelefono.setText(miProveedor.getTelefono());
				btnAceptar.setEnabled(true);
				chckbxHabilitado.setEnabled(true);
				if (miProveedor.getFlagHabilitado() == 1) {
					chckbxHabilitado.setSelected(true);
				} else {
					chckbxHabilitado.setSelected(false);
				}
			} else {
				limpiar();
			}
		}

		if (e.getSource() == btnAceptar) {
			// logica de guardar
			if (cmbProveedor.getSelectedIndex() > 0) {// verifico que no este vacio el campo del nombre
				if (miCoordinador.actualizarProveedor(txtTelefono, txtEmail, cmbProveedor, chckbxHabilitado)) {// cargo
																												// en la
																												// BD la
																												// actualizacion
																												// del
					dispose();																					// Servicio
					JOptionPane.showMessageDialog(null, "Proveedor Actualizado con Exito");
					limpiar();
					
				} else {
					JOptionPane.showMessageDialog(null, "El Proveedor no se pudo Actualizar", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un proveedor para actualizarlo", "Advertencia",
						JOptionPane.ERROR_MESSAGE);
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
		txtEmail.setEditable(false);
		txtTelefono.setEditable(false);

		btnAceptar.setEnabled(false);
		chckbxHabilitado.setEnabled(false);
	}
}
