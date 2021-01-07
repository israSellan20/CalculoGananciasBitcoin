package vista;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import controlador.panelImagen;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;


public class Gui_Bitcoin extends JFrame {

	private panelImagen p;
	private JTextField txfPrecioActual;
	private JTextField txfPrecioComprado;
	private JTextField txfCantidadComprado;
	private JLabel lblNeto;
	private JLabel lblRetorno;
	private JButton btnNewButton;
	private JButton btnLimpiarDatos;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Gui_Bitcoin frame = new Gui_Bitcoin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui_Bitcoin() {
		initContentPane();
		initLabels(); 
		initTextFields();
		initButtons();	
	}
	
	
	private void initContentPane() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p = new panelImagen();
		setBounds(100, 100, 684, 800);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		setResizable(false); //No se permite maximizar ni manejar el ancho y largo del JFrame
		setLocationRelativeTo(null);
	}
	
	//Se inicializan los labels
	private void initLabels() {
		JLabel lblNewLabel = new JLabel("Calculo ganancias Bitcoin");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 44));
		lblNewLabel.setBounds(144, 10, 386, 87);
		p.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Precio actual del bitcoin: ");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 26));
		lblNewLabel_1.setBounds(30, 152, 231, 47);
		p.add(lblNewLabel_1);
		
		JLabel lblPrecioDelBitcoin = new JLabel("Precio del bitcoin comprado(en dolares):");
		lblPrecioDelBitcoin.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 26));
		lblPrecioDelBitcoin.setBounds(30, 252, 368, 47);
		p.add(lblPrecioDelBitcoin);
		
		JLabel lblCantidadDeBitcoins = new JLabel("Cantidad de bitcoins comprados(en dolares): ");
		lblCantidadDeBitcoins.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 26));
		lblCantidadDeBitcoins.setBounds(30, 352, 409, 47);
		p.add(lblCantidadDeBitcoins);
		
		JLabel lblGananciasNeta = new JLabel("Ganancias o perdidas netas:");
		lblGananciasNeta.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 26));
		lblGananciasNeta.setBounds(30, 452, 259, 47);
		p.add(lblGananciasNeta);
		
		JLabel lblPorcentajeDeRetorno = new JLabel("Porcentaje de retorno: ");
		lblPorcentajeDeRetorno.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 26));
		lblPorcentajeDeRetorno.setBounds(30, 552, 231, 47);
		p.add(lblPorcentajeDeRetorno);
		
		lblRetorno = new JLabel("");
		lblRetorno.setForeground(Color.RED);
		lblRetorno.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblRetorno.setBounds(244, 562, 171, 26);
		p.add(lblRetorno);
		
		lblNeto = new JLabel("");
		lblNeto.setForeground(Color.RED);
		lblNeto.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNeto.setBounds(290, 462, 390, 26);
		p.add(lblNeto);
		
	}
	
	//Se inicializan los textfields
	private void initTextFields() {
		txfPrecioActual = new JTextField();
		txfPrecioActual.setBackground(new Color(255, 255, 255));
		txfPrecioActual.setToolTipText("");
		txfPrecioActual.setBounds(267, 167, 131, 19);
		p.add(txfPrecioActual);
		txfPrecioActual.setColumns(10);
		
		txfPrecioComprado = new JTextField();
		txfPrecioComprado.setToolTipText("");
		txfPrecioComprado.setColumns(10);
		txfPrecioComprado.setBackground(Color.WHITE);
		txfPrecioComprado.setBounds(408, 270, 131, 19);
		p.add(txfPrecioComprado);
		
		txfCantidadComprado = new JTextField();
		txfCantidadComprado.setToolTipText("");
		txfCantidadComprado.setColumns(10);
		txfCantidadComprado.setBackground(Color.WHITE);
		txfCantidadComprado.setBounds(446, 370, 131, 19);
		p.add(txfCantidadComprado);
	}
	
	
	//Se inicializan los buttons
	private void initButtons() {
		btnNewButton = new JButton("Calcular");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 19));
		btnNewButton.setBounds(349, 699, 131, 33);
		p.add(btnNewButton);
		
		btnLimpiarDatos = new JButton("Limpiar datos");
		btnLimpiarDatos.setFont(new Font("Arial", Font.BOLD, 19));
		btnLimpiarDatos.setBounds(174, 699, 171, 33);
		btnLimpiarDatos.setEnabled(false);
		p.add(btnLimpiarDatos);
	}

	//Metodos Getter y Setter
	public JTextField getTxfPrecioActual() {
		return txfPrecioActual;
	}

	public void setTxfPrecioActual(JTextField txfPrecioActual) {
		this.txfPrecioActual = txfPrecioActual;
	}

	public JTextField getTxfPrecioComprado() {
		return txfPrecioComprado;
	}

	public void setTxfPrecioComprado(JTextField txfPrecioComprado) {
		this.txfPrecioComprado = txfPrecioComprado;
	}

	public JTextField getTxfCantidadComprado() {
		return txfCantidadComprado;
	}

	public void setTxfCantidadComprado(JTextField txfCantidadComprado) {
		this.txfCantidadComprado = txfCantidadComprado;
	}

	public JLabel getLblNeto() {
		return lblNeto;
	}

	public void setLblNeto(JLabel lblNeto) {
		this.lblNeto = lblNeto;
	}

	public JLabel getLblRetorno() {
		return lblRetorno;
	}

	public void setLblRetorno(JLabel lblRetorno) {
		this.lblRetorno = lblRetorno;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JButton getBtnLimpiarDatos() {
		return btnLimpiarDatos;
	}

	public void setBtnLimpiarDatos(JButton btnLimpiarDatos) {
		this.btnLimpiarDatos = btnLimpiarDatos;
	}

	public panelImagen getP() {
		return p;
	}

	public void setP(panelImagen p) {
		this.p = p;
	}
	
	
	
}
