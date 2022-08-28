package com.controlStock.controlStock.igu.impresoras;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import com.controlStock.controlStock.principal.Coordinador;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class MarcaImpresora extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMarca;
	private JLabel lblNuevaMarca;
	private JLabel lblMarca;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private Coordinador miCoordinador;
	public static String marca;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public MarcaImpresora() {
		setPreferredSize(new Dimension(460, 170));
		setModal(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(460, 170));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblNuevaMarca = new JLabel("Nueva Marca");
		lblNuevaMarca.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNuevaMarca.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNuevaMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNuevaMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaMarca.setBounds(0, 11, 444, 25);
		getContentPane().add(lblNuevaMarca);

		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMarca.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMarca.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblMarca.setBounds(10, 47, 46, 23);
		getContentPane().add(lblMarca);

		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMarca.setToolTipText("Agregue la marca de la impresora");
		txtMarca.setBounds(59, 47, 375, 20);
		txtMarca.setColumns(10);
		getContentPane().add(txtMarca);

		btnAceptar = new JButton("");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setIcon(new ImageIcon(MarcaImpresora.class.getResource("/com/controlStock/controlStock/icons/aceptar-48px.png")));
		btnAceptar.setFocusable(false);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setAlignmentX(0.5f);
		btnAceptar.setBounds(315, 80, 48, 48);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(MarcaImpresora.class.getResource("/com/controlStock/controlStock/icons/cerrar-ventana-48px.png")));
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
		btnCancelar.setBounds(386, 80, 48, 48);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*if (e.getSource() == btnAceptar) {
			if (!txtMarca.getText().equals("")) {// verifico que no este vacio el campo del nombre
				if (!miCoordinador.existeMarca(txtMarca)) {// verifico que no exista ya cargado en BD
					if (miCoordinador.nuevaMarca(txtMarca)) {// cargo en la BD el nueva Marca
						JOptionPane.showMessageDialog(null, "Marca agregada con exito");
						marca = txtMarca.getText();
						txtMarca.setText("");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "La marca no se pudo agregar", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"La marca '" + txtMarca.getText() + "'  ya se encuentra cargada");
					txtMarca.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe agregar un Nombre a la marca", "Advertencia",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == btnCancelar) {
			limpiar();
			dispose();
		}*/
	}

	/*
	 * public String marca() { String marc = this.marca; return marc; }
	 */
	private void limpiar() {
		txtMarca.setText("");
	}

}
