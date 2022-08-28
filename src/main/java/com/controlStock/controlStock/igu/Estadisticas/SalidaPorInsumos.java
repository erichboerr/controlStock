package com.controlStock.controlStock.igu.Estadisticas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
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
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import com.controlStock.controlStock.connection.ConnectionDB;
import com.controlStock.controlStock.loggers.Logs;
import com.controlStock.controlStock.logicaSistema.CargaComboBox;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import com.controlStock.controlStock.principal.Coordinador;
import java.awt.Cursor;

public class SalidaPorInsumos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> cmbInsumo;
	private JLabel lblFechaDesde;
	private JLabel lblFechaHasta;
	private JLabel lblTitulo;
	private JCalendar calendarDesde;
	private JCalendar calendarHasta;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private int insumoId;
	private int anio;
	private int mes;
	private int dia;
	private Date fDesde = null;
	private Date fHasta = null;
	private String fechaDesde;
	private String fechaHasta;
	private Coordinador miCoordinador;
	private Connection conn;
	private ResultSet rs;
	private Statement st;
	private String total;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	CargaComboBox cmb = new CargaComboBox();

	public SalidaPorInsumos() {
		setMinimumSize(new Dimension(460, 385));
		setSize(new Dimension(460, 385));
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setAlwaysOnTop(false);
		setBounds(100, 100, 450, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setPreferredSize(new Dimension(450, 385));
		contentPanel.setSize(new Dimension(450, 385));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);

		lblTitulo = new JLabel("Salida de Insumsos");
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
		lblFechaDesde.setBounds(14, 89, 194, 25);
		contentPanel.add(lblFechaDesde);

		cmbInsumo = new JComboBox<String>();
		cmbInsumo.setFocusable(false);
		cmbInsumo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbInsumo.setBounds(10, 50, 424, 28);
		contentPanel.add(cmbInsumo);
		cmb.cargarInsum(cmbInsumo);
		cmbInsumo.insertItemAt("Seleccione un Insumo", 0);
		cmbInsumo.setSelectedIndex(0);

		lblFechaHasta = new JLabel("Seleccione Fecha Hasta");
		lblFechaHasta.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaHasta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaHasta.setBounds(218, 89, 204, 25);
		contentPanel.add(lblFechaHasta);

		calendarDesde = new JCalendar();
		calendarDesde.getDayChooser().getDayPanel().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarDesde.getYearChooser().getSpinner().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarDesde.getMonthChooser().getComboBox().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarDesde.setBounds(10, 125, 198, 155);
		contentPanel.add(calendarDesde);

		calendarHasta = new JCalendar();
		calendarHasta.getDayChooser().getDayPanel().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarHasta.getYearChooser().getSpinner().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarHasta.getMonthChooser().getComboBox().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendarHasta.setBounds(222, 125, 198, 155);
		contentPanel.add(calendarHasta);

		btnAceptar = new JButton("");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setIcon(new ImageIcon(
				SalidaPorInsumos.class.getResource("/com/controlStock/controlStock/icons/aceptar-48px.png")));
		btnAceptar.setFocusable(false);
		btnAceptar.setFocusPainted(false);
		btnAceptar.setContentAreaFilled(false);
		btnAceptar.setBorderPainted(false);
		btnAceptar.setBorder(null);
		btnAceptar.setAlignmentX(0.5f);
		btnAceptar.setBounds(320, 291, 48, 48);
		contentPanel.add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(
				SalidaPorInsumos.class.getResource("/com/controlStock/controlStock/icons/cerrar-ventana-48px.png")));
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
		btnCancelar.setBounds(386, 291, 48, 48);
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			if (cmbInsumo.getSelectedIndex() > 0) {
				insumoId = miCoordinador.insumoId(cmbInsumo);

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
						dispose();

						conn = ConnectionDB.getConnection();
						String sql = "SELECT sum(stkin.egreso) " + "FROM t_stockinsumo stkin WHERE fechaegreso >= '"
								+ fechaDesde + "' and fechaegreso <= '" + fechaHasta + "' and t_insumo_id = '"
								+ insumoId + "'";
						try {
							st = conn.createStatement();
							rs = st.executeQuery(sql);
							if (rs.next()) {
								total = rs.getString(1);
							}
						} catch (SQLException ex) {
							String error = "(PantallaInsumosMovimiento 307) Error al calcular el total de insumos consumidos: "
									+ ex.getMessage();
							miCoordinador.cargaErrores(error);
						}
						Map<String, Object> parametros = new HashMap<String, Object>();
						parametros.put("fechaDesde", fDesde);
						parametros.put("fechaHasta", fHasta);
						parametros.put("insumoId", insumoId);
						parametros.put("total", total);
						JasperReport reporte = (JasperReport) JRLoader
								.loadObject(getClass().getResource("/jrReportes/movimientoInsumos.jasper"));
						JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros,
								ConnectionDB.getConnection());
						JasperExportManager.exportReportToPdfFile(jasperPrint,
								"C:\\ControlStock\\reportes\\salidaPorInsumo-(" + getFecha() + ")-" + numeroAleatorio() + ".pdf");
						JasperViewer viewer = new JasperViewer(jasperPrint, false);
						viewer.setVisible(true);
						limpiar();

					} else {
						JOptionPane.showMessageDialog(null, "La Fecha DESDE no puede ser superior a la fecha HASTA",
								"Advertencia", JOptionPane.ERROR_MESSAGE);
					}

				} catch (JRException | ParseException ex) {
					String error = ex.getMessage();
					Logs miLogs = new Logs();
					miLogs.cargarArchivo(error);
					System.out.println("error al generar el reporte " + ex.getMessage());
				}

			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un Insumo para la estadistica", "Advertencia",
						JOptionPane.ERROR_MESSAGE);
			}

			if (e.getSource() == btnCancelar) {
				limpiar();
				dispose();
			}
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
