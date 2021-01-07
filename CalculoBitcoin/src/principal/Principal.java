package principal;

import controlador.Ctr_GuiBitcoin;
import modelo.DatosBitcoin;
import vista.Gui_Bitcoin;

public class Principal {
	
	public static void main(String[] args) {
		
		ventana();
		
	}
	
	public static void ventana() {
		
		Gui_Bitcoin ventana = new Gui_Bitcoin();
		new Ctr_GuiBitcoin(ventana, new DatosBitcoin());
		ventana.setVisible(true);	
	}
}
