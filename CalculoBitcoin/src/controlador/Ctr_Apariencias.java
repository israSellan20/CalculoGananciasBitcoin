package controlador;

import java.awt.Color;

import vista.Gui_Bitcoin;

public class Ctr_Apariencias {

	private Gui_Bitcoin gui;
	
	public Ctr_Apariencias() {}
	
	public Ctr_Apariencias(Gui_Bitcoin gui) {
		this.gui = gui;
	}
	
	public void aparienciaFondoTheta() {
		gui.getLblNewLabel().setForeground(new Color(214, 219, 223));
		gui.getLblNewLabel_1().setForeground(new Color(214, 219, 223));
		gui.getLblPrecioDelBitcoin().setForeground(new Color(214, 219, 223));
		gui.getLblCantidadDeBitcoins().setForeground(new Color(214, 219, 223));
		gui.getLblGananciasNeta().setForeground(new Color(214, 219, 223));
		gui.getLblPorcentajeDeRetorno().setForeground(new Color(214, 219, 223));
	}
	
	public void aparienciaFondoVechain() {
		gui.getLblNewLabel().setForeground(new Color(21, 67, 96 ));
		gui.getLblNewLabel_1().setForeground(new Color(21, 67, 96 ));
		gui.getLblPrecioDelBitcoin().setForeground(new Color(21, 67, 96 ));
		gui.getLblCantidadDeBitcoins().setForeground(new Color(21, 67, 96));
		gui.getLblGananciasNeta().setForeground(new Color(21, 67, 96));
		gui.getLblPorcentajeDeRetorno().setForeground(new Color(21, 67, 96 ));
	}
	
	public void aparienciaFondoDoge() {
		gui.getLblNewLabel().setForeground(new Color(99, 64, 14  ));
		gui.getLblNewLabel_1().setForeground(new Color(99, 64, 14  ));
		gui.getLblPrecioDelBitcoin().setForeground(new Color(99, 64, 14  ));
		gui.getLblCantidadDeBitcoins().setForeground(new Color(99, 64, 14 ));
		gui.getLblGananciasNeta().setForeground(new Color(99, 64, 14 ));
		gui.getLblPorcentajeDeRetorno().setForeground(new Color(99, 64, 14  ));
	}
	
}
