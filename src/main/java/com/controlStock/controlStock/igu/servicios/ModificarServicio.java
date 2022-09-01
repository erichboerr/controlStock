package com.controlStock.controlStock.igu.servicios;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import com.controlStock.controlStock.logicaSistema.CargaComboBox;
import com.controlStock.controlStock.principal.Coordinador;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


public class ModificarServicio extends JDialog implements ActionListener {

		private static final long serialVersionUID = 1L;
		private JLabel lblTitulo;
		private JTextField txtServicio;
		private JButton btnCancelar;
		private JButton btnAceptar;
		private JLabel lblServicioNew;
		private Coordinador miCoordinador;
		private JComboBox<String> cmbServicio;
		private JLabel lblServicioOriginal;
		
		public void setCoodinador(Coordinador miCoordinador) {
			this.miCoordinador = miCoordinador;
		}

		CargaComboBox cmb = new CargaComboBox();		

		public ModificarServicio() {
			setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			setMinimumSize(new Dimension(540, 225));
			setResizable(false);
			setModal(true);
			setLocationRelativeTo(null);
			getContentPane().setLayout(null);

			lblTitulo = new JLabel("Actualizar datos Servicio");
			lblTitulo.setMinimumSize(new Dimension(530, 180));
			lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblTitulo.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblTitulo.setBounds(0, 11, 524, 25);
			getContentPane().add(lblTitulo);

			lblServicioOriginal = new JLabel("Servicio:");
			lblServicioOriginal.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblServicioOriginal.setBounds(10, 47, 75, 23);
			getContentPane().add(lblServicioOriginal);
			
			cmbServicio = new JComboBox<String>();
			cmbServicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cmbServicio.setFocusable(false);
			cmbServicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cmbServicio.setToolTipText("Seleccione servicio a Actualizar");
			cmbServicio.setBounds(94, 47, 420, 25);
			getContentPane().add(cmbServicio);
			cmbServicio.removeAll();
			cmb.cargarCmbServicio(cmbServicio);
			cmbServicio.insertItemAt("Seleccione un Servicio", 0);
			cmbServicio.setSelectedIndex(0);

			lblServicioNew = new JLabel("Servicio:");
			lblServicioNew.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblServicioNew.setBounds(10, 90, 75, 23);
			getContentPane().add(lblServicioNew);

			txtServicio = new JTextField();
			txtServicio.setToolTipText("Ingrese el nombre del servicio");
			txtServicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtServicio.setBounds(94, 90, 420, 25);
			getContentPane().add(txtServicio);
			txtServicio.setColumns(10);			

			btnAceptar = new JButton("");
			btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAceptar.setIcon(new ImageIcon(ModificarServicio.class.getResource("/com/controlStock/controlStock/icons/aceptar-48px.png")));
			btnAceptar.setFocusable(false);
			btnAceptar.setFocusPainted(false);
			btnAceptar.setContentAreaFilled(false);
			btnAceptar.setBorderPainted(false);
			btnAceptar.setBorder(null);
			btnAceptar.setAlignmentX(0.5f);
			btnAceptar.setBounds(403, 126, 48, 48);
			getContentPane().add(btnAceptar);
			btnAceptar.addActionListener(this);

			btnCancelar = new JButton("");
			btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnCancelar.setIcon(new ImageIcon(ModificarServicio.class.getResource("/com/controlStock/controlStock/icons/cerrar-ventana-48px.png")));
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
			btnCancelar.setBounds(466, 126, 48, 48);
			getContentPane().add(btnCancelar);
			btnCancelar.addActionListener(this);			
		}

		@Override
		public void actionPerformed(ActionEvent e) {				
			if (e.getSource() == btnAceptar) {
				// logica guardar
				if (!txtServicio.getText().equals("")) {// verifico que no este vacio el campo del nombre
					if (miCoordinador.actualizarCliente(txtServicio, cmbServicio)) {// cargo en la BD la actualizacion del
						dispose();														// Servicio
						JOptionPane.showMessageDialog(null, "Servicio Actualizado con Exito");
						txtServicio.setText("");
						
					} else {
						JOptionPane.showMessageDialog(null, "El servicio no se pudo Actualizar", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe agregar un Nombre al servicio para actualizarlo",
							"Advertencia", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (e.getSource() == btnCancelar) {
				limpiar();
				dispose();
			}
		}

		private void limpiar() {
			txtServicio.setText("");
			cmbServicio.removeAll();
			cmb.cargarCmbServicio(cmbServicio);
			cmbServicio.insertItemAt("Seleccione un Servicio", 0);
			cmbServicio.setSelectedIndex(0);

		}
	}
