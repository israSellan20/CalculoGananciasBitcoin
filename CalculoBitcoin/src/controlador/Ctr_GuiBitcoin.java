package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

import modelo.DatosBitcoin;
import vista.Gui_Bitcoin;

public class Ctr_GuiBitcoin implements ActionListener,  KeyListener{
	
	private Gui_Bitcoin gui;
	private DatosBitcoin datos;
	
	public Ctr_GuiBitcoin() {}
	
	public Ctr_GuiBitcoin(Gui_Bitcoin gui, DatosBitcoin datos) {
		this.gui = gui;
		this.datos = datos;
		addListeners();
	}
	
	//Agrega los escuchadores necesarios
	private void addListeners() {
		this.gui.getBtnNewButton().addActionListener(this);
		this.gui.getBtnLimpiarDatos().addActionListener(this);
		this.gui.getTxfCantidadComprado().addKeyListener(this);
		this.gui.getTxfPrecioActual().addKeyListener(this);
		this.gui.getTxfPrecioComprado().addKeyListener(this);
		this.gui.getRiFondoBitcoin().addActionListener(this);
		this.gui.getRiFondoTheta().addActionListener(this);
		this.gui.getRiFondoVechain().addActionListener(this);
		this.gui.getRiFondoDoge().addActionListener(this);
	}
	
	//Limpia los datos de los textfields dejandolos todo en blanco
	private void limpiarDatos() {
		this.gui.getTxfPrecioActual().setText("");
		this.gui.getTxfPrecioComprado().setText("");
		this.gui.getTxfCantidadComprado().setText("");
	}
	
	//Guarda los datos en la clase DatosBitcoin del paquete modelo
	private void guardarDatos() {
		this.datos.setValorActual(Float.parseFloat(this.gui.getTxfPrecioActual().getText()));
		this.datos.setValorComprado(Float.parseFloat(this.gui.getTxfPrecioComprado().getText()));
		this.datos.setCantidadComprado(Float.parseFloat(this.gui.getTxfCantidadComprado().getText()));
		
		procesarGananciasNetas(); 
		procesarPorcentajeRetorno();
	}
	
	//Calcula las ganacias netas y muestra mensaje por pantalla los resultados
	private void procesarGananciasNetas() {
		if(this.datos.calcularGananciasNetas() > 0.0000000 && this.datos.calcularGananciasNetas() < 1) {
		DecimalFormat formato1 = new DecimalFormat("0.00000");
		this.gui.getLblNeto().setForeground(Color.green);
		this.gui.getLblNeto().setText("Usted a ganado "+(String.valueOf(formato1.format(this.datos.calcularGananciasNetas()))+" dolares!!"));
		
		}
		
		//Si las ganancias netas son iguales o superiores a 1 dolar
		else if(this.datos.calcularGananciasNetas() >= 1) {
			DecimalFormat formato1 = new DecimalFormat("0.00"); // Muestra solo 2 decimales
			this.gui.getLblNeto().setForeground(Color.green);
			this.gui.getLblNeto().setFont(new Font("Arial Black", Font.PLAIN, 15));
			this.gui.getLblNeto().setText("Usted a ganado "+(String.valueOf(formato1.format(this.datos.calcularGananciasNetas()))+" dolares!!"));
		}
		
		//Si las ganacia neta es igual a cero
		else if(this.datos.calcularGananciasNetas() == 0) {
			DecimalFormat formato1 = new DecimalFormat("0.00");
			this.gui.getLblNeto().setForeground(Color.gray);
			this.gui.getLblNeto().setFont(new Font("Arial Black", Font.PLAIN, 15));
			this.gui.getLblNeto().setText("No ha ganado ni perdido, tiene "+
			(String.valueOf(formato1.format(this.datos.calcularGananciasNetas()))+" dolares "));
		}
		
		//Si hay perdida entre cantidades menores a 0 hasta -1
		else if(this.datos.calcularGananciasNetas() < 0.00000 && this.datos.calcularGananciasNetas() > -1 ) {
			DecimalFormat formato1 = new DecimalFormat("0.00000");//Al ser perdidas minimas, se muestra por pantalla
			this.gui.getLblNeto().setForeground(Color.red);
			this.gui.getLblNeto().setText("Usted va perdiendo "+(String.valueOf(formato1.format(this.datos.calcularGananciasNetas()))
					+" dolares"));
		}
		
		
		else {
			DecimalFormat formato1 = new DecimalFormat("0.00");
			this.gui.getLblNeto().setForeground(Color.red);
			this.gui.getLblNeto().setText("Usted va perdiendo "+(String.valueOf(formato1.format(this.datos.calcularGananciasNetas()))
					+" dolares"));
		}
	}
	
	
	private void procesarPorcentajeRetorno(){
		
		//Si las ganancias netas son entre 0 y 1 dolar
		if(this.datos.calcularGananciasNetas() > 0 && this.datos.calcularGananciasNetas() < 1) {
			DecimalFormat formato1 = new DecimalFormat("0.00000");
			this.gui.getLblRetorno().setForeground(Color.green);
			this.gui.getLblRetorno().setText((String.valueOf(formato1.format(this.datos.calcularPorcentajeRetorno()))+"%"));/**LLama el metodo calcularProcentajeRetorno()
																																para calcular el procentaje de retorno de nuestra
																																inversion y muestra ese porcentaje por 
																																pantalla
																																*/
			
			}
		
		//Si las ganancias netas son mayores o iguales de 1 dolar en adelante
		else if(this.datos.calcularGananciasNetas() >= 1) {
			DecimalFormat formato1 = new DecimalFormat("0.00");
			this.gui.getLblRetorno().setForeground(Color.green);
			this.gui.getLblRetorno().setText((String.valueOf(formato1.format(this.datos.calcularPorcentajeRetorno()))+"%"));
		}
		
		//Si las ganancias netas son iguales a cero
		else if(this.datos.calcularGananciasNetas() == 0) {
			DecimalFormat formato1 = new DecimalFormat("0.00");
			this.gui.getLblRetorno().setForeground(Color.gray);
			this.gui.getLblRetorno().setText((String.valueOf(formato1.format(this.datos.calcularPorcentajeRetorno()))+"%"));
		}
		
		//Si las ganancias netas son entre 0 y -1 dolar
		else if(this.datos.calcularGananciasNetas() < 0.00000 && this.datos.calcularGananciasNetas() > -1) {
			DecimalFormat formato1 = new DecimalFormat("0.00000");
			this.gui.getLblRetorno().setForeground(Color.red);
			this.gui.getLblRetorno().setText((String.valueOf(formato1.format(this.datos.calcularPorcentajeRetorno()))+"%"));
		}
			
		//Si las perdidas netas son menores a 1 dolar
		else {
			DecimalFormat formato1 = new DecimalFormat("0.00");
			this.gui.getLblRetorno().setForeground(Color.red);
			this.gui.getLblRetorno().setText((String.valueOf(formato1.format(this.datos.calcularPorcentajeRetorno()))+"%"));
		}
	}

	private void fondoBitcoin() {
		Gui_Bitcoin ventana = new Gui_Bitcoin();
		new Ctr_GuiBitcoin(ventana, new DatosBitcoin());
		ventana.setVisible(true);
		
		ventana.getTxfPrecioActual().setText((gui.getTxfPrecioActual().getText()));
		ventana.getTxfPrecioComprado().setText((gui.getTxfPrecioComprado().getText())); 
		ventana.getTxfCantidadComprado().setText((gui.getTxfCantidadComprado().getText())); 
		ventana.getLblNeto().setText(gui.getLblNeto().getText()); 
		ventana.getLblRetorno().setText(gui.getLblRetorno().getText()); 
		ventana.getLblNeto().setForeground(gui.getLblNeto().getForeground());
		ventana.getLblRetorno().setForeground(gui.getLblRetorno().getForeground());
		
		gui.dispose();
	}
	
	private void fondoTheta() {
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/Theta.png"));
		Gui_Bitcoin ventana = new Gui_Bitcoin(new panelImagen(imagenFondo));
		new Ctr_GuiBitcoin(ventana, new DatosBitcoin());
		ventana.setVisible(true);	
		
		ventana.getRiFondoTheta().setSelected(true);
		ventana.getRiFondoTheta().setEnabled(false);
		
		ventana.getTxfPrecioActual().setText((gui.getTxfPrecioActual().getText()));
		ventana.getTxfPrecioComprado().setText((gui.getTxfPrecioComprado().getText())); 
		ventana.getTxfCantidadComprado().setText((gui.getTxfCantidadComprado().getText())); 
		ventana.getLblNeto().setText(gui.getLblNeto().getText()); 
		ventana.getLblRetorno().setText(gui.getLblRetorno().getText()); 
		ventana.getLblNeto().setForeground(gui.getLblNeto().getForeground());
		ventana.getLblRetorno().setForeground(gui.getLblRetorno().getForeground());
		
		new Ctr_Apariencias(ventana).aparienciaFondoTheta();
				
		gui.dispose();
	}
	
	private void fondoVechain() {
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/Fondo Vechain.png"));
		Gui_Bitcoin ventana = new Gui_Bitcoin(new panelImagen(imagenFondo));
		new Ctr_GuiBitcoin(ventana, new DatosBitcoin());
		ventana.setVisible(true);
		
		ventana.getRiFondoVechain().setSelected(true);
		ventana.getRiFondoVechain().setEnabled(false);
		
		ventana.getTxfPrecioActual().setText((gui.getTxfPrecioActual().getText()));
		ventana.getTxfPrecioComprado().setText((gui.getTxfPrecioComprado().getText())); 
		ventana.getTxfCantidadComprado().setText((gui.getTxfCantidadComprado().getText())); 
		ventana.getLblNeto().setText(gui.getLblNeto().getText()); 
		ventana.getLblRetorno().setText(gui.getLblRetorno().getText()); 
		ventana.getLblNeto().setForeground(gui.getLblNeto().getForeground());
		ventana.getLblRetorno().setForeground(gui.getLblRetorno().getForeground());
		
		new Ctr_Apariencias(ventana).aparienciaFondoVechain();
		
		gui.dispose();
		
	}
	
	private void fondoDoge() {
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/Doge.png"));
		Gui_Bitcoin ventana = new Gui_Bitcoin(new panelImagen(imagenFondo));
		new Ctr_GuiBitcoin(ventana, new DatosBitcoin());
		ventana.setVisible(true);
		
		ventana.getRiFondoDoge().setSelected(true);
		ventana.getRiFondoDoge().setEnabled(false);
		
		ventana.getTxfPrecioActual().setText((gui.getTxfPrecioActual().getText()));
		ventana.getTxfPrecioComprado().setText((gui.getTxfPrecioComprado().getText())); 
		ventana.getTxfCantidadComprado().setText((gui.getTxfCantidadComprado().getText())); 
		ventana.getLblNeto().setText(gui.getLblNeto().getText()); 
		ventana.getLblRetorno().setText(gui.getLblRetorno().getText()); 
		ventana.getLblNeto().setForeground(gui.getLblNeto().getForeground());
		ventana.getLblRetorno().setForeground(gui.getLblRetorno().getForeground());
		
		new Ctr_Apariencias(ventana).aparienciaFondoDoge();
		
		gui.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.gui.getBtnNewButton()) {
			this.gui.getBtnLimpiarDatos().setEnabled(true);
			guardarDatos();
		}
		
		if(e.getSource() == this.gui.getBtnLimpiarDatos()) {
			limpiarDatos();
			this.gui.getBtnLimpiarDatos().setEnabled(false);
		}
		
		if(e.getSource() == this.gui.getRiFondoBitcoin()) {
			fondoBitcoin();
		}
		
		if(e.getSource() == this.gui.getRiFondoTheta()) {
			fondoTheta();
		}
		
		if(e.getSource() == this.gui.getRiFondoVechain()) {
			fondoVechain();
		}
		
		if(e.getSource() == this.gui.getRiFondoDoge()) {
			fondoDoge();
		}
		
	}
	

	@Override
	public void keyPressed(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
		
		if(e.getSource() == this.gui.getTxfCantidadComprado()) {
			char validar = e.getKeyChar();	
			
				//En el textfield txfCantidadComprado no se podra escribir letras, solo se podra escribir numeros
				if(validar >= 32 && validar <= 45 || validar == 47 || validar >= 58 && validar <= 8482) {
					e.consume();
					}
			}	
	}
}
