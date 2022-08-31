package com.controlStock.controlStock.igu.Estadisticas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import com.toedter.calendar.JCalendar;
import com.controlStock.controlStock.connection.ConnectionDB;
import com.controlStock.controlStock.logicaSistema.CargaComboBox;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import com.controlStock.controlStock.principal.Coordinador;
import java.awt.Cursor;

public class ConsumidoPeriodo extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblFechaDesde;
	private JLabel lblFechaHasta;
	private JLabel lblTitulo;
	private JCalendar calendarDesde;
	private JCalendar calendarHasta;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private int anio;
	private int mes;
	private int dia;
	private Date fDesde = null;
	private Date fHasta = null;
	private String fechaDesde;
	private String fechaHasta;
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	CargaComboBox cmb = new CargaComboBox();

	public ConsumidoPeriodo() {
		setMaximumSize(new Dimension(460, 350));
		setMinimumSize(new Dimension(460, 350));
		setSize(new Dimension(460, 350));
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setAlwaysOnTop(false);
		setBounds(100, 100, 450, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setMinimumSize(new Dimension(450, 350));
		contentPanel.setMaximumSize(new Dimension(450, 350));
		contentPanel.setPreferredSize(new Dimension(450, 350));
		contentPanel.setSize(new Dimension(450, 350));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);

		lblTitulo = new JLabel("Consumo en el Periodo");
		lblTitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setBounds(0, 11, 444, 28);
		contentPanel.add(lblTitulo);

		lblFechaDesde = new JLabel("Seleccione Fecha Desde");
		lblFechaDesde.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDesde.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblFechaDesde.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaDesde.setBounds(10, 50, 194, 25);
		contentPanel.add(lblFechaDesde);

		lblFechaHasta = new JLabel("Seleccione Fecha Hasta");
		lblFechaHasta.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaHasta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaHasta.setBounds(220, 50, 204, 25);
		contentPanel.add(lblFechaHasta);

		calendarDesde = new JCalendar();
		calendarDesde.getDayChooser().getDayPanel().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarDesde.getYearChooser().getSpinner().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarDesde.getMonthChooser().getComboBox().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarDesde.setBounds(10, 90, 198, 155);
		contentPanel.add(calendarDesde);

		calendarHasta = new JCalendar();
		calendarHasta.getDayChooser().getDayPanel().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarHasta.getYearChooser().getSpinner().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarHasta.getMonthChooser().getComboBox().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarHasta.setBounds(222, 90, 198, 155);
		contentPanel.add(calendarHasta);

		btnAceptar = new JButton("");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setIcon(new ImageIcon(SalidaPorInsumos.class.getResource("/com/controlStock/controlStock/icons/aceptar-48px.png")));
		btnAceptar.setFocusable(false);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setAlignmentX(0.5f);
		btnAceptar.setBounds(320, 256, 48, 48);
		contentPanel.add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar
				.setIcon(new ImageIcon(SalidaPorInsumos.class.getResource("/com/controlStock/controlStock/icons/cerrar-ventana-48px.png")));
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
		btnCancelar.setBounds(386, 256, 48, 48);
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
				anio = calendarDesde.getCalendar().get(Calendar.YEAR);
				mes = calendarDesde.getCalendar().get(Calendar.MARCH) + 1;
				dia = calendarDesde.getCalendar().get(Calendar.DAY_OF_MONTH);
				fechaDesde = (anio + "-" + mes + "-" + dia);

				anio = calendarHasta.getCalendar().get(Calendar.YEAR);
				mes = calendarHasta.getCalendar().get(Calendar.MARCH) + 1;
				dia = calendarHasta.getCalendar().get(Calendar.DAY_OF_MONTH);
				fechaHasta = (anio + "-" + mes + "-" + dia);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

				try {
					fDesde = formatter.parse(fechaDesde);
					fHasta = formatter.parse(fechaHasta);
					if (fDesde.before(fHasta)) {
						Map<String, Object> parametros = new HashMap<String, Object>();
						parametros.put("fechaDesde", fDesde);
						parametros.put("fechaHasta", fHasta);
						JasperReport reporte = (JasperReport) JRLoader
								.loadObject(getClass().getResource("/com/controlStock/controlStock/jrReportes/ConsumoSeleccion.jasper"));
						JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros,
								ConnectionDB.getConnection());
						JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\ControlStock\\reportes\\ConsumoEnPeriodo-("
								+ getFecha() + ")-" + numeroAleatorio() + ".pdf");
						JasperViewer viewer = new JasperViewer(jasperPrint, false);
						viewer.setVisible(true);
						dispose();
						limpiar();
					} else {
						JOptionPane.showMessageDialog(null, "La Fecha DESDE no puede ser superior a la fecha HASTA",
								"Advertencia", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ez) {

					String error = "(PantallaInsumosMovimiento 274) : " + ez.getMessage();
					miCoordinador.cargaErrores(error);
				}
			
		}

		if (e.getSource() == btnCancelar) {
			limpiar();
			dispose();
		}

	}

	private void limpiar() {	
	}

	private static String getFecha() {
		Date fechaActual = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yy");
		return formateador.format(fechaActual);
	}

	private int numeroAleatorio() {
		int valorEntero = (int) Math.floor(Math.random() * (999 - 1 + 1) + 1);
		return valorEntero;
	}
}
